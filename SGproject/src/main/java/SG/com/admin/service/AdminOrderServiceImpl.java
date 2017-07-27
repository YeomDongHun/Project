package SG.com.admin.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import SG.com.admin.dao.AdminOrderDao;

@Service("adminOrderService")
public class AdminOrderServiceImpl implements AdminOrderService {
	
	@Resource(name="adminOrderDao")
	private AdminOrderDao adminOrderDao;
	
	//주문조회(관리자)
	public List<Map<String,Object>> adminOrderList(Map<String,Object>map) throws Exception{
		
		return adminOrderDao.adminOrderList(map);
	}

	//주문 검색(주문상태) - 상단 카테고리
	public List<Map<String,Object>> adminOrderSearch0(Map<String,Object>map) throws Exception{
		
		return adminOrderDao.adminOrderSearch0(map);
		
	}
	
	//주문 검색(주문방법) - 상단 카테고리	
	public List<Map<String,Object>> adminOrderSearch1(Map<String,Object>map) throws Exception{
		
		return adminOrderDao.adminOrderSearch1(map);
		
	}

	//주문 검색(주문자)
	public List<Map<String,Object>> adminOrderSearch2(Map<String,Object>map) throws Exception{
		
		return adminOrderDao.adminOrderSearch2(map);
	}
	
	
	//주문 검색(주문코드)
	public List<Map<String,Object>> adminOrderSearch3(Map<String,Object>map) throws Exception{
		
		return adminOrderDao.adminOrderSearch3(map);
	}
	
	//주문 상세보기
	
	public List<Map<String,Object>> adminOrderDetail(Map<String,Object>map) throws Exception{
		return adminOrderDao.adminOrderDetail(map);
	}
		
	//주문 상태 변경 (입금전, 배송준비중,배송중,배송완료)
	public void adminOrderStateUpdate(Map<String,Object>map) throws Exception{
		adminOrderDao.adminOrderStateUpdate(map);
	}
	
	//배송번호를 통해 주문목록 조회
	public List<Map<String,Object>> adminDeliOrder(int delino) throws Exception{
		
		return adminOrderDao.adminDeliOrderList(delino);
	}
	
	/*----------------주문상태가 입금확인으로 바뀐후 진행--------------------*/
		
	//결제 테이블 데이터 입력 	
	public void adminTradeUpdate(Map<String,Object>map) throws Exception{
		adminOrderDao.adminTradeInsert(map);
	}
	
	//배송 테이블 업데이트 => 송장번호 생성 후 업데이트
	public void adminDeliUpdate(Map<String,Object>map) throws Exception{
		adminOrderDao.adminDeliUpdate(map);
	}
	//포인트 지급 => 입금이 완료되면 결제금액의 1% 삽입
	public void adminPointInsert(Map<String,Object>map) throws Exception{
		adminOrderDao.adminPointInsert(map);
	}
	
}
