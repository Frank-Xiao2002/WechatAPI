package dev.xxj.wechatapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import static java.lang.System.currentTimeMillis;

@Slf4j
public class TemptTokenUtil {
    private static final String accessStr = "https://api.weixin.qq.com/cgi-bin/token?" +
            "grant_type=client_credential" +
            "&appid=APPID" +
            "&secret=APPSECRET";

    public String getTokenInfo(String appId, String appSecret) throws JSONException {
        String url = accessStr.replace("APPID", appId).replace("APPSECRET", appSecret);
        String cont = URL2TokenUtil.getTemptURLToken(url);
        log.debug("cont = " + cont);
        JSONObject jsonObject = new JSONObject(cont);
        String accessToken = jsonObject.getString("access_token");
        long createdTime = jsonObject.getLong("createdTime");
        if (currentTimeMillis() - createdTime > 7200 * 1000) {
            cont = URL2TokenUtil.getTemptURLToken(url);
        }
        return accessToken;
    }
}
