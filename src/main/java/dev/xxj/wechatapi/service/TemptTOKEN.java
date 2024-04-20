package dev.xxj.wechatapi.service;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TemptTOKEN {
    private String access_token;
    private static final String expiresIn = "7200";
    private Long createTime;

    public TemptTOKEN(String access_token, Long createTime) {
        this.access_token = access_token;
        this.createTime = createTime;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() - createTime > 7200 * 1000;
    }
}
