package com.baidu.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;



public class BaseController {
	
	

    private static final String DEFAULT_ENCODING = "UTF-8";
    /**
     * JSON_TYPE
     */
    public static final String JSON_TYPE = "application/json";
    /**
     * HTML_TYPE
     */
    public static final String HTML_TYPE = "text/html";
    /**
     * TEXT_TYPE
     */
    public static final String TEXT_TYPE = "text/plain";
    
    /**
     * 返回成功失败key
     */
    public static final String RESULTMAP_KEY_SUCCESS = "success";
    /**
     * 返回描述消息key
     */
    public static final String RESULTMAP_KEY_MSG = "msg";
    /**
     * 返回数据key
     */
    public static final String RESULTMAP_KEY_DATA = "data";

    /**
     * 成功
     */
    public static final Boolean RESULTMAP_SUCCESS_TRUE = true;
    /**
     * 失败
     */
    public static final Boolean RESULTMAP_SUCCESS_FALSE = false;
    /**
     * 出现异常错误字符串提示
     */
    public static final String EXCEPTION_ERROR_STR = "加载数据失败,请稍后重试";

    /**
     * 取得参数转成Long.
     *
     * @param request
     * @param paramName
     * @return
     */
    
    
    private String getStream(String url){
        try {
            //得到字节流
            InputStream in = new URL(url).openStream();
            //将字节流转化成字符流，并指定字符集
            InputStreamReader isr = new InputStreamReader(in,"UTF-8");
            //将字符流以缓存的形式一行一行输出
            BufferedReader bf = new BufferedReader(isr); 
            String results = "";
            String newLine = "";
            while((newLine = bf.readLine()) != null){
                results += newLine+"\n";
            }
            return results;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

 
    public static void main(String[] args) {
    	String strPath = "E:\\a\\aa";  
    	File file = new File(strPath);  
    	if(!file.exists()){  
    	    file.mkdirs();  
    	}  
	}
    
    
    
    
}

