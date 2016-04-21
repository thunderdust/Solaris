package jp.co.worksap.stm.solaris.entity.customer;

import java.util.Date;

import jp.co.worksap.stm.solaris.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerCreationEntity {

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

	public CustomerCreationEntity(CustomerDto c) {
		this.name = c.getName();
		this.gender = c.getGender();
		this.birthday = c.getBirthday();
		this.email = c.getEmail();
		this.contactNumber = c.getContactNumber();
		this.orderCount = c.getOrderCount();
		this.referralCount = c.getReferralCount();
		this.address = c.getAddress();
		this.occupation = c.getOccupation();
		this.salary = c.getSalary();
		this.registerDate = c.getRegisterDate();
	}

}
