package dev.xxj.wechatapi;

import dev.xxj.wechatapi.entity.AccessToken;
import dev.xxj.wechatapi.entity.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WechatApiApplication {

    private static final Logger log = LoggerFactory.getLogger(WechatApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WechatApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ConfigurableApplicationContext context) {
        return args -> {
            log.info("access_token: {}", AccessToken.getAccessToken());
            log.info("app properties: {}", context.getBean(AppProperties.class));
        };
    }
}
