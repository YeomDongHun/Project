package SG.com.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import SG.com.common.CommandMap;
//import 페이징
import SG.com.common.Paging;
import SG.com.board.service.MemberFaqService;

@Controller
public class MemberFaqController {
	
	@Resource(name="memberFaqService")
	private MemberFaqService memberFaqService;
	
	
	private int searchNum;//목록을 구분하는 변수
	private String isSearch;//검색값을 받아오게끔 변수 설정
	
	
	//페이징 관련 변수
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 5;
	private int blockPage = 10;
	private String pagingHtml;
	private Paging page;
	
	
	@RequestMapping(value = "/memberFaqList")
	public String memberFaqList(Model model,CommandMap commandMap, HttpServletRequest request)throws Exception{
	
		String isSearch = request.getParameter("isSearch");
		
		Map<String, Object> isSearchMap = new HashMap<String, Object>();
		Map<String, Object> categoryMap = new HashMap<String, Object>();
		
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) { //currentPage가 null 이거나 공백 이거나 0 일때.
			currentPage = 1;
		} else { //currentPage에 담겨오는 값이 있다면 담겨오는 값으로 설정.
			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		}
		
		
		List<Map<String,Object>> faqList = memberFaqService.memberfaqList(commandMap.getMap());
		
		if(request.getParameter("isSearch") !=null){
			
			searchNum = Integer.parseInt(request.getParameter("searchNum"));
			isSearchMap.put("isSearch",isSearch);
			
			if(searchNum == 0){//글제목=0
				faqList = memberFaqService.memberfaqSearch0(isSearchMap);
				}
			if(searchNum == 1){//글내용=1
				faqList = memberFaqService.memberfaqSearch1(isSearchMap);
			}
			System.out.println(faqList);
			totalCount = faqList.size();
			page = new Paging(currentPage, totalCount, blockCount, blockPage, "memberFaqList",searchNum,isSearch);
			pagingHtml = page.getPagingHtml().toString();
			
			
			model.addAttribute("list",faqList);
			
			return "memberFaqList_tiles";
			
			
		}else if(request.getParameter("category") != null){
			String ctg = request.getParameter("category");
			System.out.println(ctg);
			
			categoryMap.put("FAQ_CATEGORY", ctg);
			faqList = memberFaqService.memberfaqSearch2(categoryMap);
			
			totalCount = faqList.size();
			page = new Paging(currentPage, totalCount, blockCount, blockPage,"memberFaqList",ctg);
			pagingHtml = page.getPagingHtml().toString();
			
			model.addAttribute("category",ctg);
			model.addAttribute("pagingHtml", pagingHtml);
			model.addAttribute("currentPage",currentPage);
			model.addAttribute("list",faqList);
			return "memberFaqList_tiles";
		
		}else{//검색 값이 없을때
			totalCount = faqList.size();
			page = new Paging(currentPage, totalCount, blockCount, blockPage, "memberFaqList");
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
			return "memberFaqList_tiles";
		}
		
	}

    @RequestMapping(value="/memberFaqDetail")
    public String faqDetail(Model model, CommandMap commandMap)throws Exception{
    	Map<String, Object>map = memberFaqService.memberfaqDetail(commandMap.getMap());
    	model.addAttribute("map",map.get("map"));
    	
    	return "memberFAqDetail";
    }

}
    



