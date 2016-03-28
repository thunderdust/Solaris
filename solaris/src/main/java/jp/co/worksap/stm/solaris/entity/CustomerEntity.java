package jp.co.worksap.stm.solaris.entity;

import java.io.Serializable;
import java.util.Date;

public class CustomerEntity implements Serializable {
	
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
	
	//private static final long serialVersionUID = -7395917071437157624L;
}
