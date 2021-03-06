package SG.com.goods.dao;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import SG.com.common.AbstractDAO;

@Repository
public class OrderDao extends AbstractDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	public void orderInsert(Map<String,Object> map) throws Exception{
		sqlSession.insert("order.orderInsert", map);
	}
	
	public void orderInsertBasket(Map<String,Object> map) throws Exception{
		sqlSession.insert("order.orderInsertBasket", map);
	}
	
	public void insertDeli(Map<String, Object> map) throws Exception{
		sqlSession.insert("deli.insertDeli", map);
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object>selectLastOrder() throws Exception {
		
		return sqlSession.selectOne("order.selectLastOrder");
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object>selectLastDeli() throws Exception {
		
		return sqlSession.selectOne("deli.selectLastDeli");
	}
	
	public void updateDeli(Map<String,Object> map) throws Exception{
		sqlSession.update("order.updateDeli", map);
	}
	

	
	@SuppressWarnings("unchecked")
	public Map<String, Object>selectOneDeli(Map<String,Object> map) throws Exception {
		
		return sqlSession.selectOne("deli.selectOneDeli");
	}
	
	public Map<String,Object> basketSelectOne(int no) throws Exception{
		return sqlSession.selectOne("basket.basketSelectOne",no);
	}
	
	public void basketDeleteMem(int member_no) throws Exception{
		sqlSession.delete("basket.basketDeleteMem");
	}
	
	public void updateDeliBasket(Map<String,Object> map) throws Exception{
		sqlSession.update("order.updateDeliBasket",map);
	}
	
	public void deleteBasket(int MEMBER_NO)throws Exception{
		sqlSession.delete("order.deleteBasket",MEMBER_NO);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> selectLastOrderList(Map<String,Object> map) throws Exception{
		return sqlSession.selectList("order.selectLastOrderList",map);
	}
	
	
	public void updateSellCount(Map<String,Object> map) throws Exception{
		sqlSession.update("order.updateSellCount", map);	
	}
	

}
