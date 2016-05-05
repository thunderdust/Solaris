package jp.co.worksap.stm.solaris.controller;

import jp.co.worksap.stm.solaris.services.specification.ScoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportsController {

	// @Autowired
	// private ReportService rs;

	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')")
	@RequestMapping(value = "/reports")
	public String viewReports() {
		return "reports";
	}

}
