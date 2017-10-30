package com.baidu.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * 自定义监听器类
 * @author Administrator
 *
 */
public class MyRequestListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		 System.out.println("结束监听器");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		  System.out.println("启动监听器");
	}

}
