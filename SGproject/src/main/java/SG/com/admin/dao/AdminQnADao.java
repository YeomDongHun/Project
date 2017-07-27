package SG.com.admin.dao;

import java.util.List;
import java.util.Map;//맵을쓰겠다


import org.springframework.stereotype.Repository;//참조

import SG.com.common.AbstractDAO;

@Repository("adminQnADao")
public class AdminQnADao extends AbstractDAO {
	

	//Q&A상세보기
	@SuppressWarnings("unchecked")
	public Map<String, Object> qnaDetail(Map<String,Object>map) throws Exception{
		return (Map<String,Object>)selectOne("qnaboard.qnaDetail",map);
	}
	//Q&A목록조회(관리자)
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>>adminQnaList(Map<String, Object>map)throws Exception{
		return(List<Map<String,Object>>)selectList("qnaboard.adminQnaList",map);
	}
	
	//Q&A검색(작성자)
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>>qnaSearch0(Map<String,Object>map)throws Exception{
		return (List<Map<String,Object>>)selectList("qnaboard.qnaSearch0",map);
	}
	//Q&A검색(제목)
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>>qnaSearch1(Map<String,Object>map)throws Exception{
		return (List<Map<String,Object>>)selectList("qnaboard.qnaSearch1",map);
	}

	//Q&A답변등록(관리자)
	public void ans(Map<String,Object>map)throws Exception{
		update("qnaboard.ans",map);
	}
	//Q&A삭제
	public void qnaDelete(Map<String,Object>map)throws Exception{
		delete("qnaboard.qnaDelete",map);
	}

}
