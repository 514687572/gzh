package com.github.stip.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.stip.net.entity.DateList;
import com.github.stip.utils.Constantutils;
import com.github.stip.utils.TimeUtils;

@Service
public class PushService {
	public static String send_templatemsg_url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

	public static String industry_id1 = "1"; // 行业id
	public static String industry_id2 = "2";// 行业id

	private static String ACCESS_TOKEN;
	// public static long ACCESS_TOKEN_TIME=new Date().getTime()-1000;

	private static long ACCESS_TOKEN_TIME = 0;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private String TOKEN = "d3r34rt45t54AA";
	public static final String setURL = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry";

	public static final String GETURL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+ Constantutils.wx_appid + "&secret=" + Constantutils.wx_appsecret; // 获取access_token的
	public static final String sendUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send"; // 发送模版信息

	/**
	 * 
	 * @Description: 模版信息
	 * @param @param
	 *            toUser
	 * @param @return
	 * @throws @author
	 *             lvguangming
	 * @date 2017-4-12
	 */
	public String setSendTemplate(DateList dateList) {
		String accessToken = getAccesstoken();
		String postURL = sendUrl + "?access_token=" + accessToken;
		Map<String, Object> sendMap = new HashMap<String, Object>();
		Map<String, Object> dateMap = new HashMap<String, Object>(); // 模版
		Map<String, Object> firstMap = new HashMap<String, Object>();
		Map<String, Object> timeMap = new HashMap<String, Object>();
		Map<String, Object> nowMap = new HashMap<String, Object>();
		Map<String, Object> remarkMap = new HashMap<String, Object>();
		Map<String, Object> keyMap = new HashMap<String, Object>();

		firstMap.put("value","纪念日提醒你");
		firstMap.put("color", "#173177");
		dateMap.put("first", firstMap);
		dateMap.put("Topic", firstMap);

		nowMap.put("value", TimeUtils.dateToString(new Date(), "yyyy-MM-dd hh:mm:ss"));
		nowMap.put("color", "#173177");
		dateMap.put("Time", nowMap);
		
		timeMap.put("value", TimeUtils.dateToString(dateList.getDateTime(), "yyyy-MM-dd hh:mm:ss"));
		timeMap.put("color", "#173177");
		dateMap.put("keyword2", timeMap);

		keyMap.put("value", dateList.getDateTitle());
		keyMap.put("color", "#173177");
		dateMap.put("keyword1", keyMap);

		int dates = TimeUtils.nDaysBetweenTwoDate(new Date(), dateList.getDateTime());
		String tempStr = "";

		if (dates < 0) {
			dates = dates * -1;
			tempStr = "已经" + dates + "天";
		} else if (dates == 0) {
			tempStr = "就是今天";
		} else {
			tempStr = "还有" + dates + "天";
		}

		remarkMap.put("value", tempStr);
		remarkMap.put("color", "#173177");
		dateMap.put("remark", remarkMap);

		sendMap.put("touser", dateList.getOpenId());
		sendMap.put("template_id",Constantutils.temp_id);
		sendMap.put("url", "http://weixinmap.com/getDetailByDateId?dateId="+dateList.getDateId()+"&openId="+dateList.getOpenId());
		sendMap.put("data", dateMap);

		JSON json = (JSON) JSONObject.toJSON(sendMap);
		String h = json.toString();
		 System.out.println("json:"+h);
		String ret = sendPost(postURL, h);
		 System.out.println(ret);
		return ret;
	}

	/**
	 * 
	 * @Description: 获取access_token并解析
	 * @param return
	 *            返回access_token值
	 * @throws @author
	 *             lvguangming
	 * @date 2017-3-29
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String getAccesstoken() {
		if (ACCESS_TOKEN_TIME != 0) { // 判断上次获取的ACCESS_TOKEN时间是否超过6000秒，若未超过直接使用上次获取的参数
			long time = (long) (new Date().getTime() - ACCESS_TOKEN_TIME) / 1000;
			if (time < 6000L) {
				return ACCESS_TOKEN;
			}
		}
		String openjosn = getOpenJosn();
		// System.out.println("getaccess_token:"+openjosn);
		JSONObject jsonObject;
		String accessToken = "";
		try {
			jsonObject = JSONObject.parseObject(openjosn);
			Map result = new HashMap();
			Iterator iterator = jsonObject.keySet().iterator();
			String key = null;
			String value = null;
			while (iterator.hasNext()) {
				key = (String) iterator.next();
				value = jsonObject.getString(key);
				result.put(key, value);
			}

			if (null != result.get("access_token")) {
				accessToken = result.get("access_token").toString();
				ACCESS_TOKEN_TIME = new Date().getTime();
				ACCESS_TOKEN = accessToken;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accessToken;
	}

	/**
	 * 
	 * @Description:设置行业信息
	 * @param @param
	 *            url
	 * @param @param
	 *            industry
	 * @param @return
	 * @throws @author
	 *             lvguangming
	 * @date 2017-3-29
	 */
	public static String setIndustry() {
		String accessToken = getAccesstoken();
		String postURL = setURL + "?access_token=" + accessToken;
		Map<String, Object> sendMap = new HashMap<String, Object>();
		sendMap.put("industry_id1", industry_id1);
		sendMap.put("industry_id2", industry_id2);
		JSON json = (JSON) JSONObject.toJSON(sendMap);
		String h = json.toString();
		System.out.println("json:" + h);
		String ret = sendPost(postURL, h);
		System.out.println(ret);
		return ret;
	}

	public static void main(String[] args) {
		PushService.setIndustry();
	}


	/**
	 * 
	 * @Description: 发送信息
	 * @param @param
	 *            args
	 * @throws @author
	 *             lvguangming
	 * @date 2017-3-29
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
		    conn.setRequestProperty("contentType", "UTF-8");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			OutputStream outputStream = conn.getOutputStream();
			// 注意编码格式，防止中文乱码
			outputStream.write(param.getBytes("UTF-8"));
			outputStream.close();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 
	 * @Description: 获取access_token
	 * @param @param
	 *            args
	 * @throws @author
	 *             lvguangming
	 * @date 2017-3-29
	 */
	private static String getOpenJosn() {
		String result = "";
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(GETURL);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
