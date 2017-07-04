package SG.com.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GoodsController {
	
	@RequestMapping(value = "/goodsList")
	public String goodsList(Model model) {
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
