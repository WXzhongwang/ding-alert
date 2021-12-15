package com.rany.ops.alert.api;

import com.rany.ops.alert.api.model.DingActionCardAlertEntity;
import com.rany.ops.alert.api.model.DingFeedCardAlertEntity;
import com.rany.ops.alert.api.model.DingLinkAlertEntity;
import com.rany.ops.alert.api.model.DingMarkDownAlertEntity;
import com.rany.ops.alert.api.model.DingMultiActionCardAlertEntity;
import com.rany.ops.alert.api.model.DingTextAlertEntity;

/**
 * @author zhongshengwang
 * @description 钉钉群聊消息接口
 * @date 2021/9/24 10:11 下午
 * @email 18668485565@163.com
 */
public interface DingAlertService {


    /**
     * 发送DingTalk文本消息
     *
     * @param alertEntity
     * @return
     */
    boolean sendDingTalkTextMsg(DingTextAlertEntity alertEntity);


    /**
     * 发送链接类型消息
     *
     * @param alertEntity
     * @return
     */
    boolean sendDingTalkLinkMsg(DingLinkAlertEntity alertEntity);

    /**
     * 发送markdown类型消息
     *
     * @param alertEntity
     * @return
     */
    boolean sendDingTalkMarkDownMsg(DingMarkDownAlertEntity alertEntity);


    /**
     * 发送整体跳转 actionCard 类型消息
     *
     * @param alertEntity
     * @return
     */
    boolean sendDingTalkActionCardMsg(DingActionCardAlertEntity alertEntity);

    /**
     * 发送独立跳转 actionCard 类型消息
     *
     * @param alertEntity
     * @return
     */
    boolean sendDingTalkMultiActionCardMsg(DingMultiActionCardAlertEntity alertEntity);

    /**
     * 发送独立跳转 actionCard 类型消息
     *
     * @param alertEntity
     * @return
     */
    boolean sendDingTalkFeedCardMsg(DingFeedCardAlertEntity alertEntity);


}
