package com.baidu.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 将字符串进行加密的工具类
 * @author Administrator
 *
 */
public class MD5Util {
     /**
      * 将源字符串通过MD5加密成字符数组
      */
	public static byte[] encodeToBytes(String source){
        byte[] result=null;		
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.reset();//重置
			//添加需要加密的源
			md.update(source.getBytes("UTF-8"));
			result=md.digest();//加密
		} catch (Exception e) {
            e.printStackTrace();
		}
        
		return result;
	}
	
	
	/**
	 * 将源字符串通过MD5加密成32位16进制位
	 */
	public static String encodeToHex(String source){
		byte[] data=encodeToBytes(source);//先加密为字符数组 
		StringBuffer hexSb=new StringBuffer();
		for(int i=0;i<data.length;i++){
			String hex=Integer.toHexString(0xff&data[i]);
			if(hex.length()==1){
				hexSb.append("0");
			}
			hexSb.append(hex);
		}
		return hexSb.toString();
	}
	
	/**
	 * 验证字符串是否匹配
	 */
	 public static boolean validate(String unknown,String okHex){
		 
		 return okHex.equals(encodeToHex(unknown));
	 }
	
	 //SHAA加密
	 public static String shaEncode(String inStr) throws Exception {
	        MessageDigest sha = null;
	        try {
	            sha = MessageDigest.getInstance("SHA");
	        } catch (Exception e) {
	            System.out.println(e.toString());
	            e.printStackTrace();
	            return "";
	        }

	        byte[] byteArray = inStr.getBytes("UTF-8");
	        byte[] md5Bytes = sha.digest(byteArray);
	        StringBuffer hexValue = new StringBuffer();
	        for (int i = 0; i < md5Bytes.length; i++) {
	            int val = ((int) md5Bytes[i]) & 0xff;
	            if (val < 16) { 
	                hexValue.append("0");
	            }
	            hexValue.append(Integer.toHexString(val));
	        }
	        return hexValue.toString();
	    }

	    /**
	     * 测试主函数
	     * @param args
	     * @throws Exception
	     */
	    public static void main(String args[]) throws Exception {
	        String str = new String("amigoxiexiexingxing");
	        System.out.println("原始：" + str);
	        System.out.println("SHA后：" + shaEncode(str));
	        System.out.println(shaEncode(str).length());
	        System.out.println("MD5后:"+encodeToHex(str));
	        System.out.println(encodeToHex(str).length());
	        System.out.println("base64后:"+getBase64(str));
	        String index=getBase64(str);
	        System.out.println("base64解密:"+getFromBase64(index));
	    }
	 
	    /**
	     * Base64位加密
	     * @param str
	     * @return
	     */
	    public static String getBase64(String str) {  
	        byte[] b = null;  
	        String s = null;  
	        try {  
	            b = str.getBytes("utf-8");  
	        } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	        }  
	        if (b != null) {  
	            s = new BASE64Encoder().encode(b);  
	        }  
	        return s;  
	    }  
	 
	    
	    // Base64位解密  
	    public static String getFromBase64(String s) {  
	        byte[] b = null;  
	        String result = null;  
	        if (s != null) {  
	            BASE64Decoder decoder = new BASE64Decoder();  
	            try {  
	                b = decoder.decodeBuffer(s);  
	                result = new String(b, "utf-8");  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        return result;  
	    }  
	 
	 
}
