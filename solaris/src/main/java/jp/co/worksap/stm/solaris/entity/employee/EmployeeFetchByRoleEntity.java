package jp.co.worksap.stm.solaris.entity.employee;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmployeeFetchByRoleEntity {

	private List<String> roles;
	private int draw;
	private int start;
	private int length;
}
