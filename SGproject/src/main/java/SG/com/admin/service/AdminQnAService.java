package SG.com.admin.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface AdminQnAService {
	//Q&A상세보기
	Map<String, Object> qnaDetail(Map<String,Object>map) throws Exception;
		 
	//Q&A목록조회(관리자)
	List<Map<String,Object>>adminQnaList(Map<String, Object>map)throws Exception;
			
			
	//Q&A목록조회-카테고리(답변대기,답변처리)
	List<Map<String,Object>>qnaSearch0(Map<String,Object>map)throws Exception;
			
	//Q&A목록조회-카테고리(상품문의,홈페이지이용문의)
	 List<Map<String,Object>>qnaSearch1(Map<String,Object>map)throws Exception;
			
	//Q&A답변등록(관리자)
	void ans(Map<String,Object>map)throws Exception;
			
	//Q&A삭제
	void qnaDelete(Map<String,Object>map)throws Exception;
			
}



