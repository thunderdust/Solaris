package jp.co.worksap.stm.solaris.controller;

import javax.servlet.http.HttpSession;

import jp.co.worksap.stm.solaris.services.specification.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	private static final String APP_NAME = "Solaris";

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = { "/", "/index" })
	public String index(Model model, HttpSession session) {
		model.addAttribute("appName", APP_NAME);
		// return template "index"
		return "index";
	}

}


