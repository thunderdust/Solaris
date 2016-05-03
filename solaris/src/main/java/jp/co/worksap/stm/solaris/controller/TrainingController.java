package jp.co.worksap.stm.solaris.controller;

import jp.co.worksap.stm.solaris.entity.score.ScoreFetchEntity;
import jp.co.worksap.stm.solaris.entity.score.ScoreListEntity;
import jp.co.worksap.stm.solaris.services.specification.ScoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TrainingController {

	@Autowired
	private ScoreService ss;

	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@RequestMapping(value = "/trainings")
	public String trainingManagement() {
		return "trainings";
	}

	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')")
	@RequestMapping(value = "/trainings/findAllScores", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ScoreListEntity getAllScores(@RequestBody ScoreFetchEntity e) {
		return ss.getAllScores(e);
	}
}
