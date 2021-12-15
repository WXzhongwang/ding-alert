package com.rany.ops.alert.api.model;

import com.rany.ops.alert.api.enums.DingTalkMsgTypeEnum;
import com.rany.ops.alert.api.utils.SignUtils;

/**
 * @author zhongshengwang
 * @description 连接类型消息
 * @date 2021/9/24 10:26 下午
 * @email 18668485565@163.com
 */

public class DingLinkAlertEntity extends BaseDingAlertEntity {

    private String title;

    private String text;

    private String msgUrl;

    private String picUrl;

    public DingLinkAlertEntity(WebHookParam webHookParam, String title, String text, String msgUrl) {
        this.msgType = DingTalkMsgTypeEnum.LINK;
        this.webHookUrl = SignUtils.getAlertUrl(webHookParam);
        this.title = title;
        this.text = text;
        this.msgUrl = msgUrl;
    }

    public DingLinkAlertEntity(WebHookParam webHookParam, String title, String text, String msgUrl, String picUrl) {
        this.msgType = DingTalkMsgTypeEnum.LINK;
        this.webHookUrl = SignUtils.getAlertUrl(webHookParam);
        this.title = title;
        this.text = text;
        this.msgUrl = msgUrl;
        this.picUrl = picUrl;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMsgUrl() {
        return msgUrl;
    }

    public void setMsgUrl(String msgUrl) {
        this.msgUrl = msgUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
