package jp.co.worksap.stm.solaris.services.implementation;

import jp.co.worksap.stm.solaris.entity.customer.CustomerCreationEntity;
import jp.co.worksap.stm.solaris.entity.customer.CustomerEntity;
import jp.co.worksap.stm.solaris.entity.customer.CustomerFetchEntity;
import jp.co.worksap.stm.solaris.entity.customer.CustomerListEntity;
import jp.co.worksap.stm.solaris.exceptions.ServiceException;
import jp.co.worksap.stm.solaris.services.specification.CustomerService;

public class CustomerServiceImplementation implements CustomerService {

	@Override
	public CustomerEntity getByEmail(String email) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerListEntity getAll(CustomerFetchEntity entity)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(CustomerCreationEntity e) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CustomerCreationEntity e) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByEmail(String email) throws ServiceException {
		// TODO Auto-generated method stub

	}

}
