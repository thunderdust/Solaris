package jp.co.worksap.stm.solaris.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmployeeFetchEntity {
	private String firstName;
	private String lastName;
	private String gender;
	private int id;
	private String email;
	private String number;
	private String role;
	private String accountName;
	private String password;
	private String timeJoined;
	private String timeLeaved;

}
