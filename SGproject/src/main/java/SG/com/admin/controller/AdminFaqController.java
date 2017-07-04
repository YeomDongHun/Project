package SG.com.admin.controller;


import java.util.HashMap;//�ؽ��ʾ���
import java.util.List;//����Ʈ����
import java.util.Map;//�ʾ���

import javax.annotation.Resource;//������̼� Resource����
import javax.servlet.http.HttpServletRequest;//request����

import org.springframework.stereotype.Controller;//�̰��� ��Ʈ�ѷ���
import org.springframework.web.bind.annotation.RequestMapping;
//�̰��� 
import org.springframework.web.servlet.ModelAndView;

import SG.com.common.CommandMap;
/*import spring.kh.siroragi.Paging;*/
//����¡

import SG.com.admin.service.AdminFaqService;

@Controller//��Ʈ�ѷ��� �����ϸ� ������ �����̳ʿ��� ��ü�� ��������� ��밡��
public class AdminFaqController {
	
	@Resource(name="adminFaqService")
	private AdminFaqService adminFaqService;
	
	//�˻� �ѹ���,�˻� ��(String)�� �޾ƿ������� ����
	private int searchNum;
	String isSearch;
	
	//������ �������� �̵� *�������� �帧���� �־����*
	@RequestMapping(value = "/admin" )
	public String list(){
		return "adminForm";//adminMain.jsp�� �̵��ϰ� ����
	}
	//FAQ������ �������� �̵�(����̵�)
	@RequestMapping(value="/adminFaq")
	public ModelAndView adminFaq(CommandMap commandMap, HttpServletRequest request)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<Map<String,Object>> list = adminFaqService.faqList(commandMap.getMap());
		String search = request.getParameter("isSearch");
		Map<String, Object> isSearchMap = new HashMap<String, Object>();
		
		if(request.getParameter("isSearch") !=null){
			isSearch = new String(search.getBytes("iso-885901"), "utf-8");
			//�޾ƿ��°� utf-8�� �ٲٴ� �۾�
			searchNum = Integer.parseInt(request.getParameter("searchNum"));
			//�Ķ���͸� �޾ƿË� String ������ ������°� int�� �ٲٴ��۾�
			isSearchMap.put("isSearch",isSearch);
			//HashMap�� "isSearch"��� �̸����� utf-8�� ���ڵ��� isSearch���� �־���
			
			if(searchNum == 0){//������=0
				list = adminFaqService.faqSearch0(isSearchMap ,isSearch);
				//isSearch�� �־���ϴ� ���� �޼ҵ带 map�� �������ִ°� �����Ǵµ�
				//�޼��带 ���鋚 map,isSearch�� �޾ƾ� �����ְԲ� �����س���
				}
			if(searchNum == 1){//�۳���=1
				list = adminFaqService.faqSearch1(isSearchMap, isSearch);
			}
			if(searchNum == 2){//ī�װ�=2
				list = adminFaqService.faqSearch2(isSearchMap, isSearch);
			}
			
			mv.addObject("isSearch", isSearch);
			mv.addObject("searchNum", searchNum);
			mv.addObject("list",list);
			mv.setViewName("adminFaq");//����Ʈ �ѷ��ִ� jsp�� tiles�� �̵�
			
			return mv;
			
			
		}else{//�˻� ���� ������
			
			mv.addObject("list",list);
			mv.setViewName("adminFaq");
			
			return mv;
		}
	}
	
	//FAQ�����
	@RequestMapping(value="/adminFaqForm")
	public String adminFaqForm(){
		return "adminFaqForm";
	}//jsp���� ��������� submit�ؼ� db�� insert�Ȱ��� �Ʒ� FAQ��Ͽ���
	//�ʿ��� �����ͼ� �����̷�Ʈ�� tiles�����ʰ� url���ٰ� ���� ����
	
	//FAQ���
	@RequestMapping(value = "/adminFaqWrite")
	public ModelAndView adminFaqWrite(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();

		adminFaqService.faqWrite(commandMap.getMap(), request);
		//�ʿ��� �������� �׻� ���������� jsp���� db���� ������ type��� �����̵Ǵ���
		//�� �ڼ��� �����Ѵ�
		mv.setViewName("redirect:/adminFaq");
		//FAQ������� �ٷ� ���� redirect�� tiles �ȸԴ°Ͱ��� ����

		return mv;
	}
	//FAQ ������ �̵�
	@RequestMapping(value = "/adminNoticeModifyForm")
	public ModelAndView adminFaqModifyForm(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView();

		Map<String, Object> map = adminFaqService.faqDetail(commandMap.getMap());
		//�󼼺��⿡ ���� ���� Ŀ�ǵ� �ʿ��� ������
		mv.addObject("map", map.get("map"));
		//�󼼺��⿡ ����ִ� ������ ������ map�� �ٽ�����
		mv.setViewName("adminNoticeModifyForm");
		//�װ� �����ϴ� ������  tiles�� ���� �̵�

		return mv;
	}
	

	// FAQ ����
	@RequestMapping(value = "/adminFaqModify")
	public ModelAndView adminFaqModify(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView();

		adminFaqService.faqModify(commandMap.getMap());

		mv.addObject("FAQ_NO", commandMap.get("FAQ_NO"));
		mv.setViewName("redirect:/adminFaq");

		return mv;
	}
	
	// FAQ �����ϱ�
	@RequestMapping(value = "/adminFaqDelete")
	public ModelAndView adminFaqDelete(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView();

		adminFaqService.faqDelete(commandMap.getMap());
		mv.setViewName("redirect:/adminFaq");

		return mv;
	}

	
	
}

