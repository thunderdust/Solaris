package jp.co.worksap.stm.solaris.entity;

import java.util.Date;
import java.util.List;

import jp.co.worksap.stm.solaris.dto.CustomerDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CustomerCreationEntity {

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

	public CustomerCreationEntity(CustomerDto c) {
		this.name = c.getName();
		this.gender = c.getGender();
		this.birthYear = c.getBirthYear();
		this.email = c.getEmail();
		this.id = c.getId();
		this.number = c.getNumber();
		this.orderCount = c.getOrderCount();
		this.referralCount = c.getReferralCount();
		this.address = c.getAddress();
		this.companyName = c.getCompanyName();
		this.occupation = c.getOccupation();
		this.salary = c.getSalary();
		this.registerDate = c.getRegisterDate();
	}

}
