package SG.com.sg;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Model model, HttpSession session) {
		
		if(session.getAttribute("MEMBER_NO")==null){
			session.setAttribute("MEMBER_NO", 0);
			session.setAttribute("MEMBER_ID", "visitor");
		}
		return "main_tiles";
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home2(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
	public String adminmain(Model model){
		return "admin_main";
	}
}
