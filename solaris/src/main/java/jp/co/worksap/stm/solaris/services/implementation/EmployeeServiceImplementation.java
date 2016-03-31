package jp.co.worksap.stm.solaris.services.implementation;

import jp.co.worksap.stm.solaris.dao.specification.EmployeeDao;
import jp.co.worksap.stm.solaris.entity.EmployeeCreationEntity;
import jp.co.worksap.stm.solaris.entity.EmployeeEntity;
import jp.co.worksap.stm.solaris.entity.EmployeeFetchEntity;
import jp.co.worksap.stm.solaris.entity.EmployeeListEntity;
import jp.co.worksap.stm.solaris.exceptions.ServiceException;
import jp.co.worksap.stm.solaris.services.specification.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public EmployeeEntity getById(String id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeListEntity getList(EmployeeFetchEntity e)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(EmployeeCreationEntity e) throws ServiceException {
		// TODO Auto-generated method stub

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
