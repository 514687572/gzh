package com.github.stip.net.entity.base;

import com.stip.mybatis.generator.plugin.BaseCriteria;
import com.stip.mybatis.generator.plugin.BaseModelExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BDateListExample extends BaseModelExample {
    protected List<Criteria> oredCriteria;

    public BDateListExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        super.clear();
        oredCriteria.clear();
    }

    protected abstract static class GeneratedCriteria extends BaseCriteria {

        public Criteria andDateIdIsNull() {
            addCriterion("dateList.date_id is null");
            return (Criteria) this;
        }

        public Criteria andDateIdIsNotNull() {
            addCriterion("dateList.date_id is not null");
            return (Criteria) this;
        }

        public Criteria andDateIdEqualTo(String value) {
            addCriterion("dateList.date_id =", value, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateIdNotEqualTo(String value) {
            addCriterion("dateList.date_id <>", value, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateIdGreaterThan(String value) {
            addCriterion("dateList.date_id >", value, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateIdGreaterThanOrEqualTo(String value) {
            addCriterion("dateList.date_id >=", value, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateIdLessThan(String value) {
            addCriterion("dateList.date_id <", value, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateIdLessThanOrEqualTo(String value) {
            addCriterion("dateList.date_id <=", value, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateIdLike(String value) {
            addCriterion("dateList.date_id like", value, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateIdNotLike(String value) {
            addCriterion("dateList.date_id not like", value, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateIdIn(List<String> values) {
            addCriterion("dateList.date_id in", values, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateIdNotIn(List<String> values) {
            addCriterion("dateList.date_id not in", values, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateIdBetween(String value1, String value2) {
            addCriterion("dateList.date_id between", value1, value2, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateIdNotBetween(String value1, String value2) {
            addCriterion("dateList.date_id not between", value1, value2, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateTitleIsNull() {
            addCriterion("dateList.date_title is null");
            return (Criteria) this;
        }

        public Criteria andDateTitleIsNotNull() {
            addCriterion("dateList.date_title is not null");
            return (Criteria) this;
        }

        public Criteria andDateTitleEqualTo(String value) {
            addCriterion("dateList.date_title =", value, "dateTitle");
            return (Criteria) this;
        }

        public Criteria andDateTitleNotEqualTo(String value) {
            addCriterion("dateList.date_title <>", value, "dateTitle");
            return (Criteria) this;
        }

        public Criteria andDateTitleGreaterThan(String value) {
            addCriterion("dateList.date_title >", value, "dateTitle");
            return (Criteria) this;
        }

        public Criteria andDateTitleGreaterThanOrEqualTo(String value) {
            addCriterion("dateList.date_title >=", value, "dateTitle");
            return (Criteria) this;
        }

        public Criteria andDateTitleLessThan(String value) {
            addCriterion("dateList.date_title <", value, "dateTitle");
            return (Criteria) this;
        }

        public Criteria andDateTitleLessThanOrEqualTo(String value) {
            addCriterion("dateList.date_title <=", value, "dateTitle");
            return (Criteria) this;
        }

        public Criteria andDateTitleLike(String value) {
            addCriterion("dateList.date_title like", value, "dateTitle");
            return (Criteria) this;
        }

        public Criteria andDateTitleNotLike(String value) {
            addCriterion("dateList.date_title not like", value, "dateTitle");
            return (Criteria) this;
        }

        public Criteria andDateTitleIn(List<String> values) {
            addCriterion("dateList.date_title in", values, "dateTitle");
            return (Criteria) this;
        }

        public Criteria andDateTitleNotIn(List<String> values) {
            addCriterion("dateList.date_title not in", values, "dateTitle");
            return (Criteria) this;
        }

        public Criteria andDateTitleBetween(String value1, String value2) {
            addCriterion("dateList.date_title between", value1, value2, "dateTitle");
            return (Criteria) this;
        }

        public Criteria andDateTitleNotBetween(String value1, String value2) {
            addCriterion("dateList.date_title not between", value1, value2, "dateTitle");
            return (Criteria) this;
        }

        public Criteria andRemindTypeIsNull() {
            addCriterion("dateList.remind_type is null");
            return (Criteria) this;
        }

        public Criteria andRemindTypeIsNotNull() {
            addCriterion("dateList.remind_type is not null");
            return (Criteria) this;
        }

        public Criteria andRemindTypeEqualTo(String value) {
            addCriterion("dateList.remind_type =", value, "remindType");
            return (Criteria) this;
        }

        public Criteria andRemindTypeNotEqualTo(String value) {
            addCriterion("dateList.remind_type <>", value, "remindType");
            return (Criteria) this;
        }

        public Criteria andRemindTypeGreaterThan(String value) {
            addCriterion("dateList.remind_type >", value, "remindType");
            return (Criteria) this;
        }

        public Criteria andRemindTypeGreaterThanOrEqualTo(String value) {
            addCriterion("dateList.remind_type >=", value, "remindType");
            return (Criteria) this;
        }

        public Criteria andRemindTypeLessThan(String value) {
            addCriterion("dateList.remind_type <", value, "remindType");
            return (Criteria) this;
        }

        public Criteria andRemindTypeLessThanOrEqualTo(String value) {
            addCriterion("dateList.remind_type <=", value, "remindType");
            return (Criteria) this;
        }

        public Criteria andRemindTypeLike(String value) {
            addCriterion("dateList.remind_type like", value, "remindType");
            return (Criteria) this;
        }

        public Criteria andRemindTypeNotLike(String value) {
            addCriterion("dateList.remind_type not like", value, "remindType");
            return (Criteria) this;
        }

        public Criteria andRemindTypeIn(List<String> values) {
            addCriterion("dateList.remind_type in", values, "remindType");
            return (Criteria) this;
        }

        public Criteria andRemindTypeNotIn(List<String> values) {
            addCriterion("dateList.remind_type not in", values, "remindType");
            return (Criteria) this;
        }

        public Criteria andRemindTypeBetween(String value1, String value2) {
            addCriterion("dateList.remind_type between", value1, value2, "remindType");
            return (Criteria) this;
        }

        public Criteria andRemindTypeNotBetween(String value1, String value2) {
            addCriterion("dateList.remind_type not between", value1, value2, "remindType");
            return (Criteria) this;
        }

        public Criteria andRepetRemindIsNull() {
            addCriterion("dateList.repet_remind is null");
            return (Criteria) this;
        }

        public Criteria andRepetRemindIsNotNull() {
            addCriterion("dateList.repet_remind is not null");
            return (Criteria) this;
        }

        public Criteria andRepetRemindEqualTo(String value) {
            addCriterion("dateList.repet_remind =", value, "repetRemind");
            return (Criteria) this;
        }

        public Criteria andRepetRemindNotEqualTo(String value) {
            addCriterion("dateList.repet_remind <>", value, "repetRemind");
            return (Criteria) this;
        }

        public Criteria andRepetRemindGreaterThan(String value) {
            addCriterion("dateList.repet_remind >", value, "repetRemind");
            return (Criteria) this;
        }

        public Criteria andRepetRemindGreaterThanOrEqualTo(String value) {
            addCriterion("dateList.repet_remind >=", value, "repetRemind");
            return (Criteria) this;
        }

        public Criteria andRepetRemindLessThan(String value) {
            addCriterion("dateList.repet_remind <", value, "repetRemind");
            return (Criteria) this;
        }

        public Criteria andRepetRemindLessThanOrEqualTo(String value) {
            addCriterion("dateList.repet_remind <=", value, "repetRemind");
            return (Criteria) this;
        }

        public Criteria andRepetRemindLike(String value) {
            addCriterion("dateList.repet_remind like", value, "repetRemind");
            return (Criteria) this;
        }

        public Criteria andRepetRemindNotLike(String value) {
            addCriterion("dateList.repet_remind not like", value, "repetRemind");
            return (Criteria) this;
        }

        public Criteria andRepetRemindIn(List<String> values) {
            addCriterion("dateList.repet_remind in", values, "repetRemind");
            return (Criteria) this;
        }

        public Criteria andRepetRemindNotIn(List<String> values) {
            addCriterion("dateList.repet_remind not in", values, "repetRemind");
            return (Criteria) this;
        }

        public Criteria andRepetRemindBetween(String value1, String value2) {
            addCriterion("dateList.repet_remind between", value1, value2, "repetRemind");
            return (Criteria) this;
        }

        public Criteria andRepetRemindNotBetween(String value1, String value2) {
            addCriterion("dateList.repet_remind not between", value1, value2, "repetRemind");
            return (Criteria) this;
        }

        public Criteria andDateTimeIsNull() {
            addCriterion("dateList.date_time is null");
            return (Criteria) this;
        }

        public Criteria andDateTimeIsNotNull() {
            addCriterion("dateList.date_time is not null");
            return (Criteria) this;
        }

        public Criteria andDateTimeEqualTo(Date value) {
            addCriterion("dateList.date_time =", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotEqualTo(Date value) {
            addCriterion("dateList.date_time <>", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeGreaterThan(Date value) {
            addCriterion("dateList.date_time >", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dateList.date_time >=", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeLessThan(Date value) {
            addCriterion("dateList.date_time <", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("dateList.date_time <=", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeIn(List<Date> values) {
            addCriterion("dateList.date_time in", values, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotIn(List<Date> values) {
            addCriterion("dateList.date_time not in", values, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeBetween(Date value1, Date value2) {
            addCriterion("dateList.date_time between", value1, value2, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("dateList.date_time not between", value1, value2, "dateTime");
            return (Criteria) this;
        }

        public Criteria andAttentionDateIsNull() {
            addCriterion("dateList.attention_date is null");
            return (Criteria) this;
        }

        public Criteria andAttentionDateIsNotNull() {
            addCriterion("dateList.attention_date is not null");
            return (Criteria) this;
        }

        public Criteria andAttentionDateEqualTo(String value) {
            addCriterion("dateList.attention_date =", value, "attentionDate");
            return (Criteria) this;
        }

        public Criteria andAttentionDateNotEqualTo(String value) {
            addCriterion("dateList.attention_date <>", value, "attentionDate");
            return (Criteria) this;
        }

        public Criteria andAttentionDateGreaterThan(String value) {
            addCriterion("dateList.attention_date >", value, "attentionDate");
            return (Criteria) this;
        }

        public Criteria andAttentionDateGreaterThanOrEqualTo(String value) {
            addCriterion("dateList.attention_date >=", value, "attentionDate");
            return (Criteria) this;
        }

        public Criteria andAttentionDateLessThan(String value) {
            addCriterion("dateList.attention_date <", value, "attentionDate");
            return (Criteria) this;
        }

        public Criteria andAttentionDateLessThanOrEqualTo(String value) {
            addCriterion("dateList.attention_date <=", value, "attentionDate");
            return (Criteria) this;
        }

        public Criteria andAttentionDateLike(String value) {
            addCriterion("dateList.attention_date like", value, "attentionDate");
            return (Criteria) this;
        }

        public Criteria andAttentionDateNotLike(String value) {
            addCriterion("dateList.attention_date not like", value, "attentionDate");
            return (Criteria) this;
        }

        public Criteria andAttentionDateIn(List<String> values) {
            addCriterion("dateList.attention_date in", values, "attentionDate");
            return (Criteria) this;
        }

        public Criteria andAttentionDateNotIn(List<String> values) {
            addCriterion("dateList.attention_date not in", values, "attentionDate");
            return (Criteria) this;
        }

        public Criteria andAttentionDateBetween(String value1, String value2) {
            addCriterion("dateList.attention_date between", value1, value2, "attentionDate");
            return (Criteria) this;
        }

        public Criteria andAttentionDateNotBetween(String value1, String value2) {
            addCriterion("dateList.attention_date not between", value1, value2, "attentionDate");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("dateList.create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("dateList.create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("dateList.create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("dateList.create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("dateList.create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dateList.create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("dateList.create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("dateList.create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("dateList.create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("dateList.create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("dateList.create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("dateList.create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("dateList.user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("dateList.user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("dateList.user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("dateList.user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("dateList.user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("dateList.user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("dateList.user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("dateList.user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("dateList.user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("dateList.user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("dateList.user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("dateList.user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("dateList.user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("dateList.user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("dateList.open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("dateList.open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("dateList.open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("dateList.open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("dateList.open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("dateList.open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("dateList.open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("dateList.open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("dateList.open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("dateList.open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("dateList.open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("dateList.open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("dateList.open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("dateList.open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andGcIsNull() {
            addCriterion("dateList.is_gc is null");
            return (Criteria) this;
        }

        public Criteria andGcIsNotNull() {
            addCriterion("dateList.is_gc is not null");
            return (Criteria) this;
        }

        public Criteria andGcEqualTo(Boolean value) {
            addCriterion("dateList.is_gc =", value, "gc");
            return (Criteria) this;
        }

        public Criteria andGcNotEqualTo(Boolean value) {
            addCriterion("dateList.is_gc <>", value, "gc");
            return (Criteria) this;
        }

        public Criteria andGcGreaterThan(Boolean value) {
            addCriterion("dateList.is_gc >", value, "gc");
            return (Criteria) this;
        }

        public Criteria andGcGreaterThanOrEqualTo(Boolean value) {
            addCriterion("dateList.is_gc >=", value, "gc");
            return (Criteria) this;
        }

        public Criteria andGcLessThan(Boolean value) {
            addCriterion("dateList.is_gc <", value, "gc");
            return (Criteria) this;
        }

        public Criteria andGcLessThanOrEqualTo(Boolean value) {
            addCriterion("dateList.is_gc <=", value, "gc");
            return (Criteria) this;
        }

        public Criteria andGcLike(Boolean value) {
            addCriterion("dateList.is_gc like", value, "gc");
            return (Criteria) this;
        }

        public Criteria andGcNotLike(Boolean value) {
            addCriterion("dateList.is_gc not like", value, "gc");
            return (Criteria) this;
        }

        public Criteria andGcIn(List<Boolean> values) {
            addCriterion("dateList.is_gc in", values, "gc");
            return (Criteria) this;
        }

        public Criteria andGcNotIn(List<Boolean> values) {
            addCriterion("dateList.is_gc not in", values, "gc");
            return (Criteria) this;
        }

        public Criteria andGcBetween(Boolean value1, Boolean value2) {
            addCriterion("dateList.is_gc between", value1, value2, "gc");
            return (Criteria) this;
        }

        public Criteria andGcNotBetween(Boolean value1, Boolean value2) {
            addCriterion("dateList.is_gc not between", value1, value2, "gc");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("dateList.remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("dateList.remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("dateList.remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("dateList.remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("dateList.remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("dateList.remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("dateList.remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("dateList.remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("dateList.remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("dateList.remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("dateList.remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("dateList.remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("dateList.remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("dateList.remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNull() {
            addCriterion("dateList.remark1 is null");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNotNull() {
            addCriterion("dateList.remark1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark1EqualTo(String value) {
            addCriterion("dateList.remark1 =", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotEqualTo(String value) {
            addCriterion("dateList.remark1 <>", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThan(String value) {
            addCriterion("dateList.remark1 >", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            addCriterion("dateList.remark1 >=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThan(String value) {
            addCriterion("dateList.remark1 <", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            addCriterion("dateList.remark1 <=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Like(String value) {
            addCriterion("dateList.remark1 like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotLike(String value) {
            addCriterion("dateList.remark1 not like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1In(List<String> values) {
            addCriterion("dateList.remark1 in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotIn(List<String> values) {
            addCriterion("dateList.remark1 not in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Between(String value1, String value2) {
            addCriterion("dateList.remark1 between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            addCriterion("dateList.remark1 not between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNull() {
            addCriterion("dateList.remark2 is null");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNotNull() {
            addCriterion("dateList.remark2 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark2EqualTo(String value) {
            addCriterion("dateList.remark2 =", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotEqualTo(String value) {
            addCriterion("dateList.remark2 <>", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThan(String value) {
            addCriterion("dateList.remark2 >", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            addCriterion("dateList.remark2 >=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThan(String value) {
            addCriterion("dateList.remark2 <", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            addCriterion("dateList.remark2 <=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Like(String value) {
            addCriterion("dateList.remark2 like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotLike(String value) {
            addCriterion("dateList.remark2 not like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2In(List<String> values) {
            addCriterion("dateList.remark2 in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotIn(List<String> values) {
            addCriterion("dateList.remark2 not in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Between(String value1, String value2) {
            addCriterion("dateList.remark2 between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            addCriterion("dateList.remark2 not between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark3IsNull() {
            addCriterion("dateList.remark3 is null");
            return (Criteria) this;
        }

        public Criteria andRemark3IsNotNull() {
            addCriterion("dateList.remark3 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark3EqualTo(String value) {
            addCriterion("dateList.remark3 =", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotEqualTo(String value) {
            addCriterion("dateList.remark3 <>", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3GreaterThan(String value) {
            addCriterion("dateList.remark3 >", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3GreaterThanOrEqualTo(String value) {
            addCriterion("dateList.remark3 >=", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3LessThan(String value) {
            addCriterion("dateList.remark3 <", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3LessThanOrEqualTo(String value) {
            addCriterion("dateList.remark3 <=", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3Like(String value) {
            addCriterion("dateList.remark3 like", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotLike(String value) {
            addCriterion("dateList.remark3 not like", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3In(List<String> values) {
            addCriterion("dateList.remark3 in", values, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotIn(List<String> values) {
            addCriterion("dateList.remark3 not in", values, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3Between(String value1, String value2) {
            addCriterion("dateList.remark3 between", value1, value2, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotBetween(String value1, String value2) {
            addCriterion("dateList.remark3 not between", value1, value2, "remark3");
            return (Criteria) this;
        }
        
        public Criteria andDayLessOne(String dateNow,String otherDate) {
        	addCriterion(" ((dateList.date_time >='"+dateNow+"' and dateList.date_time <='"+otherDate+"') or (dateList.repet_remind ='每天' or dateList.remind_type='每天'))");
        	return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}