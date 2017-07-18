package SG.com.goods.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import SG.com.common.CommandMap;
import SG.com.goods.service.GoodsService;
import SG.com.goods.service.OrderService;
import SG.com.member.service.MemberService;
import SG.com.member.service.PointService;

@Controller
public class OrderController {

	@Resource
	OrderService orderService;
	@Resource
	MemberService memberService;
	@Resource
	GoodsService goodsService;
	@Resource
	PointService pointService;

	
	
	
	//장바구니 구매시  주문 확인 페이지 
	@RequestMapping(value="/basketOrder", method=RequestMethod.POST)
	public String basketOrder(Model model, HttpSession session, CommandMap map, HttpServletRequest request,
			@RequestParam(value="BASKET_NO", required=true) List<Integer> basketno) throws Exception{
		
		session = request.getSession(false);
		
		//비회원일시 로그인 폼으로 
		if(session.getAttribute("MEMBER_ID").toString().equals("visitor")){
			return "redirect:loginForm";
		
		}else{
			//파라미터 값 받기 

			List<Map<String,Object>> Basketlist = orderService.basketSelectOne(Integer.parseInt(session.getAttribute("MEMBER_NO").toString()));
  
		      String member_id=session.getAttribute("MEMBER_ID").toString();
		      int totalMoney=0;
		      for(int i=0;i<Basketlist.size();i++){
		    	  
		    	  totalMoney += Integer.parseInt(Basketlist.get(i).get("BASKET_GOODS_PRICE").toString());
		    	  
		      }
	      
		      
		    //적립 예정 포인트
		    int plusPoint = totalMoney/100;

	      //회원 정보 - 주소 가져오기 
	      Map<String,Object> orderDeli= memberService.myinfoDetail(map.getMap());
	      
	      //나의 포인트 가져오기 
	      map.put("MEMBER_NO", session.getAttribute("MEMBER_NO"));
	      Map<String,Object> myPointMap = pointService.sumPoint(map.getMap());
	      int myPoint=Integer.parseInt(myPointMap.get("SUM").toString());
	      

	     
	      model.addAttribute("orderGoods",Basketlist);
	      model.addAttribute("totalMoney",totalMoney );
	      model.addAttribute("myPoint",myPoint);
	      model.addAttribute("orderDeli",orderDeli);
	      model.addAttribute("plusPoint",plusPoint);
	   
	      
	      return "goodsOrder_tiles";
			
			
			
		}
		
		
		
		
	}
	

	
	
	//상세보기에서 구매시 주문 확인 페이지 이동
	   @RequestMapping(value="/goodsOrder", method=RequestMethod.POST)
	   public String goodsOrder(Model model,HttpServletRequest request, HttpSession session, CommandMap map) throws Exception{
	      
	      session = request.getSession(false);
	      String member_no=session.getAttribute("MEMBER_NO").toString();
	      
	      if(member_no.equals("0")){
	         return "redirect:loginForm";
	      }else{
	    	//파라미터 값 받기 
	    	  
	    	  
		      String tst=request.getParameter("GOODS_NO");
		      int goods_no = Integer.parseInt(tst);
		      String topping_name = request.getParameter("ORDER_TOPPING_NAME");
		      String tst2=request.getParameter("ORDER_GOODS_AMOUNT");
		      int order_goods_amount=Integer.parseInt(tst2);
		      String tst3=request.getParameter("GOODS_POINT");
		      int goods_point=Integer.parseInt(tst3);
	    	  
	    	  
	      String member_id=session.getAttribute("MEMBER_ID").toString();
	      map.put("MEMBER_ID", member_id);
	      map.put("MEMBER_NO", member_no);
	      
	      //상품 정보 가져오기 
	      List<Map<String,Object>> orderGoods = goodsService.selectOneGoodsList(goods_no);
	      //회원 정보 - 주소 가져오기 
	      Map<String,Object> orderDeli= memberService.myinfoDetail(map.getMap());
	      //포인트 가져오기 
	      map.put("MEMBER_NO", session.getAttribute("MEMBER_NO"));
	      Map<String,Object> myPointMap = pointService.sumPoint(map.getMap());
	      int myPoint=Integer.parseInt(myPointMap.get("SUM").toString());
	      
	     
	     //총주문금액
	     int totalMoney = order_goods_amount * Integer.parseInt(orderGoods.get(0).get("GOODS_PRICE").toString());

	     //적립 예정 포인트
	     int plusPoint = totalMoney/100;
	      
	     
	     	orderGoods.get(0).put("TOPPING_NAME", topping_name);
	     	orderGoods.get(0).put("GOODS_AMOUNT", order_goods_amount);

	      model.addAttribute("orderGoods", orderGoods);
	      model.addAttribute("orderDeli", orderDeli);
	      model.addAttribute("myPoint", myPoint);
	      model.addAttribute("GOODS_POINT", goods_point);
	      model.addAttribute("totalMoney", totalMoney);
	      model.addAttribute("plusPoint", plusPoint);
	      
	      return "goodsOrder_tiles";
	      }
	   }
	   
	   
	   
