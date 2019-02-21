package com.stu.blog.wxdomain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("item")
public class Articles {

    @XStreamAlias("Title")
    private String title;//标题

    @XStreamAlias("Description")
    private String description;//描述


    @XStreamAlias("PicUrl")
    private String picUrl;//图片链接

    @XStreamAlias("Url")
    private String url;//点击图文消息跳转链接


    public Articles() {
    }

    public Articles(String title, String description, String picUrl ,String url) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.picUrl = picUrl;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

}
