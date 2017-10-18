package com.github.stip.utils;

public class Constantutils {
	public static String wx_appid = "";
	public static String wx_appsecret = "";
	public static String wx_token = "";
	public static String wx_aeskey = "";
	public static String APIKEY = "";
	
	public static String url="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+wx_appid+"&redirect_uri=http%3A%2F%2Fweixinmap.com%2Fwechat%2Fportal%2Fauth&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
	public static String add_url="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+wx_appid+"&redirect_uri=http%3A%2F%2Fweixinmap.com%2Fwechat%2Fportal%2Fauth&response_type=code&scope=snsapi_userinfo&state=addDate#wechat_redirect";

	public static String ADD_DATE="addDate";
	public static String STATE="STATE";
	public static String gh_id="gh_8d883a26372c";
	public static String temp_id="b0qafm7fzv8r62KLtRSWbpoPpTEtBv2-7CV8s7fuaqM";
}
