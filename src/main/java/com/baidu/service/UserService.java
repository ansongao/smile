package com.baidu.service;

import java.util.List;

import com.baidu.entity.Page;
import com.baidu.entity.User;

public interface UserService {
	public User login(String userId,String password); 
	//分页查询
	public List<User> findCheck(User user);
	//分页显示
	public List<User> showPage(Page page);
	//获得User总数
	public int getAll();
	//注册方法
	public Boolean registCheck(String username,String password);
}
