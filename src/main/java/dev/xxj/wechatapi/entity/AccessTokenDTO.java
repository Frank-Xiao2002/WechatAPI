package dev.xxj.wechatapi.entity;

public record AccessTokenDTO(
        String access_token,
        Integer expires_in
) {
}
