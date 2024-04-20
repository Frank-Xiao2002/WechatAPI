package dev.xxj.wechatapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class TemptTokenUtil {
    private static final String accessStr = "https://api.weixin.qq.com/cgi-bin/token?" + "grant_type" +
            "=client_credential" + "&appid=APPID" + "&secret=APPSECRET";

    private final RestTemplate restTemplate = new RestTemplate();

    public String getTokenInfo(String appId, String appSecret) {
        String uri = accessStr.replace("APPID", appId).replace("APPSECRET", appSecret);
        log.debug("uri = {}", uri);
        TemptTOKEN temptTOKEN;
        temptTOKEN = restTemplate.getForObject(uri, TemptTOKEN.class);
        assert temptTOKEN != null;
        temptTOKEN.setCreateTime(System.currentTimeMillis());
        log.debug("temptTOKEN = {}", temptTOKEN);
        return temptTOKEN.getAccess_token();
    }
}
