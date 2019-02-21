package com.stu.blog.wxdomain.memudomain;

public class ClickButton extends AbsButton{

    private String type = "click";
    private String key;

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
}
