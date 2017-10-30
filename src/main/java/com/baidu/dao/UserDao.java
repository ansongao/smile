package com.baidu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baidu.entity.Page;
import com.baidu.entity.User;

public interface UserDao {
	  public User findByName(String name);
	  //得到User总数
	  public int findAll();
	  public List<User> findSome(User user);
	  //分页显示用户
	  public List<User> findAllForPage(Page page);
	  public void regist(String name,String password);
}
