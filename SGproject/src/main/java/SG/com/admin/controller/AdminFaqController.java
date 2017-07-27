package SG.com.admin.controller;


import java.util.HashMap;//해쉬맵쓸것
import java.util.List;//리스트쓸것
import java.util.Map;//맵쓸것

import javax.annotation.Resource;//어노테이션 Resource쓸것
import javax.servlet.http.HttpServletRequest;//request쓸것

import org.springframework.stereotype.Controller;//이것이 컨트롤러다
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


import SG.com.common.CommandMap;
/*import spring.kh.siroragi.Paging;*/
//페이징
import SG.com.common.Paging;
import SG.com.admin.service.AdminFaqService;

@Controller//컨트롤러를 설정하면 스프링 컨테이너에서 객체로 만들어져서 사용가능
public class AdminFaqController {
	
	//검색 넘버와,검색 값(String)을 받아오기위한 변수
	private int searchNum;
	String isSearch;
	
	//페이징 관련 변수
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 10;
	private String pagingHtml;
	private Paging page;
	
	
	@Resource(name="adminFaqService")
	private AdminFaqService adminFaqService;
	
	//관리자 페이지로 이동 *수정사항 흐름도에 넣어야함*
	@RequestMapping(value = "/admin" )
	public String list(){
		return "adminForm";//adminMain.jsp로 이동하게 설정
	}
	//FAQ관리자 페이지로 이동(목록이동)
	@RequestMapping(value="/adminFaq")
	public String adminFaq(Model model,CommandMap commandMap, HttpServletRequest request)throws Exception{
		
		String isSearch = request.getParameter("isSearch");
		
		Map<String, Object> isSearchMap = new HashMap<String, Object>();
		Map<String, Object> categoryMap = new HashMap<String, Object>();
		
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) { //currentPage가 null 이거나 공백 이거나 0 일때.
			currentPage = 1;
		} else { //currentPage에 담겨오는 값이 있다면 담겨오는 값으로 설정.
			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		}
		
		
		List<Map<String,Object>> faqList = adminFaqService.faqList(commandMap.getMap());
		
		if(request.getParameter("isSearch") !=null){
			
			searchNum = Integer.parseInt(request.getParameter("searchNum"));
			isSearchMap.put("isSearch",isSearch);
			
			if(searchNum == 0){//글제목=0
				faqList = adminFaqService.faqSearch0(isSearchMap);
				}
			if(searchNum == 1){//글내용=1
				faqList = adminFaqService.faqSearch1(isSearchMap);
			}
			System.out.println(faqList);
			totalCount = faqList.size();
			page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminFaq");
			pagingHtml = page.getPagingHtml().toString();
			
			
			model.addAttribute("list",faqList);
			
			return "admin_faq";
			
			
		}else if(request.getParameter("category") != null){
			String ctg = request.getParameter("category");
			System.out.println(ctg);
			
			categoryMap.put("FAQ_CATEGORY", ctg);
			faqList = adminFaqService.faqSearch2(categoryMap);
			
			totalCount = faqList.size();
			page = new Paging(currentPage, totalCount, blockCount, blockPage,"adminFaq",ctg);
			pagingHtml = page.getPagingHtml().toString();
			
			model.addAttribute("category",ctg);
			model.addAttribute("pagingHtml", pagingHtml);
			model.addAttribute("currentPage",currentPage);
			model.addAttribute("list",faqList);
			return "admin_faq";
		
		}else{//검색 값이 없을때
			totalCount = faqList.size();
			page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminFaq");
			pagingHtml = page.getPagingHtml().toString();

			int lastCount = totalCount;

			if (page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;

			faqList = faqList.subList(page.getStartCount(), lastCount);

			model.addAttribute("isSearch", isSearch);
			model.addAttribute("searchNum", searchNum);
			model.addAttribute("totalCount", totalCount);
			model.addAttribute("pagingHtml", pagingHtml);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("list",faqList);
			return "admin_faq";
		}
	}
	
	//FAQ등록폼
	@RequestMapping(value="/adminFaqForm")
	public String adminFaqForm(){
		return "admin_FaqForm";
	}//jsp에서 등록폼에서 submit해서 db로 insert된것을 아래 FAQ등록에서
	//맵에서 꺼내와서 리다이렉트로 tiles걸지않고 url에다가 봐로 쏴줌
	
	//FAQ등록
	@RequestMapping(value = "/adminFaqWrite")
	public String adminFaqWrite(CommandMap commandMap, HttpServletRequest request) throws Exception {
		
		System.out.println(commandMap.getMap());
		adminFaqService.faqWrite(commandMap.getMap(), request);
		//맵에서 꺼내쓸때 항상 유의할점은 jsp에서 db에서 설정된 type들과 매핑이되는지
		//를 자세히 봐야한다

		return "redirect:/adminFaq";
	}
	//FAQ 수정폼 이동
	@RequestMapping(value = "/adminFaqModifyForm")
	public String adminFaqModifyForm(Model model,CommandMap commandMap,HttpServletRequest request) throws Exception {
		commandMap.put("FAQ_NO", request.getParameter("FAQ_NO"));
		boolean modify = true;
		Map<String, Object> map = adminFaqService.faqDetail(commandMap.getMap());
		//상세보기에 대한 것을 커맨드 맵에서 꺼내옴
		model.addAttribute("map", map);
		model.addAttribute("modify",modify);
		//상세보기에 들어있는 정보를 꺼내서 map에 다시저장
		System.out.println(map);
		System.out.println("완료");
		return "admin_FaqForm";
	}
	

	// FAQ 수정
	@RequestMapping(value = "/adminFaqModify")
	public String adminFaqModify(Model model, CommandMap commandMap) throws Exception {

		adminFaqService.faqModify(commandMap.getMap());

		model.addAttribute("FAQ_NO", commandMap.get("FAQ_NO"));

		return "redirect:/adminFaq";
	}
	
	// FAQ 삭제하기
	@RequestMapping(value = "/adminFaqDelete")
	public String adminFaqDelete(CommandMap commandMap) throws Exception {


		adminFaqService.faqDelete(commandMap.getMap());

		return "redirect:/adminFaq";
	}

	
	
}

