package dev.xxj.wechatapi.controller;

import dev.xxj.wechatapi.service.TemptTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TemptTokenController {
    @RequestMapping(value = "/")
    public ResponseEntity<String> getAccessTemptToken() throws JSONException {
        String appId = "wxb6937d86c0864f71", appSecret = "c43e915dd78ef92958ccc6d8ffa3ecd1";
        String tokenInfo = new TemptTokenUtil().getTokenInfo(appId, appSecret);
        log.info("tempt access token = {}", tokenInfo);
        return ResponseEntity.ok(tokenInfo);
    }
}
