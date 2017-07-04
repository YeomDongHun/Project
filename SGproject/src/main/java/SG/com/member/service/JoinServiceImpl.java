package SG.com.member.service;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import SG.com.member.dao.JoinDao;

@Service("joinService")
public class JoinServiceImpl implements JoinService {
	

	@Resource(name="JoinDao")
	private JoinDao JoinDao;
	
	@Override
	public void insertMember(Map<String, Object> map, HttpServletRequest request) throws Exception{
		JoinDao.insertMember(map);
	} 	// ȸ�������� DB�� ���(ȸ������)
	
	@Override
	public int checkEmail(Map<String, Object> map) throws Exception{
		return JoinDao.checkEmail(map);
	}     // �̸��� ����- �̸��� �ߺ�Ȯ��
		
	
	@Override
	public int chekcId(String mem_id) throws Exception {
		return JoinDao.checkId(mem_id);
	}   //ȸ������ id�ߺ�üũ

		

		
		
		

}