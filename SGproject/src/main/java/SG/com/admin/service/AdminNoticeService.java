package SG.com.admin.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface AdminNoticeService {
	
	//공지사항 목록조회
	public List<Map<String,Object>> noticeList(Map<String,Object>map)throws Exception;
		
	//공지사항 상세보기
	public Map<String,Object> noticeDetail(Map<String,Object>map)throws Exception;

	
	//공지사항 등록
	public void noticeInsert(Map<String,Object>map, HttpServletRequest request)throws Exception;
	//공지사항 수정
	public void noticeUpdate(Map<String,Object>map, HttpServletRequest request)throws Exception;

	//공지사항 삭제
	public void noticeDelete(Map<String,Object>map)throws Exception;
	
	public List<Map<String,Object>> searchTitle(Map<String,Object>map)throws Exception;
	
	public List<Map<String,Object>> searchContent(Map<String,Object>map)throws Exception;

}
	
	

