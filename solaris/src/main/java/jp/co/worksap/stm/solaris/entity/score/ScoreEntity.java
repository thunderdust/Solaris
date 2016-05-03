package jp.co.worksap.stm.solaris.entity.score;

import java.sql.Date;

import jp.co.worksap.stm.solaris.dto.ScoreDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScoreEntity {

	private String employeeName;
	private String employId;
	private int testId;
	private String testType;
	private int score;
	private Date date;

	public ScoreEntity(ScoreDto s) {
		this.employeeName = s.getEmployeeName();
		this.employId = s.getEmployId();
		this.testId = s.getTestId();
		this.testType = s.getTestType();
		this.score = s.getScore();
		this.date = s.getDate();
	}
}
