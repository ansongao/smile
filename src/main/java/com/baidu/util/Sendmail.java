package com.baidu.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.baidu.entity.EmailUser;

public class Sendmail extends Thread{
    //用于给用户发送消息的邮箱
	private String from="15356152347@sohu.com";
	//邮箱用户名
	private String username="douanson";
	//邮箱的密码
	private String password="g18086518450";
	//发送邮件的服务器地址
	private String host="stmp.sohu.com";
	
	private EmailUser user;
	public Sendmail(EmailUser user){
		this.user=user;
	}
	
	/**
	 * 重写Thread中run方法的实现，在run方法中发送邮件给指定用户
	 */
	public void run(){
		try {
		  System.out.println("进入邮箱注册方法");
          Properties prop=new Properties();
		  prop.setProperty("mail.host", host);	
		  prop.setProperty("mail.transport.protocol", "smtp");
		  prop.setProperty("mail.smtp.auth", "true");
	      Session session=Session.getInstance(prop);
	      session.setDebug(true);
	      Transport ts=session.getTransport();
	      ts.connect(host, username, password);
	      Message message=createEmail(session,user);
	      ts.sendMessage(message, message.getAllRecipients());
	      ts.close();
	      System.out.println("结束");
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 创建要发送的邮件
	 */
	public Message createEmail(Session session,EmailUser user) throws Exception{
		MimeMessage message=new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
		message.setSubject("用户注册邮件");
		
		String info="恭喜您注册成功,您的用户名是:"+user.getUsername()+",您的密码是:"+user.getPassword()+",请妥善保管，如有问题请联系网站客服!!";
		message.setContent(info,"text/html;charset=UTF-8");
		message.saveChanges();
		return message;
	}
	
	
}
