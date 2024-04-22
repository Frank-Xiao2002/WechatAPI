package dev.xxj.wechatapi.weixin.entity.view;

import lombok.Data;

@Data
public class ClickButton extends Button {
    private String type;
    private String key;
}
