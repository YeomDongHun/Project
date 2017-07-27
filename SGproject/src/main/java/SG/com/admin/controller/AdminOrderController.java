package SG.com.admin.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import SG.com.admin.service.AdminOrderService;
import SG.com.common.CommandMap;

import SG.com.common.Paging;

@Controller
public class AdminOrderController {
	
	@Resource(name="adminOrderService")
	private AdminOrderService adminOrderService;
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
	
	//주문상태 변수
	private int orderstateNum;
	
	//주문목록조회
	@RequestMapping(value="/adminOrderList")
	public String adminOrderList(Model model,CommandMap commandMap,HttpServletRequest request) throws Exception{
		
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) { //currentPage가 null 이거나 공백 이거나 0 일때.
			currentPage = 1;
		} else { //currentPage에 담겨오는 값이 있다면 담겨오는 값으로 설정.
			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		}
		List<Map<String,Object>>order = adminOrderService.adminOrderList(commandMap.getMap());			
		Map<String,Object> ordermap = new HashMap<String,Object>();
		
		if(request.getParameter("searchNum") != null){
			isSearch = request.getParameter("isSearch");//검색어
			System.out.println(isSearch);
			ordermap.put("isSearch",isSearch);
			searchNum = Integer.parseInt(request.getParameter("searchNum").toString()); //검색 구분 번호
		
			if(searchNum == 0){ //주문 검색(주문상태) - 상단 카테고리
				order = adminOrderService.adminOrderSearch0(ordermap);
			}
			else if(searchNum == 1){//주문 검색(주문방법) - 상단 카테고리	
				order = adminOrderService.adminOrderSearch1(ordermap);				
			}
			else if(searchNum == 2){//주문 검색(주문자) 
				order = adminOrderService.adminOrderSearch2(ordermap);
			}
			else if(searchNum == 3){//주문 검색(주문코드)
				order = adminOrderService.adminOrderSearch3(ordermap);
			}
			
			totalCount = order.size();
			page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminOrderList",searchNum,isSearch);
			pagingHtml = page.getPagingHtml().toString();

			int lastCount = totalCount;

			if (page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;

			order = order.subList(page.getStartCount(), lastCount);
			
			System.out.println("뿌려주기만하면댐 ㅋ");
			model.addAttribute("order",order);
			model.addAttribute("isSearch", isSearch);
			model.addAttribute("searchNum", searchNum);
			model.addAttribute("totalCount", totalCount);
			model.addAttribute("pagingHtml", pagingHtml);
			model.addAttribute("currentPage", currentPage);
			
			return "admin_orderList";
			
			
			
		}
		totalCount = order.size();
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminOrderList");
		pagingHtml = page.getPagingHtml().toString();

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		order = order.subList(page.getStartCount(), lastCount);
		
		System.out.println("뿌려주기만하면댐 ㅋ");
		model.addAttribute("order",order);
		model.addAttribute("isSearch", isSearch);
		model.addAttribute("searchNum", searchNum);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pagingHtml", pagingHtml);
		model.addAttribute("currentPage", currentPage);
		
		return "admin_orderList";
		
	}
	
