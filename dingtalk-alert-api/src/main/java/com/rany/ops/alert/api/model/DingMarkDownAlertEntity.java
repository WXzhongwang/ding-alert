package com.rany.ops.alert.api.model;

import com.rany.ops.alert.api.enums.DingTalkMsgTypeEnum;
import com.rany.ops.alert.api.utils.SignUtils;

import java.util.Set;

/**
 * @author zhongshengwang
 * @description markdown类型消息
 * @date 2021/9/24 10:31 下午
 * @email 18668485565@163.com
 */

public class DingMarkDownAlertEntity extends BaseDingAlertEntity {

    private String title;

    private String text;

    /**
     * at 用户手机号
     */
    private Set<String> mobiles;

    /**
     * 是否at所有用户
     */
    private Boolean isAtAll;

    public DingMarkDownAlertEntity(WebHookParam webHookParam, String title, String text) {
        this.msgType = DingTalkMsgTypeEnum.MARKDOWN;
        this.webHookUrl = SignUtils.getAlertUrl(webHookParam);
        this.title = title;
        this.text = text;
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

    public Set<String> getMobiles() {
        return mobiles;
    }

    public void setMobiles(Set<String> mobiles) {
        this.mobiles = mobiles;
    }

    public Boolean getAtAll() {
        return isAtAll;
    }

    public void setAtAll(Boolean atAll) {
        isAtAll = atAll;
    }
}
