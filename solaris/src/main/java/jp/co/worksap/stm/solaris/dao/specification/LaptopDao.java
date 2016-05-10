package jp.co.worksap.stm.solaris.dao.specification;

import java.io.IOException;
import java.util.List;

import jp.co.worksap.stm.solaris.dto.LaptopDto;

public interface LaptopDao {

	LaptopDto getById(String id) throws IOException;
	
	List<LaptopDto> getAll(int start, int length) throws IOException;

	void insert(LaptopDto ld) throws IOException;

	void update(LaptopDto ld) throws IOException;

	void deleteByName(String name) throws IOException;

	int getTotalCount() throws IOException;

	int getFilteredCount(String searchParam) throws IOException;
	
	List<LaptopDto> filter(String searchParam, int start, int size) throws IOException;

}
