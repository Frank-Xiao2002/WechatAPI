package dev.xxj.wechatapi.weixin.entity;

public record AccessTokenDTO(
        String access_token,
        Integer expires_in
) {
}
