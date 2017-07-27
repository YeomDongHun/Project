package SG.com.admin.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import SG.com.common.CommandMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import SG.com.common.Paging;
import SG.com.admin.service.AdminMemberService;

@Controller
public class AdminMemberController {
		@Resource(name="adminMemberService")
		private AdminMemberService adminMemberService;
		
		//검색 관련 변수
		private int searchNum;
		private String isSearch;

		//페이징 관련 변수
		private int currentPage = 1;
		private int totalCount;
		private int blockCount = 10;
		private int blockPage = 10;
		private String pagingHtml;
		private Paging page;

	@RequestMapping(value="/adminMemberListON")
	public String adminMemberListON(Model model,CommandMap commandMap,HttpServletRequest request) throws Exception{
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) { //currentPage가 null 이거나 공백 이거나 0 일때.
			currentPage = 1;
		} else { //currentPage에 담겨오는 값이 있다면 담겨오는 값으로 설정.
			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		}
		
		List<Map<String, Object>>adminmemberliston = adminMemberService.adminMemberListON();
		adminmemberliston = adminMemberService.adminMemberListON();
		System.out.println(adminmemberliston);
		
		
		
		isSearch = request.getParameter("isSearch");

		commandMap.put("isSearch",isSearch);
		if (isSearch != null) {//검색값이 있으면

			commandMap.put("isSearch", isSearch);
			searchNum = Integer.parseInt(request.getParameter("searchNum"));
		   //searchNum= 받아와서 인트값으로 바꾸는 작업


			if (searchNum == 0) { //아이디
				adminmemberliston = adminMemberService.adminMembersearch0(commandMap.getMap());
			} else if (searchNum == 1) { //이름
				adminmemberliston = adminMemberService.adminMembersearch1(commandMap.getMap());
			}
			

		totalCount = adminmemberliston.size();
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminMemberListON",searchNum,isSearch);
		pagingHtml = page.getPagingHtml().toString();

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		adminmemberliston = adminmemberliston.subList(page.getStartCount(), lastCount);
		
		System.out.println("1==================");
		model.addAttribute("adminmemberliston",adminmemberliston);
		model.addAttribute("isSearch", isSearch);
		model.addAttribute("searchNum", searchNum);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pagingHtml", pagingHtml);
		model.addAttribute("currentPage", currentPage);
		
		return "admin_memberList";
	}else{
		totalCount = adminmemberliston.size();
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminMemberListON",searchNum,isSearch);
		pagingHtml = page.getPagingHtml().toString();

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		adminmemberliston = adminmemberliston.subList(page.getStartCount(), lastCount);
		
		System.out.println("1==================");
		model.addAttribute("adminmemberliston",adminmemberliston);
		model.addAttribute("isSearch", isSearch);
		model.addAttribute("searchNum", searchNum);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pagingHtml", pagingHtml);
		model.addAttribute("currentPage", currentPage);

		return "admin_memberList";
	}
	}
	
	
	
	@RequestMapping(value="/adminMemberListOFF")
	public String adminMemberListOFF(Model model,CommandMap commandMap,HttpServletRequest request) throws Exception{
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) { //currentPage가 null 이거나 공백 이거나 0 일때.
			currentPage = 1;
		} else { //currentPage에 담겨오는 값이 있다면 담겨오는 값으로 설정.
			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		}
		
		List<Map<String, Object>>adminmemberlistoff = adminMemberService.adminMemberListOFF(commandMap.getMap());
		adminmemberlistoff = adminMemberService.adminMemberListOFF(commandMap.getMap());
		System.out.println(adminmemberlistoff);
		
		
		
		isSearch = request.getParameter("isSearch");

		commandMap.put("isSearch",isSearch);
		if (isSearch != null) {//검색값이 있으면

			commandMap.put("isSearch", isSearch);
			searchNum = Integer.parseInt(request.getParameter("searchNum"));
		   //searchNum= 받아와서 인트값으로 바꾸는 작업


			if (searchNum == 0) { //아이디
				adminmemberlistoff = adminMemberService.adminMembersearch0F(commandMap.getMap());
			} else if (searchNum == 1) { //이름
				adminmemberlistoff = adminMemberService.adminMembersearch1F(commandMap.getMap());
			}
			

		totalCount = adminmemberlistoff.size();
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminMemberListOFF",searchNum,isSearch);
		pagingHtml = page.getPagingHtml().toString();

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		adminmemberlistoff = adminmemberlistoff.subList(page.getStartCount(), lastCount);
		
		System.out.println("22222==================");
		model.addAttribute("adminmemberlistoff",adminmemberlistoff);
		model.addAttribute("isSearch", isSearch);
		model.addAttribute("searchNum", searchNum);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pagingHtml", pagingHtml);
		model.addAttribute("currentPage", currentPage);
		
		return "admin_memberListOFF";
	}else{
		totalCount = adminmemberlistoff.size();
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminMemberListOFF",searchNum,isSearch);
		pagingHtml = page.getPagingHtml().toString();

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		adminmemberlistoff = adminmemberlistoff.subList(page.getStartCount(), lastCount);
		
		System.out.println("1==================");
		model.addAttribute("adminmemberlistoff",adminmemberlistoff);
		model.addAttribute("isSearch", isSearch);
		model.addAttribute("searchNum", searchNum);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pagingHtml", pagingHtml);
		model.addAttribute("currentPage", currentPage);

		return "admin_memberListOFF";
	}
	}
	
	
	@RequestMapping(value="/adminMemberDelete")
	public String adminMemberDelete(Model model, CommandMap commandMap, HttpServletRequest request) throws Exception{
	
		@SuppressWarnings("unused")
		List<Map<String, Object>>adminmemberliston = adminMemberService.adminMemberListON();
		adminmemberliston = adminMemberService.adminMemberListON();
		
		adminMemberService.adminMemberDelete(commandMap.getMap());
		return "redirect:/adminMemberListON";
	}
	
	@RequestMapping(value="/adminMemberPoint")
	public String adminMemberPoint(Model model,CommandMap commandMap,HttpServletRequest request) throws Exception{
		
		System.out.println(commandMap.getMap());
		List<Map<String, Object>>adminmemberpoint = adminMemberService.adminMemberPoint(commandMap.getMap());
		adminmemberpoint = adminMemberService.adminMemberPoint(commandMap.getMap());
		System.out.println(adminmemberpoint);
		
		System.out.println("1==================");
		model.addAttribute("adminmemberpoint",adminmemberpoint);
		
		return "admin_memberpoint";
	}
	
	@RequestMapping(value="/adminMemberPointInsert")///이건인설트
	public String adminMemberPointinsert(Model model, CommandMap commandMap, HttpServletRequest request) throws Exception{
		String member_no = request.getParameter("POINT_MEMBER_NO"); //맴버넘버
		int point_member_no = Integer.parseInt(member_no);
		commandMap.put("POINT_MEMBER_NO", point_member_no);
		
		String point = request.getParameter("POINT_MONEY"); //추가할 포인트
		int point_money = Integer.parseInt(point);
		commandMap.put("POINT_MONEY", point_money);
		
		Map<String, Object> pointinsert = new HashMap<String, Object>();
		pointinsert = commandMap.getMap();
		System.out.println(pointinsert);
		
		adminMemberService.adminMemberPointInsert(pointinsert);
		List<Map<String, Object>>adminmemberliston = adminMemberService.adminMemberListON();
		model.addAttribute("adminmemberliston",adminmemberliston);
		return "admin_memberList"; 
	}
	
	
	
}
