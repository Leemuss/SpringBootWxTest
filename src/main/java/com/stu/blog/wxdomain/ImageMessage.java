package com.stu.blog.wxdomain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

@XStreamAlias("xml")
public class ImageMessage extends BaseMessage{

    @XStreamAlias("MediaId")
    private String mediaId;//文本消息内容

    public ImageMessage(){}

    public ImageMessage(Map<String,String> requestMap, String medialId){
        super(requestMap);
        this.setMsgType("image");
        this.mediaId = medialId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        mediaId = mediaId;
    }

    @Override
    public String toString() {
        return "TextMessage{" +
                "ToUserName='" + getToUserName()+ '\'' +
                ", FromUserName='" + getFromUserName() + '\'' +
                ", CreateTime=" + getCreateTime() +
                ", mediaId=" + getMediaId() + '\'' +
                ", MsgType='" + getMsgType() + '\'' +
                '}';
    }

}
