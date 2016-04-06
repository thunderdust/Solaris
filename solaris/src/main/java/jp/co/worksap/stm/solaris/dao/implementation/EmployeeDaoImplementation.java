package jp.co.worksap.stm.solaris.dao.implementation;

import java.io.IOException;
import java.util.List;

import jp.co.worksap.stm.solaris.dao.specification.EmployeeDao;
import jp.co.worksap.stm.solaris.dto.EmployeeDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImplementation implements EmployeeDao {

	@Autowired
	private JdbcTemplate template;

	// SQL manipulation queries
	private static final String FETCH_BY_ID = "SELECT * FROM EMPLOYEES WHERE id = ?";
	private static final String RANGE_FETCH = "SELECT * FROM EMPLOYEES LIMIT ? OFFSET ?";
	private static final String COUNT_EMPLOYEE_BY_ROLE = "SELECT COUNT(*) FROM EMPLOYEES WHERE role= ?";
	private static final String COUNT_EMPLOYEE = "SELECT COUNT(*) FROM EMPLOYEES";
	private static final String INSERT_EMPLOYEE = "INSERT INTO EMPLOYEES "
			+ " (firstname, lastname, gender, id, email, contact_number, role, password, time_joined)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String DELETE_EMPLOYEE = "DELETE FROM EMPLOYEES WHERE id = ?";
	private static final String UPDATE_EMPLOYEE_AND_PASSWORD = "UPDATE EMPLOYEES SET password = ?, "
			+ "firstname = ?, lastname = ?, gender = ?, id = ?, email = ?, contact_number = ?, role = ?, password = ?, time_joined = ?";
	private static final String UPDATE_EMPLOYEE = "UPDATE EMPLOYEES SET "
			+ "firstname = ?, lastname = ?, gender = ?, id = ?, email = ?, contact_number = ?, role = ?, password = ?, time_joined = ?";

	@Override
	public EmployeeDto getByID(String id) throws IOException {

		try {
			return template.queryForObject(
					FETCH_BY_ID,
					(rs, rownum) -> {
						return new EmployeeDto(rs.getString("firstname"), rs
								.getString("lastname"), rs.getString("gender"),
								rs.getString("id"), rs.getString("email"), rs
										.getString("role"), rs
										.getString("contact_number"), rs
										.getString("password"), rs
										.getString("time_joined"));
					}, id);

		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public List<EmployeeDto> getBy(int start, int size) throws IOException {

		try {
			return template.query(
					RANGE_FETCH,
					ps -> {
						ps.setInt(1, size);
						ps.setInt(2, start);
					},
					(rs, rownum) -> {
						return new EmployeeDto(rs.getString("firstname"), rs
								.getString("lastname"), rs.getString("gender"),
								rs.getString("id"), rs.getString("email"), rs
										.getString("role"), rs
										.getString("contact_number"), rs
										.getString("password"), rs
										.getString("time_joined"));

					});

		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public int getTotalCount(int role) throws IOException {

		try {
			return template.queryForObject(COUNT_EMPLOYEE_BY_ROLE,
					(rs, rownum) -> {
						return rs.getInt(1);
					}, role);
		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public int getTotalCount() throws IOException {

		try {
			return template.queryForObject(COUNT_EMPLOYEE, (rs, rownum) -> {
				return rs.getInt(1);
			});
		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public void insert(EmployeeDto ed) throws IOException {

		try {
			template.update(INSERT_EMPLOYEE, (ps) -> {
				ps.setString(1, ed.getFirstName());
				ps.setString(2, ed.getLastName());
				ps.setString(3, ed.getGender());
				ps.setString(4, ed.getId());
				ps.setString(5, ed.getEmail());
				ps.setString(6, ed.getRole());
				ps.setString(7, ed.getContact_number());
				ps.setString(8, ed.getPassword());
				ps.setString(9, ed.getTimeJoined());

			});

		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public void update(EmployeeDto ed) throws IOException {
		// TODO Auto-generated method stub
		try {
			// updates without password change
			if (ed.getPassword() == null) {
				template.update(UPDATE_EMPLOYEE, (ps) -> {
					ps.setString(1, ed.getFirstName());
					ps.setString(2, ed.getLastName());
					ps.setString(3, ed.getGender());
					ps.setString(4, ed.getId());
					ps.setString(5, ed.getEmail());
					ps.setString(6, ed.getRole());
					ps.setString(7, ed.getContact_number());
					ps.setString(8, ed.getTimeJoined());
				});
			} else {
				template.update(UPDATE_EMPLOYEE_AND_PASSWORD, (ps) -> {
					ps.setString(1, ed.getFirstName());
					ps.setString(2, ed.getLastName());
					ps.setString(3, ed.getGender());
					ps.setString(4, ed.getId());
					ps.setString(5, ed.getEmail());
					ps.setString(6, ed.getRole());
					ps.setString(7, ed.getContact_number());
					ps.setString(8, ed.getPassword());
					ps.setString(10, ed.getTimeJoined());
				});
			}

		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public void deleteBy(String id) throws IOException {
		try {
			template.update(DELETE_EMPLOYEE, (ps) -> {
				ps.setString(1, id);
			});

		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}
}
