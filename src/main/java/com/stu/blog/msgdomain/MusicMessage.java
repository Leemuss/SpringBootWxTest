package com.stu.blog.msgdomain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

@XStreamAlias("xml")
public class MusicMessage extends BaseMessage {

    private Music music;


    public MusicMessage() {
    }

    public MusicMessage(Map<String, String> requestMap, String medialId) {
        super(requestMap);
        this.setMsgType("music");
        this.music = music;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}
