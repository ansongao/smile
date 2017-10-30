package com.baidu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.service.UserService;

@Controller
public class UtilController {
    @Resource
	private UserService userService;
    /**
     * 设置cookie
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/admin/cookie")
    public ModelAndView getCookie(HttpServletRequest request,HttpServletResponse response) throws Exception {
    	String input=null;
    	String show=null;
    	Cookie[] cookies=request.getCookies();
    	if(cookies!=null){
    		input="这是您第一次访问本网站";
    		show="访问过才会真实数据";
    		for(int i=0;i<cookies.length;i++){
    			Cookie cookie=cookies[i];
    			if(cookie.getName().equals("lastAccessTime")){
    				Long lastAccessTime=Long.parseLong(cookie.getValue());
    				Date date=new Date(lastAccessTime);
    				 input="您上次访问的时间是："+date;
    			}
    			if(cookie.getName().equals("test")){
    				show=URLDecoder.decode(cookie.getValue(),"UTF-8");
    				
    			}
    		}
    		
    	}else{
    		 input="这是您第一次访问本网站";
    		 show="访问过才会真实数据";
    	}
    	request.setAttribute("input", input);
    	request.setAttribute("show", show);
    	//用户访问之后重新设定用户的访问时间，存储到cookie中，然后发送给浏览器
    	Cookie c=new Cookie("lastAccessTime",System.currentTimeMillis()+"");
    	//cookie中存储中文必须如下格式
    	Cookie test=new Cookie("test",URLEncoder.encode("测试一下", "UTF-8") );
    	//将cookie对象添加到response对象中，
    	response.addCookie(c);
    	response.addCookie(test);
    	return new ModelAndView("admin/cookie");
    }
    /**
     * 清除cookie
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value="/admin/remove")
    public void remove(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	    System.out.println("进入删除cookie方法");
    	//创建一个名字为lastAccessTime的cookie
    	       Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis()+"");
    	       Cookie cookie1 = new Cookie("test",URLEncoder.encode("测试", "UTF-8") );
    	         //将cookie的有效期设置为0，命令浏览器删除该cookie
    	        cookie.setMaxAge(0);
    	        cookie1.setMaxAge(0);
    	       response.addCookie(cookie);
    	       response.addCookie(cookie1);
    }
    /**
     * 上传页面
     */
    @RequestMapping(value="/upload")
    public String uploadView(){
    	
    	return "upload";
    }
    
    
    // 定义允许上传的文件扩展名
    private String Ext_Name = "gif,jpg,jpeg,png";
    
    
    /**
     * 上传方法
     */
    @RequestMapping(value="/admin/upload")
    public String upload(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String message="";//消息提示
    	//转化request
    	MultipartHttpServletRequest rm=(MultipartHttpServletRequest) request;
       //获得前端页面传来的文件
    	MultipartFile mfile=rm.getFile("file1");
    	
       //获得文件的字节数组
    	byte[] bfile=mfile.getBytes();
       //获得文件名
    	String fileName=mfile.getOriginalFilename();
       //输出测试
    	System.out.println("文件名称："+fileName+"大小："+bfile.length);
    	
    	 // 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
        fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
        
        // 得到上传文件的扩展名
        String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        // 检查扩展名
        // 如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
        System.out.println("上传的文件的扩展名是：" + fileExt);
        if(!Ext_Name.contains(fileExt)){
            System.out.println("上传文件扩展名是不允许的扩展名：" + fileExt);
            message = message + "文件：" + fileName + "，上传文件扩展名是不允许的扩展名：" + fileExt + "<br/>";
            request.setAttribute("news", message);
        }else{
        	//保存文件
        	saveFile(bfile,fileName,request);
          	request.setAttribute("news", "上传成功");
        }
      
    	return "message";
    }
    
    
    /**
     * 保存上传文件方法
     */
    private void saveFile(byte[] bfile,String fileName,HttpServletRequest request) throws Exception{
    	//定义文件输出流
    	//String upload=request.getServletContext().getRealPath("/resource/download");
    	
    	String upload="E:\\tomcat\\apache-tomcat-8.0.46\\images";
    	
    	
    	
    	System.out.println("储存位置："+upload);
    	OutputStream out=new FileOutputStream(new File(upload,fileName));
        out.write(bfile);
        out.flush();
        out.close();
    }
    
