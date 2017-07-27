package SG.com.admin.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import SG.com.common.AbstractDAO;

@Repository("adminMemberDao")
public class AdminMemberDao extends AbstractDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>>adminMemberListON() throws Exception{
		
		return (List<Map<String,Object>>) selectList("admember.adminMemberListON");
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>>adminMemberListOFF(Map<String,Object>map) throws Exception{
		
		return (List<Map<String,Object>>) selectList("admember.adminMemberListOFF",map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String,Object>>adminMemberPoint(Map<String,Object>map) throws Exception{
		
		return (List<Map<String,Object>>) selectList("admember.adminMemberPoint",map);
	}

	
	//포인트 수동 적립
		public void adminMemberPointInsert(Map<String, Object>map) throws Exception 
		{
			sqlSession.insert("admember.adminMemberPointInsert", map);
		}
		
	//맴버 삭제
		public void adminMemberDelete(Map<String,Object>map)throws Exception{
			delete("admember.adminMemberDelete",map);
	}
	
	//맴버 검색(아이디)ON인경우
	@SuppressWarnings("unchecked")
		public List<Map<String,Object>>adminMembersearch0(Map<String,Object>map)throws Exception{
			return (List<Map<String,Object>>)selectList("admember.adminMembersearch0",map);
	}
	
	//맴버 검색(이름)ON인경우
		@SuppressWarnings("unchecked")
		public List<Map<String,Object>>adminMembersearch1(Map<String,Object>map)throws Exception{
			return (List<Map<String,Object>>)selectList("admember.adminMembersearch1",map);
	}
	//맴버검색 (아이디)OFF인경우
		@SuppressWarnings("unchecked")
		public List<Map<String,Object>>adminMembersearch0F(Map<String,Object>map)throws Exception{
			return (List<Map<String,Object>>)selectList("admember.adminMembersearch0F",map);
	}
	//맴버검색( 이름)OFF인경우
		@SuppressWarnings("unchecked")
		public List<Map<String,Object>>adminMembersearch1F(Map<String,Object>map)throws Exception{
			return (List<Map<String,Object>>)selectList("admember.adminMembersearch1F",map);
	}
	
}
