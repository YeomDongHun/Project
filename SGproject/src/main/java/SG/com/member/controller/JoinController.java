package SG.com.member.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JoinController {
	
	@RequestMapping(value = "/joinEmail")
	public String joinEmail(Model model) {
		return "joinEmail";
	}
	
	@RequestMapping(value = "/modal_email")
	public String modal_email(Model model) {
		return "Member/modal_email";
	}
	
	@RequestMapping(value = "/joinForm")
	public String joinForm(Model model) {
		return "joinForm";
	}
	
	@RequestMapping(value = "/joinBody")
	public String body(Model model) {
		return "joinBody";
	}
	
	@RequestMapping(value = "/joinSuccess")
	public String joinSuccess(Model model) {
		return "joinSuccess";
	}
	
	
}
