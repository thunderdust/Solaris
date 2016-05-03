package jp.co.worksap.stm.solaris.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrainingController {
	
	//@Autowired
	//private TrainingService employeeService;

	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@RequestMapping(value = "/trainings")
	public String trainingManagement() {
		return "trainings";
	}
}
