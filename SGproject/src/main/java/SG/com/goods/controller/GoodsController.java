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
	
	@RequestMapping(value = "/goodsList")
	public String goodsList(Model model) throws Exception {
		List<Map<String, Object>> list = goodsService.goodsList();
		model.addAttribute("goodsList",list);
		System.out.println(list);
		return "goodsList_tiles";
	}
	
	@RequestMapping(value = "/goodsDIY")
	public String goodsDIY(Model model) {
		return "goodsDIY_tiles";
	}
	
	@RequestMapping(value="/goodsDetail")
	public String goodsDetail(Model model){
		return "goodsDetail_tiles";
	}
	
	
	
	

}
