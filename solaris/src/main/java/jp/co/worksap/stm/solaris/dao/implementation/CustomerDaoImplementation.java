package jp.co.worksap.stm.solaris.dao.implementation;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import jp.co.worksap.stm.solaris.dao.specification.CustomerDao;
import jp.co.worksap.stm.solaris.dto.CustomerDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImplementation implements CustomerDao {

	@Autowired
	private JdbcTemplate template;

	private static final String GET_TOTAL_COUNT = "SELECT COUNT(*) FROM CUSTOMERS";
	private static final String FETCH_ALL = "SELECT * FROM CUSTOMERS LIMIT ? OFFSET ?";
	private static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMERS "
			+ "(name, gender, birthday, email, contact_number, order_count, referral_count, address, occupation, salary, register_date)"
			+ " VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	private static final String UPDATE_CUSTOMER = "UPDATE CUSTOMERS SET name = ?, gender = ?, birthday = ?, email = ?, contact_number = ?, order_count = ?, referral_count = ?, address = ?, occupation = ?, salary = ?, register_date = ? WHERE email = ?";
	private static final String DELETE_CUSTOMER = "DELETE FROM CUSTOMERS WHERE email = ?";
	private static final String FILTER_BY_SEARCH = "SELECT * FROM CUSTOMERS WHERE name LIKE ? OR gender LIKE ? OR birthday LIKE ? OR email LIKE ? OR contact_number LIKE ? OR address LIKE ? OR occupation LIKE ? OR salary LIKE ? OR register_date LIKE ?"
			+ "LIMIT ? OFFSET ?";
	private static final String FILTER_COUNT = "SELECT COUNT(*) FROM CUSTOMERS WHERE name LIKE ? OR gender LIKE ? OR birthday LIKE ? OR email LIKE ? OR contact_number LIKE ? OR address LIKE ? OR occupation LIKE ? OR salary LIKE ? OR register_date LIKE ?";


	@Override
	public List<CustomerDto> getAll(int start, int size) throws IOException {
		try {
			return template.query(
					FETCH_ALL,
					ps -> {
						ps.setInt(1, size);
						ps.setInt(2, start);
					}, 
					(rs, rownum) -> {
						return new CustomerDto(rs.getString("name"), rs
								.getString("gender"), rs.getDate("birthday"),
								rs.getString("email"), rs
										.getString("contact_number"), rs
										.getInt("order_count"), rs
										.getInt("referral_count"), rs
										.getString("address"), rs
										.getString("occupation"), rs
										.getInt("salary"), rs
										.getDate("register_date"));
					});
		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public void insert(CustomerDto cd) throws IOException {

		// Date format conversion
		Date sqlBirthday = new java.sql.Date(cd.getBirthday().getTime());
		Date sqlRegisterDate = new java.sql.Date(cd.getRegisterDate().getTime());

		try {
			template.update(INSERT_CUSTOMER, (ps) -> {
				ps.setString(1, cd.getName());
				ps.setString(2, cd.getGender());
				ps.setDate(3, sqlBirthday);
				ps.setString(4, cd.getEmail());
				ps.setString(5, cd.getContactNumber());
				ps.setInt(6, cd.getOrderCount());
				ps.setInt(7, cd.getReferralCount());
				ps.setString(8, cd.getAddress());
				ps.setString(9, cd.getOccupation());
				ps.setInt(10, cd.getSalary());
				ps.setDate(11, sqlRegisterDate);
			});

		} catch (DataAccessException e) {
			throw new IOException(e);
		}

	}

	@Override
	public void update(CustomerDto cd) throws IOException {

		// Date format conversion
		Date sqlBirthday = new java.sql.Date(cd.getBirthday().getTime());
		Date sqlRegisterDate = new java.sql.Date(cd.getRegisterDate().getTime());

		try {
			template.update(UPDATE_CUSTOMER, (ps) -> {
				ps.setString(1, cd.getName());
				ps.setString(2, cd.getGender());
				ps.setDate(3, sqlBirthday);
				ps.setString(4, cd.getEmail());
				ps.setString(5, cd.getContactNumber());
				ps.setInt(6, cd.getOrderCount());
				ps.setInt(7, cd.getReferralCount());
				ps.setString(8, cd.getAddress());
				ps.setString(9, cd.getOccupation());
				ps.setInt(10, cd.getSalary());
				ps.setDate(11, sqlRegisterDate);
				ps.setString(12, cd.getEmail());
			});
		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public void deleteByEmail(String email) throws IOException {
		try {
			template.update(DELETE_CUSTOMER, (ps) -> {
				ps.setString(1, email);
			});
		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public int getTotalCount() throws IOException {
		try {
			return template.queryForObject(GET_TOTAL_COUNT, (rs, rownum) -> {
				return rs.getInt(1);
			});
		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public int getFilteredCount(String searchParam) throws IOException {
		try {
			return template.queryForObject(FILTER_COUNT, (rs, column) -> {
				return rs.getInt(1);
			}, "%" + searchParam + "%", "%" + searchParam + "%", "%"
					+ searchParam + "%", "%" + searchParam + "%", "%"
					+ searchParam + "%", "%" + searchParam + "%", "%"
					+ searchParam + "%", "%" + searchParam + "%", "%"
					+ searchParam + "%");
		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public List<CustomerDto> filter(String searchParam, int start, int size)
			throws IOException {

		try {
			return template.query(
					FILTER_BY_SEARCH,
					(ps) -> {
						ps.setString(1, "%" + searchParam + "%");
						ps.setString(2, "%" + searchParam + "%");
						ps.setString(3, "%" + searchParam + "%");
						ps.setString(4, "%" + searchParam + "%");
						ps.setString(5, "%" + searchParam + "%");
						ps.setString(6, "%" + searchParam + "%");
						ps.setString(7, "%" + searchParam + "%");
						ps.setString(8, "%" + searchParam + "%");
						ps.setString(9, "%" + searchParam + "%");
						ps.setInt(10, size);
						ps.setInt(11, start);
					},
					(rs, rownum) -> {
						return new CustomerDto(rs.getString("name"), rs
								.getString("gender"), rs.getDate("birthday"),
								rs.getString("email"), rs
										.getString("contact_number"), rs
										.getInt("order_count"), rs
										.getInt("referral_count"), rs
										.getString("address"), rs
										.getString("occupation"), rs
										.getInt("salary"), rs
										.getDate("register_date"));
					});
		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}
}
