package jp.co.worksap.stm.solaris.services.implementation;

import java.io.IOException;
import java.util.List;

import jp.co.worksap.stm.solaris.dao.specification.ScoreDao;
import jp.co.worksap.stm.solaris.dto.ScoreDto;
import jp.co.worksap.stm.solaris.entity.score.ScoreCreationEntity;
import jp.co.worksap.stm.solaris.entity.score.ScoreEntity;
import jp.co.worksap.stm.solaris.entity.score.ScoreFetchEntity;
import jp.co.worksap.stm.solaris.entity.score.ScoreListEntity;
import jp.co.worksap.stm.solaris.exceptions.ServiceException;
import jp.co.worksap.stm.solaris.services.specification.ScoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class ScoreServiceImplementation implements ScoreService {

	@Autowired
	private ScoreDao sd;

	@Override
	public ScoreListEntity getAllScores(ScoreFetchEntity s)
			throws ServiceException {

		List<ScoreDto> dtoList = null;
		int count = 0;
		try {
			dtoList = sd.getAllScores();
			count = sd.getTotalCount();

		} catch (IOException e) {
			throw new ServiceException("Error getting all the scores", e);
		}

		List<ScoreEntity> entities = Lists.newArrayList();
		for (ScoreDto dto : dtoList) {
			ScoreEntity newEntity = new ScoreEntity(dto);
			entities.add(newEntity);
		}
		return new ScoreListEntity(s.getDraw(), count, count, entities);
	}

	@Override
	public ScoreListEntity findByEmployeeId(String id) throws ServiceException {

		List<ScoreDto> dtoList = null;
		int count = 0;
		try {
			dtoList = sd.getByEmployeeId(id);
			count = sd.getTotalCountOfEmployee(id);

		} catch (IOException e) {
			throw new ServiceException(
					"Error getting all the scores of employee: " + id, e);
		}

		List<ScoreEntity> entities = Lists.newArrayList();
		for (ScoreDto dto : dtoList) {
			ScoreEntity newEntity = new ScoreEntity(dto);
			entities.add(newEntity);
		}
		return new ScoreListEntity(0, count, count, entities);
	}

	@Override
	public void insertScore(ScoreCreationEntity s) throws ServiceException {
		
		ScoreDto sdto = new ScoreDto(s);
		
		try {
			sd.insertScore(sdto);
		}catch (IOException e) {
			throw new ServiceException(
					"Error insert score for: " + s.getEmployeeId(), e);
		}
	}
}
