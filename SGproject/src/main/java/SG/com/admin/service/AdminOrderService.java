package SG.com.admin.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface AdminOrderService {
	
	//주문조회(관리자)
	List<Map<String,Object>> adminOrderList(Map<String,Object>map) throws Exception;

	//주문 검색(주문상태) - 상단 카테고리
	List<Map<String,Object>> adminOrderSearch0(Map<String,Object>map) throws Exception;
	
	//주문 검색(주문방법) - 상단 카테고리	
	List<Map<String,Object>> adminOrderSearch1(Map<String,Object>map) throws Exception;

	//주문 검색(주문자)
	List<Map<String,Object>> adminOrderSearch2(Map<String,Object>map) throws Exception;
	
	//주문 검색(주문코드)
	List<Map<String,Object>> adminOrderSearch3(Map<String,Object>map) throws Exception;
	
	//주문상세보기
	List<Map<String,Object>> adminOrderDetail(Map<String,Object>map) throws Exception;
		
	//주문 상태 변경 (입금전, 배송준비중,배송중,배송완료)
	void adminOrderStateUpdate(Map<String,Object>map) throws Exception;
	
	
	//배송번호를 통해 주문을 꺼냄
	List<Map<String,Object>> adminDeliOrder(int delino) throws Exception;
	
	/*----------------주문상태가 입금확인으로 바뀐후 진행--------------------*/
		
	
	
	
	//결제 테이블 업데이트 => 결제번호,배송번호,아이디를 제외한 나머지 데이터 	
	void adminTradeUpdate(Map<String,Object>map) throws Exception;
	
	//배송 테이블 업데이트 => 송장번호 생성 후 업데이트
	void adminDeliUpdate(Map<String,Object>map) throws Exception;
	
	//포인트 지급 => 입금이 완료되면 결제금액의 1% 삽입
	void adminPointInsert(Map<String,Object>map) throws Exception;
	
}
