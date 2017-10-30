package com.baidu.dao;

import com.baidu.entity.EmailUser;

public interface EmailUserDao {

	//添加用户
	public void addUser(EmailUser user);
	//通过验证查找用户
	public EmailUser findByCode(String code);
	//将state设置为可用 0表示不可能   1表示可用
	public void changeState(String username);
}
