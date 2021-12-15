package com.rany.ops.alert.api.model;

import com.rany.ops.alert.api.enums.DingTalkMsgTypeEnum;
import com.rany.ops.alert.api.utils.SignUtils;

import java.util.List;

/**
 * @author zhongshengwang
 * @description TODO
 * @date 2021/9/24 10:44 下午
 * @email 18668485565@163.com
 */

public class DingFeedCardAlertEntity extends BaseDingAlertEntity {

    private List<FeedCardItem> feeds;

    public DingFeedCardAlertEntity(WebHookParam webHookParam, List<FeedCardItem> feeds) {
        this.webHookUrl = SignUtils.getAlertUrl(webHookParam);
        this.msgType = DingTalkMsgTypeEnum.FEED_CARD;
        this.feeds = feeds;
    }

    public List<FeedCardItem> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<FeedCardItem> feeds) {
        this.feeds = feeds;
    }
}
