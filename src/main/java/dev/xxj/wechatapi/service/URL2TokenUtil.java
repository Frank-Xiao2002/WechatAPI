package dev.xxj.wechatapi.service;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

@Slf4j
@Deprecated
public class URL2TokenUtil {
    public static String getTemptURLToken(String strURL) {
        try {
            URL url = new URL(strURL);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            var bytes = new byte[1024];
            int len;
            StringBuilder stringBuilder = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                stringBuilder.append(new String(bytes, 0, len));
            }
            log.debug("inputStream : {}", stringBuilder.toString());
            String replaced = stringBuilder.toString().replace("}", ",");
            replaced += "\"createdTime\":" + System.currentTimeMillis() + "}";
            return replaced;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
