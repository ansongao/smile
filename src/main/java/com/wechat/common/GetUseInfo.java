package com.wechat.common;

import java.util.HashMap;

import com.wechat.constants.GlobalConstants;
import com.wechat.util.HttpUtils;

import net.sf.json.JSONObject;

/**
 * 获取微信用户信息
 * @author Administrator
 *
 */
public class GetUseInfo {
    /**
     * 通过openid获取用户信息
     */
	 public static HashMap<String, String> Openid_userinfo(String openid)
	            throws Exception {
	        HashMap<String, String> params = new HashMap<String, String>();
	        params.put("access_token",
	                GlobalConstants.getInterfaceUrl("access_token"));  //定时器中获取到的token
	        params.put("openid", openid);  //需要获取的用户的openid
	        params.put("lang", "zh_CN");
	        String subscribers = HttpUtils.sendGet(
	                GlobalConstants.getInterfaceUrl("OpenidUserinfoUrl"), params);
	        System.out.println("返回微信信息:"+subscribers);
	        params.clear();
	        //这里返回参数只取了昵称、头像、和性别
	        params.put("nickname",
	                JSONObject.fromObject(subscribers).getString("nickname")); //昵称
	        params.put("headimgurl",
	                JSONObject.fromObject(subscribers).getString("headimgurl"));  //图像
	        params.put("sex", JSONObject.fromObject(subscribers).getString("sex"));  //性别
	        return params;
	    }
	 
	}