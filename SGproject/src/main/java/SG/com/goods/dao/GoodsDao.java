package SG.com.goods.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import SG.com.common.AbstractDAO;

@Repository
public class GoodsDao extends AbstractDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> goodsList() throws Exception {
		
		return sqlSession.selectList("goods.goodsList");
	}

}
