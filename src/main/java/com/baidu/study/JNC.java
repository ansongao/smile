package com.baidu.study;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author: anson
 * @CreateDate: 2017年8月25日 上午9:17:50
 * @version: V 1.0
 * 
 */
public class JNC extends Wine {
    
	private String id;
	
	private Study study;
	/**
	 * @desc 子类重载父类方法 父类中不存在该方法，向上转型后，父类是不能引用该方法的
	 * @param a
	 * @return void
	 */
	public  Study get(){
		return study;
	}
	
	
	public void fun1(String a) {
		System.out.println("JNC 的 Fun1...");
		fun2();
		get().say();
		String ss=get().a;
		System.out.println(ss);
	}

	/**
	 * 子类重写父类方法 指向子类的父类引用调用fun2时，必定是调用该方法
	 */
	public void fun2() {
		System.out.println("JNC 的Fun2...");
	}

	public JNC() {
		super();
		System.out.println("JNC构造函数");
	}

	public String toString() {
		return "什么都没有";
	}

	
	
	
	
	public static void main(String[] args) {
//		Calendar c=Calendar.getInstance();
//		System.out.println(c.get(GregorianCalendar.YEAR));
//		JNC j=new JNC();
//		Map<String,Object> o=new HashMap();
//		o.put("key", "value");
//		o.put("key1", "value1");
//		j.fun1("2");
		long a=System.currentTimeMillis();
		JNC j=new JNC();
		Wine w=new Wine();
		String s="22";
		StringBuffer str=new StringBuffer(s);
		for(int i=0;i<100000;i++){
			//54
			//s.concat(Integer.toString(i));
			
			//31902
		    //s=s+Integer.toString(i);
			
			//38
			//str.append(Integer.toString(i));
		}
		
		long b=System.currentTimeMillis();
		System.out.println(b-a);
		
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}




	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Wine){
			Wine e=(Wine)obj;
			System.out.println(this.id);
		    return e.getId()==this.id;
		}
			return false;
		
			
	
	}

     
	
	

}


