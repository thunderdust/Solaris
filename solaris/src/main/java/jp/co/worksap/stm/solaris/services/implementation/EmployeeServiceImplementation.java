package jp.co.worksap.stm.solaris.services.implementation;

import java.io.IOException;

import jp.co.worksap.stm.solaris.dao.specification.EmployeeDao;
import jp.co.worksap.stm.solaris.dto.EmployeeDto;
import jp.co.worksap.stm.solaris.entity.EmployeeCreationEntity;
import jp.co.worksap.stm.solaris.entity.EmployeeEntity;
import jp.co.worksap.stm.solaris.entity.EmployeeFetchEntity;
import jp.co.worksap.stm.solaris.entity.EmployeeListEntity;
import jp.co.worksap.stm.solaris.exceptions.ServiceException;
import jp.co.worksap.stm.solaris.services.specification.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public EmployeeEntity getById(String id) throws ServiceException {
		EmployeeDto dto = null;
		try {
			dto = employeeDao.getByID(id);
		} catch (IOException e) {
			throw new ServiceException("Cannot find user for id: " + id, e);
		}
		EmployeeEntity entity = null;
		if (dto != null) {
			entity = new EmployeeEntity(dto);

		} else {
			// null
		}
		return entity;
	}

	@Override
	public EmployeeListEntity getList(EmployeeFetchEntity e)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
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
	}

	@Override
	public void update(EmployeeCreationEntity e) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(String id) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getUserRoleById(String userId) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertRole(String userId) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRole(String userId) throws ServiceException {
		// TODO Auto-generated method stub

	}
}
