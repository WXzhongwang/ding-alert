package com.rany.ops.alert.api.utils;

import com.rany.ops.alert.api.model.WebHookParam;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author zhongshengwang
 * @description SignUtils
 * @date 2021/9/24 10:58 下午
 * @email 18668485565@163.com
 */
public class SignUtils {

    private final static Logger logger = LoggerFactory.getLogger(SignUtils.class);

    public static String getSign(long timestamp, String secret) {
        String stringToSign = timestamp + "\n" + secret;
        Mac mac = null;
        try {
            mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
            return URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException e) {
            logger.error("get sign error", e);
        }
        return "";
    }

    public static String getAlertUrl(WebHookParam webHookParam) {
        if (!webHookParam.getUseSign()) {
            return webHookParam.getWebHookUrl();
        }
        long timestamp = System.currentTimeMillis();
        String sign = getSign(timestamp, webHookParam.getSecret());
        return String.format("%s&timestamp=%s&sign=%s", webHookParam.getWebHookUrl(), timestamp, sign);
    }

    public static void main(String[] args) throws Exception {
        WebHookParam webHookParam = new WebHookParam("https://oapi.dingtalk.com/robot/send?access_token=b729a1e337c48afeef8f1f400aa75b08f8dc1f3366f0000223a6bef79a01532a",
                true, "SEC2ac0e12b0e49330361d9f80bd98cfed198d48897c8b7f00a2d35925161f3ef35");
        System.out.println(getAlertUrl(webHookParam));
    }
}
