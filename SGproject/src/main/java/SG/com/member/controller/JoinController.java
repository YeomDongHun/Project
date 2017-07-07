package SG.com.member.controller;

import org.springframework.ui.Model;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import SG.com.common.CommandMap;
import SG.com.member.service.PointService;
import SG.com.member.service.JoinService;


@Controller
public class JoinController 
{
	
	String authNum = ""; //������ȣ �ʱ�ȭ
	
	@Resource(name="joinService")
	private JoinService joinService;
	
	@Resource(name="pointService")
	private PointService pointService;
	
	//�̸��� ���� ����
	@RequestMapping(value = "/joinEmail")
	public String joinEmail(Model model)
	{		
		return "joinEmail";
	}
	
	//�̸��� ����
	@RequestMapping(value = "/modal_email")
	public String modal_email(Model model) 
	{
		return "Member/modal_email";
	}
	
	//�̸��� ���� ���� ����
	@RequestMapping(value="/joinStep1/modal_email_auth")
	public String email_auth(HttpServletResponse response, HttpServletRequest request, Model model, CommandMap Map) throws Exception
	{
		
		//��ũ��Ʈ�� �Ѱ��� email ���� ����
		String email = (String) Map.getMap().get("email");
		
		System.out.println("email = " + email);
		
		//email�� MEMBER_EMAIL ������ map�� �ٽ� �־���
		Map.getMap().put("MEMBER_EMAIL", email);
		
		//MEMBER ���̺� �Է��� �̸����� �ִ����� ���� ���� üũ
		int checkNum = joinService.checkEmail(Map.getMap());
		
		System.out.println("checkNum="+checkNum);
		
		//��ϵ� �̸����� ���� ���
		if(checkNum==0)
		{
		
		authNum = RandomNum(); //������ȣ ����
		sendEmail(email.toString(), authNum);
		System.out.println("���Ϻ���");
		}
		
		String checkNumString=String.valueOf(checkNum);
		PrintWriter writer = response.getWriter();
		//�̸����� �ִ��� ���ο� ���� checkNum�� write -> joinStep1.jsp �ȿ� email_code���� checkNum�� ������ �� 
		writer.write(checkNumString);        
		writer.flush(); //������..
		writer.close();
				
		model.addAttribute("email",email);
		model.addAttribute("authNum", authNum);
				
		System.out.println("������ȣ"+authNum);
		
		return "Member/join_Step1";
	}
	
	//������ �̸��Ϸ� ���� ������
	private void sendEmail(String email,String authNum)
	{
		String host ="smtp.gmail.com";
		String subject = "���� ���� ��ȣ ����"; // ���� ����
		String fromName ="���� ������"; //������
		String from="SG@gmail.com"; //������ ����
		String to1 = email; //ȸ�� �̸���
		
		String content = "�ȳ��ϼ���. ������ ���ڴ��Դϴ�. ������ȣ[" + authNum +"]"; //������ȣ �߼� ���� ����
		
		try
		{
			Properties props = new Properties();
			
			props.put("mail.smtp,starttls.enable","true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host",host);
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			
			props.put("mail.smtp.port", "465");
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.auth", "true");
			
			Session mailSession = Session.getInstance(props,new javax.mail.Authenticator()
			{
					protected PasswordAuthentication getPasswordAuthentication()
					{
					  //������ �̸��� �н����� ����
				      return new PasswordAuthentication("siroragi@gmail.com","sirorgi3");
				    
			}
			});
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from,MimeUtility.encodeText(fromName,"UTF-8","B"))); //�����»������
			
			InternetAddress[] address1 = {new InternetAddress(to1)};
			
			msg.setRecipients(Message.RecipientType.TO, address1); //�޴»������1
			msg.setSubject(subject); //������
			msg.setSentDate(new java.util.Date()); //������ ��¥����
			msg.setContent(content,"text/html;charset=utf-8"); //���뼳��
			
			Transport.send(msg);
		}
		catch (MessagingException e) 
		{
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			
		}
	}
	
	//������ȣ ���� ����
	public String RandomNum()
	{
		StringBuffer buffer = new StringBuffer();
		for(int i = 0;i<=6;i++)
		{
			int n= (int)(Math.random() * 10);
			buffer.append(n);
		}
		return buffer.toString();
	}
	
	//������ȣ ��ȿ�� ����
	@RequestMapping(value="/joinStep1/modal_email_auth_success", method=RequestMethod.POST)
    public @ResponseBody String authValidate (HttpServletRequest request) throws Exception   
    {
         
        String str = authNum;
        System.out.println("������ȣ �˻� : "+authNum);
        return str;
    }
	
	//�̿��� ��
	@RequestMapping(value = "/joinAgree")
	public String joinAgree(Model model) 
	{
		return "joinAgree";
	}
	
	//ȸ������ ��
	@RequestMapping(value = "/joinForm")
	public String joinForm(Model model) 
	{
		return "joinForm";
	}
	

	
	//ȸ������ ����
	@RequestMapping(value = "/joinSuccess")
	public String joinSuccess(Model model) 
	{
		return "joinSuccess";
	}
	
	
}
