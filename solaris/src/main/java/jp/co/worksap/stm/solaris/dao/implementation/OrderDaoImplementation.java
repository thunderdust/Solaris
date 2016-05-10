package jp.co.worksap.stm.solaris.dao.implementation;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.worksap.stm.solaris.dao.specification.OrderDao;
import jp.co.worksap.stm.solaris.dto.OrderDto;

@Repository
public class OrderDaoImplementation implements OrderDao {

	@Autowired
	private JdbcTemplate template;

	private static final String FETCH_BY_ID = "SELECT * FROM ORDERS WHERE id = ?";
	private static final String FETCH_ALL = "SELECT * FROM ORDERS" + " LIMIT ? OFFSET ?";
	private static final String COUNT_ALL = "SELECT COUNT(*) FROM ORDERS";
	private static final String INSERT_ORDER = "INSERT INTO ORDERS "
			+ "(id, client_email, client_name, laptop_name, quantity, price, seller_id, delivery_deadline, created_date, last_modified)"
			+ " VALUES(?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_ORDER = "UPDATE ORDERS SET client_email = ?, client_name = ?, laptop_name = ?, quantity = ?, price = ?, seller_id = ?, delivery_deadline = ?, created_date = ?, last_modified = ? WHERE id = ?";
	private static final String DELETE_ORDER = "DELETE FROM ORDERS WHERE id = ?";
	private static final String FILTER_BY_SEARCH = "SELECT * FROM ORDERS WHERE "
			+ "id LIKE ? OR client_email LIKE ? OR client_name LIKE ? OR laptop_name LIKE ? OR quantity LIKE ? OR price LIKE ? OR seller_id LIKE ? OR delivery_deadline LIKE ? OR created_date LIKE ? OR last_modified LIKE ?"
			+ " LIMIT ? OFFSET ?";
	private static final String COUNT_FILTER = "SELECT COUNT(*) FROM ORDERS WHERE "
			+ "id LIKE ? OR client_email LIKE ? OR client_name LIKE ? OR laptop_name LIKE ? OR quantity LIKE ? OR price LIKE ? OR seller_id LIKE ? OR delivery_deadline LIKE ? OR created_date LIKE ? OR last_modified LIKE ?";

	@Override
	public OrderDto getById(int id) throws IOException {
		try {
			return template.queryForObject(
					FETCH_BY_ID,
					(rs, rownum) -> {
						return new OrderDto(rs.getInt("id"), rs
								.getString("client_email"), rs
								.getString("client_name"), rs
								.getString("laptop_name"), rs
								.getInt("quantity"), rs.getFloat("price"), rs
								.getString("seller_id"), rs
								.getDate("delivery_deadline"), rs
								.getDate("created_date"), rs
								.getDate("last_modified"));
					}, id);

		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public List<OrderDto> getAll(int start, int size) throws IOException {
		try {
			// No role selection
			return template.query(
					FETCH_ALL,
					ps -> {
						ps.setInt(1, size);
						ps.setInt(2, start);
					},
					(rs, rownum) -> {
						return new OrderDto(rs.getInt("id"), rs
								.getString("client_email"), rs
								.getString("client_name"), rs
								.getString("laptop_name"), rs
								.getInt("quantity"), rs.getFloat("price"), rs
								.getString("seller_id"), rs
								.getDate("delivery_deadline"), rs
								.getDate("created_date"), rs
								.getDate("last_modified"));
					});

		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public void insert(OrderDto od) throws IOException {

		Date sqlLastModified = new java.sql.Date(Calendar.getInstance()
				.getTimeInMillis());
		try {
			template.update(INSERT_ORDER, (ps) -> {
				ps.setInt(1, od.getId());
				ps.setString(2, od.getClientEmail());
				ps.setString(3, od.getClientName());
				ps.setString(4, od.getLaptopName());
				ps.setInt(5, od.getQuantity());
				ps.setFloat(6, od.getPrice());
				ps.setString(7, od.getSellerId());
				ps.setDate(8, od.getDeliveryDeadline());
				ps.setDate(9, od.getCreatedDate());
				ps.setDate(10, sqlLastModified);
			});

		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public void update(OrderDto od) throws IOException {
		Date sqlLastModified = new java.sql.Date(Calendar.getInstance()
				.getTimeInMillis());
		try {
			template.update(UPDATE_ORDER, (ps) -> {

				ps.setString(1, od.getClientEmail());
				ps.setString(2, od.getClientName());
				ps.setString(3, od.getLaptopName());
				ps.setInt(4, od.getQuantity());
				ps.setFloat(5, od.getPrice());
				ps.setString(6, od.getSellerId());
				ps.setDate(7, od.getDeliveryDeadline());
				ps.setDate(8, od.getCreatedDate());
				ps.setDate(9, sqlLastModified);
				ps.setInt(10, od.getId());
			});

		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public void deleteById(int id) throws IOException {
		try {
			template.update(DELETE_ORDER, (ps) -> {
				ps.setInt(1, id);
			});

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
	public int getFilteredCount(String searchParam) throws IOException {
		try {
			return template.queryForObject(COUNT_FILTER, (rs, column) -> {
				return rs.getInt(1);
			}, "%" + searchParam + "%", "%" + searchParam + "%", "%"
					+ searchParam + "%", "%" + searchParam + "%", "%"
					+ searchParam + "%", "%" + searchParam + "%", "%"
					+ searchParam + "%", "%" + searchParam + "%", "%"
					+ searchParam + "%", "%" + searchParam + "%");
		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public List<OrderDto> filter(String searchParam, int start, int size)
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
						ps.setString(10, "%" + searchParam + "%");
						ps.setInt(11, size);
						ps.setInt(12, start);
					},
					(rs, rownum) -> {
						return new OrderDto(rs.getInt("id"), rs
								.getString("client_email"), rs
								.getString("client_name"), rs
								.getString("laptop_name"), rs
								.getInt("quantity"), rs.getFloat("price"), rs
								.getString("seller_id"), rs
								.getDate("delivery_deadline"), rs
								.getDate("created_date"), rs
								.getDate("last_modified"));
					});
		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

}
