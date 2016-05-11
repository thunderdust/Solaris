package jp.co.worksap.stm.solaris.services.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jp.co.worksap.stm.solaris.dao.specification.EmployeeDao;
import jp.co.worksap.stm.solaris.dto.EmployeeDto;
import jp.co.worksap.stm.solaris.entity.employee.EmployeeCreationEntity;
import jp.co.worksap.stm.solaris.entity.employee.EmployeeEntity;
import jp.co.worksap.stm.solaris.entity.employee.EmployeeFetchByRoleEntity;
import jp.co.worksap.stm.solaris.entity.employee.EmployeeFetchEntity;
import jp.co.worksap.stm.solaris.entity.employee.EmployeeListEntity;
import jp.co.worksap.stm.solaris.exceptions.ServiceException;
import jp.co.worksap.stm.solaris.services.specification.EmployeeService;
import jp.co.worksap.stm.solaris.services.specification.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private RoleService roleService;

	@Override
	public EmployeeEntity getById(String id) throws ServiceException {
		EmployeeDto dto = null;
		try {
			dto = employeeDao.getByID(id);
		} catch (IOException e) {
			throw new ServiceException("Cannot find user for id: " + id, e);
		}
		EmployeeEntity entity = null;
		List<String> roles = null;
		if (dto != null) {
			roles = roleService.getRolesByUserId(id);
			entity = new EmployeeEntity(dto, roles);

		}
		return entity;
	}

	@Override
	public EmployeeListEntity getListByRole(EmployeeFetchByRoleEntity entity)
			throws ServiceException {
		List<EmployeeDto> dtoList = null;
		int count = 0;
		try {
			dtoList = employeeDao.getByRole(entity.getRoles().toString(),
					entity.getStart(), entity.getLength());
			if (entity.getRoles().toString().contains("ALL")) {
				count = employeeDao.getTotalCount();
			} else {
				count = employeeDao.getTotalCount(entity.getRoles().toString());
			}

		} catch (IOException e) {
			throw new ServiceException("Could not find user for role: "
					+ entity.getRoles(), e);
		}

		List<EmployeeEntity> entities = Lists.newArrayList();
		for (EmployeeDto dto : dtoList) {
			List<String> roles = roleService.getRolesByUserId(dto.getId());
			EmployeeEntity newEntity = new EmployeeEntity(dto, roles);
			entities.add(newEntity);
		}

		return new EmployeeListEntity(entity.getDraw(), count, count, entities);
	}

	@Override
	public EmployeeListEntity getAll(EmployeeFetchEntity entity)
			throws ServiceException {

		List<EmployeeDto> dtoList = null;
		int count = 0;
		try {
			dtoList = employeeDao.getAll(entity.getStart(), entity.getLength());
			count = employeeDao.getTotalCount();

		} catch (IOException e) {
			throw new ServiceException("Error get all employees", e);
		}

		List<EmployeeEntity> entities = Lists.newArrayList();
		for (EmployeeDto dto : dtoList) {
			List<String> roles = roleService.getRolesByUserId(dto.getId());
			EmployeeEntity newEntity = new EmployeeEntity(dto, roles);
			entities.add(newEntity);
		}

		return new EmployeeListEntity(entity.getDraw(), count, count, entities);
	}

	@Override
	@Transactional
	public void insert(EmployeeCreationEntity ce) throws ServiceException {
		String userId = ce.getId();
		EmployeeDto dto = new EmployeeDto(ce);
		try {
			employeeDao.insert(dto);
		} catch (IOException e) {
			throw new ServiceException("Cannot add user account for userId: "
					+ userId, e);
		}

		// Delete & insert roles
		roleService.deleteRoles(userId);
		roleService.insertRoles(userId, ce.getRoles());
	}

	@Override
	public void update(EmployeeCreationEntity e) throws ServiceException {
		String id = e.getId();
		EmployeeDto dto = new EmployeeDto(e);
		try {
			employeeDao.update(dto);

		} catch (IOException error) {
			throw new ServiceException(
					"Failed to update employee account with id: " + id, error);
		}
	}

	@Override
	public void deleteById(String id) throws ServiceException {
		try {
			employeeDao.deleteBy(id);
			roleService.deleteRoles(id);

		} catch (IOException e) {
			throw new ServiceException(
					"Failed to delete employee account with id: " + id, e);
		}
	}

	@Override
	public EmployeeListEntity filter(EmployeeFetchEntity entity)
			throws ServiceException {
		List<EmployeeDto> employeeList = null;
		int count = 0;
		try {
			employeeList = employeeDao.filter(entity.getSearchParam().toLowerCase(), entity.getStart(), entity.getLength());
			count = employeeDao.getFilteredCount(entity.getSearchParam().toLowerCase());
			
		}catch (IOException e) {
			throw new ServiceException("Error occured in filtering", e);
		}
		List<EmployeeEntity> entityList = new ArrayList<EmployeeEntity>();
		for (EmployeeDto dto: employeeList){
			List<String> roles = roleService.getRolesByUserId(dto.getId());
			EmployeeEntity newEntity = new EmployeeEntity(dto, roles);
			entityList.add(newEntity);
		}
		return new EmployeeListEntity(entity.getDraw(), count, count, entityList);
	}
}
