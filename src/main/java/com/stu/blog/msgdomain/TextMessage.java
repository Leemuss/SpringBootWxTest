package com.stu.blog.msgdomain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

@XStreamAlias("xml")
public class TextMessage extends BaseMessage{

    @XStreamAlias("Content")
    private String content;//文本消息内容c

    public TextMessage(){}

    public TextMessage(Map<String,String> requestMap,String content){
        super(requestMap);
        this.setMsgType("text");
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        content = content;
    }

    @Override
    public String toString() {
        return "TextMessage{" +
                "ToUserName='" + getToUserName()+ '\'' +
                ", FromUserName='" + getFromUserName() + '\'' +
                ", CreateTime=" + getCreateTime() +
                ", Content=" + getContent() + '\'' +
                ", MsgType='" + getMsgType() + '\'' +
                '}';
    }

}
