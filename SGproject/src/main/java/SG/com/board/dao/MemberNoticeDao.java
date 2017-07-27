package SG.com.board.dao;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import SG.com.common.AbstractDAO;

@Repository
public class MemberNoticeDao extends AbstractDAO {
	
	
	//회원 공지사항 목록조회
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> noticeList(Map<String,Object>map)throws Exception{
		return (List<Map<String,Object>>)selectList("notice.noticeList", map);
	}
	
	//회원 공지사항 상세보기
	@SuppressWarnings("unchecked")
	public Map<String,Object> noticeDetail(Map<String,Object>map)throws Exception{
		return (Map<String, Object>) selectOne("notice.noticeDetail", map);
	}
	
	//회원 공지사항 검색(타입+내용)
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> searchContent(Map<String,Object>map)throws Exception{
		return (List<Map<String,Object>>)selectList("notice.searchContent", map);
	}
	
	//회원 공지사항 검색(타입+제목)
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> searchTitle(Map<String,Object>map)throws Exception{
		return (List<Map<String,Object>>)selectList("notice.searchTitle", map);
	}
	
	//공지사항 게시글 조회수 업데이트
	public void noticeHitcount(Map<String,Object>map)throws Exception{
		 update("notice.noticeHitcount", map);
	}


}
