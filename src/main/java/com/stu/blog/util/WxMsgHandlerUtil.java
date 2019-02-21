package com.stu.blog.util;

import com.alibaba.fastjson.JSONObject;
import com.stu.blog.wxdomain.*;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class WxMsgHandlerUtil {

    private static Logger logger = LoggerFactory.getLogger(WxMsgHandlerUtil.class);
    private static final String token = "index";


    private static final String GET_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    private static final String APPID = "wxeeacd25f725c3c06";
    private static final String APPSECRET = "0d8e89066b62ef1b82993a7765db92b8";

    private static AccessToken accessToken;

    /**
     * 1）将token、timestamp、nonce三个参数进行字典序排序
     * 2）将三个参数字符串拼接成一个字符串进行sha1加密
     * 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean isCheck(String signature,String timestamp,String nonce){
        String [] strs = new String[]{token,timestamp,nonce};
        Arrays.sort(strs);
        String newStr = strs[0] + strs[1] + strs[2];
        String sign = sha1(newStr);
        System.out.println(sign);
        System.out.println(signature);
        if (sign.equals(signature))
            return true;
        else
            return false;
    }

    /**
     * sha1加密
     * @param newStr
     * @return
     */
    private static String sha1(String newStr) {
        logger.info("开始接入验证");
        try {
            //获取解密对象
            MessageDigest md = MessageDigest.getInstance("sha1");
            byte[] digest = md.digest(newStr.getBytes());
            char chars[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
            StringBuilder sb = new StringBuilder();
            //处理加密结果
            for (byte b : digest) {
                sb.append(chars[(b>>4)&15]);
                sb.append(chars[b&15]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String,String> parseRequest(HttpServletResponse response, HttpServletRequest request) {
        logger.info("开始处理微信消息");
        Map<String,String> map = new HashMap<>();
        SAXReader saxReader = new SAXReader();
        try {
            //读取输入流，获取文档对象
            InputStream inputStream = request.getInputStream();
            Document document = saxReader.read(inputStream);
            //根据文档对象获取根节点
            Element rootElement = document.getRootElement();
            //获取根节点的所有子节点
            List<Element> elements = rootElement.elements();
            for (Element element : elements) {
                map.put(element.getName(),element.getStringValue());
            }
            inputStream.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;

    }

    public static BaseMessage dealTextMessage(Map<String, String> map) {
        //用户发来的消息
        String content = map.get("Content");
        //String msg = chatWithRobort(content);
        List<Articles> articles = null;
        if("1".equals(content)){
            articles = new ArrayList<>();
            String picUrl = "http://mmbiz.qpic.cn/mmbiz_jpg/V6sQHCpiblmCTG1LiaFuSgCJ3wicxTs1s2tBoveCvicZQ6LjGniajyCB6ItPxkjXgS3UopwnHGFvyj25RziacknAytrA/";
            //String picUrl = "http://mmbiz.qpic.cn/mmbiz_jpg/V6sQHCpiblmCTG1LiaFuSgCJ3wicxTs1s2tU8UrkBiaFj1no4IibW7HrbTDScX1jewsgO7fCunFxEoBecCS048LLKMA/";
            articles.add(new Articles("哪有那么多惊喜，惊吓就有！","赶紧点进去看看吧！记得收藏", picUrl, "https://www.leemus.cn"));
            NewsMessage news = new NewsMessage(map,"1",articles);
            System.out.println("news:" + news);
            return news;
        }else {
            TextMessage tm = new TextMessage(map,"回复1有惊喜哦！");
            System.out.println("text:" +tm);
            return tm;
        }


    }

    public static BaseMessage dealEvent(Map<String, String> map) {
        String content = map.get("Event");

        return null;
    }

    private static String chatWithRobort(String content) {
        return null;
    }

    /**
     * bean处理成xml
     * @param msg
     * @return
     */
    public static String beanToXml(BaseMessage msg) {
        XStream stream = new XStream();
        stream.processAnnotations(TextMessage.class);
        stream.processAnnotations(ImageMessage.class);
        stream.processAnnotations(VideoMessage.class);
        stream.processAnnotations(VoiceMessage.class);
        stream.processAnnotations(MusicMessage.class);
        stream.processAnnotations(NewsMessage.class);
        String s = stream.toXML(msg);
        return s;
    }

    /**
     * 解析tonken
     */
    public static void getToken(){
        String url = GET_TOKEN_URL.replace("APPID",APPID).replace("APPSECRET",APPSECRET);
        String tokenStr = WxMsgUtil.getToken(url);
        System.out.println("tokenStr:" + tokenStr);
        //String tokenStr = "{\"access_token\":\"18_INjiAmG2E7flEbPlFiHlzfkEppq5YERSjXRsWqgknkvKK_KBTMNbwxqFAU7e0EOS9hHCFXBKa0MqRBIjyT8B7W5onN0uym269-A15G-wwAT4aeRBoBZAkeJia-_nBn2Fl3A5U-3q5Yo-7rVBSNTcAEADYE\",\"expires_in\":7200}";
        accessToken = JSONObject.parseObject(tokenStr, AccessToken.class);
        //String access_token = jsonObject.getString("access_token");
        //String expires_in = jsonObject.getString("expires_in");

        //WxMsgHandlerUtil.accessToken = new AccessToken(access_token,expires_in);
        //System.out.println(accessToken);
    }

    /**
     * 向外暴露AccessToken
     * @return
     */
    public static String expiredToken(){
        if (accessToken == null || accessToken.isExpired()){
            getToken();
        }
        return accessToken.getAccessToken();
    }


}
