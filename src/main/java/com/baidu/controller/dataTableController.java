package com.baidu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.entity.Page;
import com.baidu.entity.User;
import com.baidu.service.UserService;
import com.baidu.util.PageUtil;

import net.sf.json.JSONObject;
/**
 * jquery表格插件运用
 * @author Administrator
 *
 */
@Controller
public class dataTableController {
    @Autowired
	private UserService userService;
	/**
	 * 表格插件页面
	 * @return
	 */
	@RequestMapping("/admin/dataTableTest")
	public String dataTest(){
		
		return "dataTable/dataTableTest";
	}
	/**
	 * 使用dataTables刷新数据进入页面
	 * @return
	 */
	@RequestMapping("/admin/UserNews")
	public String dataNews(HttpServletRequest request){
		String currentPages=(String)request.getSession().getAttribute("c");
		int currentPage=1;
		if(currentPages==null||"".equals(currentPages)){
    		currentPage=1;
    	}else{
    		currentPage=Integer.parseInt(currentPages);
    	}
	
		int count=userService.getAll();
    	//10表示每页显示数，count表总的用户数，currentPage表当前页数
    	Page page=PageUtil.createPage(10, count, currentPage);
		request.setAttribute("page", page);
		return "dataTable/UserNews";
	}
	
	 /**
	  * dataTables刷新数据请求
	  * @param request
	  * @param response
	  * @return
	  * @throws Exception
	  */
    @ResponseBody
    @RequestMapping(value="/admin/dataTable")
    public JSONObject dataTable(HttpServletRequest request,
            HttpServletResponse response) throws Exception{
    	System.out.println("进入插件分页页面");
    	String currentPages=request.getParameter("currentPage");
    	String c=request.getParameter("cc");
    	int currentPage=0;
    	if(currentPages==null||"".equals(currentPages)){
    		currentPage=1;
    	}else{
    		currentPage=Integer.parseInt(currentPages);
    	}
    	System.out.println(currentPage);
    	//得到用户总数
    	int count=userService.getAll();
    	//10表示每页显示数，count表总的用户数，currentPage表当前页数
    	Page page=PageUtil.createPage(10, count, currentPage);
    	//得到当前页用户
    	List<User> all=userService.showPage(page);
    	//存放结果集
    	page.setData(all);
    	request.getSession().setAttribute("c", currentPages);
    	JSONObject j=new JSONObject();
    	j.put("data", all);
    	//j.put("page", page);
    	return j;
    }
    
    /**
     * 点击页面页码返回数据
     */
    //返回页面
    @ResponseBody
    @RequestMapping(value="/admin/dataShow")
    public ModelAndView showPage2(HttpServletRequest request,
            HttpServletResponse response) throws Exception{
    	String url="admin/UserNews";
    	//接收当前页面传来的参数
    	String currentPages=(String)request.getSession().getAttribute("c");
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
    	return new ModelAndView(url);
    }	
    
    @RequestMapping("test1")
    public String test1(){
    	
    	return "test";
    }
    
    @RequestMapping("accept")
    public String accept(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	//request.setCharacterEncoding("UTF-8");
    	String username=request.getParameter("username");
    	String password=request.getParameter("password");

    	username = new String (username.getBytes("iso8859-1"),"UTF-8");
    	System.out.println("当前值"+username+password);
    	
    	return "test";
    }
    
    public static void main(String[] args) {
    	
    	
	}
    
}
