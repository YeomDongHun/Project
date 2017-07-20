package SG.com.goods.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import SG.com.goods.dao.OrderDao;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Resource
	private OrderDao orderDao;

	@Override
	public void orderInsert(Map<String, Object> map) throws Exception {
		orderDao.orderInsert(map);
		
	}

	@Override
	public void insertDeli(Map<String, Object> map) throws Exception {
		orderDao.insertDeli(map);
		
	}

	@Override
	public Map<String, Object> selectLastOrder() throws Exception {
		return orderDao.selectLastOrder();
	}

	@Override
	public Map<String, Object> selectLastDeli() throws Exception {
		return orderDao.selectLastDeli();
	}

	@Override
	public void updateDeli(Map<String, Object> map) throws Exception {
		orderDao.updateDeli(map);
		
	}

	

	@Override
	public Map<String, Object> selectOneDeli(Map<String,Object> map) throws Exception {
		return orderDao.selectOneDeli(map);
	}

	@Override
	public Map<String, Object> basketSelectOne(int no) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(no);
		return orderDao.basketSelectOne(no);
	}

	@Override
	public void basketDeleteMem(int member_no) throws Exception {

		orderDao.basketDeleteMem(member_no);
		
	}

	@Override
	public void orderInsertBasket(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		orderDao.orderInsertBasket(map);
		
	}

	@Override
	public void updateDeliBasket(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		orderDao.updateDeliBasket(map);
		
	}

	


	

	
}
