    package com.stu.blog.msgdomain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

@XStreamAlias("xml")
public class VideoMessage extends BaseMessage{

    @XStreamAlias("MediaId")
    private String mediaId;//通过素材管理中的接口上传多媒体文件，得到的id

    @XStreamAlias("Title")
    private String title;//标题

    @XStreamAlias("Description")
    private String description;//描述

    public VideoMessage(){}

    public VideoMessage(Map<String,String> requestMap, String mediaId){
        super(requestMap);
        this.setMsgType("video");
        this.mediaId = mediaId;
        this.title = title;
        this.description = description;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TextMessage{" +
                "ToUserName='" + getToUserName()+ '\'' +
                ", FromUserName='" + getFromUserName() + '\'' +
                ", CreateTime=" + getCreateTime() +
                ", mediaId=" + getMediaId() + '\'' +
                ", title=" + getTitle() + '\'' +
                ", description=" + getDescription() + '\'' +
                ", MsgType='" + getMsgType() + '\'' +
                '}';
    }

}
