package dev.xxj.wechatapi;

import dev.xxj.wechatapi.web.data.Company;
import dev.xxj.wechatapi.web.repo.CompanyRepository;
import dev.xxj.wechatapi.weixin.entity.AccessToken;
import dev.xxj.wechatapi.weixin.entity.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WechatApiApplication {
    @Autowired
    private CompanyRepository repository;

    private static final Logger log = LoggerFactory.getLogger(WechatApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WechatApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ConfigurableApplicationContext context) {
        return args -> {
            log.info("access_token: {}", AccessToken.getAccessToken());
            log.info("app properties: {}", context.getBean(AppProperties.class));
            Company company = repository.save(Company.builder().name("Apple").address("USA").build());
            log.info("company: {}", company);
        };
    }
}
