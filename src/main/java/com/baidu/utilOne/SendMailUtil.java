package com.baidu.utilOne;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dao.EmailUserDao;
import com.baidu.dao.UserDao;
import com.baidu.entity.EmailUser;
import com.baidu.service.EmailUserService;
import com.baidu.service.EmailUserServiceImpl;

/**
 * 发送邮件的工具类
 * @author Administrator
 *
 */
@Service
public class SendMailUtil {
     
	  private EmailUserService service;
	  
	  private static final String HOST="stmp.163.com";
	  private static final String PROTOCOL="stmp";
	  private static final int PORT=25;
	  private static final String SENDER="15356152347@163.com";
	  private static final String SENDERPWD="g18086518450";
	  
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
          msg.setContent("<h1>此邮件为官方激活邮件！请点击下面链接完成激活操作！</h1><h3><a href='http://localhost:8080/SendMail/servlet/ActiveServlet?code="+code+"'>http://localhost:8080/SendMail/servlet/ActiveServlet</a></h3>","text/html;charset=UTF-8");
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
			EmailUser user=service.findByCode(code);
			if(user!=null){
				service.changeState(code);
				return true;
			}
		
			return false;
		}
	  
	  
	  
}
