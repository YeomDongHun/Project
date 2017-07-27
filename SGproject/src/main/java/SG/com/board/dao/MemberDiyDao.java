package SG.com.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import SG.com.common.AbstractDAO;

@Repository
public class MemberDiyDao extends AbstractDAO {
	
	//게시글 목록조회
		@SuppressWarnings("unchecked")
		public List<Map<String, Object>> diyList(Map<String, Object> map) throws Exception {
			System.out.println("ㄱㄱㄱ");
			return (List<Map<String, Object>>) selectList("diyboard.diyboardList",map);
		}
		
		//게시글 상세정보
		
		@SuppressWarnings("unchecked")
		public Map<String,Object> diyDetail(Map<String,Object>map)throws Exception{
		   return (Map<String,Object>) selectOne("diyboard.diyboardDetail",map);	
		}
		//게시글 목록조회(댓글갯수+평점포함)
		@SuppressWarnings("unchecked")
		public List<Map<String,Object>> diyListCR(Map<String,Object>map)throws Exception{
			return (List<Map<String,Object>>)selectList("diyboard.diyListCR", map);
		}
		//게시글 등록
		public void diyInsert(Map<String,Object>map) throws Exception{
			insert("diyboard.diyInsert",map);
		}
		
		//게시글 수정
		public void diyModify(Map<String,Object>map) throws Exception{
			update("diyboard.diyModify",map);
		}
		
		//게시글 삭제
		public void diyDelete(Map<String,Object>map) throws Exception{
			delete("diyboard.diyDelete",map);
		}
		
		//게시글 관련 댓글 전체 삭제
		public void diyCmtDelete(Map<String,Object>map) throws Exception{
			delete("diyboard.diyCmtDelete",map);
		}
		
		//게시글 이미지 등록
		
		public void diyImageInsert(Map<String,Object>map) throws Exception{
			update("diyboard.diyImageInsert",map);
		}
		
		//diy 게시판 댓글조회
		@SuppressWarnings("unchecked")
		public List<Map<String,Object>>diyCommentList(int diyno)throws Exception{
			return (List<Map<String,Object>>)selectList("diyboard.diyCommentList",diyno);
		}
		//diy 게시판 댓글등록
		public void diyInsertComment(Map<String,Object>map)throws Exception{
			insert("diyboard.diyInsertComment",map);
		}
		//diy 게시판 댓글 삭제
		public void diyRefDelete(Map<String,Object>map)throws Exception{
			delete("diyboard.diyRefDelete",map);
		}
		//diy 게시판 아이디 검색=0
		@SuppressWarnings("unchecked")
		public List<Map<String,Object>> diySearchM(Map<String,Object>map)throws Exception{
			return (List<Map<String,Object>>)selectList("diyboard.diyboardSearch0", map);
		}
		//diy 게시판 제목 검색=1
		@SuppressWarnings("unchecked")
		public List<Map<String,Object>> diySearchT(Map<String,Object>map)throws Exception{
			return (List<Map<String,Object>>)selectList("diyboard.diyboardSearch1",map);
		}
		//평점 아직 보류중....
		@SuppressWarnings("unchecked")
		public List<Map<String,Object>> memberRateAvg(Map<String,Object>map)throws Exception{
			return (List<Map<String,Object>>)selectList("diyboard.memberRateAvg",map);
		}
		public void hitCount(Map<String,Object>map)throws Exception{
			update("diyboard.hitCount",map);
		}
}

