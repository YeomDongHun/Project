package SG.com.admin.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface AdminGoodsService {
	
	
		//상품목록(완제품)
		List<Map<String,Object>> adminGoodsList(Map<String,Object>map) throws Exception;
		
		
		//상품 상세보기(완제품)	
		Map<String,Object> adminGoodsDetail(Map<String,Object>map) throws Exception;
		
		// 상품 검색(상품 이름)
		public List<Map<String, Object>> adminGoodsSearch0(String isSearch) throws Exception;

		// 상품 검색(상품 번호)
		public List<Map<String, Object>> adminGoodsSearch1(String isSearch) throws Exception;

		// 상품 검색(카테고리 검색)
		public List<Map<String, Object>> adminGoodsSearch2(String isSearch) throws Exception;

		// 상품 검색(판매 ON or OFF)
		public List<Map<String, Object>> adminGoodsSearch3(String isSearch) throws Exception;

		// 상품 검색(재고가 0인 상품)
		public List<Map<String, Object>> adminGoodsSearch4(String isSearch) throws Exception;
				
		// 상품 정렬(판매량순)
		public List<Map<String, Object>> adminGoodsSearch5(String isSearch) throws Exception;
		
		//상품 등록
		public void adminGoodsInsert(Map<String,Object>map, HttpServletRequest request) throws Exception;
		
		//상품 수정
		public void adminGoodsModify(Map<String,Object>map, HttpServletRequest request) throws Exception;
		
		//상품 삭제(GOODS_ONOFF = > OFF)
		public void adminGoodsDelete(Map<String,Object>map) throws Exception;
		
		/*// 상품 수정 폼으로 이동
		public List<Map<String, Object>> goodsModifyForm(Map<String, Object> map) throws Exception;
		
		public List<Map<String, Object>> goodsModifyFormImage(Map<String, Object> map) throws Exception;
		// 상품 수정
		public void goodsModify(Map<String, Object> map, HttpServletRequest request) throws Exception;

		// 상품 삭제
		public void goodsDelete(Map<String, Object> map) throws Exception;
*/	
		
		//토핑 조회
		public List<Map<String,Object>>adminToppingList(Map<String,Object>map)throws Exception;
		
		//토핑 상세보기
		public Map<String,Object> adminToppingDetail(Map<String,Object>map)throws Exception;
		
		//토핑 등록
		public void adminToppingInsert(Map<String,Object>map,HttpServletRequest request) throws Exception;
				
		//토핑 수정		
		public void adminToppingModify(Map<String,Object>map,HttpServletRequest request) throws Exception;
		
		//토핑 삭제
		public void adminToppingDelete(Map<String,Object>map,HttpServletRequest request) throws Exception;
		
		//토핑 검색(상품 이름)
		public List<Map<String, Object>> adminToppingSearch0(String isSearch) throws Exception;

		//토핑 검색(상품 번호)
		public List<Map<String, Object>> adminToppingSearch1(String isSearch) throws Exception;

		//토핑 검색(카테고리 검색)
		public List<Map<String, Object>> adminToppingSearch2(String isSearch) throws Exception;

		//토핑 검색(판매 ON or OFF)
		public List<Map<String, Object>> adminToppingSearch3(String isSearch) throws Exception;

		//토핑 검색(재고가 0인 상품)
		public List<Map<String, Object>> adminToppingSearch4(String isSearch) throws Exception;
				
		//토핑 정렬(판매량순)
		public List<Map<String, Object>> adminToppingSearch5(String isSearch) throws Exception;
		
	
}
