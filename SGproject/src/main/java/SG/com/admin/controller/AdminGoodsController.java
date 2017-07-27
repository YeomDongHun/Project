package SG.com.admin.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import SG.com.admin.service.AdminGoodsService;
import SG.com.common.CommandMap;

import SG.com.common.Paging;

@Controller
public class AdminGoodsController {
	
	@Resource(name= "adminGoodsService")
	private AdminGoodsService adminGoodsService;
	
	
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

	
	//상품리스트(완제품)
	@RequestMapping(value="/adminGoodsList")
	public String adminGoodsList(Model model, CommandMap commandMap, HttpServletRequest request) throws Exception{

		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) { //currentPage가 null 이거나 공백 이거나 0 일때.
			currentPage = 1;
		} else { //currentPage에 담겨오는 값이 있다면 담겨오는 값으로 설정.
			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		}
		
		List<Map<String, Object>> goodsList = adminGoodsService.adminGoodsList(commandMap.getMap());
		
		
		if (request.getParameter("isSearch") != null) {
			//isSearch = new String(s.getBytes("iso-8859-1"), "utf-8");
			Map<String,Object>searchMap = new HashMap<String,Object>(); 
			isSearch=request.getParameter("isSearch");
			
			searchNum = Integer.parseInt(request.getParameter("searchNum"));
			
			if (searchNum == 0)// 상품이름 (검색)
				goodsList = adminGoodsService.adminGoodsSearch0(isSearch);
			else if (searchNum == 1)// 상품번호번호 (검색)
				goodsList = adminGoodsService.adminGoodsSearch1(isSearch);
			else if (searchNum == 2)// 카테고리
				goodsList = adminGoodsService.adminGoodsSearch2(isSearch);
			else if (searchNum == 3)// 판매 활성화 or 비활성화 상품 구분
				goodsList = adminGoodsService.adminGoodsSearch3(isSearch);
			else if (searchNum == 4)// 판매량 많은 순
				goodsList = adminGoodsService.adminGoodsSearch4(isSearch);
			else if (searchNum == 5)// 재고가 0인 상품
				goodsList = adminGoodsService.adminGoodsSearch5(isSearch);

		
			totalCount = goodsList.size();
			page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminGoodsList",searchNum,isSearch);
			pagingHtml = page.getPagingHtml().toString();

			int lastCount = totalCount;

			if (page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;

			goodsList = goodsList.subList(page.getStartCount(), lastCount);

			model.addAttribute("isSearch", isSearch);
			model.addAttribute("searchNum", searchNum);
			model.addAttribute("totalCount", totalCount);
			model.addAttribute("pagingHtml", pagingHtml);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("goodsList",goodsList);
			
			return "admin_goodslist";
			
		
		
		
		
		
		}	
		
		totalCount = goodsList.size();
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminGoodsList");
		pagingHtml = page.getPagingHtml().toString();

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		goodsList = goodsList.subList(page.getStartCount(), lastCount);

		model.addAttribute("isSearch", isSearch);
		model.addAttribute("searchNum", searchNum);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pagingHtml", pagingHtml);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("goodsList",goodsList);
		
		return "admin_goodslist";
	}
	
	
	//상품등록 폼으로 이동(완제품)
	@RequestMapping(value="/adminGoodsForm")
	public String adminGoodsForm(Model model)throws Exception{
		
		return "admin_goodsForm";
	}
	
	//상품등록(완제품)
	@RequestMapping(value="/adminGoodsInsert")
	public String adminGoodsInsert(Model model, CommandMap commandmap, HttpServletRequest request) throws Exception{
		
		adminGoodsService.adminGoodsInsert(commandmap.getMap(), request);
		
		return "redirect:/adminGoodsList";
	}
	
	//상품상세보기 =>수정폼(완제품)
	@RequestMapping(value="/adminGoodsDetail")
	public String adminGoodsDetail(Model model,CommandMap commandmap,HttpServletRequest request) throws Exception{
		
		Map<String,Object> goodsMap = adminGoodsService.adminGoodsDetail(commandmap.getMap());
		
		boolean modify = true;
		
		model.addAttribute("goods",goodsMap);
		model.addAttribute("modify",modify);
		return "admin_goodsModifyForm";
	}
	
	//상품 수정처리
	@RequestMapping(value="/adminGoodsModify")
	public String adminGoodsModify(Model model, CommandMap commandmap,HttpServletRequest request) throws Exception{
		
		adminGoodsService.adminGoodsModify(commandmap.getMap(), request);
		
		return "redirect:/adminGoodsList";
	}
	
