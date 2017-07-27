package SG.com.board.service;

import java.util.List;
import java.util.Map;

public interface MemberFaqService {
	//FAQ목록조회
	List<Map<String,Object>> memberfaqList(Map<String,Object>map) throws Exception;
	
	//FAQ상세보기
	Map<String, Object> memberfaqDetail(Map<String,Object>map) throws Exception;
	
	//FAQ검색 제목=0
	List<Map<String,Object>> memberfaqSearch0(Map<String,Object>map) throws Exception;
	
	//FAQ검색 내용=1
	List<Map<String,Object>> memberfaqSearch1(Map<String,Object>map) throws Exception;
	
	//FAQ검색 카테고리=2
	List<Map<String,Object>> memberfaqSearch2(Map<String,Object>map) throws Exception;
}
