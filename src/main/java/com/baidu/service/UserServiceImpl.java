package com.baidu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dao.UserDao;
import com.baidu.entity.Page;
import com.baidu.entity.User;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
	private UserDao userDao;
	
	
	public User login(String userId,String password) {
		if(userId==""){
			System.out.println("用户名不能为空");
			return null;
		}
		User user=userDao.findByName(userId);
		if(user==null){
			System.out.println("用户不存在");
			return null;
		}
		if(!password.equals(user.getPassword())){
			System.out.println("密码错误");
			return null;
		}
		return user;
	}


	@Override
	public List<User> findCheck(User user) {
		user.setLogin_id("13116741405");
		List<User> use=userDao.findSome(user);
		return use;
	}


	public List<User> showPage(Page page) {
      
		List<User> list=userDao.findAllForPage(page);
		return list;
	}


	//得到用户总数
	public int getAll() {
        int count=userDao.findAll();
		return count;
	}


	//验证业务处理
	public Boolean registCheck(String username,String password) {
		User user=userDao.findByName(username);
		if(user!=null){
			System.out.println("用户名已存在");
		    return false;
		}
		userDao.regist(username, password);
        System.out.println("注册完毕");
        return true;
	}

}
