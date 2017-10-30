package com.wechat.response.entity;

import com.baidu.entity.BaseEntity;

/**
 * 图片消息
 * @author Administrator
 *
 */
public class ImageMessage extends BaseMessage {
    
    private Image Image;
 
    public Image getImage() {
        return Image;
    }
 
    public void setImage(Image image) {
        Image = image;
    }
     
 
}
