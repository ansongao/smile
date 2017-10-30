package com.wechat.controller;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.baidu.util.SignUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.wechat.response.entity.TextMessage;
import com.wechat.util.EventDispatcher;
import com.wechat.util.MessageUtil;
import com.wechat.util.MsgDispatcher;

@Controller
public class WechatSecurity {
	private static Logger logger = Logger.getLogger(WechatSecurity.class);
	   
	    @RequestMapping(value = "security", method = RequestMethod.GET )
	    public void doGet(
	            HttpServletRequest request,
	            HttpServletResponse response,
	            @RequestParam(value = "signature", required = true) String signature,
	            @RequestParam(value = "timestamp", required = true) String timestamp,
	            @RequestParam(value = "nonce", required = true) String nonce,
	            @RequestParam(value = "echostr", required = true) String echostr) {
	        try {
	            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
	                PrintWriter out = response.getWriter();
	                out.print(echostr);
	                out.close();
	            } else {
	                logger.info("这里存在非法请求！");
	            }
	        } catch (Exception e) {
	            logger.error(e, e);
	        }
	    }
	 
	    @RequestMapping(value = "security", method = RequestMethod.POST)
	    // post方法用于接收微信服务端消息
	    public void DoPost(HttpServletRequest request,HttpServletResponse response) {
	    	try{
	    		 request.setCharacterEncoding("UTF-8");
		         response.setCharacterEncoding("UTF-8");
		         PrintWriter out=response.getWriter();
	            Map<String, String> map=MessageUtil.parseXml(request);
	            String msgtype=map.get("MsgType");
	            System.out.println("消息类型:"+map.get("MsgType"));
	            System.out.println(map.get("Content"));
                
	            String news=null;
	           
	          if(MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgtype)){
	              news=EventDispatcher.processEvent(map); //进入事件处理
	            }else{
	             // news=MsgDispatcher.processMessage(map); //进入消息处理
	            }
	            out.print(news);
	            out.close();
	        }catch(Exception e){
	            logger.error(e,e);
	        }
	    }
	    
	    
	    
}
