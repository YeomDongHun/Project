 
package SG.com.member.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import SG.com.common.CommandMap;
import SG.com.goods.service.GoodsServiceImpl;
import SG.com.goods.service.WishServiceImpl;

@Controller
public class WishController {
 @Resource
 WishServiceImpl wishService;
 @Resource
 GoodsServiceImpl goodsService;
 
 /*@RequestMapping(value = "/wishList")
 public String wishList(Model model) {
  return "mywish";
 }*/
 
 
  //위시 추가
  @RequestMapping(value="/addWish",method = RequestMethod.POST )
  public String wish(Model model,HttpServletRequest request, HttpSession session, CommandMap map) throws Exception{
   
   int WISH_GOODS_NO  = Integer.parseInt(request.getParameter("WISH_GOODS_NO").toString().substring(2));
   
    int WISH_MEMBER_NO  =Integer.parseInt(request.getParameter("WISH_MEMBER_NO").toString()); 
          map.put("WISH_GOODS_NAME", goodsService.selectOneGoods(WISH_GOODS_NO).get("GOODS_NAME"));
          map.put("WISH_MEMBER_NO", WISH_MEMBER_NO);
          map.put("WISH_GOODS_NO", WISH_GOODS_NO);
   System.out.println(map.getMap());
   
   wishService.insertWish(map.getMap());
   return "Goods/goodsList";
   
  }
  
  //위시 삭제
  @RequestMapping(value="/delWish",method = RequestMethod.POST )
  public String wishDel(Model model,HttpServletRequest request, HttpSession session, CommandMap map) throws Exception{
   int WISH_GOODS_NO  = Integer.parseInt(request.getParameter("WISH_GOODS_NO").toString().substring(2));
   int WISH_MEMBER_NO  =Integer.parseInt(request.getParameter("WISH_MEMBER_NO").toString()); 
   map.put("WISH_GOODS_NO", WISH_GOODS_NO);
   map.put("WISH_MEMBER_NO", WISH_MEMBER_NO);
   
   wishService.deleteMyWish(map.getMap());
   return "Goods/goodsList";
   
  }
}