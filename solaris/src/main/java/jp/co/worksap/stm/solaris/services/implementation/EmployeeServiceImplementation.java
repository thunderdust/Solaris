package jp.co.worksap.stm.solaris.services.implementation;

import java.io.IOException;
import java.util.List;

import jp.co.worksap.stm.solaris.dao.specification.EmployeeDao;
import jp.co.worksap.stm.solaris.dto.EmployeeDto;
import jp.co.worksap.stm.solaris.entity.EmployeeCreationEntity;
import jp.co.worksap.stm.solaris.entity.EmployeeEntity;
import jp.co.worksap.stm.solaris.entity.EmployeeFetchByRoleEntity;
import jp.co.worksap.stm.solaris.entity.EmployeeListEntity;
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
			dtoList = employeeDao.getByRole(entity.getRole().get(0),
					entity.getStart(), entity.getLength());
			if (entity.getRole().contains("ALL")) {
				count = employeeDao.getTotalCount();
			} else {
				count = employeeDao.getTotalCount(entity.getRole().get(0));
			}

		} catch (IOException e) {
			throw new ServiceException("Could not find user for role: "
					+ entity.getRole(), e);
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
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(String id) throws ServiceException {
		// TODO Auto-generated method stub

	}
}
