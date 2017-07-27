package SG.com.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import SG.com.admin.dao.AdminGoodsDao;
import SG.com.common.GoodsImageUtils;
import SG.com.common.ToppingImageUtils;


@Service("adminGoodsService") //해당 클래스를 adminGoodsService로 사용
public class AdminGoodsServiceImpl implements AdminGoodsService{
	
	@Resource(name="adminGoodsDao")
	private AdminGoodsDao adminGoodsDao;
	
	@Resource(name="goodsImageUtils")
	private GoodsImageUtils goodsImageUtils;
	
	@Resource(name="toppingImageUtils")
	private ToppingImageUtils toppingImageUtils;
	//상품목록
	@Override	
	public List<Map<String,Object>> adminGoodsList(Map<String,Object>map) throws Exception{
		return adminGoodsDao.adminGoodsList(map);
	}
	
	@Override
	public Map<String,Object> adminGoodsDetail(Map<String,Object>map) throws Exception{
		
		return adminGoodsDao.adminGoodsDetail(map);
	}
	
	//상품등록
	@Override
	public void adminGoodsInsert(Map<String,Object>map,HttpServletRequest request) throws Exception{
			
		System.out.println(map +"SG_GOODS : DB작업전");
		
		adminGoodsDao.adminGoodsInsert(map); //이미지파일을 제외한 데이터 입력
		
		System.out.println(map +"SG_GOODS : DB작업후");
		
		map = goodsImageUtils.goodsThumbnail(map,request); //goodsThumbnail메서드를 통해  파일작성 및 파일이름을 가져온 후
		
		adminGoodsDao.goodsThumbnailInsert(map); //Thumbnail 파일명이 저장된 map을 매개인자로 주어 데이터 입력.
		
		System.out.println(map+"썸네일 이미지 등록완료");//콘솔창에 찍어봅시다..
		
		List<Map<String,Object>> goodsImageList = goodsImageUtils.parseInsertFileInfo(map, request);//parseInsertFileInfo메서드를 통해 파일 작성 및 파일이름을 가져온 후 리스트<맵>형태로 리턴
		
		if(goodsImageList.size() > 0 ){
			for(int i = 0; i< goodsImageList.size(); i++){//반복문 실행
				adminGoodsDao.goodsImageInsert(goodsImageList.get(i));//리스트안에 담겨진 map들을 전부 입력
				System.out.println(i+"번째 이미지 입력완료");//콘솔에 찍어보자..
			}
		}
		
	}
	
	//상품 수정
	@Override
	public void adminGoodsModify(Map<String,Object>map,HttpServletRequest request) throws Exception{
		
		adminGoodsDao.adminGoodsModify(map); //SG_GOODS 테이블 수정  (이미지 제외)
		
			System.out.println("+++++1.SG_GOODS 테이블 수정 완료 (썸네일 컬럼 제외)++++++"+map);
		
		map = goodsImageUtils.parseUpdateThumbImage(map, request); // 실제 이미지 파일(기존 파일  삭제 => 새 파일 등록) 수정
		
			System.out.println("+++++2.실제 이미지파일 수정 (기존 파일 삭제 => 새로운 파일 저장)++++++"+map);
		
		adminGoodsDao.goodsThumbnailInsert(map);// 테이블 이미지 컬럼 업데이트
			
			System.out.println("+++++3.SG_GOODS 테이블 썸네일 컬럼 업데이트 완료++++++"+map);
			
		map = goodsImageUtils.goodsImageModify(map, request);
		
			System.out.println("IMAGE_IMAGE 수정 완료" + map);
		
		adminGoodsDao.adminImageModify(map); //SG_IMAGE 테이블 업데이트 
			
	}
	
	//상품삭제(GOODS_ONOFF => OFF)
	@Override
	public void adminGoodsDelete(Map<String,Object>map) throws Exception{
		
		adminGoodsDao.adminGoodsDelete(map);
		
	}
	
	// 상품 검색(상품명)
	@Override
	public List<Map<String, Object>> adminGoodsSearch0(String isSearch) throws Exception {

		return adminGoodsDao.adminGoodsSearch0(isSearch);
	}

	// 상품 검색(상품 번호)
	@Override
	public List<Map<String, Object>> adminGoodsSearch1(String isSearch) throws Exception {

		return adminGoodsDao.adminGoodsSearch1(isSearch);
	}

		// 상품 검색(카테고리 검색)
		@Override
		public List<Map<String, Object>> adminGoodsSearch2(String isSearch) throws Exception {

			List<Map<String, Object>> goodsList = adminGoodsDao.adminGoodsSearch2(isSearch);
			return goodsList;
		}

