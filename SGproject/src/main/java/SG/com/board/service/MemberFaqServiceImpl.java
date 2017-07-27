package SG.com.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import SG.com.board.dao.MemberFaqDao;

@Service("memberFaqService")
public class MemberFaqServiceImpl implements MemberFaqService{
	
	@Resource
	private MemberFaqDao memberFaqDao;
	
	//FAQ목록조회
	public List<Map<String,Object>> memberfaqList(Map<String,Object>map) throws Exception{
		
		return memberFaqDao.faqList(map);
	}
	
	//FAQ상세보기
	public Map<String, Object> memberfaqDetail(Map<String,Object>map) throws Exception{
		
		return memberFaqDao.faqDetail(map);
	}
	
	//FAQ검색 제목=0
	public List<Map<String,Object>> memberfaqSearch0(Map<String,Object>map) throws Exception{
		
		return memberFaqDao.faqSearch0(map);
	}
	
	//FAQ검색 내용=1
	public List<Map<String,Object>> memberfaqSearch1(Map<String,Object>map) throws Exception{
		
		return memberFaqDao.faqSearch1(map);
	}
	
	//FAQ검색 카테고리=2
	public List<Map<String,Object>> memberfaqSearch2(Map<String,Object>map) throws Exception{
		
		return memberFaqDao.faqSearch2(map);
	}
}
