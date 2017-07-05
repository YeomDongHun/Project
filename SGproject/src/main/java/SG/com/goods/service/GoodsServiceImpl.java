package SG.com.goods.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import SG.com.goods.dao.GoodsDao;
import SG.com.member.dao.JoinDao;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Resource
	private GoodsDao goodsDao;
	
	@Override
	public List<Map<String, Object>> goodsList() throws Exception {
		// TODO Auto-generated method stub
		return goodsDao.goodsList();
	}

}
