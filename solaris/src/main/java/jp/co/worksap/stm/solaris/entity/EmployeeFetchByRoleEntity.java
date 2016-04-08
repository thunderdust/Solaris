package jp.co.worksap.stm.solaris.entity;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmployeeFetchByRoleEntity {

	private List<String> role;
	private int draw;
	private int start;
	private int length;
}
