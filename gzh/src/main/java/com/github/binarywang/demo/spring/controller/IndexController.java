package com.github.binarywang.demo.spring.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.stip.net.entity.DateList;
import com.github.stip.net.entity.Muser;
import com.github.stip.service.HelperService;
import com.github.stip.utils.GrnerateUUID;
import com.github.stip.utils.TimeUtils;

import me.chanjar.weixin.common.util.crypto.SHA1;

/**
 * 微信小程序用户接口
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@RestController
@RequestMapping("/")
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private String TOKEN = "d3r34rt45t54AA";
    @Autowired
    private HelperService helperService;

    /**
     * <pre>
     * 获取用户信息接口
     * </pre>
     */
    @RequestMapping(name="/index")
    public ModelAndView index() {
		return new ModelAndView("index");
    }
    
    /**
     * <pre>
     * 获取用户信息接口
     * </pre>
     * @throws IOException 
     */
    @RequestMapping("/check")
    public void check( HttpServletRequest request,HttpServletResponse response) throws IOException {
    	 String signature = request.getParameter("signature");
         // 随机字符串
         String echostr = request.getParameter("echostr");
         // 时间戳
         String timestamp = request.getParameter("timestamp");
         // 随机数
         String nonce = request.getParameter("nonce");

         String[] str = { TOKEN, timestamp, nonce };
         Arrays.sort(str); // 字典序排序
         String bigStr = str[0] + str[1] + str[2];
         // SHA1加密
         SHA1 sha1= new SHA1();
         String digest =sha1.gen(str);

         // 确认请求来至微信
         if (digest.equals(signature)) {
             response.getWriter().print(echostr);
         }
    }
    
    /**
     * <pre>
     * 保存用户纪念日
     * </pre>
     * @throws IOException 
     */
    @RequestMapping("/saveDate")
    public Map<String,Object> saveDate( HttpServletRequest request,HttpServletResponse response) throws IOException {
    	Map<String,Object> result=new HashMap<String,Object>();
    	
    	if(null!=request.getSession().getAttribute("openid")) {
    		String openid = request.getSession().getAttribute("openid").toString();
    		String typerepeat = request.getParameter("typerepeat").toString();
    		String typeremind = request.getParameter("typeremind").toString();
    		String isGC = request.getParameter("isGC").toString();
    		String isAttention = request.getParameter("isAttention").toString();
    		String thingname = request.getParameter("thingname").toString();
    		String datetime = request.getParameter("datetime").toString();
    		Muser user=(Muser) request.getSession().getAttribute("user");
    		
    		DateList dateList=new DateList();
    		
    		dateList.setRepetRemind(typeremind);
    		dateList.setDateTitle(thingname);
    		dateList.setAttentionDate(isAttention);
    		dateList.setCreateTime(new Date());
    		dateList.setDateTime(TimeUtils.stringToDate(datetime, "yyyy-MM-dd hh:mm"));
    		dateList.setGc(isGC.equals("1"));
    		dateList.setRemindType(typerepeat);
    		dateList.setOpenId(openid);
    		dateList.setUserId(user.getId());
    		dateList.setDateId(GrnerateUUID.getUUID());
    		
    		helperService.insertDate(dateList);
    		result.put("success", Boolean.TRUE);
    	}else {
    		result.put("success", Boolean.FALSE);
    	}
    	 
		return result;
    }
    
    
    /**
     * <pre>
     * 编辑用户纪念日
     * </pre>
     * @throws IOException 
     */
    @RequestMapping("/saveDateDetils")
    public Map<String,Object> saveDateDetils( HttpServletRequest request,HttpServletResponse response) throws IOException {
    	Map<String,Object> result=new HashMap<String,Object>();
    	String dateId = request.getParameter("dateId").toString();
    	String openId = request.getParameter("openId").toString();
    	String typerepeat = request.getParameter("typerepeat").toString();
    	String typeremind = request.getParameter("typeremind").toString();
    	String isGC = request.getParameter("isGC").toString();
    	String isAttention = request.getParameter("isAttention").toString();
    	String thingname = request.getParameter("thingname").toString();
    	String datetime = request.getParameter("datetime").toString();
    	
    	if(!"".equals(openId)) {
    		List<DateList> dateList = helperService.getDateListByDateId(dateId);
    		DateList date=dateList.get(0);
    		
    		date.setRepetRemind(typeremind);
    		date.setDateTitle(thingname);
    		date.setAttentionDate(isAttention);
    		date.setDateTime(TimeUtils.stringToDate(datetime, "yyyy-MM-dd hh:mm"));
    		date.setGc(isGC.equals("1"));
    		date.setRemindType(typerepeat);
    		
    		helperService.updateByPrimaryKey(date);
    		result.put("success", Boolean.TRUE);
    	}else {
    		result.put("success", Boolean.FALSE);
    	}
    	 
		return result;
    }
    
    
    /**
     * <pre>
     * 保存用户纪念日
     * </pre>
     * @throws IOException 
     */
    @RequestMapping("/getDateList")
    public Map<String,Object> getDateList( HttpServletRequest request,HttpServletResponse response) throws IOException {
    	Map<String,Object> result=new HashMap<String,Object>();
    	if(null!=request.getSession().getAttribute("openid")) {
    		String openid = request.getSession().getAttribute("openid").toString();
    		
    		List<DateList> dateList=helperService.getDateListByOpenId(openid);
    		result.put("dateList", dateList);
    		result.put("success", Boolean.TRUE);
    		request.getSession().setAttribute("dateList", dateList);
    	}else {
    		result.put("success", Boolean.FALSE);
    	}
		return result;
    }
    
    /**
     * <pre>
     * 查询指定用户指定纪念日
     * </pre>
     * @throws IOException 
     */
    @RequestMapping("/selectDateList")
    public ModelAndView selectDateList( HttpServletRequest request,HttpServletResponse response) throws IOException {
    	Map<String,Object> result=new HashMap<String,Object>();
    	ModelAndView mav=null;
    	if(null!=request.getSession().getAttribute("openid")) {
    		String openid = request.getSession().getAttribute("openid").toString();
    		
    		List<DateList> dateList=helperService.getDateListByOpenId(openid);
    		result.put("dateList", dateList);
    		result.put("success", Boolean.TRUE);
    		mav=new ModelAndView("dateList",result);
    	}else {
    		result.put("success", Boolean.FALSE);
    		mav=new ModelAndView("dateList",result);
    	}
		return mav;
    }
    
    /**
     * <pre>
     * 跳转至详情页
     * </pre>
     * @throws IOException 
     */
    @RequestMapping("/getDetail")
    public Map<String, Object> getDetail( HttpServletRequest request,HttpServletResponse response) throws IOException {
    	Map<String,Object> result=new HashMap<String,Object>();
    	if(null!=request.getSession().getAttribute("openid")) {
    		String openid = request.getSession().getAttribute("openid").toString();
    		String dateId=request.getParameter("dateId");
    		
    		List<DateList> dateList=helperService.getDateListByOpenId(openid,dateId);
    		DateList date=dateList.get(0);
    		result.put("date", date);
    		request.getSession().setAttribute("date", date);
    		result.put("success", Boolean.TRUE);
    	}else if(null!=request.getParameter("openId")){
    		String openid = request.getParameter("openId");
    		request.getSession().setAttribute("openId", request.getParameter("openId"));
    		String dateId=request.getParameter("dateId");
    		
    		List<DateList> dateList=helperService.getDateListByOpenId(openid,dateId);
    		DateList date=dateList.get(0);
    		result.put("date", date);
    		request.getSession().setAttribute("date", date);
    		result.put("success", Boolean.TRUE);
    	}
    	
		return result;
    }
    
	/**
	 * <pre>
	 * 跳转至详情页getDetailByDateId
	 * </pre>
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/getDetailByDateId")
	public ModelAndView getDetailByDateId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		ModelAndView mav=null;
		String dateId = request.getParameter("dateId");

		List<DateList> dateList = helperService.getDateListByDateId(dateId);
		if(dateList!=null) {
			DateList date = dateList.get(0);
			result.put("date", date);
			request.getSession().setAttribute("date", date);
			result.put("success", Boolean.TRUE);
		}
		
		mav=new ModelAndView("card",result);

		return mav;
	}
	
    /**
     * <pre>
     * 删除用户纪念日
     * </pre>
     * @throws IOException 
     */
    @RequestMapping("/deleteDate")
    public Map<String,Object> deleteDate( HttpServletRequest request,HttpServletResponse response) throws IOException {
    	Map<String,Object> result=new HashMap<String,Object>();
    	String dateId = request.getParameter("dateId").toString();
    	
    	if(!"".equals(dateId)) {
    		helperService.deleteByPrimaryKey(dateId);
    		result.put("success", Boolean.TRUE);
    	}else {
    		result.put("success", Boolean.FALSE);
    	}
    	 
		return result;
    }

}
