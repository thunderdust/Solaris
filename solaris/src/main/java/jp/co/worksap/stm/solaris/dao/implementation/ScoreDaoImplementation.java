package jp.co.worksap.stm.solaris.dao.implementation;

import java.io.IOException;
import java.util.List;

import jp.co.worksap.stm.solaris.dao.specification.ScoreDao;
import jp.co.worksap.stm.solaris.dto.ScoreDto;
import jp.co.worksap.stm.solaris.entity.score.ScoreEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreDaoImplementation implements ScoreDao {

	@Autowired
	private JdbcTemplate template;

	private static final String COUNT_ALL = "SELECT COUNT(*) FROM TRAINING_SCORES";
	private static final String COUNT_BY_EMPLOYEE_ID = "SELECT COUNT(*) FROM TRAINING_SCORES WHERE employee_id = ?";
	private static final String FETCH_ALL = "SELECT * FROM TRAINING_SCORES";
	private static final String FETCH_BY_EMPLOYEE_ID = "SELECT * FROM TRAINING_SCORES WHERE employee_id = ?";

	@Override
	public List<ScoreDto> getAllScores() throws IOException {
		try {
			return template.query(
					FETCH_ALL,
					(rs, rownum) -> {
						return new ScoreDto(rs.getString("employee_name"),
								rs.getString("employee_id"), rs
										.getInt("test_id"), rs
										.getString("test_type"), rs
										.getInt("score"), rs.getDate("date"));
					});

		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public List<ScoreDto> getByEmployeeId(String id) throws IOException {
		try {
			return template.query(
					FETCH_BY_EMPLOYEE_ID,
					(rs, rownum) -> {
						return new ScoreDto(rs.getString("employee_name"),
								            rs.getString("employee_id"), rs
										.getInt("test_id"), rs
										.getString("test_type"), rs
										.getInt("score"), rs.getDate("date"));
					}, id);

		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public int getTotalCount() throws IOException {
		try {
			return template.queryForObject(COUNT_ALL, (rs, rownum) -> {
				return rs.getInt(1);
			});
		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public int getTotalCountOfEmployee(String id) throws IOException {
		try {
			return template.queryForObject(COUNT_BY_EMPLOYEE_ID,
					(rs, rownum) -> {
						return rs.getInt(1);
					}, id);
		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

}
