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
	private String id;
	private String email;
	private String contact_number;
	private List<String> roles;
	private String password;
	private String timeJoined;

	public EmployeeCreationEntity(EmployeeDto e, List<String> roles) {

		this.firstName = e.getFirstName();
		this.lastName = e.getLastName();
		this.gender = e.getGender();
		this.id = e.getId();
		this.email = e.getEmail();
		this.contact_number = e.getContact_number();
		this.roles = roles;
		this.password = e.getPassword();
		this.timeJoined = e.getTimeJoined();

	}
}
