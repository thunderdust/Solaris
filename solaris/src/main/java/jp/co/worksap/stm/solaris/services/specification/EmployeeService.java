package jp.co.worksap.stm.solaris.services.specification;



import jp.co.worksap.stm.solaris.entity.employee.EmployeeCreationEntity;
import jp.co.worksap.stm.solaris.entity.employee.EmployeeEntity;
import jp.co.worksap.stm.solaris.entity.employee.EmployeeFetchAllEntity;
import jp.co.worksap.stm.solaris.entity.employee.EmployeeFetchByRoleEntity;
import jp.co.worksap.stm.solaris.entity.employee.EmployeeListEntity;
import jp.co.worksap.stm.solaris.exceptions.ServiceException;

public interface EmployeeService {

	EmployeeEntity getById(String userId) throws ServiceException;

	EmployeeListEntity getListByRole(EmployeeFetchByRoleEntity e)
			throws ServiceException;

	EmployeeListEntity getAll(EmployeeFetchAllEntity entity)
			throws ServiceException;

	void insert(EmployeeCreationEntity e) throws ServiceException;

	void update(EmployeeCreationEntity e) throws ServiceException;

	void deleteById(String userId) throws ServiceException;
}
