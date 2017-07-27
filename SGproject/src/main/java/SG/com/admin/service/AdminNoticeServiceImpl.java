package SG.com.admin.service;

import java.util.List;
import java.util.Map;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;



import SG.com.admin.dao.AdminNoticeDao;
import SG.com.common.NoticeImageUtils;

@Service("adminNoticeService")
public class AdminNoticeServiceImpl implements AdminNoticeService{

@Resource
private AdminNoticeDao adminNoticeDao;

@Resource
private NoticeImageUtils noticeImangeUtils;


	//공지사항 목록조회
    @Override
	public List<Map<String,Object>> noticeList(Map<String,Object>map)throws Exception{
    return adminNoticeDao.noticeList(map);
		
	}
		
	//공지사항 상세보기
	public Map<String,Object> noticeDetail(Map<String,Object>map)throws Exception{
		adminNoticeDao.noticeHitcount(map); //공지사항 게시글 조회수 업데이트
		
		return adminNoticeDao.noticeDetail(map);
	}

	//공지사항 검색(타입+제목)
	public List<Map<String,Object>> searchTitle(Map<String,Object>map)throws Exception{
	return adminNoticeDao.searchTitle(map); 	
	}
	//공지사항 검색(타입+내용)
	public List<Map<String,Object>> searchContent(Map<String,Object>map)throws Exception{
	return adminNoticeDao.searchContent(map);
		
	}
	
	//공지사항 등록
	public void noticeInsert(Map<String,Object>map, HttpServletRequest request)throws Exception{
		adminNoticeDao.noticeInsert(map);
		//내용 인설트
		map = noticeImangeUtils.noticeImageInsert(map, request);
		//파일화 시킨걸 map에 집어넣음
		System.out.println(map);
		adminNoticeDao.noticeImageUpdate(map);
		//이미지 업로드
	}	
			
	//공지사항 수정
	public void noticeUpdate(Map<String,Object>map,HttpServletRequest request )throws Exception{
		adminNoticeDao.noticeUpdate(map);
		
		map = noticeImangeUtils.noticeImageUpdate(map,request);//기존에 있는 옛날파일을 삭제하고 새로운 파일을 넣음
		
		adminNoticeDao.noticeImageUpdate(map);
	}
	
	//공지사항 삭제
	public void noticeDelete(Map<String,Object>map)throws Exception{
		adminNoticeDao.noticeDelete(map);
		System.out.println(map+"++++++++++++++++테이블 삭제완료");
		noticeImangeUtils.noticeImageDelete(map);//실제파일 삭제 
	
	}

	
}