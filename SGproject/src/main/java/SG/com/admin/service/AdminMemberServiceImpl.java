package SG.com.admin.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import SG.com.admin.dao.AdminMemberDao;


@Service("adminMemberService")
public class AdminMemberServiceImpl implements AdminMemberService{
	
	@Resource(name="adminMemberDao")
	private AdminMemberDao adminMemberDao;
	//ON인 상태의 회원 목록
	public List<Map<String,Object>>adminMemberListON()throws Exception{
		   return adminMemberDao.adminMemberListON();
	   }
	
	//OFF인 상태의 회원 목록
	public List<Map<String,Object>>adminMemberListOFF(Map<String, Object>map)throws Exception{
		   return adminMemberDao.adminMemberListOFF(map);
	   }
	//맴버 삭제
		 public void adminMemberDelete(Map<String,Object>map)throws Exception{
			 adminMemberDao.adminMemberDelete(map);
		 }
	
	//맴버 검색 아이디 ON인경우
		 public List<Map<String,Object>>adminMembersearch0(Map<String,Object>map)throws Exception{
			 return adminMemberDao.adminMembersearch0(map);
		 }
	//맴버 검색 이름 ON인경우
		 public List<Map<String,Object>>adminMembersearch1(Map<String,Object>map)throws Exception{
			 return adminMemberDao.adminMembersearch1(map);
		 }
		 
	//맴버 검색 이름 ON인경우
		 public List<Map<String,Object>>adminMembersearch0F(Map<String,Object>map)throws Exception{
			 return adminMemberDao.adminMembersearch0F(map);
		 }
	//맴버 검색 이름 ON인경우
		 public List<Map<String,Object>>adminMembersearch1F(Map<String,Object>map)throws Exception{
			 return adminMemberDao.adminMembersearch1F(map);
		 }
	 //포인트 적립 창
		 public List<Map<String,Object>>adminMemberPoint(Map<String,Object>map)throws Exception{
			 return adminMemberDao.adminMemberPoint(map);
		 }
		//포인트 적립
		 @Override
		   public void adminMemberPointInsert(Map<String, Object> map) throws Exception
		   {
			 adminMemberDao.adminMemberPointInsert(map);
		   }
		 
		 
}
