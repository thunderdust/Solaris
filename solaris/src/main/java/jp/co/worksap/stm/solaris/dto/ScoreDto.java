package jp.co.worksap.stm.solaris.dto;

import java.sql.Date;
import java.util.Calendar;

import jp.co.worksap.stm.solaris.entity.score.ScoreCreationEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScoreDto {

	private String employeeId;
	private int testId;
	private String testType;
	private int score;
	private Date date;

	public ScoreDto(ScoreCreationEntity s) {

		this.employeeId = s.getEmployeeId();
		this.testId = s.getTestId();
		this.testType = s.getTestType();
		this.score = s.getScore();
		if (s.getDate() != null) {
			this.date = s.getDate();
		} else {
			Date sqlDate = new java.sql.Date(Calendar.getInstance()
					.getTimeInMillis());
			this.date = sqlDate;
		}
	}

}
