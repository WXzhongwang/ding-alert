package com.rany.ops.alert.api.model;

/**
 * @author zhongshengwang
 * @description TODO
 * @date 2021/10/1 8:33 上午
 * @email 18668485565@163.com
 */

public class FeedCardItem {

    private String title;

    private String messageURL;

    private String picURL;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessageURL() {
        return messageURL;
    }

    public void setMessageURL(String messageURL) {
        this.messageURL = messageURL;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }
}
