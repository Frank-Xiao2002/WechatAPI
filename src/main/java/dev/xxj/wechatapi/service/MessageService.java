package dev.xxj.wechatapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

@Slf4j
@Service
public class MessageService {

    private final String responseBody =
            """
                    <xml>
                    <ToUserName><![CDATA[TOUSERNAME]]></ToUserName>
                    <FromUserName><![CDATA[FROMUSERNAME]]></FromUserName>
                    <CreateTime>CREATETIME</CreateTime>
                    <MsgType><![CDATA[text]]></MsgType>
                    <Content><![CDATA[CONTENT]]></Content>
                    </xml>""";

    public String sendWebURI(String requestBody) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        InputSource inputSource = new InputSource(new StringReader(requestBody));
        Document doc = factory.newDocumentBuilder().parse(inputSource);
        String ToUserName = doc.getElementsByTagName("ToUserName").item(0).getTextContent();
        String FromUserName = doc.getElementsByTagName("FromUserName").item(0).getTextContent();
        String content = """
                您好，欢迎关注xxj的公众号！
                求职相关信息请访问网页：http://120.46.182.90/wechatapi/web/
                感谢您对本公众号的支持！""";
        String result = responseBody.replace("TOUSERNAME", FromUserName)
                .replace("FROMUSERNAME", ToUserName)
                .replace("CREATETIME", String.valueOf(System.currentTimeMillis()))
                .replace("CONTENT", content);
        log.debug("response: \n{}", result);
        return result;
    }
}
