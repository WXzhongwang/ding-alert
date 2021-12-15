package com.rany.ops.manager;

import com.alibaba.fastjson.JSONObject;
import com.rany.ops.manager.model.DingMsgRequest;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * DingTalkAlertManager
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2021/9/24 10:00 下午
 * @email 18668485565@163.com
 */
public class DingTalkAlertManager {

    private final static Logger logger = LoggerFactory.getLogger(DingTalkAlertManager.class);

    private static final int CPU_NUM = Runtime.getRuntime().availableProcessors();

    private static final AtomicInteger INCREMENT = new AtomicInteger();

    private static final BlockingQueue<DingMsgRequest> QUEUE = new ArrayBlockingQueue(200);

    private static volatile ThreadPoolExecutor EXECUTOR = null;

    private static ThreadPoolExecutor getThreadPool() {
        if (EXECUTOR == null) {
            synchronized (DingTalkAlertManager.class) {
                if (EXECUTOR == null) {
                    int coreNum = CPU_NUM <= 0 ? 8 : CPU_NUM;
                    EXECUTOR = new ThreadPoolExecutor(coreNum, coreNum, 2000L, TimeUnit.MILLISECONDS,
                            new LinkedBlockingQueue<>(5000), r -> new Thread(Thread.currentThread().getThreadGroup(), r,
                            "Alert-ThreadPool-" + INCREMENT.getAndIncrement()), new ThreadPoolExecutor.CallerRunsPolicy());
                }
            }
        }
        return EXECUTOR;
    }

    public static boolean asyncAlert(String webHookUrl, JSONObject alertEntity) {
        if (StringUtils.isNotEmpty(webHookUrl) && Objects.nonNull(alertEntity)) {
            DingMsgRequest request = new DingMsgRequest(webHookUrl, alertEntity);
            if (!QUEUE.offer(request)) {
                logger.warn("alert queue is full, ignore it");
                return false;
            }
        } else {
            logger.warn("alert entity is null or url is empty, ignore it");
            return false;
        }
        return true;
    }

    /**
     * 立即发送
     *
     * @param webHookUrl
     * @param alertEntity
     * @return
     */
    public static boolean alert(String webHookUrl, JSONObject alertEntity) {
        if (StringUtils.isEmpty(webHookUrl) || Objects.isNull(alertEntity)) {
            logger.warn("alert entity is null or url is empty, ignore it");
            return false;
        }
        DingMsgRequest request = new DingMsgRequest(webHookUrl, alertEntity);
        return DingUtils.send(request);
    }

    private static List<DingMsgRequest> getAlertEntitiesFromQueue() {
        List<DingMsgRequest> alertEntities = new ArrayList<>();
        do {
            DingMsgRequest alertEntity = null;
            try {
                alertEntity = QUEUE.poll(3L, TimeUnit.SECONDS);
            } catch (InterruptedException ex) {
                logger.warn(ex.getMessage(), ex);
                break;
            }
            if (alertEntity == null) {
                break;
            }
            alertEntities.add(alertEntity);
        } while (alertEntities.size() < 200);
        return alertEntities;
    }

    public static class AlertWorker implements Runnable {

        public AlertWorker(String url, List<DingMsgRequest> messages) {
            this.url = url;
            this.messages = messages;
        }

        private String url;

        private List<DingMsgRequest> messages;

        @Override
        public void run() {

        }
    }

}
