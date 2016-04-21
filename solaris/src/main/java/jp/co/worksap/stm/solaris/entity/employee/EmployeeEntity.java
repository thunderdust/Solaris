package jp.co.worksap.stm.solaris.entity.employee;
import java.io.Serializable;
import java.util.List;

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

	private static final long serialVersionUID = -7395947091403157624L;

	private String firstName;
	private String lastName;
	private String gender;
	private String id;
	private String email;
	private String contact_number;
	private List<String> roles;
	private String password;
	private String timeJoined;

	public EmployeeEntity(EmployeeDto e, List<String> roles) {
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
