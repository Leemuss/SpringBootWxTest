package com.stu.blog.msgdomain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@XStreamAlias("xml")
public class NewsMessage extends BaseMessage {

    @XStreamAlias("ArticleCount")
    private String articleCount;
    @XStreamAlias("Articles")
    private List<Articles> articles = new ArrayList<>();



    public NewsMessage() {
    }

    public NewsMessage(Map<String, String> requestMap, String articleCount,List<Articles> articles) {
        super(requestMap);
        this.setMsgType("news");
        this.articles = articles;
        this.articleCount = articleCount;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    public String getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(String articleCount) {
        this.articleCount = articleCount;
    }
}
