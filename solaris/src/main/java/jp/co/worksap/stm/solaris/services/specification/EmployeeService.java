package jp.co.worksap.stm.solaris.services.specification;

import jp.co.worksap.stm.solaris.entity.EmployeeCreationEntity;
import jp.co.worksap.stm.solaris.entity.EmployeeEntity;
import jp.co.worksap.stm.solaris.entity.EmployeeFetchEntity;
import jp.co.worksap.stm.solaris.entity.EmployeeListEntity;
import jp.co.worksap.stm.solaris.exceptions.ServiceException;

public interface EmployeeService {

	EmployeeEntity getById(String id) throws ServiceException;

	EmployeeListEntity getList(EmployeeFetchEntity e) throws ServiceException;

	void insert(EmployeeCreationEntity e) throws ServiceException;

	void update(EmployeeCreationEntity e) throws ServiceException;

	void deleteById(String id) throws ServiceException;

}
