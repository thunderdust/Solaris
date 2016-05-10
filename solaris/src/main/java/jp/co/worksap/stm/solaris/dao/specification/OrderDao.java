package jp.co.worksap.stm.solaris.dao.specification;

import java.io.IOException;
import java.util.List;

import jp.co.worksap.stm.solaris.dto.OrderDto;

public interface OrderDao {

	OrderDto getById(int id) throws IOException;

	List<OrderDto> getAll(int start, int size) throws IOException;

	List<OrderDto> filter(String searchParam, int start, int size)
			throws IOException;

	int getFilteredCount(String searchParam) throws IOException;

	void insert(OrderDto od) throws IOException;

	void update(OrderDto od) throws IOException;

	void deleteById(int id) throws IOException;

	int getTotalCount() throws IOException;
}
