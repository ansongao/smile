package com.baidu.service;

import com.baidu.entity.EmailUser;

public interface EmailUserService {
    
	//添加用户判断
	public boolean addUser(EmailUser user);
	//通过验证查找用户
	public EmailUser findByCode(String code);
	//激活状态判断
	public void changeState(String code);
	  
}
