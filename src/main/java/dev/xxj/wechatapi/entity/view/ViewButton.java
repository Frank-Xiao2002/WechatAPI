package dev.xxj.wechatapi.entity.view;

import lombok.Data;

@Data
public class ViewButton extends Button {
    private String type;
    private String url;
}
