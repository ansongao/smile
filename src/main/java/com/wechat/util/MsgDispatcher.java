package com.wechat.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wechat.common.GetUseInfo;
import com.wechat.response.entity.Article;
import com.wechat.response.entity.NewsMessage;
import com.wechat.response.entity.TextMessage;





/**
 * 消息业务处理分发器
 * @author Administrator
 *
 */
@Service
public class MsgDispatcher {
	private static final Logger logger=Logger.getLogger("MsgDispatcher.class");
	
    public static String processMessage(Map<String, String> map) {
    	String responseMessage = "success";
    	String openid=map.get("FromUserName"); //用户openid
    	String mpid=map.get("ToUserName");   //公众号原始ID
    	logger.error("用户openid:"+openid+"  "+"公众号原始id:"+mpid);         
    	//普通文本消息
    	TextMessage txtmsg=new TextMessage();
    	txtmsg.setToUserName(openid);
    	txtmsg.setFromUserName(mpid);
    	txtmsg.setCreateTime(new Date().getTime());
    	txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
    	if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
    		String content=map.get("Content");
    		  if("1".equals(content)){
    		        txtmsg.setContent("你好，你发送的内容是1！");
    		    }else if("2".equals(content)){
    		        NewsMessage newmsg=new NewsMessage();
    		    	newmsg.setToUserName(openid);
    		    	newmsg.setFromUserName(mpid);
    		    	newmsg.setCreateTime(new Date().getTime());
    		    	newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
    		    	
    		    	 Article article=new Article();
    	            article.setDescription("这是一张神奇的图片"); //图文消息的描述
    	            article.setPicUrl("http://www.tuling123.com/resources/web/v4/img/personalCen/icon36.png"); //图文消息图片地址
    	            article.setTitle("图文消息");  //图文消息标题
    	            article.setUrl("http://www.baidu.com");  //图文url链接
    	            List<Article> list=new ArrayList<Article>();
    	            list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里list中加入多个Article即可！
    	            newmsg.setArticleCount(list.size());
    	            newmsg.setArticles(list);
    	            return MessageUtil.newsMessageToXml(newmsg);
    		    	
    		    }else if("3".equals(content)){
    		        txtmsg.setContent("你好，你发送的内容是3！");
    		    }else if("4".equals(content)){
    		        txtmsg.setContent("<a href=\"http://www.baidu.com\">百度一下</a>");
    		    }else{
    		        txtmsg.setContent("你好，然后呢");
    		    }
    		    return MessageUtil.textMessageToXml(txtmsg);
    	}
    	
    	
    	  //对图文消息
    	NewsMessage newmsg=new NewsMessage();
    	newmsg.setToUserName(openid);
    	newmsg.setFromUserName(mpid);
    	newmsg.setCreateTime(new Date().getTime());
    	newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
            System.out.println("==============这是图片消息！");
//            Article article=new Article();
//            article.setDescription("这是一张神奇的图片"); //图文消息的描述
//            article.setPicUrl("http://www.tuling123.com/resources/web/v4/img/personalCen/icon36.png"); //图文消息图片地址
//            article.setTitle("图文消息");  //图文消息标题
//            article.setUrl("http://www.baidu.com");  //图文url链接
//            List<Article> list=new ArrayList<Article>();
//            list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里list中加入多个Article即可！
//            newmsg.setArticleCount(list.size());
//            newmsg.setArticles(list);
//            return MessageUtil.newsMessageToXml(newmsg);
            
            try {
            	System.out.println("获取用户信息");
                HashMap<String, String> userinfo=GetUseInfo.Openid_userinfo(openid);
                System.out.println("用户信息:"+userinfo);
                Article article=new Article();
                article.setDescription("谢谢您的关注"); //图文消息的描述
                article.setPicUrl(userinfo.get("headimgurl")); //图文消息图片地址
                article.setTitle("尊敬的："+userinfo.get("nickname")+",你好！");  //图文消息标题
                article.setUrl("http://www.baidu.com");  //图文url链接
                List<Article> list=new ArrayList<Article>();
                list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里list中加入多个Article即可！
                newmsg.setArticleCount(list.size());
                newmsg.setArticles(list);
                System.out.println("用户信息:"+list);
                return MessageUtil.newsMessageToXml(newmsg);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("====代码有问题额☺！");
            e.printStackTrace();
            
        }
            
        }
         
         
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { // 链接消息
        	System.out.println("==============这是链接消息！");
        	  txtmsg.setContent("");
             return MessageUtil.textMessageToXml(txtmsg);
            
        }
         
         
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) { // 位置消息
            System.out.println("==============这是位置消息！");
            return "";
        }
         
         
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) { // 视频消息
            System.out.println("==============这是视频消息！");
        }
         
         
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) { // 语音消息
            System.out.println("==============这是语音消息！");
        }
 
        return null;
    }
}
