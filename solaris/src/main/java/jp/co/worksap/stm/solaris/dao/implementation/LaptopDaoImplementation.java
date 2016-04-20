package jp.co.worksap.stm.solaris.dao.implementation;

import java.io.IOException;
import java.util.List;

import jp.co.worksap.stm.solaris.dao.specification.LaptopDao;
import jp.co.worksap.stm.solaris.dto.LaptopDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopDaoImplementation implements LaptopDao {

	private static final String INSERT_LAPTOP = "INSERT INTO LAPTOPS ("
			+ "name, brand, publish_date, default_price, width, height, length, weight, screen_size, os, cpu, ram_size, hard_drive_model, hard_drive_size, resolution_horizontal, resolution_vertical, touch_screen, gpu, graphics_card_type, graphics_memory, battery_life, battery_cell, optical_drive, optical_drive_speed, track_point, front_camera, camera_pixel, usb_port_2, usb_port_3, usb_port_type, vga_port, hdmi_port, card_reader_type, bluetooth, antivirus_software, laptop_bag, warranty, images"
			+ ") "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String FETCH_ALL = "SELECT * FROM LAPTOPS";
	private static final String COUNT_LAPTOP = "SELECT COUNT(*) FROM LAPTOPS";
	private static final String DELETE_LAPTOP = "DELETE FROM LAPTOPS WHERE name = ?";

	@Autowired
	JdbcTemplate template;

	@Override
	public LaptopDto getById(String id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(LaptopDto ld) throws IOException {
		try {
			template.update(INSERT_LAPTOP, (ps) -> {
				ps.setString(1, ld.getName());
				ps.setString(2, ld.getBrand());
				ps.setDate(3, ld.getPublishDate());
				ps.setBigDecimal(4, ld.getPrice());
				ps.setInt(5, ld.getLaptop_width());
				ps.setInt(6, ld.getLaptop_height());
				ps.setInt(7, ld.getLaptop_length());
				ps.setInt(8, ld.getLaptop_weight());
				ps.setFloat(9, ld.getScreenSize());
				ps.setString(10, ld.getOs());
				ps.setString(11, ld.getCpu());
				ps.setInt(12, ld.getRamSize());
				ps.setString(13, ld.getHddModel());
				ps.setInt(14, ld.getHddSize());
				ps.setInt(15, ld.getResolutionHorizontal());
				ps.setInt(16, ld.getResolutionVertical());
				ps.setBoolean(17, ld.isTouchScreen());
				ps.setString(18, ld.getGpu());
				ps.setString(19, ld.getGraphicsCardType());
				ps.setInt(20, ld.getGraphicMemory());
				ps.setFloat(21, ld.getBatteryLife());
				ps.setInt(22, ld.getBatteryCells());
				ps.setString(23, ld.getOpticalDrive());
				ps.setInt(24, ld.getOpticalDriveSpeed());
				ps.setBoolean(25, ld.isHasTrackPoint());
				ps.setBoolean(26, ld.isHasFrontCamera());
				ps.setFloat(27, ld.getCameraPixel());
				ps.setInt(28, ld.getUsb_2_slot());
				ps.setInt(29, ld.getUsb_3_slot());
				ps.setString(30, ld.getUsbPortType());
				ps.setBoolean(31, ld.isHasVGAPort());
				ps.setBoolean(32, ld.isHasHDMIPort());
				ps.setString(33, ld.getCardReaderTypes());
				ps.setString(34, ld.getBluetooth());
				ps.setString(35, ld.getAntivirusSoftware());
				ps.setBoolean(36, ld.isHasBag());
				ps.setInt(37, ld.getWarranty());
				ps.setString(38, ld.getImagePath());
			});

		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public void update(LaptopDto ld) throws IOException {

	}

	@Override
	public void deleteByName(String name) throws IOException {
		try {
			template.update(DELETE_LAPTOP, ps -> ps.setString(1, name));

		} catch (DataAccessException e) {
			throw new IOException(e);
		}

	}

	@Override
	public int getTotalCount() throws IOException {
		try {
			return template.queryForObject(COUNT_LAPTOP, (rs, rownum) -> {
				return rs.getInt(1);
			});

		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

	@Override
	public int getFilteredCount(String searchParam) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<LaptopDto> getAll() throws IOException {
		try {
			return template.query(
					FETCH_ALL,
					(rs, rownum) -> {
						return new LaptopDto(rs.getString("name"), rs
								.getString("brand"),
								rs.getDate("publish_date"), rs
										.getBigDecimal("default_price"), rs
										.getInt("width"), rs.getInt("height"),
								rs.getInt("length"), rs.getInt("weight"), rs
										.getFloat("screen_size"), rs
										.getString("os"), rs.getString("cpu"),
								rs.getInt("ram_size"), rs
										.getString("hard_drive_model"), rs
										.getInt("hard_drive_size"), rs
										.getInt("resolution_horizontal"), rs
										.getInt("resolution_vertical"), rs
										.getBoolean("touch_screen"), rs
										.getString("gpu"), rs
										.getString("graphics_card_type"), rs
										.getInt("graphics_memory"), rs
										.getFloat("battery_life"), rs
										.getInt("battery_cell"), rs
										.getString("optical_drive"), rs
										.getInt("optical_drive_speed"), rs
										.getBoolean("track_point"), rs
										.getBoolean("front_camera"), rs
										.getFloat("camera_pixel"), rs
										.getInt("usb_port_2"), rs
										.getInt("usb_port_3"), rs
										.getString("usb_port_type"), rs
										.getBoolean("vga_port"), rs
										.getBoolean("hdmi_port"), rs
										.getString("card_reader_type"), rs
										.getString("bluetooth"), rs
										.getString("antivirus_software"), rs
										.getBoolean("laptop_bag"), rs
										.getInt("warranty"), rs
										.getString("images"));
					});

		} catch (DataAccessException e) {
			throw new IOException(e);
		}
	}

}
