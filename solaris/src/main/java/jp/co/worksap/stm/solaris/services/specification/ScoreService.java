package jp.co.worksap.stm.solaris.services.specification;

import jp.co.worksap.stm.solaris.entity.score.ScoreFetchEntity;
import jp.co.worksap.stm.solaris.entity.score.ScoreListEntity;
import jp.co.worksap.stm.solaris.exceptions.ServiceException;

public interface ScoreService {
	
	ScoreListEntity getAllScores(ScoreFetchEntity s) throws ServiceException;
	
	ScoreListEntity findByEmployeeId(String id) throws ServiceException;
	
}
