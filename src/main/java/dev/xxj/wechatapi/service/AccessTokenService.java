package dev.xxj.wechatapi.service;

import dev.xxj.wechatapi.entity.AccessTokenDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Service class to retrieve access token from WeChat server. The class replaces the APPID & APPSECRET
 * with the actual appId and appSecret, and use {@link  org.springframework.web.client.RestTemplate} to
 * send the request.
 * <p>
 * It is typically used in the AppProperties class to retrieve the
 * access token.
 *
 * @author Frank-Xiao2002
 * @see dev.xxj.wechatapi.entity.AppProperties
 */
@Slf4j
@Service
public class AccessTokenService {
    /**
     * Static string template to retrieve access token from WeChat server.
     */
    private static final String accessStr = "https://api.weixin.qq.com/cgi-bin/token?" + "grant_type" +
            "=client_credential" + "&appid=APPID" + "&secret=APPSECRET";

    /**
     * restTemplate to send the request.
     */
    private static final RestTemplate restTemplate = new RestTemplate();

    /**
     * Get access token from WeChat server. It uses {@link RestTemplate#getForObject(URI, Class)}
     * to retrieve the access token and save it in {@link AccessTokenDTO}.
     *
     * @param appId     development id
     * @param appSecret development secret
     * @return AccessTokenDTO object to store response
     * @see RestTemplate
     * @see AccessTokenDTO
     */
    public static AccessTokenDTO getToken(String appId, String appSecret) {
        String uri = accessStr.replace("APPID", appId).replace("APPSECRET", appSecret);
        log.debug("uri = {}", uri);
        return restTemplate.getForObject(uri, AccessTokenDTO.class);
    }
}
