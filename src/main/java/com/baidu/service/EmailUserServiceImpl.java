package com.baidu.service;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dao.EmailUserDao;
import com.baidu.entity.EmailUser;
@Service("emailUserService")
public class EmailUserServiceImpl implements EmailUserService{
    @Autowired
	private EmailUserDao userDao;
    
	public boolean addUser(EmailUser user) {
		System.out.println("进入注册");
        EmailUser emailUser=userDao.findByCode(user.getCode());
		//添加用户
        if(emailUser!=null){
        	System.out.println("用户已存在");
        	return false;
        }
		userDao.addUser(user);
		return true;
	}

	public EmailUser findByCode(String code) {
		EmailUser user=userDao.findByCode(code);
		if(user==null){
			System.out.println("该用户不存在");
		}
		
		return user;
	}
    /**
     * 将用户状态改为可用 
     */
	public void changeState(String code) {
		EmailUser user=findByCode(code);
		String username=user.getUsername();
		//将用户的激活状态改为可用
		userDao.changeState(username);
		System.out.println("修改完毕");
	}
	
	
	

}
