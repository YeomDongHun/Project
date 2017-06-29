package SG.com.Board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberQnAController {
	
	@RequestMapping(value = "/memberQnAList", method = RequestMethod.GET)
	public String memberQnAList(Model model) {
		return "memberQnAList";
	}

}
