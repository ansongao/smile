package com.baidu.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
/**
 * 初始化servlet
 * @author Administrator
 *
 */
@WebServlet("/Log4JInitServlet") 
public class Log4JInitServlet extends HttpServlet {

	private static final long serialVersionUID = -6074706387719397321L;

	public Log4JInitServlet() {
		
		super();
	}
    
	public void init(ServletConfig config) throws ServletException {
		 System.out.println("Log4JInitServlet 正在初始化 log4j日志设置信息");  
		 String log4jLocation = config.getInitParameter("log4j-properties-location"); 
		 
		 ServletContext sc = config.getServletContext();  
		 if (log4jLocation == null) {  
	            System.err.println("*** 没有 log4j-properties-location 初始化的文件, 所以使用 BasicConfigurator初始化");  
	            BasicConfigurator.configure();  
	        } else {  
	            String webAppPath = sc.getRealPath("/");  
	            String log4jProp = webAppPath + log4jLocation;  
	            File yoMamaYesThisSaysYoMama = new File(log4jProp);  
	            if (yoMamaYesThisSaysYoMama.exists()) {  
	                System.out.println("使用: " + log4jProp+"初始化日志设置信息");  
	                PropertyConfigurator.configure(log4jProp);  
	            } else {  
	                System.err.println("*** " + log4jProp + " 文件没有找到， 所以使用 BasicConfigurator初始化");  
	                BasicConfigurator.configure();  
	            }  
	        }  
	        super.init(config);  
		
	}
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doPost(req, resp);
	}

	
    
	
	
	
}
