package SG.com.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberFaqController {
	
	@RequestMapping(value = "/memberFaqList", method = RequestMethod.GET)
	public String memberFaqList(Model model) {
		return "memberFaqList";
	}

}
