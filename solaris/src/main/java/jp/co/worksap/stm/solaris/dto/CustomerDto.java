package jp.co.worksap.stm.solaris.dto;

import java.util.Date;
import java.util.List;

import jp.co.worksap.stm.solaris.entity.CustomerCreationEntity;
import jp.co.worksap.stm.solaris.entity.EmployeeCreationEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {

	private String name;
	private String gender;
	private int birthYear;
	private String email;
	private int id;
	private String number;
	private int orderCount;
	private int referralCount;
	private String address;
	private String companyName;
	private String occupation;
	private int salary;
	private String introducedBy;
	private Date registerDate;

	public CustomerDto(CustomerCreationEntity c) {

		name = c.getName();
		gender = c.getGender();
		birthYear = c.getBirthYear();
		email = c.getEmail();
		id = c.getId();
		number = c.getNumber();
		orderCount = c.getOrderCount();
		referralCount = c.getReferralCount();
		address = c.getAddress();
		companyName = c.getCompanyName();
		occupation = c.getOccupation();
		salary = c.getSalary();
		registerDate = c.getRegisterDate();

	}
}
