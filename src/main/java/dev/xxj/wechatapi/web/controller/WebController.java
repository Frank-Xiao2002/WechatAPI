package dev.xxj.wechatapi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for web pages.
 *
 * @author Frank-Xiao2002
 */
@Controller
@RequestMapping("/web")
public class WebController {
    @RequestMapping("/")
    public String frontPage() {
        return "index";
    }
}
