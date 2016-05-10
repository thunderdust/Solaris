package jp.co.worksap.stm.solaris.services.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jp.co.worksap.stm.solaris.dao.specification.CustomerDao;
import jp.co.worksap.stm.solaris.dto.CustomerDto;
import jp.co.worksap.stm.solaris.entity.customer.CustomerCreationEntity;
import jp.co.worksap.stm.solaris.entity.customer.CustomerEntity;
import jp.co.worksap.stm.solaris.entity.customer.CustomerFetchEntity;
import jp.co.worksap.stm.solaris.entity.customer.CustomerListEntity;
import jp.co.worksap.stm.solaris.exceptions.ServiceException;
import jp.co.worksap.stm.solaris.services.specification.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	private CustomerDao cd;

	@Override
	public CustomerEntity getByEmail(String email) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerListEntity getAll(CustomerFetchEntity entity)
			throws ServiceException {

		List<CustomerDto> dtoList = null;
		int count = 0;
		try {
			dtoList = cd.getAll();
			count = cd.getTotalCount();

		} catch (IOException e) {
			throw new ServiceException("Error getting all customers", e);
		}

		List<CustomerEntity> ceList = Lists.newArrayList();
		for (CustomerDto dto : dtoList) {
			CustomerEntity ce = new CustomerEntity(dto);
			ceList.add(ce);
		}
		return new CustomerListEntity(entity.getDraw(), count, count, ceList);
	}

	@Override
	public void insert(CustomerCreationEntity e) throws ServiceException {
		try {
			CustomerDto cdto = new CustomerDto(e);
			cd.insert(cdto);

		} catch (IOException er) {
			throw new ServiceException("Error adding new customer", er);
		}

	}

	@Override
	public void update(CustomerCreationEntity e) throws ServiceException {
		try {
			CustomerDto cdto = new CustomerDto(e);
			cd.update(cdto);

		} catch (IOException er) {
			throw new ServiceException("Error updating customer", er);
		}
	}

	@Override
	public void deleteByEmail(String email) throws ServiceException {
		try {

			cd.deleteByEmail(email);

		} catch (IOException er) {
			throw new ServiceException("Error adding new customer", er);
		}
	}

	@Override
	public CustomerListEntity filter(CustomerFetchEntity cfe)
			throws ServiceException {
		List<CustomerDto> customerList = null;
		int count = 0;
		try {
			customerList = cd.filter(cfe.getSearchParam().toLowerCase(), cfe.getStart(), cfe.getLength());
			count = cd.getFilteredCount(cfe.getSearchParam().toLowerCase());
			
		}catch (IOException e) {
			throw new ServiceException("Error occured in filtering", e);
		}
		List<CustomerEntity> entityList = new ArrayList<CustomerEntity>();
		for (CustomerDto dto: customerList){
			entityList.add(new CustomerEntity(dto));
		}
		return new CustomerListEntity(cfe.getDraw(), count, count, entityList);
	}
}
