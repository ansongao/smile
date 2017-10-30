package com.wechat.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wechat.response.entity.ImageMessage;
import com.wechat.response.entity.NewsMessage;
import com.wechat.common.GetUseInfo;
import com.wechat.response.entity.Article;
import com.wechat.response.entity.Image;

import net.sf.json.JSONObject;

/**
 * 事件消息业务分发器
 * @author Administrator
 *
 */
@Service
public class EventDispatcher {
    private static final Logger logger=Logger.getLogger(EventDispatcher.class);
	
    public static String processEvent(Map<String, String> map) {
    	
    	String openid = map.get("FromUserName"); // 用户openid
    	String mpid = map.get("ToUserName"); // 公众号原始ID
    	  NewsMessage newmsg=new NewsMessage();
    	    newmsg.setToUserName(openid);
    	    newmsg.setFromUserName(mpid);
    	    newmsg.setCreateTime(new Date().getTime());
    	    newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
    	  
    	    try {
                HashMap<String, String> userinfo=GetUseInfo.Openid_userinfo(openid);
                Article article=new Article();
                article.setDescription("感谢您的关注"); //图文消息的描述
                article.setPicUrl(userinfo.get("headimgurl")); //图文消息图片地址
                article.setTitle("尊敬的："+userinfo.get("nickname")+",你好");  //图文消息标题
                article.setUrl("http://www.baidu.com");  //图文url链接
                List<Article> list=new ArrayList<Article>();
                list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里list中加入多个Article即可！
                newmsg.setArticleCount(list.size());
                newmsg.setArticles(list);
                return MessageUtil.newsMessageToXml(newmsg);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("====代码有问题额☺！");
            logger.error(e,e);
        }    
       if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { //关注事件
    	
        }
         
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) { //取消关注事件
            System.out.println("==============这是取消关注事件！");
        }
         
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SCAN)) { //扫描二维码事件
            System.out.println("==============这是扫描二维码事件！");
        }
         
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_LOCATION)) { //位置上报事件
            System.out.println("==============这是位置上报事件！");
        }
         
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_CLICK)) { //自定义菜单点击事件
            System.out.println("==============这是自定义菜单点击事件！");
        }
         
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_VIEW)) { //自定义菜单View事件
            System.out.println("==============这是自定义菜单View事件！");
        }
         
         
        return null;
    }
}
