package jp.co.worksap.stm.solaris.entity.customer;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CustomerFetchEntity {

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
	
	private String searchParam;
	private int draw;
	private int start;
	private int length;

}
