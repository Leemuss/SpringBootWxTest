package com.stu.blog.wxdomain;

public class AccessToken {

    private String accessToken;
    private Long expiresIn;

    public AccessToken() {
    }

    public AccessToken(String accessToken, String expires_in) {
        this.accessToken = accessToken;
        this.expiresIn = System.currentTimeMillis() + Integer.parseInt(expires_in) * 1000;
    }

    public boolean isExpired(){
        return System.currentTimeMillis() > this.expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "accessToken='" + accessToken + '\'' +
                ", expiresIn='" + expiresIn + '\'' +
                '}';
    }
}
