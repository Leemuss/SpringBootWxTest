package com.stu.blog.wxdomain.memudomain;

import java.util.ArrayList;
import java.util.List;

public class Button {

    private List<AbsButton> button = new ArrayList<>();


    public List<AbsButton> getButton() {
        return button;
    }

    public void setButton(List<AbsButton> button) {
        this.button = button;
    }
}
