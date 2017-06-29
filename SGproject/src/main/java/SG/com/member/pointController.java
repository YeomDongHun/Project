package SG.com.member;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class pointController {
	
	@RequestMapping(value = "/myPoint")
	public String mypoint(Model model) {
		return "mypoint";
	}
	
	
	
	
}
