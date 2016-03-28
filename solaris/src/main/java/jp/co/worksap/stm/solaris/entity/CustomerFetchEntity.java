package jp.co.worksap.stm.solaris.entity;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CustomerFetchEntity {

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

}
