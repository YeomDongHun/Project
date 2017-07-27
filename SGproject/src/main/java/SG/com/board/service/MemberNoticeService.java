package SG.com.board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface MemberNoticeService {
	
	//공지사항 목록조회
	public List<Map<String,Object>> noticeList(Map<String,Object>map)throws Exception;
		
	//공지사항 상세보기 + 조회수업데이트
	public Map<String,Object> noticeDetail(Map<String,Object>map)throws Exception;

	//공지사항 검색(타입+제목)
	public List<Map<String,Object>> searchTitle(Map<String,Object>map)throws Exception;

	//공지사항 검색(타입+내용)
	public List<Map<String,Object>> searchContent(Map<String,Object>map)throws Exception;

	
}
	
	

