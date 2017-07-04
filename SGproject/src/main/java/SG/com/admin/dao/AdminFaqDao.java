package SG.com.admin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import SG.com.common.AbstractDAO;

@Repository("AdminFaqDao")//컨테이너에 넣는 Repository
public class AdminFaqDao extends AbstractDAO {
	
	//전체 리스트
	@SuppressWarnings("unchecked")//경고 무시
	public List<Map<String,Object>> faqList(Map<String,Object>map)throws Exception{
		return (List<Map<String,Object>>) selectList("faq.faqList, map");
	}
	//FAQ상세보기
	@SuppressWarnings("unchecked")
	public Map<String,Object> faqDetail(Map<String,Object>map)throws Exception{
		return(Map<String,Object>) selectOne("faq.faqDetail",map);
		
	}
	
	//FAQ검색(제목)=0
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> faqSearch0(Map<String,Object>map, String isSearch){
		return (List<Map<String,Object>>) faqSearch0("faq.faqSearch0",map, isSearch);
		
	}
	//FAQ검색(내용)=1
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> faqSearch1(Map<String,Object>map, String isSearch){
		return (List<Map<String,Object>>) faqSearch1("faq.faqSearch1",map, isSearch);
		
	}
	//FAQ검색(카테고리)=2
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> faqSearch2(Map<String,Object>map, String isSearch){
		return (List<Map<String,Object>>) faqSearch2("faq.faqSearch2",map, isSearch);
		
	}
	
	//FAQ등록
	public void faqWrite(Map<String, Object>map) throws Exception{
		insert("faq.faqWrite",map);
	}
	
	//FAQ수정	
	public void faqModify(Map<String, Object>map)throws Exception{
		update("faq.faqModify",map);
	}
	
	//FAQ조회수
	public void faqUpdateHitCnt(Map<String,Object>map) throws Exception{
		update("faq.faqUpdateHitCnt",map);
	}
	//FAQ삭제
	public void faqDelete(Map<String, Object>map) throws Exception{
		delete("faq.faqDelete",map);
	}
			
	

}
