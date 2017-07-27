package SG.com.sg;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import SG.com.goods.service.GoodsServiceImpl;

@Controller
public class MainController {
	
	@Resource
	GoodsServiceImpl goodsService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Model model ,HttpSession session) throws Exception {
		
		int currentPage=1;
		
		List<Map<String,Object>> list = goodsService.mainList();
		
		if(session.getAttribute("MEMBER_NO")==null){
		session.setAttribute("MEMBER_ID", "visitor");
		session.setAttribute("MEMBER_NO", 0);
		}else if(Integer.parseInt(session.getAttribute("MEMBER_NO").toString())!=0){
			
			//사이드 장바구니 처리
			List<Map<String,Object>> sessionList = new ArrayList<Map<String,Object>>();
	        sessionList = goodsService.BascketMemberSelect( Integer.parseInt(session.getAttribute("MEMBER_NO").toString()));
			session.setAttribute("basketList", sessionList);
			System.out.println("로그인 세션 생성=============="+sessionList);
		}
		
		model.addAttribute("goodsList",list);
		model.addAttribute("currentPage",currentPage);
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
