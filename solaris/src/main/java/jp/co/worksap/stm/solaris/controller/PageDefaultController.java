package jp.co.worksap.stm.solaris.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageDefaultController {
	// for 403 access denied pages
	@RequestMapping(value = "/403")
	public String accessDenied(Principal user) {
		return "error/unauthorized";
	}
}
