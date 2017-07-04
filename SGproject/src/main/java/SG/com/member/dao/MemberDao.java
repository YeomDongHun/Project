package SG.com.member.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import SG.com.common.AbstractDAO;


@Repository("memberDAO")
public class MemberDao extends AbstractDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	

	
	//회원 정보 수정
	public void updateMember(Map<String, Object>map) {
		sqlSession.update("member.updateMember", map);
	}

	// 관리자가 회원 정보 OFF로 수정(회원강제 탈퇴)
	public void deleteMember(Map<String, Object> map) throws Exception {
		sqlSession.update("member.deleteMember", map);
	}

	// 회원 아이디 검색
	public List<Map<String, Object>> searchMemberId(Map<String, Object> map) throws Exception {
		return sqlSession.selectList("member.searchMemberId", map);
	}

	// 회원 이름 검색
	public List<Map<String, Object>> searchMemberName(Map<String, Object> map) throws Exception {
		return sqlSession.selectList("member.searchMemberName", map);
	}

	// 회원 전화번호 검색
	public List<Map<String, Object>> searchMemberPhone(Map<String, Object> map) throws Exception {
		return sqlSession.selectList("member.searchMemberPhone", map);
	}

	// 회원 이메일 검색
	public List<Map<String, Object>> searchMemberEmail(Map<String, Object> map) throws Exception {
		return sqlSession.selectList("member.searchMemberEmail", map);
	}

	// 회원포인트 수정
	public void updatePoint(Map<String, Object> map) throws Exception {
		sqlSession.update("member.updatePoint", map);

	}

}