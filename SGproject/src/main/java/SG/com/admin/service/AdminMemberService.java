package SG.com.admin.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public interface AdminMemberService {

	
	//맴버 목록조회(관리자)ON인 경우만
			List<Map<String,Object>>adminMemberListON()throws Exception;
			
	//맴버 목록조회(관리자)OFF인 경우만
			List<Map<String,Object>>adminMemberListOFF(Map<String, Object>map)throws Exception;	
		
	//맴버 삭제
		void adminMemberDelete(Map<String,Object>map)throws Exception;
		
	//맴버 검색 (아이디) ON인경우
		List<Map<String,Object>>adminMembersearch0(Map<String,Object>map)throws Exception;
		 
	//맴버 검색 (이름)  ON인경우
		List<Map<String,Object>>adminMembersearch1(Map<String,Object>map)throws Exception;
	//맴버검색 (아이디) OFF인경우
		List<Map<String,Object>>adminMembersearch0F(Map<String,Object>map)throws Exception;
	//맴버검색 (이름)  OFF인경우
		List<Map<String,Object>>adminMembersearch1F(Map<String,Object>map)throws Exception;
		
	//맴버 보유포인트
		List<Map<String,Object>>adminMemberPoint(Map<String,Object>map)throws Exception;
	//포인트 적립
		public void adminMemberPointInsert(Map<String, Object>map) throws Exception;

}
