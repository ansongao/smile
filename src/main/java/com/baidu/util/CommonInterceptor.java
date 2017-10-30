package com.baidu.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.baidu.entity.User;
/**
 * Springmvc拦截器
 * @author Administrator
 *
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {
	  private static final Logger log = Logger.getLogger(CommonInterceptor.class);
    
	  //匿名用户可访问的地址
	    private String[] anonymousUrls;
	    
	    /** 
	     * Handler执行之前调用这个方法 
	     */  
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
        //获取请求的url
		String uri=request.getRequestURI();
        //获取项目名称
		String ctx=request.getContextPath();
	    //去掉项目名称
		uri = uri.replaceFirst(ctx, "");
		if(uri.equals("/admin/login.do")){
			System.out.println("登录页面通行");
			return true;
		}
		System.out.println("当前地址:"+uri);
		User user=(User)request.getSession().getAttribute("user");
		//if(user!=null){
		//	return true;
		//}
		//不符合条件的，跳转到登录界面  
      //  request.getRequestDispatcher("/index.jsp").forward(request, response);  
		return true;
	}

	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
    
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
	
}
