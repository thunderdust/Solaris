package jp.co.worksap.stm.solaris.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.Iterator;

import jp.co.worksap.stm.solaris.entity.score.ScoreFetchEntity;
import jp.co.worksap.stm.solaris.entity.score.ScoreListEntity;
import jp.co.worksap.stm.solaris.services.specification.ScoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
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

	/*
	 * Display list of one employee's score or all scores depending on ROLE of
	 * current user
	 */
	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@RequestMapping(value = "/trainings/findScores", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ScoreListEntity getScores(@RequestBody ScoreFetchEntity e,
			Principal p) {
		User user = (User) ((Authentication) p).getPrincipal();
		String username = user.getUsername();
		Collection<GrantedAuthority> authorityCollection = user
				.getAuthorities();
		Iterator<GrantedAuthority> ig = authorityCollection.iterator();
		Boolean isManager = false;
		while (ig.hasNext()) {
			GrantedAuthority thisAu = ig.next();
			String thisAuthorityString = thisAu.getAuthority();
			if (thisAuthorityString.contains("ADMIN")
					|| thisAuthorityString.contains("MANAGER")) {
				isManager = true;
			}
		}

		if (isManager) {
			return ss.getAllScores(e);
		} else {
			return ss.findByEmployeeId(username);
		}
	}
}
