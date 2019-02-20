package com.stu.blog.service.impl;

import com.stu.blog.msgdomain.AccessToken;
import com.stu.blog.msgdomain.BaseMessage;
import com.stu.blog.msgdomain.TextMessage;
import com.stu.blog.msgdomain.WxMsgInfo;
import com.stu.blog.service.WxCoreService;
import com.stu.blog.util.WxMsgHandlerUtil;
import com.stu.blog.util.WxMsgUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

@Service
public class WxCoreServiceImpl implements WxCoreService {

    private static final Logger log = LoggerFactory.getLogger(WxCoreServiceImpl.class);

    @Override
    public String weixinMessageHandelCoreService(HttpServletRequest request, HttpServletResponse response) {
        BaseMessage msg = null;
        Map<String, String> map = WxMsgHandlerUtil.parseRequest(response, request);
        System.out.println("接收到的消息:" + map);

        log.info("开始处理消息类型");
        String msgType = map.get("MsgType");
        switch(msgType){
                //文本
            case "text":
                msg = WxMsgHandlerUtil.dealTextMessage(map);
                break;
                //图片
            case "image":
                break;
                //视频
            case "video":
                break;
                //语音
            case "voice":
                break;
                //音乐
            case "music":
                break;
                //图文
            case "news":
                break;
                //短视频
            case "shortvideo":
                break;
                //地理位置
            case "location":
                break;
                //链接
            case "link":
                break;
            default:
                break;
        }

        //把消息对象处理为xml
        System.out.println(msg);

        String accessToken = WxMsgHandlerUtil.expiredToken();
        System.out.println("accessToken:" + accessToken);

        return msg != null?WxMsgHandlerUtil.beanToXml(msg):null;
    }
}
