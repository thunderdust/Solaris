package jp.co.worksap.stm.solaris.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmployeeFetchByRoleEntity {

	private String role;
	private int draw;
	private int start;
	private int length;
}
