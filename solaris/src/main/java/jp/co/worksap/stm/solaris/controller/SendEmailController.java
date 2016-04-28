package jp.co.worksap.stm.solaris.controller;

import jp.co.worksap.stm.solaris.utils.email.EmailHtmlSender;
import jp.co.worksap.stm.solaris.utils.email.EmailStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.context.Context;

@Controller
public class SendEmailController {

	@Autowired
	private EmailHtmlSender eSender;

	@PreAuthorize("hasAuthority('SALES MANAGER')")
	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public String sendEmail(@RequestParam String email) {
		Context context = new Context();
		context.setVariable("title", "Testing");
		context.setVariable("description", "Test for java spring email sending");
		EmailStatus emailStatus = eSender.send(email, "Title of email",
				"/email/promotion-1", context);
		return emailStatus.toString();
	}
}
