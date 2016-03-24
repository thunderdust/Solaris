package jp.co.worksap.stm.solaris.entity;

import java.util.List;

import jp.co.worksap.stm.solaris.dto.EmployeeDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmployeeCreationEntity {

	private String firstName;
	private String lastName;
	private String gender;
	private int id;
	private String email;
	private String number;
	private List<Integer> roles;
	private String accountName;
	private String password;
	private String timeJoined;
	private String timeLeaved;

	public EmployeeCreationEntity (EmployeeDto e){
		
		this.firstName = e.getFirstName();
		this.lastName = e.getLastName();
		this.gender = e.getGender();
		this.id = e.getId();
		this.email = e.getEmail();
		this.number = e.getNumber();
		this.roles = e.getRoles();
		this.accountName = e.getAccountName();
		this.password = e.getPassword();
		this.timeJoined = e.getTimeJoined();
		this.timeLeaved = e.getTimeLeaved();	
	}
}
