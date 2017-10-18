package com.github.stip.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.stip.net.dao.DateListDao;
import com.github.stip.net.dao.MuserDao;
import com.github.stip.net.entity.DateList;
import com.github.stip.net.entity.DateListExample;
import com.github.stip.net.entity.Muser;
import com.github.stip.net.entity.MuserExample;
import com.github.stip.net.entity.base.BDateListExample.Criteria;
import com.github.stip.utils.TimeUtils;

@Service
public class HelperService {
	@Resource
	public MuserDao muserDao;
	@Resource
	public DateListDao dateListDao;
	
	public Muser findUserByLoginName(String id) {
		MuserExample example=new MuserExample();
		example.createCriteria().andIdEqualTo(id);
		List<Muser> userList=muserDao.selectByExample(example);
		
		if(userList!=null&&userList.size()>0){
			return userList.get(0);
		}else{
			return null;
		}
	}
	
	public Muser findUserByOpenId(String openId) {
		MuserExample example=new MuserExample();
		example.createCriteria().andOpenidEqualTo(openId);
		List<Muser> userList=muserDao.selectByExample(example);
		
		if(userList!=null&&userList.size()>0){
			return userList.get(0);
		}else{
			return null;
		}
	}
	
	public void insertUser(Muser user) {
		muserDao.insert(user);
	}
	
	public void insertDate(DateList date) {
		dateListDao.insert(date);
	}
	
	public void updateByPrimaryKey(DateList date) {
		dateListDao.updateByPrimaryKey(date);
	}
	
	public void deleteByPrimaryKey(String id) {
		dateListDao.deleteByPrimaryKey(id);
	}
	
	public List<DateList> getDateListByOpenId(String openId){
		DateListExample example=new DateListExample();
		example.createCriteria().andOpenIdEqualTo(openId);
		example.setOrderByClause(" dateList.attention_date desc,dateList.date_time asc");
		List<DateList> dateList=dateListDao.selectByExample(example);
		
		if(dateList!=null&&dateList.size()>0){
			
			for(DateList date:dateList) {
				if(date.getAttentionDate().equals("1")) {
					date.setRemark3(TimeUtils.dateToString(date.getDateTime(), "yyyy-MM-dd hh:mm:ss"));
				}
				int dates=TimeUtils.nDaysBetweenTwoDate(new Date(), date.getDateTime());
				if(dates<0) {
					dates=dates*-1;
					date.setRemark("已经");
					date.setRemark1(dates+"");
					date.setRemark2("天");
				}else if(dates==0){
					date.setRemark("就是");
					date.setRemark1("今天");
					date.setRemark2("");
				}else {
					date.setRemark("还有");
					date.setRemark1(dates+"");
					date.setRemark2("天");
				}
			}
			
			return dateList;
		}else{
			return null;
		}
	}
	
	public List<DateList> getDateListByOpenId(String openId,String dateId){
		DateListExample example=new DateListExample();
		Criteria criteria=example.createCriteria();
		criteria.andOpenIdEqualTo(openId);
		if(null!=dateId) {
			criteria.andDateIdEqualTo(dateId);
		}
		example.setOrderByClause(" dateList.attention_date desc,dateList.date_time asc");
		List<DateList> dateList=dateListDao.selectByExample(example);
		
		if(dateList!=null&&dateList.size()>0){
			
			for(DateList date:dateList) {
				date.setRemark3(TimeUtils.dateToString(date.getDateTime(), "yyyy-MM-dd hh:mm:ss"));
				
				int dates=TimeUtils.nDaysBetweenTwoDate(new Date(), date.getDateTime());
				if(dates<0) {
					dates=dates*-1;
					date.setRemark("已经");
					date.setRemark1(dates+"");
					date.setRemark2("天");
				}else if(dates==0){
					date.setRemark("就是");
					date.setRemark1("今天");
					date.setRemark2("");
				}else {
					date.setRemark("还有");
					date.setRemark1(dates+"");
					date.setRemark2("天");
				}
			}
			
			return dateList;
		}else{
			return null;
		}
	}
	
	public List<DateList> getDateListByDateId(String dateId){
		DateListExample example=new DateListExample();
		Criteria criteria=example.createCriteria();
		if(null!=dateId) {
			criteria.andDateIdEqualTo(dateId);
		}
		example.setOrderByClause(" dateList.attention_date desc,dateList.date_time asc");
		List<DateList> dateList=dateListDao.selectByExample(example);
		
		if(dateList!=null&&dateList.size()>0){
			
			for(DateList date:dateList) {
				date.setRemark3(TimeUtils.dateToString(date.getDateTime(), "yyyy-MM-dd hh:mm:ss"));
				
				int dates=TimeUtils.nDaysBetweenTwoDate(new Date(), date.getDateTime());
				if(dates<0) {
					dates=dates*-1;
					date.setRemark("已经");
					date.setRemark1(dates+"");
					date.setRemark2("天");
				}else if(dates==0){
					date.setRemark("就是");
					date.setRemark1("今天");
					date.setRemark2("");
				}else {
					date.setRemark("还有");
					date.setRemark1(dates+"");
					date.setRemark2("天");
				}
			}
			
			return dateList;
		}else{
			return null;
		}
	}
	
	
	public List<DateList> getDateListByDate(){
		DateListExample example=new DateListExample();
		example.createCriteria().andDayLessOne(TimeUtils.dateToString(new Date(), "yyyy-MM-dd hh:mm:ss"),TimeUtils.dateToString(TimeUtils.setDateDay(new Date(), 2), "yyyy-MM-dd hh:mm:ss"));;
		example.setOrderByClause(" dateList.attention_date desc,dateList.date_time asc");
		List<DateList> dateList=dateListDao.selectByExample(example);
		
		if(dateList!=null&&dateList.size()>0){
			return dateList;
		}else{
			return null;
		}
	}
	
}
