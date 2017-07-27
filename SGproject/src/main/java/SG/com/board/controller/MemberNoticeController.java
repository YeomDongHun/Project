package SG.com.board.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import SG.com.board.service.MemberNoticeService;
import SG.com.common.CommandMap;
import SG.com.common.Paging;
@Controller
public class MemberNoticeController {
	
	@Resource
	private MemberNoticeService memberNoticeService;
	
	//검색 변수
	private int searchNum;
	private String isSearch;
	//페이징 변수
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 5;
	private String pagingHtml;
	private Paging page;
	
	//리스트 뿌려주는로직
	@RequestMapping(value = "/memberNoticeList", method = RequestMethod.GET)
	public String memberNoticeList(Model model,CommandMap commandMap,HttpServletRequest request)throws Exception{
		
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) {
			currentPage = 1;
			//받아오는 현제페이지가 없으면 페이지 1부터시작
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			//받아오는 현제페이지가 있으면 인트값으로해서 현제페이지 값설정
		}
		List<Map<String,Object>>noticeList = memberNoticeService.noticeList(commandMap.getMap());
		//map에서 꺼내온 List뿌려주는 쿼리를 List에 형태인 noticeList에 담는작업
		isSearch = request.getParameter("isSearch");
		//isSearch는 request를해서 받음
		
		if (isSearch != null) {//검색값이 있으면


			searchNum = Integer.parseInt(request.getParameter("searchNum"));
		   //searchNum= 받아와서 인트값으로 바꾸는 작업


			if (searchNum == 0) { //제목 받는 searchNum==0일떄 실행되는 것
				noticeList = memberNoticeService.searchTitle(commandMap.getMap());
			} else if (searchNum == 1) { // 내용
				noticeList = memberNoticeService.searchContent(commandMap.getMap());
			}
			totalCount = noticeList.size();
			page = new Paging(currentPage, totalCount, blockCount, blockPage, "memberNoticeList", searchNum, isSearch);//?"noticeAdminList
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
			
			return "noticeList_tiles";
			//마지막으로 리스트로 뿌려줌 

	}else{

		totalCount = noticeList.size();

		page = new Paging(currentPage, totalCount, blockCount, blockPage, "memberNoticeList");
		pagingHtml = page.getPagingHtml().toString();

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		noticeList = noticeList.subList(page.getStartCount(), lastCount);

		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pagingHtml", pagingHtml);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("noticeList", noticeList);
		
		return "noticeList_tiles";
	}  
		
	}
	//상세정보
	@RequestMapping(value="/memberNoticeDetail")
	public String memberNoticeDetail(Model model, CommandMap commandMap)throws Exception{
		Map<String,Object>notice = memberNoticeService.noticeDetail(commandMap.getMap());
		model.addAttribute("notice", notice);
		return "memberNoticeDetail_tiles";
	}
}
