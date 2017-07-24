package SG.com.goods.controller;

import java.util.ArrayList;
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
      
      List<Map<String,Object>> Basketlist = new ArrayList<Map<String,Object>>();
      
      //비회원일시 로그인 폼으로 
      if(session.getAttribute("MEMBER_ID").toString().equals("visitor")){
         return "redirect:loginForm";
      
      }else{
         //파라미터 값 받기 
    	  for(int i=0;i<basketno.size();i++){
    	  	Basketlist.add(orderService.basketSelectOne(Integer.parseInt(basketno.get(i).toString())));
    	  }
            String member_id=session.getAttribute("MEMBER_ID").toString();
            int totalMoney=0;
            for(int i=0;i<Basketlist.size();i++){
             
               totalMoney += Integer.parseInt(Basketlist.get(i).get("GOODS_PRICE").toString());
               
            }
         
            
          //적립 예정 포인트
          int plusPoint = totalMoney/100;

         //회원 정보 - 주소 가져오기 
        map.put("MEMBER_ID", session.getAttribute("MEMBER_ID").toString());
         Map<String,Object> orderDeli= memberService.myinfoDetail(map.getMap());
         
         //나의 포인트 가져오기 
         map.put("MEMBER_NO", session.getAttribute("MEMBER_NO"));
         Map<String,Object> myPointMap = pointService.sumPoint(map.getMap());
         int myPoint=Integer.parseInt(myPointMap.get("SUM").toString());
         

         System.out.println("=============세션 생성==================");
         session.setAttribute("orderGoods", Basketlist);
         session.setAttribute("orderDeli", orderDeli);
         System.out.println(session.getAttribute("orderGoods"));
         
         
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
      
      
      
      //주문 완료 페이지 이동 
	  @SuppressWarnings("unchecked")
      @RequestMapping(value="/goodsOrderSuccess", method=RequestMethod.POST)
      public String orderSuccess(Model model, CommandMap map, HttpServletRequest request, HttpSession session) throws Exception{
		  
		  Map<String,Object> count = new HashMap<String,Object>();
		  
		  
		  
		  
	  //상세보기에서 구매시 주문 완료 페이지 이동=============================================================================================== 
    	  if(session.getAttribute("orderGoods")==null || session.getAttribute("orderGoods")==""){
    		  String member_id=map.get("MEMBER_ID").toString();
    		  System.out.println(member_id);
    	        map.put("ORDER_MEMBER_ID", member_id);
    	        map.put("DELI_MEMBER_ID", member_id);
    	       
    	        
    	         //주문테이블insert
    	        Map<String,Object> orderMap = new HashMap<String,Object>();
    	        orderMap.put("ORDER_GOODS_NO", Integer.parseInt(map.get("ORDER_GOODS_NO").toString()));
    	        orderMap.put("ORDER_GOODS_AMOUNT", Integer.parseInt(map.get("ORDER_GOODS_AMOUNT").toString()));
    	        orderMap.put("ORDER_MEMBER_ID", map.get("ORDER_MEMBER_ID"));
    	        orderMap.put("ORDER_MONEY", Integer.parseInt(request.getParameter("dcMoney")));
    	        orderMap.put("ORDER_TRADE_TYPE", Integer.parseInt(map.get("ORDER_TRADE_TYPE").toString()));
    	        orderMap.put("ORDER_TOPPING_NAME", map.get("ORDER_TOPPING_NAME"));
    	        orderService.orderInsert(orderMap);
    	         
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
    	        DeliMap.put("DELI_ORDER_MEMO", request.getParameter("DELI_ORDER_MEMO"));

    	         orderService.insertDeli(DeliMap);

    	         
    	         

    	         //마지막 주문 번호, 배송번호 가져오기
    	         Map<String, Object> selectLastOrder = orderService.selectLastOrder();
    	         System.out.println("11111111111"+selectLastOrder);
    	         
    	         
    	         int order_no=Integer.parseInt(selectLastOrder.get("ORDER_NO").toString());
    	         
    	         map.put("ORDER_NO", order_no);
    	         Map<String, Object> selectLastDeli = orderService.selectLastDeli();
    	         int deli_no=Integer.parseInt(selectLastDeli.get("DELI_NO").toString());
    	         map.put("DELI_NO", deli_no);

    	         
    	         //주문테이블 update
    	         orderService.updateDeli(map.getMap());// update SG_ORDER set DELI_NO=#{DELI_NO} where orderno=#{orderno}

    	         
    	         //사용한 포인트 차감(포인트 사용 insert)
    	         Map<String,Object> pointMap=new HashMap<String,Object>();
    	         int dcPoint = Integer.parseInt(request.getParameter("dcPoint"));
    	         pointMap.put("POINT_MONEY", dcPoint*(-1));
    	         pointMap.put("POINT_MEMBER_NO", session.getAttribute("MEMBER_NO").toString());
    	         pointMap.put("POINT_ORDER_NO", selectLastOrder.get("ORDER_NO").toString());
    	         pointService.usePoint(pointMap);
				
    	        
    	         
    	         //주문완료페이지 뿌려줄 것
    	         count.put("GOODS_AMOUNT", Integer.parseInt(map.get("ORDER_GOODS_AMOUNT").toString()));
    	         count.put("GOODS_NO", Integer.parseInt(map.get("ORDER_GOODS_NO").toString()));
    	         
    	         orderService.updateSellCount(count);
    	         
    	         //주문완료페이지 뿌려줄 것
                 
                 //주문번호, 주문일자, 총주문금액
                 model.addAttribute("orderInfo", selectLastOrder);
                 
                 //주문상품번호 가져오기
                 int order_goods_no=Integer.parseInt(selectLastOrder.get("ORDER_GOODS_NO").toString());
                            

                 //주문상품정보 

                 Map<String,Object> orderGoodsInfo = goodsService.selectOneGoods(order_goods_no);
                 List<Map<String,Object>>goodsList = new ArrayList<Map<String,Object>>();

                 
    	         //diy주문상품정보 
    	         if(session.getAttribute("orderDiyGoods")!=null){
    	         orderGoodsInfo = (Map<String, Object>) session.getAttribute("orderDiyGoods");
    	         orderGoodsInfo.put("TOPPING_NAME", selectLastOrder.get("ORDER_TOPPING_NAME").toString());
    	         goodsList.add(orderGoodsInfo);
    	         }else{ 	     
                 orderGoodsInfo.put("TOPPING_NAME", selectLastOrder.get("ORDER_TOPPING_NAME").toString());
                 goodsList.add(orderGoodsInfo);
    	         }

    	         //총주문금액, 총할인금액, 총결제금액, 
    	         //dcPoint=1000, plusPoint=110, 
                 model.addAttribute("orderGoodsInfo",goodsList);

    	         model.addAttribute("totalMoney", request.getParameter("totalMoney"));
    	         model.addAttribute("dcPoint", request.getParameter("dcPoint"));
    	         model.addAttribute("plusPoint", request.getParameter("plusPoint"));
    			 model.addAttribute("dcMoney", request.getParameter("dcMoney"));
    	         
    	         //수령자정보
    	         model.addAttribute("deliInfo",selectLastDeli);    	         
    	 
    	 //장바구니에서 구매시 주문 완료 페이지 이동=============================================================================================== 	  
    	  }else{
    		  
			//장바구니 받아오기 
    		List<Map<String,Object>> basketList = (List<Map<String, Object>>) session.getAttribute("orderGoods");
			Map<String,Object> DeliList = (Map<String, Object>) session.getAttribute("orderDeli");
			int dcPoint = Integer.parseInt(request.getParameter("dcPoint").toString());
			int dcPointEach = dcPoint/basketList.size();
			
			
			System.out.println(basketList);
			
			//주문 insert
			for(int i=0;i<basketList.size();i++){
	
	 	         basketList.get(i).put("ORDER_MONEY", Integer.parseInt(basketList.get(i).get("GOODS_PRICE").toString())-dcPointEach);
	 	         basketList.get(i).put("ORDER_TRADE_TYPE", Integer.parseInt(request.getParameter("ORDER_TRADE_TYPE").toString()));
	 	         basketList.get(i).put("MEMBER_ID", session.getAttribute("MEMBER_ID").toString());
	 	         
	 	         count.put("GOODS_AMOUNT", Integer.parseInt(basketList.get(i).get("GOODS_AMOUNT").toString()));
    	         count.put("GOODS_NO", Integer.parseInt(basketList.get(i).get("GOODS_NO").toString()));
    	         
    	         orderService.updateSellCount(count);
	 	         orderService.orderInsertBasket(basketList.get(i));	
			}
			
			//마지막 주문 list 가져오기 
			Map<String, Object> lastmap = new HashMap<String, Object>();
			lastmap.put("ORDER_MEMBER_ID", session.getAttribute("MEMBER_ID").toString());
			List<Map<String,Object>> selectLastOrderList = (List<Map<String, Object>>) orderService.selectLastOrderList(lastmap);
	         
			//포인트 사용 insert
			for(int i=0; i<selectLastOrderList.size();i++){
				 
				Map<String,Object> pointMap=new HashMap<String,Object>();
		         pointMap.put("POINT_MONEY", dcPointEach*(-1));
		         pointMap.put("POINT_MEMBER_NO", session.getAttribute("MEMBER_NO").toString());
		         pointMap.put("POINT_ORDER_NO", selectLastOrderList.get(i).get("ORDER_NO").toString());
		         pointService.usePoint(pointMap);
				
			}
			//배송insert
			
			DeliList.put("DELI_MEMBER_ID", session.getAttribute("MEMBER_ID"));
			DeliList.put("DELI_ORDER_ZIP", request.getParameter("DELI_ORDER_ZIP"));
			DeliList.put("DELI_ORDER_ADDR1", request.getParameter("DELI_ORDER_ADDR1"));
			DeliList.put("DELI_ORDER_ADDR2", request.getParameter("DELI_ORDER_ADDR2"));
			DeliList.put("DELI_ORDER_NAME", request.getParameter("DELI_ORDER_NAME"));
			DeliList.put("DELI_ORDER_PHONE", request.getParameter("DELI_ORDER_PHONE"));
			DeliList.put("DELI_RECEIVE_ZIP", request.getParameter("DELI_RECEIVE_ZIP"));
			DeliList.put("DELI_RECEIVE_ADDR1", request.getParameter("DELI_RECEIVE_ADDR1"));
			DeliList.put("DELI_RECEIVE_ADDR2", request.getParameter("DELI_RECEIVE_ADDR2"));
			DeliList.put("DELI_RECEIVE_NAME", request.getParameter("DELI_RECEIVE_NAME"));
			DeliList.put("DELI_RECEIVE_PHONE", request.getParameter("DELI_RECEIVE_PHONE"));
			DeliList.put("DELI_ORDER_MEMO", request.getParameter("DELI_ORDER_MEMO"));
 	    
 	        
			orderService.insertDeli(DeliList);
			 
			//마지막 배송 번호 뽑아오기 
			
			Map<String, Object> selectLastOrder = orderService.selectLastOrder();
	         
	         
		    Map<String, Object> selectLastDeli = orderService.selectLastDeli();
    	    int deli_no=Integer.parseInt(selectLastDeli.get("DELI_NO").toString());
    	    map.put("DELI_NO", deli_no);
    	    
    	    
    	    //주문 배송번호 update
	 		orderService.updateDeliBasket(map.getMap());	
	 			
	 		
	 		System.out.println("basketList=================/n"+basketList);
	 		
	 		int num;
	 		for(int i=0;i<basketList.size();i++){
	 			
	 			num=Integer.parseInt(basketList.get(i).get("BASKET_NO").toString());
				goodsService.basketDelete(num);

	 		}

	 		
	 		
	 		
	 		session.removeAttribute("orderDiyGoods");
			session.removeAttribute("orderGoods");
			session.removeAttribute("orderDeli");
			session.removeAttribute("basketList");
			//결제 완료 페이지에 뿌려줄 정보 
			
			model.addAttribute("deliInfo",selectLastDeli);
			model.addAttribute("orderInfo", selectLastOrder); // 주문날짜 
			model.addAttribute("orderGoodsInfo",basketList);
			model.addAttribute("totalMoney", request.getParameter("totalMoney"));
			model.addAttribute("dcMoney", request.getParameter("dcMoney"));
	        model.addAttribute("dcPoint", request.getParameter("dcPoint"));
	        model.addAttribute("plusPoint", request.getParameter("plusPoint"));

	
    	  }
        
       
         
         return "goodsOrderSuccess_tiles";
      }
	  
	  
	  
	  
	  
	  
	  
	   //사이드장바구니 구매시  주문 확인 페이지 
	   @SuppressWarnings("unchecked")
	@RequestMapping(value="/SideBasketOrder", method=RequestMethod.GET)
	   public String SideBasketOrder(Model model,CommandMap map, HttpSession session, HttpServletRequest request) throws Exception{
	      
	      session = request.getSession(false);
	      
	      List<Map<String,Object>> Basketlist = new ArrayList<Map<String,Object>>();
	      
	      //비회원일시 로그인 폼으로 
	      if(session.getAttribute("MEMBER_ID").toString().equals("visitor")){
	         return "redirect:loginForm";
	      
	      }else{
	         //파라미터 값 받기 
	    	  Basketlist =  (List<Map<String, Object>>) session.getAttribute("basketList");
	    	  }
	      
	      
	            int totalMoney=0;
	            for(int i=0;i<Basketlist.size();i++){
	             
	               totalMoney += Integer.parseInt(Basketlist.get(i).get("GOODS_PRICE").toString());
	               
	            }
	         
	            
	          //적립 예정 포인트
	          int plusPoint = totalMoney/100;

	         //회원 정보 - 주소 가져오기 
	        map.put("MEMBER_ID", session.getAttribute("MEMBER_ID").toString());
	         Map<String,Object> orderDeli= memberService.myinfoDetail(map.getMap());
	         
	         //나의 포인트 가져오기 
	         map.put("MEMBER_NO", session.getAttribute("MEMBER_NO"));
	         Map<String,Object> myPointMap = pointService.sumPoint(map.getMap());
	         int myPoint=Integer.parseInt(myPointMap.get("SUM").toString());
	         

	         System.out.println("=============세션 생성==================");
	         session.setAttribute("orderGoods", Basketlist);
	         session.setAttribute("orderDeli", orderDeli);
	         System.out.println(session.getAttribute("orderGoods"));
	         
	         
	         model.addAttribute("orderGoods",Basketlist);
	         model.addAttribute("totalMoney",totalMoney );
	         model.addAttribute("myPoint",myPoint);
	         model.addAttribute("orderDeli",orderDeli);
	         model.addAttribute("plusPoint",plusPoint);
	      
	         
	         return "goodsOrder_tiles";
    
	   }
	   
	   
	   
	 //DIY 구매
		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/PaymentDiy")
		public String PaymentDiy(Model model,HttpSession session,HttpServletRequest request) throws Exception {
			/*basketList 사이드 장바구니 세션이름*/
			/*toppingList diy 세션 이름*/
			/*list 장바구니에 들어갈 DIY*/
	
			List<Map<String,Object>> toppingList = (List<Map<String, Object>>) session.getAttribute("toppingList");
			Map<String,Object> list = new HashMap<String,Object>();
			
			String GOODS_TOPPING="";

			for(int i =0;i<toppingList.size();i++){
				if(i==0){
					GOODS_TOPPING = toppingList.get(i).get("TOPPING_NAME").toString();
				}else{
					GOODS_TOPPING = GOODS_TOPPING +","+ toppingList.get(i).get("TOPPING_NAME").toString();
				}
			}
			
			request.getParameter("form_price");
			request.getParameter("form_kcal");
			
			
			list.put("GOODS_NO", 0);
			list.put("GOODS_NAME", "DIY샐러드");
			list.put("GOODS_DETAIL", GOODS_TOPPING);
			list.put("TOPPING_NAME", GOODS_TOPPING);
			list.put("GOODS_KCAL", Integer.parseInt(request.getParameter("form_kcal").toString()));
			list.put("GOODS_PRICE", Integer.parseInt(request.getParameter("form_price").toString()));
			list.put("GOODS_THUMBNAIL", "SG_diy.jpg");
			list.put("GOODS_AMOUNT", 1);
			list.put("MEMBER_NO", Integer.parseInt(session.getAttribute("MEMBER_NO").toString()));
			
			
	         

			if(Integer.parseInt(session.getAttribute("MEMBER_NO").toString()) ==0){
				return "redirect:loginForm";
				
			}
			
	         Map<String,Object> orderMap = new HashMap<String,Object>();
	         orderMap.put("MEMBER_ID", session.getAttribute("MEMBER_ID").toString());
	         orderMap.put("MEMBER_NO", Integer.parseInt(session.getAttribute("MEMBER_NO").toString()));
	         Map<String,Object> orderDeli = memberService.myinfoDetail(orderMap);

	         
	         
	       
	         
	       
		
			int totalMoney = Integer.parseInt(list.get("GOODS_PRICE").toString());
			int plusPoint = totalMoney/100;
			
			   Map<String,Object> myPointMap = pointService.sumPoint(orderMap);
		         int myPoint=Integer.parseInt(myPointMap.get("SUM").toString());
		         
		         System.out.println(list);
		         
		         List<Map<String,Object>> orderGoodsList = new ArrayList<Map<String,Object>>();
		         orderGoodsList.add(list);
		         
		         
		         	session.setAttribute("orderDiyGoods", list);
			        session.setAttribute("orderDeli", orderDeli);
			         
					session.removeAttribute("toppingList");
			
		       model.addAttribute("orderGoods",orderGoodsList);
		         model.addAttribute("totalMoney",totalMoney );
		         model.addAttribute("myPoint",myPoint);
		         model.addAttribute("orderDeli",orderDeli);
		         model.addAttribute("plusPoint",plusPoint);
			
			return "goodsOrder_tiles";
			
		}
			
	   
}