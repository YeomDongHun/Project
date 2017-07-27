package SG.com.admin.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
/*import javax.servlet.http.HttpSession;*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*import org.springframework.web.bind.annotation.RequestMethod;*/
/*import org.springframework.web.bind.annotation.RequestParam;*/
/*import org.springframework.web.bind.annotation.ResponseBody;*/
import org.springframework.ui.Model;
/*import org.springframework.validation.BindingResult;*/

import SG.com.admin.service.AdminQnAService;
//Resource가 안먹힘
import SG.com.common.CommandMap;
import SG.com.common.Paging;
//페이징 import

@Controller
public class AdminQnAController {
	
	@Resource(name= "adminQnAService")
	private AdminQnAService adminQnAService;
	
	//검색
	private int searchNum;
	private String isSearch;
	
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 5;
	private String pagingHtml;
	private Paging page;
	
@RequestMapping(value="/adminQnA")
public String adminQnA( CommandMap commandMap, Model model , HttpServletRequest request)throws Exception{	

	if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
			|| request.getParameter("currentPage").equals("0")) {
		currentPage = 1;
		//받아오는 현제페이지가 없으면 페이지 1부터시작
	} else {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		//받아오는 현제페이지가 있으면 인트값으로해서 현제페이지 값설정
	}
	List<Map<String, Object>>qnalist = adminQnAService.adminQnaList(commandMap.getMap());
	
	isSearch = request.getParameter("isSearch");
	commandMap.put("isSearch",isSearch);
	if (isSearch != null) {//검색값이 있으면

		commandMap.put("isSearch", isSearch);
		searchNum = Integer.parseInt(request.getParameter("searchNum"));
	   //searchNum= 받아와서 인트값으로 바꾸는 작업


		if (searchNum == 0) { //작성자
			qnalist = adminQnAService.qnaSearch0(commandMap.getMap());
		} else if (searchNum == 1) { //카테고리
			qnalist = adminQnAService.qnaSearch1(commandMap.getMap());
		}
		
		totalCount = qnalist.size();
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "AdminQnA", searchNum, isSearch);
		pagingHtml = page.getPagingHtml().toString();

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		qnalist = qnalist.subList(page.getStartCount(), lastCount);

		model.addAttribute("isSearch", isSearch);
		model.addAttribute("searchNum", searchNum);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pagingHtml", pagingHtml);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("qnalist", qnalist);
		
		return "admin_qnalist";
		

}else{


	totalCount = qnalist.size();

	page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminQnA", searchNum, isSearch);
	pagingHtml = page.getPagingHtml().toString();

	int lastCount = totalCount;

	if (page.getEndCount() < totalCount)
		lastCount = page.getEndCount() + 1;

	qnalist = qnalist.subList(page.getStartCount(), lastCount);

	model.addAttribute("totalCount", totalCount);
	model.addAttribute("pagingHtml", pagingHtml);
	model.addAttribute("currentPage", currentPage);
	model.addAttribute("qnalist", qnalist);
				
	return "admin_qnalist";
	}
}

		   
		@RequestMapping(value = "/adminAnswerForm")
 		public String adminAnswerForm(CommandMap commandMap, Model model, HttpServletRequest request  )throws Exception{
		
		commandMap.put("QNA_NO", request.getParameter("QNA_NO"));
		Map<String,Object> qna = adminQnAService.qnaDetail(commandMap.getMap());
				
		model.addAttribute("qna",qna);
		return "adminAnswer_Form";
		    	
		    }
		    
		@RequestMapping(value="/adminAnswer")
		public String adminAnswer(CommandMap commandMap, Model model, HttpServletRequest request)throws Exception{
		  adminQnAService.ans(commandMap.getMap());//여기에다가 답변상태 변경에대한 쿼리문 넣어줘야해요
		   return "redirect:/adminQnA";
 	
		    }

		@RequestMapping(value="/adminAnswerDelete")
		public String adminAnswerDelete(CommandMap commandMap, Model model, HttpServletRequest request)throws Exception{
			adminQnAService.qnaDelete(commandMap.getMap());
			return "redirect:/adminQnA";

		    }
	
	
	}

