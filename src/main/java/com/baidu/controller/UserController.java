package com.baidu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.entity.EmailUser;
import com.baidu.entity.User;
import com.baidu.service.UserService;
import com.baidu.service.UserServiceImpl;
import com.baidu.util.JsonResult;
import com.baidu.util.Sendmail;

import net.sf.json.JSONObject;

@Controller
public class UserController {
	    @Resource
		private UserService userService;
	
    private User user;
	/**
	 * 登录验证
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
    @ResponseBody
    @RequestMapping(value="/admin/login")  
	    public Object login(HttpServletRequest request,
	                              HttpServletResponse response) throws Exception {
	        String username=request.getParameter("username");
	        String password=request.getParameter("password");
	        System.out.println("进入登录方法"+username+"   "+password);
	        user=userService.login(username,password);
	        //存入用户，用于后台判断是否登录
            request.getSession().setAttribute("user",user);
	        if(user==null){
	        	Exception e=new Exception();
	        	System.out.println("空");
	        	JSONObject jsonObject = new JSONObject();
	        	jsonObject.put("state", 1);
	        	return jsonObject;
	        }else{
	        	  System.out.println("非空");
                 System.out.println(user);
                 String jsonStr = "{id:2}";
                 JSONObject jsonObject = JSONObject.fromObject(jsonStr);  
	        	return jsonObject;
	        }
	        
	    }
	  
	  /**
	   * 商城主页面
	   * @param request
	   * @param response
	   * @return
	   */
	 
	  @RequestMapping(value="/admin/show")
	     public ModelAndView show(HttpServletRequest request,HttpServletResponse response){
	    	 
	    	 String returnview="admin/shop";
	    	 return new ModelAndView(returnview);
	     }
	  
	  @RequestMapping(value="/admin/welcome")
	     public ModelAndView welcome(HttpServletRequest request,HttpServletResponse response){
	    	 
	    	 String returnview="welcome";
	    	 return new ModelAndView(returnview);
	     }
	  
     /**
      * 注册界面
      * @return
      */
	  @RequestMapping(value ="/admin/regist")
	    public ModelAndView check(HttpServletRequest request){
		  String[] city=(String[])request.getSession().getAttribute("city");
		 request.setAttribute("show", city);
		 
		  return  new ModelAndView("admin/regist");
	    }
	  
	  @RequestMapping(value ="/admin/check")
	    public ModelAndView go(){
		  
		  int a=1;
		  return  new ModelAndView("regist");
	    }
	  
	  @ResponseBody
	  @RequestMapping(value ="/admin/city")
	    public JSONObject city(HttpServletRequest request,HttpServletResponse response){
	
		  JSONObject j=new JSONObject();
		  j.put("success", true);
		  return  j;
	    }
	  /**
	   * 编辑页面
	   * @return
	   */
	  @RequestMapping(value ="/admin/edit")
	    public ModelAndView edit(){
		  
		
		  return  new ModelAndView("admin/edit");
	    }
	  
	  /**
	   * 注册
	   */
	  @ResponseBody
	  @RequestMapping(value="regist/checked")
	  public JSONObject checked(HttpServletRequest request,HttpServletResponse response) throws Exception{
		  //接受前台页面注册信息
		  String username=request.getParameter("username");
		  String password=request.getParameter("password");
		  //获取客户端验证码
		  String code=request.getParameter("code");
		  code=new String (code.getBytes("iso8859-1"),"UTF-8"); 
		  String checkcode=(String)request.getSession().getAttribute("checkcode");
		  System.out.println(code+checkcode);
		  try {
			
			  String email=request.getParameter("email");
			  EmailUser user=new EmailUser();
			  user.setEmail(email);
			  user.setUsername(username);
			  user.setPassword(password);
			  //用自己开辟的一个线程来发送邮件
		   //  Sendmail send=new Sendmail(user);
			//  send.start();
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		  JSONObject j=new JSONObject();
		  //验证码验证
		  if(!code.equals(checkcode)){
			  j.put("state", "codeError");
			  return j;
		  }
		  //注册
		  Boolean flag=userService.registCheck(username, password);
		  //判断该用户是否注册成功
		  if(flag==false){
			  //已经注册
			  j.put("state", false);
		  }
		  if(flag){
			  j.put("state", true);
		  }
		  System.out.println(j);
		  return j;
	  }
}
