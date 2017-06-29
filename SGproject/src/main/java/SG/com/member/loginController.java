package SG.com.member;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class loginController {
	
	@RequestMapping(value = "/loginForm")
	public String login(Model model) {
		return "loginForm";
	}
	
	@RequestMapping(value = "/loginSuccess")
	public String loginSuccess(Model model) {
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(Model model) {
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/login/findform")
	public String findform(Model model) {
		return "findform";
	}
	
	
	
	
}