    /**
     * 提供下载的页面
     */
    @RequestMapping(value="/download")
    public String download(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	//获取文件目录
    	//String FilePath=request.getSession().getServletContext().getRealPath("/resource/download");
    	
    	String FilePath="E:\\tomcat\\apache-tomcat-8.0.46\\images";
        System.out.println("提供下载的目录："+FilePath);
    	 //存储要下载的文件名
         Map<String,String> fileNameMap = new HashMap<String,String>();
         //递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中
         listfile(new File(FilePath),fileNameMap);
         //将Map集合发送到listfile.jsp页面进行显示
         request.setAttribute("fileNameMap",fileNameMap );
         
         return "download";
    }
    
    
    /**
     * 遍历提供下载的文件目录下的所有文件
     */
    public void listfile(File file,Map<String,String>map){
    	//如果file代表的是一个目录
    	if(!file.isFile()){
    		//列出该目录下所有文件和目录
    		File[] files=file.listFiles();
    		//遍历该数组
    		for(File f:files){
    			//递归
    			listfile(f,map);
    		}
    	}else{
    		//去除文件名uuid部分的命名,即得到下载文件的原名
    		String realName=file.getName().substring(file.getName().indexOf("_")+1);
    		System.out.println("下载文件名："+realName);
    		map.put(file.getName(), realName);
    	}
    	
    }
    
    /**
     * 实现下载
     */
    @RequestMapping(value="/admin/download")
    public String down(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	System.out.println("进入下载方法");
    	//得到要下载的文件名
    	String fileName=request.getParameter("fileName");
    	//提供下载的文件目录
    	//String fileSaveRootPath=request.getSession().getServletContext().getRealPath("/resource/download");
       
    	String fileSaveRootPath="E:\\tomcat\\apache-tomcat-8.0.46\\images";
    	//通过文件名找出文件所在目录
    	//String path=findFileSavePathByName(fileName,fileSaveRootPath);
        //得到要下载的文件
    	File file=new File(fileSaveRootPath+"\\"+fileName);
    	//如果文件不存在
    	if(!file.exists()){
    		request.setAttribute("message", "您要下载的资源已不存在");
    		return "download/download";
    	}
    	//处理文件名
    	String realName=fileName.substring(fileName.indexOf("_")+1);
    	//设置响应头控制浏览器下载该文件
    	response.setHeader("content-disposition",  "attachment;fileName=" + URLEncoder.encode(realName, "UTF-8"));
        //读取要下载的文件，保存到文件输入流
    	FileInputStream in=new 	FileInputStream(fileSaveRootPath+"\\"+fileName);
    	//创建输出流
    	OutputStream out=response.getOutputStream();
    	//创建缓冲区
    	byte[] buffer=new byte[1024];
    	int len=0;
    	//循环将输入流中的内容读取到缓冲区中
    	while((len=in.read(buffer))>0){
    		//输出缓冲区的内容到浏览器,实现文件下载
    		out.write(buffer,0,len);
    	}
    	//关闭文件输入流
    	in.close();
    	//关闭输出流
    	out.close();
    	request.setAttribute("message", "资源下载成功");
    	return "download/download";
    }
    
    
    /**
     * 通过文件名找出文件所在位置
     */
    public String findFileSavePathByName(String fileName,String saveRootPath) throws Exception{
    	int hashcode=fileName.hashCode();
    	//为避免在一个目录保存多个文件，影响文件读取的性能，应把文件打散到多个目录存储
    	int dir1 = hashcode&0xf;  //0--15
        int dir2 = (hashcode&0xf0)>>4;  //0-15
        String dir = saveRootPath + "\\" + dir1 + "\\" + dir2; 		
    	File file=new File(dir);	
    	if(!file.exists()){
    		//创建目录
    		file.mkdirs();
    	}
    	return dir;
    }
    
 
    
    public static void main(String[] args) {
		String path=System.getProperty("user.dir");
		String filePath=new UtilController().getClass().getResource("/").getPath();
		System.out.println(filePath);
	}
    
}



