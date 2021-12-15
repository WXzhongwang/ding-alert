package com.rany.ops.alert.api.model;

import com.rany.ops.alert.api.enums.DingTalkMsgTypeEnum;

import java.io.Serializable;

/**
 * @author zhongshengwang
 * @description 告警实体
 * @date 2021/9/24 10:12 下午
 * @email 18668485565@163.com
 */
public abstract class BaseDingAlertEntity implements Serializable {

    protected String webHookUrl;

    protected DingTalkMsgTypeEnum msgType;

    public String getWebHookUrl() {
        return webHookUrl;
    }
}
