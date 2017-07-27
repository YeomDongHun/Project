package SG.com.admin.dao;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import SG.com.common.AbstractDAO;

@Repository("adminGoodsDao")
public class AdminGoodsDao extends AbstractDAO{
	
	//상품 조회
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> adminGoodsList(Map<String,Object>map)throws Exception{
		return (List<Map<String,Object>>) selectList("adgoods.adgoodsList", map);
	}
	
	//상품 상세보기
	@SuppressWarnings("unchecked")
	public Map<String,Object> adminGoodsDetail(Map<String,Object>map) throws Exception{
		return (Map<String,Object>) selectOne("adgoods.adgoodsDetail",map); 
	}
	
	//이미지를 제외한 상품등록
	public void adminGoodsInsert(Map<String,Object>map)throws Exception{
		insert("adgoods.insertAdminGoods", map);
		
	}
	//상품 썸네일 이미지 등록
	public void goodsThumbnailInsert(Map<String,Object>map)throws Exception{
		update("adgoods.updateGoodsThumbnail",map);
	}
	
	//상품 이미지 등록
	public void goodsImageInsert(Map<String,Object>map)throws Exception{
		insert("adgoods.insertGoodsImage",map);
	}
	
	//상품 삭제
	public void adminGoodsDelete(Map<String,Object>map) throws Exception{
		update("adgoods.adGoodsDelete",map);
	}
	
/*	//상품 이미지 테이블 삭제
	public void adminGoodsImageDelete(Map<String,Object>map) throws Exception{
		delete("adgoods.adGoodsImageDelete",map);
	}*/
			
	//상품 수정
	public void adminGoodsModify(Map<String,Object>map) throws Exception{
		update("adgoods.adgoodsModify",map);
	}
	
	//상품 이미지 수정
	public void adminImageModify(Map<String,Object>map) throws Exception{
		update("adgoods.adImageModify",map);
	}
	
	// 상품 검색(상품 이름)
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> adminGoodsSearch0(String isSearch) throws Exception {
		return (List<Map<String,Object>>)selectList("adgoods.adgoodsListSearch0",isSearch);
	}

	// 상품 검색(상품 번호)
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> adminGoodsSearch1(String isSearch) throws Exception {
		return (List<Map<String,Object>>)selectList("adgoods.adgoodsListSearch1",isSearch);
	}

	// 상품 검색(카테고리 검색)
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> adminGoodsSearch2(String isSearch) throws Exception {
		return (List<Map<String,Object>>)selectList("adgoods.adgoodsListSearch2",isSearch);
	}

	// 상품 검색(판매On,Off)
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> adminGoodsSearch3(String isSearch) throws Exception {
		return (List<Map<String,Object>>)selectList("adgoods.adgoodsListSearch3",isSearch);
	}

	// 상품 검색(판매량 많은 순, 조회수 많은 순)
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> adminGoodsSearch4(String isSearch) throws Exception {
		return (List<Map<String,Object>>)selectList("adgoods.adgoodsListSearch4",isSearch);
	}

	// 상품 검색(재고가 0인 상품)
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> adminGoodsSearch5(String isSearch) throws Exception {
		return (List<Map<String,Object>>)selectList("adgoods.adgoodsListSearch5",isSearch);
	}
		
	//토핑 조회
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> adminToppingList(Map<String,Object>map)throws Exception{
		return (List<Map<String,Object>>) selectList("adgoods.adToppingList", map);
	}
	
	//토핑 상세보기
	@SuppressWarnings("unchecked")
	public Map<String,Object> adminToppingDetail(Map<String,Object>map) throws Exception{
			return (Map<String,Object>)selectOne("adgoods.adToppingDetail",map);
	}
	
	//토핑 수정
	public void adminToppingModify(Map<String,Object>map) throws Exception{
		update("adgoods.adToppingModify",map);
	}
		
	//토핑등록(이미지 제외)		
	public void adminToppingInsert(Map<String,Object>map) throws Exception{
		insert("adgoods.adToppingInsert",map);			
	}
		
	//토핑 이미지 등록(업데이트)
	public void adminToppingImageInsert(Map<String,Object>map) throws Exception{
		update("adgoods.adToppingImageUpdate",map);
	}
	
	//토핑 삭제
	public void adminToppingDelete(Map<String,Object>map) throws Exception{
		delete("adgoods.adToppingDelete",map);
	}
		
	//토핑 검색(상품 이름)
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> adminToppingSearch0(String isSearch) throws Exception {
		return (List<Map<String,Object>>)selectList("adgoods.adToppingListSearch0",isSearch);
	}

	//토핑 검색(상품 번호)
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> adminToppingSearch1(String isSearch) throws Exception {
		return (List<Map<String,Object>>)selectList("adgoods.adToppingListSearch1",isSearch);
	}

	//토핑 검색(카테고리 검색)
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> adminToppingSearch2(String isSearch) throws Exception {
		return (List<Map<String,Object>>)selectList("adgoods.adToppingListSearch2",isSearch);
	}

	//토핑 검색(판매On,Off)
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> adminToppingSearch3(String isSearch) throws Exception {
		return (List<Map<String,Object>>)selectList("adgoods.adToppingListSearch3",isSearch);
	}

	//토핑 검색(판매량 많은 순, 조회수 많은 순)
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> adminToppingSearch4(String isSearch) throws Exception {
		return (List<Map<String,Object>>)selectList("adgoods.adToppingListSearch4",isSearch);
	}
	
	//토핑 검색 (재고0)
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> adminToppingSearch5(String isSearch) throws Exception{
		
		return (List<Map<String,Object>>)selectList("adgoods.adToppingListSearch5",isSearch);
	}
		
		
		
		
		
		
}
