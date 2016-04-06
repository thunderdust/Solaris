package jp.co.worksap.stm.solaris.entity;

import java.io.Serializable;

import jp.co.worksap.stm.solaris.dto.EmployeeDto;
import lombok.Data;
import lombok.NoArgsConstructor;

/* Roles 
 * 01 Administrator
 * 02 GM
 * 03 SM
 * 04 SR
 * 05 ASA
 * 06 AC
 * */

@NoArgsConstructor
@Data	
public class EmployeeEntity implements Serializable {

	private static final long serialVersionUID = -7395947091407157624L;

	private String firstName;
	private String lastName;
	private String gender;
	private String id;
	private String email;
	private String contact_number;
	private String role;
	private String password;
	private String timeJoined;

	public EmployeeEntity(EmployeeDto e) {
		this.firstName = e.getFirstName();
		this.lastName = e.getLastName();
		this.gender = e.getGender();
		this.id = e.getId();
		this.email = e.getEmail();
		this.contact_number = e.getContact_number();
		this.role = e.getRole();
		this.password = e.getPassword();
		this.timeJoined = e.getTimeJoined();
	}

}
