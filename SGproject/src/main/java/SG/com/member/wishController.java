package SG.com.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class wishController {

	@RequestMapping(value = "/wishList")
	public String wishList(Model model) {
		return "mywish";
	}
}
