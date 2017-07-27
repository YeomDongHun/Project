package SG.com.admin.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import SG.com.admin.service.AdminNoticeService;
import SG.com.common.CommandMap;
import SG.com.common.Paging;


@Controller
public class AdminNoticeController {
	
	@Resource(name="adminNoticeService")
	private AdminNoticeService adminNoticeService;
	
	//검색 변수
	private int searchNum;
	private int noticetype;
	private String isSearch;
	//페이징 변수
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 5;
	private String pagingHtml;
	private Paging page;
	private String filePath ="절대경로";
	
	@RequestMapping(value="/adminNoticeAdminList")
	public String adminNoticeAdminList(Model model,CommandMap commandMap, HttpServletRequest request)throws Exception{
	

		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) {
			currentPage = 1;
			//받아오는 현제페이지가 없으면 페이지 1부터시작
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			//받아오는 현제페이지가 있으면 인트값으로해서 현제페이지 값설정
		}
		
		List<Map<String,Object>>noticeList = adminNoticeService.noticeList(commandMap.getMap());
		//map에서 꺼내온 List뿌려주는 쿼리를 List에 형태인 noticeList에 담는작업
		isSearch = request.getParameter("isSearch");
		//isSearch는 request를해서 받음
		
		if (isSearch != null) {//검색값이 있으면

			noticetype = Integer.parseInt(request.getParameter("NOTICE_TYPE"));
			commandMap.put("NOTICE_TYPE", noticetype);
			commandMap.put("isSearch", isSearch);
			searchNum = Integer.parseInt(request.getParameter("searchNum"));
		   //searchNum= 받아와서 인트값으로 바꾸는 작업


			if (searchNum == 0) { //제목 받는 searchNum==0일떄 실행되는 것
				noticeList = adminNoticeService.searchTitle(commandMap.getMap());
			} else if (searchNum == 1) { // 내용
				noticeList = adminNoticeService.searchContent(commandMap.getMap());
			}
			
			totalCount = noticeList.size();
			page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminNoticeAdminList", searchNum, isSearch);//?"noticeAdminList
			pagingHtml = page.getPagingHtml().toString();

			int lastCount = totalCount;

			if (page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;

			noticeList = noticeList.subList(page.getStartCount(), lastCount);

			model.addAttribute("isSearch", isSearch);
			model.addAttribute("searchNum", searchNum);
			model.addAttribute("totalCount", totalCount);
			model.addAttribute("pagingHtml", pagingHtml);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("noticeList", noticeList);
			
			return "admin_noticeList";
			//마지막으로 리스트로 뿌려줌 

	}else{
	

		totalCount = noticeList.size();

		page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminNoticeAdminList");
		pagingHtml = page.getPagingHtml().toString();

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		noticeList = noticeList.subList(page.getStartCount(), lastCount);

		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pagingHtml", pagingHtml);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("noticeList", noticeList);
		
		return "admin_noticeList";
	}  
	}
	
	
	
	@RequestMapping(value="/adminNoticeForm")
	public String adminNoticeForm(Model model, CommandMap commandMap)throws Exception{
		return "admin_NoticeForm";
	}

	
	
	@RequestMapping(value="/adminNoticeWrite")
	public String adminNoticeWrite(Model model, CommandMap commandMap, HttpServletRequest request)throws Exception{

		adminNoticeService.noticeInsert(commandMap.getMap(), request);
		//인설트
		
		return "redirect:/adminNoticeAdminList";
	}

	
	@RequestMapping(value="/adminNoticeDetail")
	public String adminNoticeDetail(Model model, CommandMap commandMap,HttpServletRequest request)throws Exception{
		
		System.out.println(request.getParameter("NOTICE_NO"));
		
		commandMap.put("NOTICE_NO", request.getParameter("NOTICE_NO"));
		
		System.out.println(commandMap.getMap());
		
		Map<String,Object>notice = adminNoticeService.noticeDetail(commandMap.getMap());
		//상세정보에 대한쿼리를 map에 저장
		model.addAttribute("filePath", filePath);
		//파일 절대경로
		model.addAttribute("notice", notice);
		//상세정보에 대한 쿼리값
		
		return "admin_noticeDetail";
	}
		
	@RequestMapping(value="/adminNoticeModifyForm")
	public String adminNoticeModifyForm(Model model,CommandMap commandMap,HttpServletRequest request)throws Exception{
		commandMap.put("NOTICE_NO", request.getParameter("NOTICE_NO")); //get으로 보낸 NOTICE_NO 받아서 맵에 저장 
		
		Map<String,Object>map =  adminNoticeService.noticeDetail(commandMap.getMap());
		//상세정보에 대한 쿼리문을 map에 저장
		
		boolean modify = true; // (등록폼에서 수정폼으로 사용하기 위한 변수 선언)
		
		model.addAttribute("map",map );
		model.addAttribute("modify",modify); //수정을 위한
		//상세정보에대한 정보를 줘야하기떄문에 위와같은 로직 구성
		return "admin_NoticeForm";
	}
	
	
	
	@RequestMapping(value="/adminNoticeModify")
	public String adminNoticeModify(Model model, CommandMap commandMap, HttpServletRequest request)throws Exception{
		//기존 파일이 있으면
		
		System.out.println(commandMap.getMap());
	    adminNoticeService.noticeUpdate(commandMap.getMap(), request);
		
		return "redirect:/adminNoticeAdminList";
		
	}
	
	
	@RequestMapping(value="/adminNoticeDelete")
	public String adminNoticeDelete(Model model, CommandMap commandMap)throws Exception{

		
	adminNoticeService.noticeDelete(commandMap.getMap());
	//게시물 삭제
	return "redirect:/adminNoticeAdminList";
		
	}			
}
	
	



