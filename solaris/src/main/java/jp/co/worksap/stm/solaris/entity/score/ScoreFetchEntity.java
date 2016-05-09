package jp.co.worksap.stm.solaris.entity.score;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ScoreFetchEntity {

	private String employId;
	private int testId;
	private String testType;
	private int score;
	private Date date;

	private String searchParam;
	private int draw;
	private int start;
	private int length;

}
