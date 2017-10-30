package com.wechat.common;

import org.apache.log4j.Logger;
import com.wechat.common.WeChatTask;
/**
 * 任务调度，定时任务类
 * @author Administrator
 *
 */
public class QuartzJob{
    private static Logger logger = Logger.getLogger(QuartzJob.class);
   /**
    * 任务执行获取token
    */
    public void workForToken() {
        try {
        	WeChatTask timer = new WeChatTask();
            timer.getToken_getTicket();
        } catch (Exception e) {
            logger.error(e, e);
        }
    }
 
 
}
