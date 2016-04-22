package jp.co.worksap.stm.solaris.dto;

import java.util.Date;

import jp.co.worksap.stm.solaris.entity.customer.CustomerCreationEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {

	private String name;
	private String gender;
	private Date birthday;
	private String email;
	private String contactNumber;
	private int orderCount;
	private int referralCount;
	private String address;
	private String occupation;
	private int salary;
	private Date registerDate;

	public CustomerDto(CustomerCreationEntity c) {

		name = c.getName();
		gender = c.getGender();
		birthday = c.getBirthday();
		email = c.getEmail();
		contactNumber = c.getContactNumber();
		orderCount = c.getOrderCount();
		referralCount = c.getReferralCount();
		address = c.getAddress();
		occupation = c.getOccupation();
		salary = c.getSalary();
		if (c.getRegisterDate() != null) {
			registerDate = c.getRegisterDate();
		} else {
			// set register date as current time
			Date d = new Date();
			registerDate = d;
		}
	}
}
