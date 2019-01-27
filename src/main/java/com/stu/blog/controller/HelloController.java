package com.stu.blog.controller;

import com.stu.blog.service.WxCoreService;
import com.stu.blog.util.WxMsgHandlerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Controller
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private WxCoreService wxCoreService;

    @ResponseBody
    @GetMapping("/msg")
    public String hello(@RequestParam String signature,
                        @RequestParam String timestamp,
                        @RequestParam String nonce,
                        @RequestParam String echostr,
                        HttpServletResponse hsr) throws IOException {
        System.out.println("signature:" + signature + ",timestamp:" + timestamp + ",nonce:" + nonce  + ",echostr:" + echostr);

        if(WxMsgHandlerUtil.isCheck(signature,timestamp,nonce)){
            log.info("接入成功");
            return echostr;
        }else{
            log.info("接入失败");
            return "error";
        }
    }

    @ResponseBody
    @PostMapping(value = "/msg")
    public String msg(HttpServletResponse response, HttpServletRequest request) throws Exception {
        //Map<String,String> map = WxService.parseRequest(response,request);
        String xml = wxCoreService.weixinMessageHandelCoreService(request,response);
        //String xml = "<xml><ToUserName>opSgm1sB8VlAfsdBnHwTAPJMAlfY</ToUserName><FromUserName>gh_ba3ffb3b11c8</FromUserName><CreateTime>1548574358</CreateTime><MsgType>text</MsgType><Content>我不能识别你发送的内容!</Content></xml>";
        request.setCharacterEncoding("UTF-8");
        // 在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；
        response.setCharacterEncoding("UTF-8");
        if (!StringUtils.isEmpty(xml)){
            log.info("返回微信消息成功！");
            System.out.println(xml);
            return xml;
        }else {
            log.info("微信消息处理失败！");
            return "error";
        }
    }
}
