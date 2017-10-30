package com.baidu.controller;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.entity.EmailUser;
import com.baidu.service.EmailUserService;
import com.baidu.service.EmailUserServiceImpl;
import com.baidu.utilOne.SendMailUtil;

/**
 * 邮箱验证
 * @author Administrator
 *
 */
@Controller
public class EmailController {
	@Autowired
	private EmailUserService service;
	/**
	 * 进入注册页面
	 */
	@RequestMapping("zhuce")
    public String zhuce(){
    	
    	return "email/register";
    }
	
	/**
	 * 注册请求
	 */
	@RequestMapping("admin/zhuce")
	public String active(HttpServletRequest request,HttpServletResponse response )throws Exception{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");		
		boolean flag=Register(username,password,email);
		if(flag){
			return "email/success";
		}
		//注册用户
		return null;
	}
	
	/**
	 * 激活请求
	 */
	@RequestMapping("admin/activeShow")
	public String activeShow(HttpServletRequest request,HttpServletResponse response )throws Exception{
	   String code=request.getParameter("code");
	   if(Active(code)){
			return "email/success";
	   }
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	  private static final String HOST="smtp.163.com";
	  private static final String PROTOCOL="smtp";
	  private static final int PORT=25;
	  private static final String SENDER="15356152347@163.com";
	  private static final String SENDERPWD="g180865";
	  
	  /**
		 * 注册用户	
		 * @param username 用户名
		 * @param password 密码
		 * @param email 邮箱
		 * @return 是否注册成功
		 */
		public Boolean Register(String username,String password,String email){
			Boolean result=false;
			//生成用户code
			String code=UUID.randomUUID().toString().replace("-", "");
           EmailUser user=new EmailUser(username,password,email,code);	
           System.out.println(username+password+email+code);
			result=service.addUser(user);
			System.out.println(result);
			//向用户发送激活邮件
			sendMail(email,code);
			
			return result;
		}
	  
	  
	  
	  /**
	   * 发送激活右键
	   * @param to 收件人邮箱地址
	   * @param code 激活码
	   */
	  public static boolean sendMail(String to, String code) {
	
		  try {
		  Properties props=new Properties();
		  //props.put("mail.smtp.auth", "true");
	      props.put("username", SENDER);   
         props.put("password", SENDERPWD);   
         props.put("mail.transport.protocol", PROTOCOL );  
         props.put("mail.smtp.host", HOST);  
         props.put("mail.smtp.port", PORT );  
         Session mailSession = Session.getDefaultInstance(props);  
         
         Message msg = new MimeMessage(mailSession);     
         msg.setFrom(new InternetAddress(SENDER));  
         msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));   
         msg.setSubject("激活邮件");   
         msg.setContent("<h1>此邮件为官方激活邮件！请点击下面链接完成激活操作！</h1><h3><a href='http://localhost:8080/superman/admin/activeShow.do?code="+code+"'>http://localhost:8080/superman/admin/activeShow.do</a></h3>","text/html;charset=UTF-8");
         msg.saveChanges(); 
         
         Transport transport = mailSession.getTransport("smtp");  
         transport.connect(props.getProperty("mail.smtp.host"), props  
                 .getProperty("username"), props.getProperty("password"));   
         transport.sendMessage(msg, msg.getAllRecipients());  
         transport.close();     
         
		} catch (Exception e) {
			e.printStackTrace();  
           System.out.println(e);  
           return false;  
		}
	     
         return true;
	  }
	  
	
	  /**
		 * 激活用户
		 * @param code 用户激活码
		 * @return 是否激活成功
		 */
		public Boolean Active(String code){
			//通过code查找用户
			System.out.println("active查找用户");
			EmailUser user=service.findByCode(code);
			if(user!=null){
				service.changeState(code);
				return true;
			}
		
			return false;
		}
}
