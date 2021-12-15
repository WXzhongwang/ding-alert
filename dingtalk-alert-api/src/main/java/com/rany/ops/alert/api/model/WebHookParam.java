package com.rany.ops.alert.api.model;

/**
 * @author zhongshengwang
 * @description TODO
 * @date 2021/9/24 10:54 下午
 * @email 18668485565@163.com
 */

public class WebHookParam {

    private String webHookUrl;

    /**
     * 只有当加签useSign设置为true时候，secret才生效
     */
    private Boolean useSign;

    private String secret;

    public WebHookParam(String webHookUrl, Boolean useSign, String secret) {
        this.webHookUrl = webHookUrl;
        this.useSign = useSign;
        this.secret = secret;
    }

    public String getWebHookUrl() {
        return webHookUrl;
    }

    public void setWebHookUrl(String webHookUrl) {
        this.webHookUrl = webHookUrl;
    }

    public Boolean getUseSign() {
        return useSign;
    }

    public void setUseSign(Boolean useSign) {
        this.useSign = useSign;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    
}
