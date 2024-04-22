package dev.xxj.wechatapi.weixin.entity.view;

import lombok.Data;

@Data
public class ViewButton extends Button {
    private String type;
    private String url;
}
