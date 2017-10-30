package com.baidu.controller;

import java.util.HashMap;
import java.util.Map;

import com.baidu.entity.ReflectDemo;

public class Work {

	public static void main(String[] args) {
		   int i=64;
		   System.out.println(Integer.toHexString(i));
		   System.out.println(Integer.toBinaryString(i));
		   System.out.println(Integer.toOctalString(i));
		   int s=1011;
		   System.out.println(String.valueOf(Integer.parseInt((s+""),2)));
		   System.out.println(String.valueOf(Integer.parseInt("0101100",8)));
		   
		   System.out.println(twoToSixteen("01011"));
		   System.out.println(month(1));
		   String shu="aaBBc";
		   System.out.println(shu.toUpperCase());
		   System.out.println(shu.toLowerCase());
		   String str="student. a am I";
		   System.out.println(sort(str));
		   System.out.println(getSum(2,1,6));
		   System.out.println(division(8,-9,-5,18));
		   ReflectDemo rd=new ReflectDemo();
	}
	
	
	/**
	 * 比较包含
	 * @param a
	 * @param b
	 */
	public static void complete(String a,String b){
		if(a.indexOf(b)>-1){
            System.out.println("a包含b");
        }else{
            System.out.println("a不包含b");
        }
	}
	
	
	/**
	 * 大小写互换
	 */
	public static String upToLow(String s){
		 StringBuffer s2 = new StringBuffer();
	        for (int i=0;i<s.length();i++){
	            char ch = s.charAt(i);
	            //判断是否大写字符
	            if (Character.isUpperCase(ch)){
	                s2.append(Character.toLowerCase(ch));
	            }else {
	                s2.append(Character.toUpperCase(ch));
	            }
	        }
	     return s2.toString();
	}
	/**
	 * 去除空格
	 * @param str
	 * @return
	 */
	public static String removeBlank(String str){
		String s=str.replaceAll("\\s", "");
		return s;
	}
	
	/**
	 * 判断是否数字
	 * @param str
	 * @return
	 */
	public static String isNumber(String str){
		try {
			Double.parseDouble(str);
			return str+" is a number";
		} catch (Exception e) {
           return str+" is not a number";
		}
	}
	/**
	 * 计算汉字个数
	 * @param n
	 * @return
	 */
	public static String chineseSum(String n){
		 String E1 = "[\u4e00-\u9fa5]";
	     String E2 = "[a-zA-Z]";
	     String E3 = "[0-9]";
	     int chineseCount = 0;
	        int englishCount = 0;
	        int numberCount = 0;

	        String temp;
	        for (int i = 0; i < n.length(); i++)
	        {
	            temp = String.valueOf(n.charAt(i));
	            if (temp.matches(E1))
	            {
	                chineseCount++;
	            }
	            if (temp.matches(E2))
	            {
	                englishCount++;
	            }
	            if (temp.matches(E3))
	            {
	                numberCount++;
	            }
	        }
	        return "汉字个数:"+chineseCount;
	}
	/**
	 * 字符串反转并去除空格数字
	 * @param str
	 * @return
	 */
	public static String reversion(String str){
		 if(str != null){
			//去除空格，数字
	            str = str.trim();
	            str = str.replaceAll("\\d+","");
	            str = str.replaceAll(" ", "");
	        }
	        StringBuffer sb = new StringBuffer();
	        for (int i = str.length() - 1; i >= 0; i--) {
	            sb.append(str.charAt(i));
	        }
	        return sb.toString();
	}
	/**
	 * 二进制转十六进制
	 * @param s
	 * @return
	 */
	public static String twoToSixteen(String s){
		String result=Integer.toHexString(Integer.parseInt(s, 2));
		return result;
	}
	/**
	 * 判断季节
	 * @param m
	 * @return
	 */
	public static String month(int m){
		Map<Integer,String> map=new HashMap();
		map.put(1, "冬天");
		return map.get(m);
	}
	/**
	 * 反转字符串语句
	 * @param str
	 * @return
	 */
	public static String sort(String str){
		 String resultString = "";
	        if (str != null && str != "") {
	            String[] strs = str.split(" ");
	            for (int i = strs.length - 1; i > -1; i--) {
	                if (resultString == "") {
	                    resultString = strs[i];
	                } else {
	                    resultString = resultString + " " + strs[i];
	                }
	            }
	        }
	        return resultString;
	}
	/**
	 * 点兵
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static String getSum(int a,int b,int c){
		if(a >= 3 || b >= 5 || c >= 7){
            return "无解";
        }else{
            for(int i = 10;i <= 100;i++){
                if((i%3 == a) && (i%5 == b) &&(i%7 == c)){
                    return Integer.toString(i);
                }
            }
            return "无解";
        }
	}
	/**
	 * 111数
	 * @param m
	 * @return
	 */
	public static String Demo(long m) {
        String wanted = "471";
        if(m==1){
            wanted = "471";
        }else{
            wanted = (m-1) + wanted;
        }
        return wanted;
    }
	/**
	 * 金字塔高度天数
	 * @param h
	 * @return
	 */
	public static String days(int h){
		if(h <= 10){
            return "1";
        }else{
            int m = h / 5;
            int n = h % 5;
            if(n == 0){
                return Integer.toString(m - 1);
            }
            else{
                return Integer.toString(m);
            }
        }
	}
	/**
	 * 复数除法
	 * @param s1
	 * @param x1
	 * @param s2
	 * @param x2
	 * @return
	 */
	 public static String division(int s1,int x1,int s2, int x2) {
		 double real,image;
	        double ss1=s1,xx1=x1,ss2=s2,xx2=x2;
	        real= (ss1*ss2+xx1*xx2)/(ss2*ss2+xx2*xx2);
	        image=(ss2*xx1-ss1*xx2)/(ss2*ss2+xx2*xx2);
	        return(real+"+"+image+"i");
	    }
}
