package jp.co.worksap.stm.solaris.dto;

import java.sql.Timestamp;
import java.util.Date;

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
	private String id;
	private String email;
	private String contact_number;
	private String role;
	private String password;
	private String timeJoined;

	public EmployeeDto(EmployeeCreationEntity e) {

		firstName = e.getFirstName();
		lastName = e.getLastName();
		gender = e.getGender();
		id = e.getId();
		email = e.getEmail();
		contact_number = e.getContact_number();
		role = e.getRole();
		if (e.getPassword() != null) {
			// hash password
			PasswordHash hash = new PasswordHash();
			password = hash.encode(e.getPassword());
		}
		// set time joined as current time
		Date date = new java.util.Date();
		this.timeJoined = (new Timestamp(date.getTime())).toString();
	}
}
