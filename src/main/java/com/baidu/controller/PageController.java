package com.baidu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.entity.Page;
import com.baidu.entity.User;
import com.baidu.service.UserService;
import com.baidu.util.PageUtil;

import net.sf.json.JSONObject;

@Controller
public class PageController {
    @Resource
	private UserService userService;
    /**
     * 分页显示
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="/admin/showPage")
    public ModelAndView showPage(HttpServletRequest request,
            HttpServletResponse response) throws Exception{
    	String url="CustomerFindAllResult";
    	//接收当前页面传来的参数
    	String currentPages=request.getParameter("currentPage");
    	int currentPage=0;
    	if(currentPages==null||"".equals(currentPages)){
    		currentPage=1;
    	}else{
    		currentPage=Integer.parseInt(currentPages);
    	}
    
    	//得到用户总数
    	int count=userService.getAll();
    	
    	//设置分页参数
    	//10表示每页显示数，count表总的用户数，currentPage表当前页数
    	Page page=PageUtil.createPage(10, count, currentPage);
    	//得到当前页用户
    	List<User> all=userService.showPage(page);
    	request.setAttribute("page", page);
    	request.setAttribute("all", all);
    	
    	String play=request.getParameter("play");
    	System.out.println(play);
    	return new ModelAndView(url);
    	
    }
    //进入页面
    @ResponseBody
    @RequestMapping(value="/admin/page")
    public ModelAndView Page(HttpServletRequest request,
            HttpServletResponse response) throws Exception{
    	System.out.println("进入分页页面");
    	String url="UserAll";
    	int currentPage=1;
    	//得到用户总数
    	int count=userService.getAll();
    	//10表示每页显示数，count表总的用户数，currentPage表当前页数
    	Page page=PageUtil.createPage(10, count, currentPage);
    	//得到当前页用户
    	List<User> all=userService.showPage(page);
    	//存放结果集
    	page.setData(all);
    	request.setAttribute("page", page);
    	request.setAttribute("all", all);
    	return new ModelAndView(url);
    	
    }
     // 判断页面
    @ResponseBody
    @RequestMapping(value="/admin/showPage1")
    public Object showPage1(HttpServletRequest request,
            HttpServletResponse response) throws Exception{
    	
    	//接收当前页面传来的参数
    	String currentPages=request.getParameter("currentPage");
    	//页面按钮值
    	String pay=request.getParameter("pay");
        //页面输入框值
    	String input=request.getParameter("input");
    	
    	request.getSession().setAttribute("currentPages", currentPages);
    	request.getSession().setAttribute("pay", pay);
    	request.getSession().setAttribute("input", input);
    	JSONObject j=new JSONObject();
         j.put("state", 1);
    	return j;
    	
    }
    //返回页面
    @ResponseBody
    @RequestMapping(value="/admin/showPage2")
    public ModelAndView showPage2(HttpServletRequest request,
            HttpServletResponse response) throws Exception{
    	String url="UserAll";
    	//接收当前页面传来的参数
    	String currentPages=(String)request.getSession().getAttribute("currentPages");
    	int currentPage=0;
    	if(currentPages==null||"".equals(currentPages)){
    		currentPage=1;
    	}else{
    		currentPage=Integer.parseInt(currentPages);
    	}
    
    	//得到用户总数
    	int count=userService.getAll();
    	//设置分页参数
    	//10表示每页显示数，count表总的用户数，currentPage表当前页数
    	Page page=PageUtil.createPage(10, count, currentPage);
    	//得到当前页用户
    	List<User> all=userService.showPage(page);
    	String input=(String)request.getSession().getAttribute("input");
    	String id=request.getSession().getId();
    	System.out.println(id);
    	request.setAttribute("inputs", input);
    	request.setAttribute("page", page);
    	request.setAttribute("all", all);
    	return new ModelAndView(url);
    	
    }
    
    
   
}
