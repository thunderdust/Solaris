package jp.co.worksap.stm.solaris.services.specification;

import jp.co.worksap.stm.solaris.entity.EmployeeCreationEntity;
import jp.co.worksap.stm.solaris.entity.EmployeeEntity;
import jp.co.worksap.stm.solaris.entity.EmployeeFetchByRoleEntity;
import jp.co.worksap.stm.solaris.entity.EmployeeListEntity;
import jp.co.worksap.stm.solaris.exceptions.ServiceException;

public interface EmployeeService {

	EmployeeEntity getById(String userId) throws ServiceException;

	EmployeeListEntity getListByRole(EmployeeFetchByRoleEntity e)
			throws ServiceException;

	void insert(EmployeeCreationEntity e) throws ServiceException;

	void update(EmployeeCreationEntity e) throws ServiceException;

	void deleteById(String userId) throws ServiceException;
}
