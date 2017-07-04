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
	

	
	//ȸ�� ���� ����
	public void updateMember(Map<String, Object>map) {
		sqlSession.update("member.updateMember", map);
	}

	// �����ڰ� ȸ�� ���� OFF�� ����(ȸ������ Ż��)
	public void deleteMember(Map<String, Object> map) throws Exception {
		sqlSession.update("member.deleteMember", map);
	}

	// ȸ�� ���̵� �˻�
	public List<Map<String, Object>> searchMemberId(Map<String, Object> map) throws Exception {
		return sqlSession.selectList("member.searchMemberId", map);
	}

	// ȸ�� �̸� �˻�
	public List<Map<String, Object>> searchMemberName(Map<String, Object> map) throws Exception {
		return sqlSession.selectList("member.searchMemberName", map);
	}

	// ȸ�� ��ȭ��ȣ �˻�
	public List<Map<String, Object>> searchMemberPhone(Map<String, Object> map) throws Exception {
		return sqlSession.selectList("member.searchMemberPhone", map);
	}

	// ȸ�� �̸��� �˻�
	public List<Map<String, Object>> searchMemberEmail(Map<String, Object> map) throws Exception {
		return sqlSession.selectList("member.searchMemberEmail", map);
	}

	// ȸ������Ʈ ����
	public void updatePoint(Map<String, Object> map) throws Exception {
		sqlSession.update("member.updatePoint", map);

	}

}