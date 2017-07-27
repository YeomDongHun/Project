package SG.com.board.service;

import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import SG.com.board.dao.MemberDiyDao;
import SG.com.common.DiyImageUtils;

@Service("memberDiyService")
public class MemberDiyServiceImpl implements MemberDiyService{
	
	@Resource
	private MemberDiyDao memberDiyDao;
	
	@Resource
	private DiyImageUtils diyImageUtils;
	
	//게시글 목록조회
	public List<Map<String, Object>> diyList(Map<String, Object> map) throws Exception{
		
		/*memberDiyDao.memberRateAvg(map);//평점
*/		return memberDiyDao.diyList(map);
	}

	
	//게시글 목록조회(댓글갯수+평점포함)
	public List<Map<String,Object>> diyListCR(Map<String,Object>map)throws Exception{
		return memberDiyDao.diyListCR(map);
		
	}
	
	//diy 게시판 상세정보
	public Map<String, Object> diyDetail(Map<String, Object> map) throws Exception {
	   memberDiyDao.hitCount(map);
       return memberDiyDao.diyDetail(map);
	}
	
	//diy 게시글 등록  + 이미지
	public void diyInsert(Map<String,Object>map,HttpServletRequest request) throws Exception{
		memberDiyDao.diyInsert(map);
		
		map = diyImageUtils.diyImageInsert(map, request);
		
		
		System.out.println(map);
		
		memberDiyDao.diyImageInsert(map);
			
	}
	//게시글 수정
	public void diyModify(Map<String,Object>map,HttpServletRequest request) throws Exception{
		
		memberDiyDao.diyModify(map);
		
		map = diyImageUtils.diyImageUpdate(map, request);
		
		memberDiyDao.diyImageInsert(map);
	}
	
	//게시글 삭제
	public void diyDelete(Map<String,Object>map) throws Exception{
		System.out.println(map+"++++++++++++++++++++++++++++++++++++++++데이터확인");
		memberDiyDao.diyCmtDelete(map);
		
		memberDiyDao.diyDelete(map);//테이블 삭제
		
		diyImageUtils.diyImageDelete(map); //실제파일 삭제
	}
	
	//댓글 등록
	public void diyInsertComment(Map<String,Object>map)throws Exception{
		memberDiyDao.diyInsertComment(map);
	}

	//diy 게시판 댓글조회
	public List<Map<String,Object>>diyCommentList(int diyno)throws Exception{
		
		return memberDiyDao.diyCommentList(diyno);
	}


	//diy 게시판 아이디검색=0
	public List<Map<String,Object>> diySearchM(Map<String,Object>map)throws Exception{
		return memberDiyDao.diySearchM(map);	
	}
	//diy 게시판 제목검색=1	
	@Override
	public List<Map<String, Object>> diySearchT(Map<String, Object> map) throws Exception {
	     return memberDiyDao.diySearchT(map);
	}


	
		
}
	
			
		
		
		


