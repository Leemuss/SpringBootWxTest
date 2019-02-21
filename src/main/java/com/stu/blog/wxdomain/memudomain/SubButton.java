package com.stu.blog.wxdomain.memudomain;

import java.util.ArrayList;
import java.util.List;

public class SubButton extends AbsButton{

    private List<AbsButton> sub_button = new ArrayList<>();

    public List<AbsButton> getSubButton() {
        return sub_button;
    }

    public void setSubButton(List<AbsButton> sub_button) {
        this.sub_button = sub_button;
    }
}
