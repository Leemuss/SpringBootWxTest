package com.stu.blog.msgdomain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

@XStreamAlias("xml")
public class VoiceMessage extends BaseMessage{

    @XStreamAlias("MediaId")
    private String mediaId;//通过素材管理中的接口上传多媒体文件，得到的id

    public VoiceMessage(){}

    public VoiceMessage(Map<String,String> requestMap, String mediaId){
        super(requestMap);
        this.setMsgType("voice");
        this.mediaId = mediaId;
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
