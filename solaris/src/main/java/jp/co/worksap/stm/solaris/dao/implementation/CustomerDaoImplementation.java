package jp.co.worksap.stm.solaris.dao.implementation;

import java.io.IOException;
import java.util.List;

import jp.co.worksap.stm.solaris.dao.specification.CustomerDao;
import jp.co.worksap.stm.solaris.dto.CustomerDto;

public class CustomerDaoImplementation implements CustomerDao {

	@Override
	public CustomerDto getById(String id) throws IOException {
		return null;
	}

	@Override
	public List<CustomerDto> getAll() throws IOException {
		return null;
	}

	@Override
	public void insert(CustomerDto ld) throws IOException {

	}

	@Override
	public void update(CustomerDto ld) throws IOException {

	}

	@Override
	public void deleteByName(String name) throws IOException {

	}

	@Override
	public int getTotalCount() throws IOException {
		return 0;
	}

	@Override
	public int getFilteredCount(String searchParam) throws IOException {
		return 0;
	}

}
