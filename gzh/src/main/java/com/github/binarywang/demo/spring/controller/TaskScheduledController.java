package com.github.binarywang.demo.spring.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.github.stip.net.entity.DateList;
import com.github.stip.service.HelperService;
import com.github.stip.service.PushService;

/**
 * 系统任务
 * 
 * @author Administrator
 *
 */
@Component
@Lazy(false)
public class TaskScheduledController {
	@Resource
	public PushService pushService;
	@Autowired
	private HelperService helperService;

	/**
	 * 每天9点运行提醒任务
	 * 
	 * @return
	 * @throws Exception
	 */
	@Scheduled(cron = "0 50 10 * * ?")
	public void remindUserDate() throws Exception {
		List<DateList> dateList=helperService.getDateListByDate();
		
		for(DateList dates:dateList) {
			pushService.setSendTemplate(dates);
			Thread.sleep(1000);
		}
	}

}
