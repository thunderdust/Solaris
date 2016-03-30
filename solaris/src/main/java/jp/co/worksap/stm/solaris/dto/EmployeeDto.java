package jp.co.worksap.stm.solaris.dto;

import java.util.List;

import jp.co.worksap.stm.solaris.entity.EmployeeCreationEntity;
import jp.co.worksap.stm.solaris.utils.PasswordHash;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {

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

	public EmployeeDto(EmployeeCreationEntity e) {
		
		firstName = e.getFirstName();
		lastName = e.getLastName();
		gender = e.getGender();
		id = e.getId();
		email = e.getEmail();
		number = e.getNumber();
		role = e.getRole();
		accountName = e.getAccountName();
		if (e.getPassword()!=null){
			// hash password
			PasswordHash hash = new PasswordHash();
			password = hash.encode (e.getPassword());
		}
		timeJoined = e.getTimeJoined();
		timeLeaved = e.getTimeLeaved();

	}
}
