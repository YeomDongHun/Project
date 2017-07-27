package SG.com.admin.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import SG.com.admin.dao.AdminQnADao;



@Service("adminQnAService")
public class AdminQnAServiceImpl implements AdminQnAService {
	
	@Resource(name="adminQnADao")
	private AdminQnADao adminQnADao;
	

	 //Q&A상세보기
	 public Map<String, Object> qnaDetail(Map<String,Object>map) throws Exception{
		 return adminQnADao.qnaDetail(map);
	 }
	 
	//Q&A목록조회(관리자)
   public List<Map<String,Object>>adminQnaList(Map<String, Object>map)throws Exception{
	   return adminQnADao.adminQnaList(map);
   }
/*		
	//Q&A목록조회-아이디(관리자)
	public List<Map<String,Object>>qnaIdSearch(Map<String, Object>map)throws Exception{
      return adminQnADao.qnaIdSearch(map);
	}
	
	//Q&A목록조회-제목(관리자)
	public List<Map<String,Object>>qnaTitleSearch(Map<String,Object>map)throws Exception{
		return adminQnADao.qnaTitleSearch(map);
	 }*/
		
	//Q&A목록조회-아이디
	public List<Map<String,Object>>qnaSearch0(Map<String,Object>map)throws Exception{
		return adminQnADao.qnaSearch0(map);
	}
		
	//Q&A목록조회-제목
	 public List<Map<String,Object>>qnaSearch1(Map<String,Object>map)throws Exception{
		 return adminQnADao.qnaSearch1(map);
	 }
	//Q&A답변등록(관리자)
	public void ans(Map<String,Object>map)throws Exception{
		adminQnADao.ans(map);
	}
		
	//Q&A삭제
	 public void qnaDelete(Map<String,Object>map)throws Exception{
		 adminQnADao.qnaDelete(map);
	 }




	
	
		
	}