		// 상품 검색(판매 On,Off)
		@Override
		public List<Map<String, Object>> adminGoodsSearch3(String isSearch) throws Exception {

			List<Map<String, Object>> goodsList = adminGoodsDao.adminGoodsSearch3(isSearch);
			return goodsList;
		}

		// 상품 검색(재고가 0인 상품)
		@Override
		public List<Map<String, Object>> adminGoodsSearch4(String isSearch) throws Exception {

			List<Map<String, Object>> goodsList = adminGoodsDao.adminGoodsSearch4(isSearch);
			return goodsList;
		}

		// 상품 정렬(판매량순)
		@Override
		public List<Map<String, Object>> adminGoodsSearch5(String isSearch) throws Exception {
			List<Map<String, Object>> goodsList = adminGoodsDao.adminGoodsSearch5(isSearch);
			return goodsList;
		}
		
		////////////////////////////////////////토핑////////////////////////////////////////
		
		//토핑 조회 
		@Override
		public List<Map<String,Object>> adminToppingList(Map<String,Object>map) throws Exception{
			List<Map<String,Object>> toppingList = adminGoodsDao.adminToppingList(map);
			return toppingList;
		}
		@Override
		public Map<String,Object> adminToppingDetail(Map<String,Object>map) throws Exception{
			return adminGoodsDao.adminToppingDetail(map);
		}
		
		
		//토핑 등록
		@Override 
		public void adminToppingInsert(Map<String,Object>map,HttpServletRequest request) throws Exception{
			
			adminGoodsDao.adminToppingInsert(map); //토핑 등록 (이미지x)
			
			System.out.println("++++++++토핑추가(이미지x)+++++++"+map);
			
			map = toppingImageUtils.toppingImageInsert(map, request); //이미지파일 클래스를 통해 이미지를 경로에 저장 시키고 맵에 저장
			
			
			adminGoodsDao.adminToppingImageInsert(map); //이미지 업데이트
		}
		
		//토핑 수정
		@Override
		public void adminToppingModify(Map<String,Object>map,HttpServletRequest request) throws Exception{
			
			adminGoodsDao.adminToppingModify(map);
			System.out.println("++++++SG_TOPPING 수정완료"+map);
			
			map = toppingImageUtils.toppingImageUpdate(map, request);
			
			adminGoodsDao.adminToppingImageInsert(map);
			System.out.println("++++++SG_TOPPING(이미지 컬럼) 수정완료"+map);
		}
		//토핑삭제
		@Override
		public void adminToppingDelete(Map<String,Object>map,HttpServletRequest request) throws Exception{
			
			adminGoodsDao.adminToppingDelete(map);; //테이블 데이터 삭제
			
			System.out.println(map);
			
			toppingImageUtils.toppingImageDelete(map); //실제 저장된 파일 삭제 
			
		}
		// 토핑검색(상품명) 
		@Override
		public List<Map<String, Object>> adminToppingSearch0(String isSearch) throws Exception {

			return adminGoodsDao.adminToppingSearch0(isSearch);
		}

		// 토핑 검색(상품 번호)
		@Override
		public List<Map<String, Object>> adminToppingSearch1(String isSearch) throws Exception {

			return adminGoodsDao.adminToppingSearch1(isSearch);
		}

		// 토핑 검색(카테고리 검색)
		@Override
		public List<Map<String, Object>> adminToppingSearch2(String isSearch) throws Exception {

			List<Map<String, Object>> toppinglist = adminGoodsDao.adminToppingSearch2(isSearch);
		return toppinglist;
		}

		// 토핑 검색(판매 On,Off)
		@Override
		public List<Map<String, Object>> adminToppingSearch3(String isSearch) throws Exception {

			List<Map<String, Object>> toppinglist = adminGoodsDao.adminToppingSearch3(isSearch);
		return toppinglist;
		
		}
 
		// 토핑 검색(판매수량)
		@Override
		public List<Map<String, Object>> adminToppingSearch4(String isSearch) throws Exception {

			List<Map<String, Object>> toppinglist = adminGoodsDao.adminToppingSearch4(isSearch);
			return toppinglist;
		}
		
		
		// 토핑 정렬(재고=0)
		@Override
		public List<Map<String, Object>> adminToppingSearch5(String isSearch) throws Exception {
			List<Map<String, Object>> toppinglist = adminGoodsDao.adminToppingSearch5(isSearch);
			return toppinglist;
		}

}
