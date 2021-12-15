package com.rany.ops.alert.api.model;

import com.rany.ops.alert.api.enums.DingTalkMsgTypeEnum;
import com.rany.ops.alert.api.enums.Level;
import com.rany.ops.alert.api.utils.SignUtils;

import java.util.Set;

/**
 * @author zhongshengwang
 * @description 文本类型告警
 * @date 2021/9/24 10:16 下午
 * @email 18668485565@163.com
 */

public class DingTextAlertEntity extends BaseDingAlertEntity {

    protected Level level;
    /**
     * 告警内容
     */
    private String content;

    /**
     * at 用户手机号
     */
    private Set<String> mobiles;

    /**
     * 是否at所有用户
     */
    private Boolean isAtAll;

    public DingTextAlertEntity(WebHookParam webHookParam, String content, Level level) {
        this.msgType = DingTalkMsgTypeEnum.TEXT;
        this.level = level;
        this.content = content;
        this.webHookUrl = SignUtils.getAlertUrl(webHookParam);
    }

    public DingTextAlertEntity(WebHookParam webHookParam, String content, Level level, Set<String> mobiles, Boolean isAtAll) {
        this.msgType = DingTalkMsgTypeEnum.TEXT;
        this.webHookUrl = SignUtils.getAlertUrl(webHookParam);
        this.level = level;
        this.content = content;
        this.mobiles = mobiles;
        this.isAtAll = isAtAll;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
