package jp.co.worksap.stm.solaris.dao.specification;

import java.io.IOException;
import java.util.List;

import jp.co.worksap.stm.solaris.dto.CustomerDto;

public interface CustomerDao {

	CustomerDto getByEmail(String id) throws IOException;

	List<CustomerDto> getAll() throws IOException;

	void insert(CustomerDto ld) throws IOException;

	void update(CustomerDto ld) throws IOException;

	void deleteByEmail(String email) throws IOException;

	int getTotalCount() throws IOException;
	
	List<CustomerDto> filter(String searchParam, int start, int size) throws IOException;

	int getFilteredCount(String searchParam) throws IOException;
	
	

}
