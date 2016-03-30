package jp.co.worksap.stm.solaris.dao.specification;

import java.io.IOException;
import java.util.List;

import jp.co.worksap.stm.solaris.dto.EmployeeDto;

public interface EmployeeDao {
	
	EmployeeDto getBy(int id) throws IOException;

	List<EmployeeDto> getBy(int startId, int size)
			throws IOException;

	int getTotalCount(int role) throws IOException;
	
	int getTotalCount() throws IOException;

	void insert(EmployeeDto account) throws IOException;

	void update(EmployeeDto account) throws IOException;

	void deleteBy(int id) throws IOException;

}
