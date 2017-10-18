package com.github.binarywang.demo.spring.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.github.binarywang.demo.spring.builder.TextBuilder;
import com.github.binarywang.demo.spring.dto.Message;
import com.github.binarywang.demo.spring.dto.WxMenuKey;
import com.github.binarywang.demo.spring.service.WeixinService;
import com.github.stip.utils.Constantutils;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * 
 * @author Binary Wang
 *
 */
@Component
public class MsgHandler extends AbstractHandler {

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,Map<String, Object> context, WxMpService wxMpService,WxSessionManager sessionManager)    {
        WeixinService weixinService = (WeixinService) wxMpService;

        if (!wxMessage.getMsgType().equals(WxConsts.XML_MSG_EVENT)) {
            //TODO 可以选择将消息保存到本地
        }

        String content = "";
        
        //当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
        if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")&& weixinService.hasKefuOnline()) {
            return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE().fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser()).build();
        }else if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")) {
        	content = "你好，欢迎来到纪念日助手";
        }else if (StringUtils.startsWithAny(wxMessage.getContent(), "纪念日")) {
        	content = "你的纪念日";
        }else if (StringUtils.contains(wxMessage.getContent(), "时光机")) {
        	content = "你的时光机器";
        }else {
        	try {
				content =MsgHandler.getMessage(wxMessage.getContent());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
        }

        return new TextBuilder().build(content, wxMessage, weixinService);

    }
    
    public static String getMessage(String inMessage) throws Exception, IOException {
         String INFO = URLEncoder.encode(inMessage, "utf-8"); 
         String getURL = "http://www.tuling123.com/openapi/api?key=" + Constantutils.APIKEY + "&info=" + INFO; 
         URL getUrl = new URL(getURL); 
         HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection(); 
         connection.connect(); 

         // 取得输入流，并使用Reader读取 
         BufferedReader reader = new BufferedReader(new InputStreamReader( connection.getInputStream(), "utf-8")); 
         StringBuffer sb = new StringBuffer(); 
         String line = ""; 
         while ((line = reader.readLine()) != null) { 
             sb.append(line); 
         } 
         reader.close(); 
         // 断开连接 
         connection.disconnect(); 
         
         Message message=JSON.parseObject(sb.toString(), Message.class);
         
         return message.text;
    }

}
