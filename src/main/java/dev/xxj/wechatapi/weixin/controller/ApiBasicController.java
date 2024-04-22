package dev.xxj.wechatapi.weixin.controller;

import dev.xxj.wechatapi.weixin.service.MessageService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


@RestController
@RequestMapping("/")
@Slf4j
public class ApiBasicController {
    /**
     * Constant string
     */
    private static final String TOKEN = "xxj";
    /**
     * MessageService bean to send the website URI to the user.
     */
    private final MessageService messageService;

    @Autowired
    public ApiBasicController(MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * Check the access from WeChat server.
     * <p>
     * When a backend server is connecting to an official Public Account, the WeChat server
     * needs to verify the server's identity. This is done by sending a GET request to the
     * backend server, and the backend server needs to respond with a string sent by the
     * WeChat platform server. Details of the verification process can be found at
     * <a href="https://developers.weixin.qq.com/doc/offiaccount/en/Getting_Started/Getting_Started_Guide.html">Official Development Document</a>.
     *
     * @param signature a parameter sent by WeChat server to verify the identity
     * @param timestamp timestamp of the request, also a parameter to help verify the identity
     * @param nonce     a random number to help verify the identity
     * @param echostr   the string that needs to be echoed back to the platform if the verification is successful
     * @return 'echostr' if the verification is successful, otherwise return null
     */
    @GetMapping("")
    public String accessCheck(@RequestParam(name = "signature") String signature,
                              @RequestParam(name = "timestamp") String timestamp,
                              @RequestParam(name = "nonce") String nonce,
                              @RequestParam(name = "echostr") String echostr) {
        log.info("signature: {}, timestamp: {}, nonce: {}, echostr: {}", signature, timestamp, nonce, echostr);
        String[] arr = new String[]{nonce, timestamp, TOKEN};
        Arrays.sort(arr);
        log.info("after sort, arr: {}", Arrays.toString(arr));
        String joined = String.join("", arr);
        log.info("joined: {}", joined);
        if (signature.equals(computeSHA1(joined))) {
            return echostr;
        } else return null;
    }

    /**
     * Deal with post request from WeChat server.
     * <p>
     * When a user sends a text message to an Official Account, a xml-formed request
     * is sent by the Official Accounts Platform and will be received at the developer backend.
     *
     * @param body body of the request from WeChat Platform server
     */
    @PostMapping("")
    public void answer(@RequestBody String body, HttpServletResponse response) {
        log.info("Received : \n" + "{}", body);
        System.out.println("-------------------");
        try {
            String responsexml = messageService.sendWebURI(body);
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(responsexml);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Compute SHA-1 hash of the given text.
     *
     * @param text input text
     * @return SHA-1 hash of the text
     */
    private String computeSHA1(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hash = md.digest(text.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
