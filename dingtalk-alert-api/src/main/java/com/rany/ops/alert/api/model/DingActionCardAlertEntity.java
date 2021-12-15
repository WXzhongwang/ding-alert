package com.rany.ops.alert.api.model;

import com.rany.ops.alert.api.enums.DingTalkMsgTypeEnum;
import com.rany.ops.alert.api.utils.SignUtils;

/**
 * @author zhongshengwang
 * @description actionCard类型消息
 * @date 2021/9/24 10:34 下午
 * @email 18668485565@163.com
 */

public class DingActionCardAlertEntity extends BaseDingAlertEntity {

    /**
     * 首屏会话透出的展示内容
     */
    private String title;

    /**
     * markdown格式的消息
     */
    private String text;

    /**
     * 单个按钮的方案。(设置此项和singleURL后btns无效)
     */
    private String singleTitle;

    /**
     * 点击singleTitle按钮触发的URL
     */
    private String singleURL;

    /**
     * 0-按钮竖直排列，1-按钮横向排列
     */
    private String btnOrientation;

    /**
     * 0-正常发消息者头像，1-隐藏发消息者头像
     */
    private String hideAvatar;

    public DingActionCardAlertEntity(WebHookParam webHookParam) {
        this.webHookUrl = SignUtils.getAlertUrl(webHookParam);
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

    public String getSingleTitle() {
        return singleTitle;
    }

    public void setSingleTitle(String singleTitle) {
        this.singleTitle = singleTitle;
        this.msgType = DingTalkMsgTypeEnum.ACTION_CARD;
    }

    public String getSingleURL() {
        return singleURL;
    }

    public void setSingleURL(String singleURL) {
        this.singleURL = singleURL;
    }

    public String getBtnOrientation() {
        return btnOrientation;
    }

    public void setBtnOrientation(String btnOrientation) {
        this.btnOrientation = btnOrientation;
    }

    public String getHideAvatar() {
        return hideAvatar;
    }

    public void setHideAvatar(String hideAvatar) {
        this.hideAvatar = hideAvatar;
    }
}
