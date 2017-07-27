package SG.com.admin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import SG.com.common.AbstractDAO;

@Repository("adminOrderDao")
public class AdminOrderDao extends AbstractDAO{
	
	//회원들의 주문조회	
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> adminOrderList(Map<String,Object>map)throws Exception{
		return (List<Map<String,Object>>) selectList("adorder.adOrderList", map);
	}
	
	//주문 검색(주문상태) - 상단 카테고리
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> adminOrderSearch0(Map<String,Object>map) throws Exception{
		return (List<Map<String,Object>>) selectList("adorder.adOrderSearch0", map);
	}
	
	//주문 검색(주문방법) - 상단 카테고리
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> adminOrderSearch1(Map<String,Object>map) throws Exception{
		return (List<Map<String,Object>>) selectList("adorder.adOrderSearch1", map);
	}
	
	//주문 검색(주문자)
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> adminOrderSearch2(Map<String,Object>map) throws Exception{
		return (List<Map<String,Object>>) selectList("adorder.adOrderSearch2", map);
	}
	
	//주문 검색(주문코드)
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> adminOrderSearch3(Map<String,Object>map) throws Exception{
			return (List<Map<String,Object>>) selectList("adorder.adOrderSearch3", map);
	}
	
	//주문 상세보기
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> adminOrderDetail(Map<String,Object>map) throws Exception{
			return (List<Map<String,Object>>) selectList("adorder.adOrderDetail",map);
	}
	
	//배송번호를 통한 조회
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> adminDeliOrderList(int delino) throws Exception{
			return(List<Map<String,Object>>) selectList("adorder.adminDeliOrderList",delino);
	}
	
	//입금 확인 버튼을 눌렀을 시 (결제 테이블 데이터입력 및 배송테이블 업데이트)
	public void adminTradeInsert(Map<String,Object>map) throws Exception{
		insert("adorder.adminTradeInsert",map);		
	}
	
	//주문 상태 변경 (입금전, 배송준비중,배송중,배송완료)
	public void adminOrderStateUpdate(Map<String,Object>map) throws Exception{		
		update("adorder.adOrderStateUpdate",map);	
	}
	
	//송장번호 업데이트
	public void adminDeliUpdate(Map<String,Object>map) throws Exception{
		update("adorder.adOrderDeliUpdate",map);
	}	
	//포인트 지급 => 입금이 완료되면 결제금액의 1% 삽입
	public void adminPointInsert(Map<String,Object>map) throws Exception{	
		insert("adorder.adOrderPointInsert",map);	
	}
	
}
