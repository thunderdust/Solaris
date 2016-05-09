package jp.co.worksap.stm.solaris.dao.specification;

import java.io.IOException;
import java.util.List;

import jp.co.worksap.stm.solaris.dto.ScoreDto;

public interface ScoreDao {

	List<ScoreDto> getAllScores() throws IOException;

	List<ScoreDto> getByEmployeeId(String id) throws IOException;

	int getTotalCount() throws IOException;

	int getTotalCountOfEmployee(String id) throws IOException;
	
	void insertScore(ScoreDto s) throws IOException;

}