	//상품삭제(완제품)
	@RequestMapping(value="/adminGoodsDelete")
	public String adminGoodsDelete(Model model,CommandMap commandmap) throws Exception{
		
		adminGoodsService.adminGoodsDelete(commandmap.getMap());
		
		return "redirect:/adminGoodsList";
	}
	
	
		////////////////////////////////토핑 관련 로직///////////////////////////	////
	
	@RequestMapping(value="/adminToppingList")
	public String adminToppingList(Model model,CommandMap commandmap,HttpServletRequest request)throws Exception{
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) { //currentPage가 null 이거나 공백 이거나 0 일때.
			currentPage = 1;
		} else { //currentPage에 담겨오는 값이 있다면 담겨오는 값으로 설정.
			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		}
		
		List<Map<String, Object>> toppingList = adminGoodsService.adminToppingList(commandmap.getMap());
		
		
		if (request.getParameter("isSearch") != null) {
			//isSearch = new String(s.getBytes("iso-8859-1"), "utf-8");
			isSearch=request.getParameter("isSearch");
			searchNum = Integer.parseInt(request.getParameter("searchNum"));

			if (searchNum == 0)// 상품이름 (검색)
				toppingList = adminGoodsService.adminToppingSearch0(isSearch);
			else if (searchNum == 1)// 상품번호번호 (검색)
				toppingList = adminGoodsService.adminToppingSearch1(isSearch);
			else if (searchNum == 2)// 카테고리
				toppingList = adminGoodsService.adminToppingSearch2(isSearch);
			else if (searchNum == 3)// 판매 활성화 or 비활성화 상품 구분
				toppingList = adminGoodsService.adminToppingSearch3(isSearch);
			else if (searchNum == 4)// 판매량순 정렬
				toppingList = adminGoodsService.adminToppingSearch4(isSearch);
			else if (searchNum == 5)// 재고 0
				toppingList = adminGoodsService.adminToppingSearch5(isSearch);

			totalCount = toppingList.size();
			page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminToppingList",searchNum,isSearch);
			pagingHtml = page.getPagingHtml().toString();

			int lastCount = totalCount;

			if (page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;

			toppingList = toppingList.subList(page.getStartCount(), lastCount);

			model.addAttribute("isSearch", isSearch);
			model.addAttribute("searchNum", searchNum);
			model.addAttribute("totalCount", totalCount);
			model.addAttribute("pagingHtml", pagingHtml);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("toppingList",toppingList);
			
			return "admin_toppingList";
		
		
		}	
		
		totalCount = toppingList.size();
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminToppingList");
		pagingHtml = page.getPagingHtml().toString();

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		toppingList = toppingList.subList(page.getStartCount(), lastCount);

		model.addAttribute("isSearch", isSearch);
		model.addAttribute("searchNum", searchNum);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pagingHtml", pagingHtml);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("toppingList",toppingList);
		
		return "admin_toppingList";
	}
	
	//토핑등록 폼이동 
	@RequestMapping(value="/adminToppingForm")
	public String adminToppingForm(Model model) throws Exception{
		
		return "admin_toppingForm";
	}
	
	//토핑상세보기 ==> 수정하기
	@RequestMapping(value="/adminToppingDetail")
	public String adminToppingDetail(CommandMap commandMap, Model model) throws Exception{
	
		Map<String,Object>toppingMap = adminGoodsService.adminToppingDetail(commandMap.getMap());
		
		boolean modify = true;
		
		model.addAttribute("topping",toppingMap);
		model.addAttribute("modify",modify);
		return "admin_modifyForm";
	}
	
	//토핑등록
	@RequestMapping(value="/adminToppingInsert")
	public String adminToppingInsert(Model model, CommandMap commandmap, HttpServletRequest request) throws Exception{
		
		adminGoodsService.adminToppingInsert(commandmap.getMap(), request);
		
		return "redirect:/adminToppingList";
	}
	//토핑수정처리
	@RequestMapping(value="/adminToppingModify")
	public String adminToppingModifyForm(Model model,CommandMap commandMap,HttpServletRequest request) throws Exception{
		
		adminGoodsService.adminToppingModify(commandMap.getMap(),request);
		
		return "redirect:/adminToppingList";
	}
	
	//토핑삭제
	@RequestMapping(value="/adminToppingDelete")
	public String adminToppingDelete(Model model,CommandMap commandMap, HttpServletRequest request) throws Exception{
		
		adminGoodsService.adminToppingDelete(commandMap.getMap(), request);
		
		return "redirect:/adminToppingList";
	}
	
}
