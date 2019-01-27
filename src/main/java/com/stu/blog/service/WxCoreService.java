package com.stu.blog.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface WxCoreService {

    public String weixinMessageHandelCoreService(HttpServletRequest request,
                                                 HttpServletResponse response);
}
