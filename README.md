# 工程简介

此工程集成钉钉的告警机器人，覆盖常见告警消息：

- 文本消息
- 链接消息
- markdown
- action card
    - 独立 action card
    - 多跳转 action card
- feed card

并提供DUBBO服务接口

```
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
     * 发送feedCard类型消息
     *
     * @param alertEntity
     * @return
     */
    boolean sendDingTalkFeedCardMsg(DingFeedCardAlertEntity alertEntity);


}

```

## 后续可进行二次扩展

1. 钉钉告警消息对于过于频繁的投递会进行丢弃，所以需要保证不要发送过于频繁
2. 可以考虑内部对消息进行合并，避免消息过多。

