package dev.xxj.wechatapi.entity.view;

import lombok.Data;

@Data
public class ClickButton extends Button {
    private String type;
    private String key;
}
