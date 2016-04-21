package jp.co.worksap.stm.solaris.entity.customer;

import java.util.Date;

import jp.co.worksap.stm.solaris.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerEntity {

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

	public CustomerEntity(CustomerDto cd) {

		this.name = cd.getName();
		this.gender = cd.getGender();
		this.address = cd.getAddress();
		this.birthday = cd.getBirthday();
		this.contactNumber = cd.getContactNumber();
		this.email = cd.getEmail();
		this.occupation = cd.getOccupation();
		this.orderCount = cd.getOrderCount();
		this.referralCount = cd.getReferralCount();
		this.registerDate = cd.getRegisterDate();
		this.salary = cd.getSalary();

	}
}
