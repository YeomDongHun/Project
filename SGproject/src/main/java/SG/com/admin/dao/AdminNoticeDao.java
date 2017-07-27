package SG.com.admin.dao;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import SG.com.common.AbstractDAO;

@Repository
public class AdminNoticeDao extends AbstractDAO {
	

	//공지사항 목록조회
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> noticeList(Map<String,Object>map)throws Exception{
		return (List<Map<String,Object>>)selectList("notice.noticeList", map);
	}
	//공지사항 상세보기
	@SuppressWarnings("unchecked")
	public Map<String,Object> noticeDetail(Map<String,Object>map)throws Exception{
		return (Map<String,Object>)selectOne("notice.noticeDetail", map);
	}
	//공지사항 검색(타입+내용)
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> searchContent(Map<String,Object>map)throws Exception{
		return (List<Map<String,Object>>)selectList("notice.searchContent", map);
	}
	//공지사항 검색(타입+제목)
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> searchTitle(Map<String,Object>map)throws Exception{
		return (List<Map<String,Object>>)selectList("notice.searchTitle", map);
	}
	//공지사항 등록
	public void noticeInsert(Map<String,Object>map)throws Exception{
		 insert("notice.noticeInsert", map);
	}
	//공지사항 수정
	public void noticeUpdate(Map<String,Object>map)throws Exception{
		 update("notice.noticeUpdate", map);
	}
	//공지사항 게시글 조회수 업데이트
	public void noticeHitcount(Map<String,Object>map)throws Exception{
		update("notice.noticeHitcount", map);
	}
	//공지사항 삭제
	public void noticeDelete(Map<String,Object>map)throws Exception{
		delete("notice.noticeDelete", map);
	}
	
	//공지사항 이미지 업데이트
	public void noticeImageUpdate(Map<String,Object>map)throws Exception{
		update("notice.noticeImageUpdate",map);
	}


}
