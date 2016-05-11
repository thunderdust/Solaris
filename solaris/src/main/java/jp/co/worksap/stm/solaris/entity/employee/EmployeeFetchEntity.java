package jp.co.worksap.stm.solaris.entity.employee;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmployeeFetchEntity {

	private String firstName;
	private String lastName;
	private String gender;
	private String id;
	private String email;
	private String contact_number;
	private List<String> roles;
	private String password;
	private String timeJoined;

	private String searchParam;
	private int draw;
	private int start;
	private int length;

}
