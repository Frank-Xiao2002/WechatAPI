package dev.xxj.wechatapi.entity;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * A class representing application's several vital properties, including
 * development id and secret, as well as access token to send requests to
 * WeChat server.
 * <p>
 * This class is registered as a Spring Bean in the application context.
 * Its fields are injected through application.properties file to increase
 * program flexibility.
 *
 * @author Frank-Xiao2002
 */
@Getter
@Component
@ToString(of = {"id", "secret"})
public class AppProperties {
    /**
     * App's development id
     */
    @Value("${dev.id}")
    private String id;

    /**
     * App's development secret
     */
    @Value("${dev.secret}")
    private String secret;

}