	//주문상태변경
	@RequestMapping(value="/adminOrderStateUpdate")
	public String adminOrderStateUpdate(Model model, CommandMap commandMap,HttpServletRequest request) throws Exception{		
		Map<String,Object> ordermap = new HashMap<String,Object>();
		Map<String,Object>delimap = new HashMap<String,Object>();
		Map<String,Object>pointmap = new HashMap<String,Object>();
		Map<String,Object>trademap = new HashMap<String,Object>();
		
		
		/*int ordernum = Integer.parseInt(request.getParameter("ORDER_NO").toString());//주문번호
*/		int delino = Integer.parseInt(request.getParameter("ORDER_DELI_NO").toString());//배송번호
		int orderstate = Integer.parseInt(request.getParameter("ORDER_STATE").toString());//주문상태
		
		
		String id = request.getParameter("ORDER_MEMBER_ID");		
		
		List<Map<String,Object>>deliorderlist = adminOrderService.adminDeliOrder(delino);
		
		if(orderstate == 0){//입금전에서 배송 준비중 상태로 변경(결제 테이블 입력) ====> 주문이 두개이상일경우..? 어떻게..?						

			
			orderstate = 1; //배송준비중으로
			
			String invno = RandomNum(); //송장번호생성 
			
			delimap.put("DELI_INVOICE_NO", invno); //송장번호 맵에 담음.
			
			delimap.put("DELI_NO", delino); //배송번호 담음
			
			adminOrderService.adminDeliUpdate(delimap);//배송 테이블에 송장번호 업데이트
			
			
			System.out.println(deliorderlist.size());
			//0721 완료
			
				if(deliorderlist.size() == 1){ //배송번호를 통한 조회를 했을경우 주문이 1개일때  -> 즉, 그룹핑이 되어있지 않을때
					

						System.out.println("++++++++!!!!!!!!!!!!!!!!!+"+orderstate);
					ordermap.put("ORDER_DELI_NO", delino);
					ordermap.put("ORDER_STATE", orderstate);
						System.out.println(ordermap);
					adminOrderService.adminOrderStateUpdate(ordermap);//주문상태변경
					
					trademap = deliorderlist.get(0);//id,money,state 담겨있는 Map을 꺼냄..
					
						System.out.println("################################"+trademap);
					trademap.put("TRADE_TYPE", 0);//무통장입금으로 고정.. 카드결제를 같이 할 경우는 받아오기.
					trademap.put("TRADE_MEMBER_ID", id);
					
						System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+trademap);
					adminOrderService.adminTradeUpdate(trademap);//결제 테이블에 입력
					
					
					int point = (int) (Integer.parseInt(String.valueOf(deliorderlist.get(0).get("ORDER_MONEY")))*0.01);
					pointmap.put("POINT_CONTENT", "구매금액적립");
					pointmap.put("POINT_MEMBER_ID",id);
					pointmap.put("POINT_MONEY", point);
					pointmap.put("POINT_ORDER_NO", deliorderlist.get(0).get("ORDER_DELI_NO"));
					
					System.out.println("####################"+pointmap);
					
					adminOrderService.adminPointInsert(pointmap); //결제 금액의 0.1% 포인트 적립
					
				}else{//주문이 2개 이상일 경우
					int point = 0;//포인트
					int trademoney = 0;//결제금액
					for(int i=0; i<deliorderlist.size(); i++){
						ordermap.put("ORDER_NO", deliorderlist.get(i).get("ORDER_NO"));//주문번호
						ordermap.put("ORDER_STATE", orderstate);//주문상태						
						adminOrderService.adminOrderStateUpdate(ordermap);//주문상태 업데이트						
						System.out.println("++++++++++++++"+"주문상태 업데이트 완료"+"++++++++++++++++++");
						
						point = (int) (Integer.parseInt(String.valueOf(deliorderlist.get(i).get("ORDER_MONEY")))*0.01);		
						pointmap.put("POINT_CONTENT", "구매금액적립");
						pointmap.put("POINT_MEMBER_ID",id);
						pointmap.put("POINT_MONEY", point);
						pointmap.put("POINT_ORDER_NO", deliorderlist.get(i).get("ORDER_DELI_NO"));
						adminOrderService.adminPointInsert(pointmap);
						
						System.out.println("++++++++++++++"+"포인트 지급완료"+"++++++++++++++++++");
						
						trademoney += Integer.parseInt(String.valueOf(deliorderlist.get(i).get("ORDER_MONEY")));
						
						trademap.put("ORDER_MONEY", trademoney);
						trademap.put("TRADE_TYPE", 0);//무통장입금으로 고정.. 카드결제를 같이 할 경우는 받아오기.
						trademap.put("TRADE_MEMBER_ID", id);
						trademap.put("ORDER_DELI_NO", delino);
											
					}
						adminOrderService.adminTradeUpdate(trademap); //결제
						System.out.println("++++++++++++++"+"결제 입력완료"+"++++++++++++++++++");
				
				}
				
				//deli_no으로 셀렉문 돌림..
			//경우의수 2가지  => 1. 결제에 들어갈 주문이 1개  or 다수 => list.size() 를 통해 구분
			//1.결제에 들어갈 주문이 1개일 경우 => 단일 베송업데이트
			//2.결제에 들어갈 주문이 2개이상 일 경우 => 반복문을 통해 업데이트 =>배송 업데이트 
			adminOrderService.adminOrderStateUpdate(ordermap);

		}//end if
		else if(orderstate == 1){//배송 준비중에서 배송중 상태로 변경
			orderstate = 2; //배송시작으로
			ordermap.put("ORDER_DELI_NO", delino);
			ordermap.put("ORDER_STATE", orderstate);
			adminOrderService.adminOrderStateUpdate(ordermap);
			
		}else if(orderstate == 2){//배송중에서 배송완료로 상태변경
			orderstate = 3; //배송완료로
			ordermap.put("ORDER_DELI_NO", delino);
			ordermap.put("ORDER_STATE", orderstate);
			adminOrderService.adminOrderStateUpdate(ordermap);
		}else{
			
		}
		/*adminOrderService.adminOrderStateUpdate(ordermap);*/
				
		return "redirect:/adminOrderList";
	}
	
	
	@RequestMapping(value="/adminOrderVeiw")
	public String adminDeliView(Model model, CommandMap commandMap, HttpServletRequest request) throws Exception{

	        commandMap.getMap().put("ORDER_DELI_NO", commandMap.getMap().get("ORDER_DELI_NO")); 
	        commandMap.getMap().put("MEMBER_ID", commandMap.getMap().get("MEMBER_ID"));
	        
	        Map<String,Object> member= new HashMap<String,Object>();
	        
	        member.put("MEMBER_ID", request.getParameter("MEMBER_ID"));

	        List<Map<String, Object>> orderDetail = adminOrderService.adminOrderDetail(commandMap.getMap());
	        model.addAttribute("orderDetail", orderDetail);
	        model.addAttribute("member",member);
		
		return "Admin/adminOrderDetail";
	}
	
	
	//송장번호 생성 메서드
	public String RandomNum()
	{
		StringBuffer buffer = new StringBuffer();
		for(int i = 0;i<=6;i++)
		{
			int n= (int)(Math.random() * 10);
			buffer.append(n);
		}
		return buffer.toString();
	}
	
}
