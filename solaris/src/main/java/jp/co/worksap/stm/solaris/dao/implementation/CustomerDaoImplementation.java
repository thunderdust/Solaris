package jp.co.worksap.stm.solaris.dao.implementation;

import java.io.IOException;
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
	private static final String FETCH_ALL = "SELECT * FROM CUSTOMERS";
	private static final String FETCH_BY_EMAIL = "SELECT * FROM CUSTOMERS WHERE email = ?";

	@Override
	public CustomerDto getByEmail(String id) throws IOException {
		return null;
	}

	@Override
	public List<CustomerDto> getAll() throws IOException {
		try {
			return template.query(
					FETCH_ALL,
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
	public void insert(CustomerDto ld) throws IOException {

	}

	@Override
	public void update(CustomerDto ld) throws IOException {

	}

	@Override
	public void deleteByName(String name) throws IOException {

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
		return 0;
	}

}
