package dev.xxj.wechatapi.weixin.entity;

import dev.xxj.wechatapi.weixin.service.AccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class that represents the access token of the application
 * and its related properties including creation time and expiration time.
 *
 * @author Frank-Xiao2002
 */
@Component
public class AccessToken {
    /**
     * the application's access token
     */
    private static String accessToken;
    /**
     * each access token expires in 7200 seconds
     */
    private static final int EXPIRATION_TIME = 7200;

    /**
     * latest update time of the access token
     */
    private static Long updateTime = 0L;

    private static AppProperties appProperties;

    @Autowired
    public AccessToken(AppProperties appProperties) {
        AccessToken.appProperties = appProperties;
    }

    /**
     * Determine whether the access token is expired.
     *
     * @return true if the access token is expired, false otherwise
     */
    public static boolean isTokenExpired() {
        return System.currentTimeMillis() - updateTime > EXPIRATION_TIME * 1000;
    }

    /**
     * Update access token when the token is expired.
     * <p>
     * It uses AccessTokenUtil.getToken() to get a new access token, and
     * update the creation time.
     * <p>
     * This is a private static method to protect from outside invocation.
     *
     * @return the new access token
     */
    private static String updateToken() {
        updateTime = System.currentTimeMillis();
        accessToken = AccessTokenService.getToken(appProperties.getId(), appProperties.getSecret())
                .access_token();
        return accessToken;
    }

    /**
     * Get the access token.
     * <p>
     * If the access token is expired, it will update the token and return the new one.
     * Otherwise, it will return the access token directly.
     *
     * @return the available access token
     */
    public static String getAccessToken() {
        if (isTokenExpired())
            return updateToken();
        return accessToken;
    }
}
