package jp.co.worksap.stm.solaris.controller;

import java.security.Principal;

import jp.co.worksap.stm.solaris.entity.score.ScoreCreationEntity;
import jp.co.worksap.stm.solaris.entity.score.ScoreFetchEntity;
import jp.co.worksap.stm.solaris.entity.score.ScoreListEntity;
import jp.co.worksap.stm.solaris.services.specification.ScoreService;
import jp.co.worksap.stm.solaris.utils.AuthorityHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TrainingController {

	@Autowired
	private ScoreService ss;

	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@RequestMapping(value = "/trainings")
	public String trainingManagement() {
		return "training/trainings";
	}

	/*
	 * Display list of one employee's score or all scores depending on ROLE of
	 * current user
	 */
	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@RequestMapping(value = "/trainings/findScores", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ScoreListEntity getScores(@RequestBody ScoreFetchEntity e,
			Principal p) {
		AuthorityHelper helper = new AuthorityHelper(p);

		if (helper.hasAuthority("ADMIN") || helper.hasAuthority("MANAGER")) {
			return ss.getAllScores(e);
		} else {
			return ss.findByEmployeeId(helper.getUsername());
		}
	}

	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@RequestMapping(value = "/trainings/sales-training")
	public String salesTraining() {
		return "training/sales-training";
	}

	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@RequestMapping(value = "/trainings/it-training")
	public String ITTraining() {
		return "training/it-training";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@RequestMapping(value = "/trainings/assessments/sales")
	public String salesAssessment(@RequestParam String index) {
		
		switch(index){
		case "1":
			return "training/sales_test_01";
		case "2":
			return "training/sales_test_02";
		default:
			return "error/not_found";
		}
		
	}
	
	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@RequestMapping(value = "/trainings/assessments/it")
	public String itAssessment(@RequestParam String index) {
		
		switch(index){
		case "1":
			return "training/it_test_01";
		case "2":
			return "training/it_test_02";
		default:
			return "error/not_found";
		}
	}
	
	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@ResponseBody
	@RequestMapping(value = "/trainings/assessments/addscore", method = RequestMethod.POST)
	public void addScoreRecord(@RequestBody ScoreCreationEntity sce, Principal p) {
		AuthorityHelper helper = new AuthorityHelper(p);
		String id = helper.getUsername();
		sce.setEmployeeId(id);
		ss.insertScore(sce);
	}
}
