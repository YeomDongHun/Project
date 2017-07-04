package SG.com.admin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import SG.com.common.AbstractDAO;

@Repository("AdminFaqDao")//�����̳ʿ� �ִ� Repository
public class AdminFaqDao extends AbstractDAO {
	
	//��ü ����Ʈ
	@SuppressWarnings("unchecked")//��� ����
	public List<Map<String,Object>> faqList(Map<String,Object>map)throws Exception{
		return (List<Map<String,Object>>) selectList("faq.faqList, map");
	}
	//FAQ�󼼺���
	@SuppressWarnings("unchecked")
	public Map<String,Object> faqDetail(Map<String,Object>map)throws Exception{
		return(Map<String,Object>) selectOne("faq.faqDetail",map);
		
	}
	
	//FAQ�˻�(����)=0
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> faqSearch0(Map<String,Object>map, String isSearch){
		return (List<Map<String,Object>>) faqSearch0("faq.faqSearch0",map, isSearch);
		
	}
	//FAQ�˻�(����)=1
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> faqSearch1(Map<String,Object>map, String isSearch){
		return (List<Map<String,Object>>) faqSearch1("faq.faqSearch1",map, isSearch);
		
	}
	//FAQ�˻�(ī�װ�)=2
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> faqSearch2(Map<String,Object>map, String isSearch){
		return (List<Map<String,Object>>) faqSearch2("faq.faqSearch2",map, isSearch);
		
	}
	
	//FAQ���
	public void faqWrite(Map<String, Object>map) throws Exception{
		insert("faq.faqWrite",map);
	}
	
	//FAQ����	
	public void faqModify(Map<String, Object>map)throws Exception{
		update("faq.faqModify",map);
	}
	
	//FAQ��ȸ��
	public void faqUpdateHitCnt(Map<String,Object>map) throws Exception{
		update("faq.faqUpdateHitCnt",map);
	}
	//FAQ����
	public void faqDelete(Map<String, Object>map) throws Exception{
		delete("faq.faqDelete",map);
	}
			
	

}
