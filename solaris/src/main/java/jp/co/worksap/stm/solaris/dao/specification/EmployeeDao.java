package jp.co.worksap.stm.solaris.dao.specification;

import java.io.IOException;
import java.util.List;

import jp.co.worksap.stm.solaris.dto.EmployeeDto;

public interface EmployeeDao {

	EmployeeDto getByID(String id) throws IOException;

	List<EmployeeDto> getByRole(String role, int start, int size)
			throws IOException;

	List<EmployeeDto> getAll() throws IOException;

	int getTotalCount(String role) throws IOException;

	int getTotalCount() throws IOException;

	void insert(EmployeeDto account) throws IOException;

	void update(EmployeeDto account) throws IOException;

	void deleteBy(String id) throws IOException;

}
