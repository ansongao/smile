package com.baidu.entity;

import java.io.Serializable;

public class User implements Serializable {

	
	private static final long serialVersionUID = -5261903112541875070L;
    
	private String login_id;
	private String password;
	private String uid;
	private String uname;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [login_id=" + login_id + ", password=" + password + ", uid=" + uid + ", uname=" + uname + "]";
	}
	public User() {
		System.out.println("得到一个user对象了");
	}
	
	  public static void main(String[] args) {
			String address="湖北 武汉市 洪山区 光谷广场";
			int a=address.lastIndexOf(" ");
			String b=address.substring(0, a);
			System.out.println(b);
		}
}
