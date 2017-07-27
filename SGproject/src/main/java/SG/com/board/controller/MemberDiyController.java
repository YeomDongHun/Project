package SG.com.board.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import SG.com.board.service.MemberDiyService;
import SG.com.common.CommandMap;
import SG.com.common.Paging;

@Controller
public class MemberDiyController {
	
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
		
		private Date TodayDate;
		@Resource
		private MemberDiyService memberDiyService;
		
		@RequestMapping(value="/memberDiyBoardList")
		public String adminDiyBoardList(Model model, CommandMap commandMap, HttpServletRequest request)throws Exception{
			if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
					|| request.getParameter("currentPage").equals("0")) {
				currentPage = 1;//받아오는 현제페이지가 없으면 현재페이지를 1로함
			} else {//현제페이지가 있으면 현제페이지를 받아오는 걸 현재페이지로함
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			
			List<Map<String,Object>>diylist = memberDiyService.diyList(commandMap.getMap());
			//리스트 뿌려주는 쿼리문을 adminDiyBoardList라는 List에다가 map형태로 저장
			System.out.println("진입성공 - 리스트 담음");
			isSearch = request.getParameter("isSearch");
			
			if(isSearch !=null){
				
				commandMap.put("isSearch", isSearch);
				searchNum = Integer.parseInt(request.getParameter("searchNum"));
				if (searchNum == 0) { //0일때는 작성자 검색
					diylist = memberDiyService.diySearchM(commandMap.getMap());
				} else if (searchNum == 1) { // 1일때는 제목으로 검색
					diylist = memberDiyService.diySearchT(commandMap.getMap());
				}
				totalCount = diylist.size();
				page = new Paging(currentPage, totalCount, blockCount, blockPage, "memberDiyBoardList", searchNum, isSearch);
				pagingHtml = page.getPagingHtml().toString();

				int lastCount = totalCount;

				if (page.getEndCount() < totalCount)
					lastCount = page.getEndCount() + 1;

				diylist = diylist.subList(page.getStartCount(), lastCount);
				
				model.addAttribute("isSearch", isSearch);//검색하는 값이있을때 필요한 검색값
				model.addAttribute("searchNum", searchNum);//검색하는 값이 있을때  search에대한 구분을 해줘야하는 값
				model.addAttribute("totalCount", totalCount);//페이징
				model.addAttribute("pagingHtml", pagingHtml);//페이징
				model.addAttribute("currentPage", currentPage);//페이징
				model.addAttribute("diylist", diylist);
				
				return "memberdiyboardList_tiles";
				//마지막으로 리스트로 뿌려줌 

		}else{
			searchNum = 0;

			totalCount = diylist.size();

			page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminNoticeAdminList", searchNum, isSearch);
			pagingHtml = page.getPagingHtml().toString();

			int lastCount = totalCount;

			if (page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;

			diylist = diylist.subList(page.getStartCount(), lastCount);
			
			TodayDate = new Date();
			model.addAttribute("totalCount", totalCount);
			model.addAttribute("pagingHtml", pagingHtml);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("diylist", diylist);
			model.addAttribute("TodayDate",TodayDate);
			return "memberdiyboardList_tiles";
		}  
		}
		
		@RequestMapping(value="/memberDiyBoardForm")
		public String memberDiyBoardForm(Model model, CommandMap commandMap) throws Exception{
			
			return "memberdiyBoardForm_tiles";
		}
	
		@RequestMapping(value="/memberDiyBoardInsert")
		public String memberDiyBoardInsert(Model model, CommandMap commandMap, HttpServletRequest request) throws Exception{
			
			memberDiyService.diyInsert(commandMap.getMap(),request);
			
			return "memberdiyboardList_tiles";
		}
		
		@RequestMapping(value="/memberDiyBoardDetail")
		public String memberDiyBoardDetail(Model model,CommandMap commandMap, HttpServletRequest request)throws Exception{
		commandMap.put("DIY_NO", request.getParameter("DIY_NO"));
		Map<String,Object>diy = memberDiyService.diyDetail(commandMap.getMap());
		model.addAttribute("diy", diy);
		//맵에다 넣어서 보내주준다
		return "memberdiyBoardDetail_tiles";
		
		}
		
		@RequestMapping(value="/memberDiyBoardModifyForm")
		public String memberDiyBoardModifyForm(Model model,CommandMap commandMap) throws Exception{
			
			Map<String,Object>diy = memberDiyService.diyDetail(commandMap.getMap());
			
			boolean modify =true;
			
			model.addAttribute("diy",diy);
			model.addAttribute("modify",modify);
			return "memberdiyBoardForm_tiles";
		}
		
		@RequestMapping(value="/memberDiyBoardModify")
		public String memberDiyBoardModify(Model model, CommandMap commandMap,HttpServletRequest request) throws Exception{
			
			memberDiyService.diyModify(commandMap.getMap(), request);
			
			return "redirect:/memberDiyBoardList";
		}
		@RequestMapping(value="/memberDiyBoardDelete")
		public String memberDiyBoardDelete(Model model, CommandMap commandMap) throws Exception{
			
			memberDiyService.diyDelete(commandMap.getMap());
			
			return "redirect:/memberDiyBoardList";
		}
		
		
		@RequestMapping(value="/memberDiyComment",method = RequestMethod.POST )
		public String memberDiyCommentList(Model model,String str,String no,String rate, HttpSession session) throws Exception{
			
			int No = Integer.parseInt(no);
			int rateValue = Integer.parseInt(rate);
			
			Map<String,Object> commentMap = new HashMap<String,Object>();
			commentMap.put("DIYCMT_CONTENT", str);
			commentMap.put("DIY_NO", No);
			
			//session 필요
			String id = session.getAttribute("MEMBER_ID").toString();
			commentMap.put("DIYCMT_ID",id );
			commentMap.put("DIYCMT_RATE",rateValue);
			
			System.out.println(commentMap);
			
			memberDiyService.diyInsertComment(commentMap);
			
		
			List<Map<String, Object>> commentList = memberDiyService.diyCommentList(No);
			model.addAttribute("commentList",commentList);
			
			return "Board/DIYBoard/memberDiyComment";
			
		}
				

}
