package SG.com.board.service;

import java.util.List;
import java.util.Map;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;



import SG.com.admin.dao.AdminNoticeDao;
import SG.com.board.dao.MemberNoticeDao;
import SG.com.common.GoodsImageUtils;

@Service("memberNoticeService")
public class MemberNoticeServiceImpl implements MemberNoticeService{

@Resource
private MemberNoticeDao memberNoticeDao;

@Resource
private GoodsImageUtils goodsImangeUtils;


	//공지사항 목록조회
    @Override
	public List<Map<String,Object>> noticeList(Map<String,Object>map)throws Exception{
    return memberNoticeDao.noticeList(map);
		
	}
		
	//공지사항 상세보기
	public Map<String,Object> noticeDetail(Map<String,Object>map)throws Exception{
			   memberNoticeDao.noticeHitcount(map); //조회수 업데이트
		return memberNoticeDao.noticeDetail(map); //상세보기
	}

	//공지사항 검색(타입+제목)
	public List<Map<String,Object>> searchTitle(Map<String,Object>map)throws Exception{
		return memberNoticeDao.searchTitle(map); 	
	}
	
	//공지사항 검색(타입+내용)
	public List<Map<String,Object>> searchContent(Map<String,Object>map)throws Exception{
		return memberNoticeDao.searchContent(map);
		
	}
	

	
}