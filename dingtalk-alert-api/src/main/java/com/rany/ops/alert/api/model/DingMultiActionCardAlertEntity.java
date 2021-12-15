package com.rany.ops.alert.api.model;

import com.rany.ops.alert.api.utils.SignUtils;

import java.util.List;

/**
 * @author zhongshengwang
 * @description actionCard类型消息
 * @date 2021/9/24 10:34 下午
 * @email 18668485565@163.com
 */

public class DingMultiActionCardAlertEntity extends BaseDingAlertEntity {

    /**
     * 首屏会话透出的展示内容
     */
    private String title;

    /**
     * markdown格式的消息
     */
    private String text;

    public List<ActionCardBtnItem> buttons;

    /**
     * 0-按钮竖直排列，1-按钮横向排列
     */
    private String btnOrientation;

    /**
     * 0-正常发消息者头像，1-隐藏发消息者头像
     */
    private String hideAvatar;

    public DingMultiActionCardAlertEntity(WebHookParam webHookParam) {
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

    public List<ActionCardBtnItem> getButtons() {
        return buttons;
    }

    public void setButtons(List<ActionCardBtnItem> buttons) {
        this.buttons = buttons;
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
