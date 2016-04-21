package jp.co.worksap.stm.solaris.services.specification;

import jp.co.worksap.stm.solaris.entity.customer.CustomerCreationEntity;
import jp.co.worksap.stm.solaris.entity.customer.CustomerEntity;
import jp.co.worksap.stm.solaris.entity.customer.CustomerFetchEntity;
import jp.co.worksap.stm.solaris.entity.customer.CustomerListEntity;
import jp.co.worksap.stm.solaris.exceptions.ServiceException;

public interface CustomerService {

	CustomerEntity getByEmail(String email) throws ServiceException;

	CustomerListEntity getAll(CustomerFetchEntity entity)
			throws ServiceException;

	void insert(CustomerCreationEntity e) throws ServiceException;

	void update(CustomerCreationEntity e) throws ServiceException;

	void deleteByEmail(String email) throws ServiceException;

}