	   //상세보기에서 구매시 주문 완료 페이지 이동 
	   @RequestMapping(value="/goodsOrderSuccess", method=RequestMethod.POST)
	   public String orderSuccess(Model model, CommandMap map, HttpServletRequest request, HttpSession session) throws Exception{
		   	
		 
		  
		  String member_id=map.get("MEMBER_ID").toString();
		  map.put("ORDER_MEMBER_ID", member_id);
		  map.put("DELI_MEMBER_ID", member_id);
		 
		  
	      //주문테이블insert
		  
		  Map<String,Object> orderMap = new HashMap<String,Object>();
		  orderMap.put("ORDER_GOODS_NO", Integer.parseInt(map.get("ORDER_GOODS_NO").toString()));
		  orderMap.put("ORDER_GOODS_AMOUNT", Integer.parseInt(map.get("ORDER_GOODS_AMOUNT").toString()));
		  orderMap.put("ORDER_MEMBER_ID", map.get("ORDER_MEMBER_ID"));
		  orderMap.put("ORDER_MONEY", Integer.parseInt(map.get("ORDER_MONEY").toString()));
		  orderMap.put("ORDER_TRADE_TYPE", Integer.parseInt(map.get("ORDER_TRADE_TYPE").toString()));
		  orderMap.put("ORDER_TOPPING_NAME", map.get("ORDER_TOPPING_NAME"));
		  int ORDER_MONEY = Integer.parseInt(map.getMap().get("ORDER_MONEY").toString());
		  map.getMap().put("ORDER_MONEY", ORDER_MONEY);
	      orderService.orderInsert(map.getMap());
	      
	      System.out.println(map.getMap().get("ORDER_NO"));//NULL
	     
	      //배송테이블 insert
	      Map<String,Object> DeliMap = new HashMap<String,Object>();
		  DeliMap.put("DELI_MEMBER_ID", map.get("DELI_MEMBER_ID"));
		  DeliMap.put("DELI_ORDER_ZIP", request.getParameter("DELI_ORDER_ZIP"));
		  DeliMap.put("DELI_ORDER_ADDR1", request.getParameter("DELI_ORDER_ADDR1"));
		  DeliMap.put("DELI_ORDER_ADDR2", request.getParameter("DELI_ORDER_ADDR2"));
		  DeliMap.put("DELI_ORDER_NAME", request.getParameter("DELI_ORDER_NAME"));
		  DeliMap.put("DELI_ORDER_PHONE", request.getParameter("DELI_ORDER_PHONE"));
		  DeliMap.put("DELI_RECEIVE_ZIP", request.getParameter("DELI_RECEIVE_ZIP"));
		  DeliMap.put("DELI_RECEIVE_ADDR1", request.getParameter("DELI_RECEIVE_ADDR1"));
		  DeliMap.put("DELI_RECEIVE_ADDR2", request.getParameter("DELI_RECEIVE_ADDR2"));
		  DeliMap.put("DELI_RECEIVE_NAME", request.getParameter("DELI_RECEIVE_NAME"));
		  DeliMap.put("DELI_RECEIVE_PHONE", request.getParameter("DELI_RECEIVE_PHONE"));

	      orderService.insertDeli(DeliMap);

	      
	      

	      //마지막 주문 번호, 배송번호 가져오기
	      Map<String, Object> selectLastOrder = orderService.selectLastOrder();
	      int order_no=Integer.parseInt(selectLastOrder.get("ORDER_NO").toString());
	      map.put("ORDER_NO", order_no);
	      Map<String, Object> selectLastDeli = orderService.selectLastDeli();
	      int deli_no=Integer.parseInt(selectLastDeli.get("DELI_NO").toString());
	      map.put("DELI_NO", deli_no);
	      map.put("TRADE_DELI_NO", deli_no);
	      
	      //주문테이블 update
	      orderService.updateDeli(map.getMap());// update SG_ORDER set DELI_NO=#{DELI_NO} where orderno=#{orderno}
	      
	      //결제 insert(결제번호, 배송번호)
	      orderService.successInsert(map.getMap());
	      
	      
	      

	     
	      
	      //주문완료페이지 뿌려줄 것
	      
	      
	      //주문번호, 주문일자, 총주문금액
	      model.addAttribute("orderInfo", selectLastOrder);
	      //주문상품번호 가져오기
	      int order_goods_no=Integer.parseInt(selectLastOrder.get("ORDER_GOODS_NO").toString());
	      //주문상품정보 
	      model.addAttribute("orderGoodsInfo",goodsService.selectOneGoods(order_goods_no));
	      //총주문금액, 총할인금액, 총결제금액, 
	      //dcPoint=1000, plusPoint=110, 
	      System.out.println(request.getParameter("totalMoney"));
	      model.addAttribute("totalMoney", request.getParameter("totalMoney"));
	      model.addAttribute("dcPoint", request.getParameter("dcPoint"));
	      model.addAttribute("plusPoint", request.getParameter("plusPoint"));
	      //수령자정보

	      System.out.println(map.getMap());
	      Map<String, Object> deli = orderService.selectLastDeli();
	      model.addAttribute("deliInfo", deli);
	      
	      return "goodsOrderSuccess_tiles";
	   }
}
