package jp.co.worksap.stm.solaris.entity;


import java.sql.Date;

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
	
	public CustomerEntity(CustomerDto cd){
		
	}
}
