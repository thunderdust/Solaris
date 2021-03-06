package jp.co.worksap.stm.solaris.entity.score;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreListEntity {
	private int draw;
	private int recordsTotal;
	private int recordsFiltered;
	private List<ScoreEntity> scoreEntities;
}
