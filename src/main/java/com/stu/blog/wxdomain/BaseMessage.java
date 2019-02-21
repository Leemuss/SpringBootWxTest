package com.stu.blog.wxdomain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Date;
import java.util.Map;


public class BaseMessage {

    @XStreamAlias("ToUserName")
    private String toUserName;//开发者微信号

    @XStreamAlias("FromUserName")
    private String fromUserName;//发送方帐号（一个OpenID）

    @XStreamAlias("CreateTime")
    private Long createTime;//消息创建时间 （整型）

    @XStreamAlias("MsgType")
    private String msgType;//消息类型

    public BaseMessage(){

    }

    public BaseMessage(Map<String,String> requestMap){
        this.toUserName = requestMap.get("FromUserName");
        this.fromUserName = requestMap.get("ToUserName");
        this.createTime = new Date().getTime()/1000;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
