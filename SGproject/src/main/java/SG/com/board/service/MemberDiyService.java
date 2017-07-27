package SG.com.board.service;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public interface MemberDiyService {
	
	//게시글 목록조회
			public List<Map<String, Object>> diyList(Map<String, Object> map) throws Exception;
			
			//게시글 상세정보
			public Map<String,Object> diyDetail(Map<String,Object>map)throws Exception;
			//게시글 목록조회(댓글갯수+평점포함)
			public List<Map<String,Object>> diyListCR(Map<String,Object>map)throws Exception;
			
			//diy 게시판 댓글조회
			public List<Map<String,Object>>diyCommentList(int diyno)throws Exception;
			
			//diy 게시판 댓글등록
			public void diyInsertComment(Map<String,Object>map)throws Exception;
			
			//diy 게시판 등록 
			public void diyInsert(Map<String,Object>map,HttpServletRequest request)throws Exception;
			
			//diy 게시글수정
			public void diyModify(Map<String,Object>map,HttpServletRequest request) throws Exception;
			
			//diy 게시글삭제
			public void diyDelete(Map<String,Object>map) throws Exception;
			
			//diy 게시판 아이디 검색=0
			public List<Map<String,Object>> diySearchM(Map<String,Object>map)throws Exception;
			//diy 게시판 제목 검색=1
			public List<Map<String,Object>> diySearchT(Map<String,Object>map)throws Exception;
	}





