package SG.com.goods.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import SG.com.goods.service.GoodsServiceImpl;

@Controller
public class GoodsController {
	@Resource
	GoodsServiceImpl goodsService;
	
	int currentPage=1;
	
	@RequestMapping(value = "/goodsList")
	public String goodsList(Model model) throws Exception {
		List<Map<String, Object>> list = goodsService.goodsList();
		model.addAttribute("goodsList",list);
		model.addAttribute("currentPage",currentPage);
		
		return "goodsList_tiles";
	}
	
	@RequestMapping(value = "/goodsDIY")
	public String goodsDIY(Model model) {
		return "goodsDIY_tiles";
	}
	
	@RequestMapping(value="/goodsDetail",method = RequestMethod.GET )
	public String goodsDetail(Model model,int goodsNo,int currentPage) throws Exception{
		Map<String,Object> list = goodsService.selectOneGoods(goodsNo);
		int point =Integer.parseInt(list.get("GOODS_PRICE").toString());
		String image = goodsService.imageList(goodsNo);
		
		model.addAttribute("image",image);
		model.addAttribute("goodsDetail",list);
		model.addAttribute("point", point/100);
		System.out.println(list);
		return "goodsDetail_tiles";
	}
	
	
	
	

}
