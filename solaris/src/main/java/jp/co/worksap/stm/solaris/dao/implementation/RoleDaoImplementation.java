package jp.co.worksap.stm.solaris.dao.implementation;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import jp.co.worksap.stm.solaris.dao.specification.RoleDao;
import jp.co.worksap.stm.solaris.dto.RoleDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

public class RoleDaoImplementation implements RoleDao {

	@Autowired
	private JdbcTemplate template;

	private static final String FETCH_BY_ID = "SELECT * FROM EMPLOYEE_ROLE WHERE EMPLOYEE_ID = ?";
	private static final String INSERT = "INSERT INTO EMPLOYEE_ROLE (employee_id, role) "
			+ " VALUES (? , ?)";
	private static final String DELETE = "DELETE FROM EMPLOYEE_ROLE WHERE employee_id = ?";

	@Override
	public List<RoleDto> getByUserId(String userId) throws IOException {
		try {
			return template.query(FETCH_BY_ID, ps -> ps.setString(1, userId), (
					rs, rownum) -> {
				return new RoleDto(rs.getString("role"));
			});

		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public void insertRole(String userId, List<RoleDto> roleList)
			throws IOException {
		try {
			template.batchUpdate(INSERT, new BatchPreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps, int i)
						throws SQLException {
					ps.setString(1, userId);
					ps.setString(2, roleList.get(i).getRoleName());
				}

				@Override
				public int getBatchSize() {
					return roleList.size();
				}
			});

		} catch (DataAccessException e) {
			throw new IOException(e);
		}

	}

	@Override
	public void deleteRole(String userId) throws IOException {
		try {
			template.update(DELETE, ps -> ps.setString(1, userId));
		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}
}
