package jp.co.worksap.stm.solaris.entity.employee;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmployeeFetchAllEntity {

	private String searchParam;
	private int draw;
	private int start;
	private int length;
}
