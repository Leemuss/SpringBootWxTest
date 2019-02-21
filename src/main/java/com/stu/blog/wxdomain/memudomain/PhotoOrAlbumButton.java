package com.stu.blog.wxdomain.memudomain;

import java.util.ArrayList;
import java.util.List;

public class PhotoOrAlbumButton extends AbsButton{

    //pic_photo_or_album 拍照或者相册发图
    //type": "pic_sysphoto","name": "系统拍照发图"
    // "type": "pic_weixin", "name": "微信相册发图"
    private String type = "pic_photo_or_album";
    private String key;
    private List<SubButton> subButton = new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<SubButton> getSubButton() {
        return subButton;
    }

    public void setSubButton(List<SubButton> subButton) {
        this.subButton = subButton;
    }
}
