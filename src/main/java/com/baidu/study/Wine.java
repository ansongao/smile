package com.baidu.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
* @author: anson
* @CreateDate: 2017年8月25日 上午9:17:18
* @version: V 1.0
* 
*/
public class Wine {
	  
	      private String id;      
	
	      public void fun2(){
	         System.out.println("Wine 的Fun2...");
	      }
	      
	      public Wine(){
	    	  System.out.println("Wine构造函数");
	      }

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
		
		
	   public static void main(String[] args) {
		    List<String> list=new ArrayList(22);
		      for(int i=0;i<20;i++){
		    	  list.add(i+"");
		      }
		        Map<String,Object> map=new HashMap();
		        Iterator it=list.iterator();
		        while(it.hasNext()){
		        	if(!it.next().equals(list.get(list.size()-1))){
		        		System.out.println(it.toString());
		        	}
		        }
	}
	      
	 }
