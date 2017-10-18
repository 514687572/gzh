package com.github.stip.net.entity.base;

import com.stip.mybatis.generator.plugin.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BDateList extends BaseModel<String> implements Serializable {
    private String dateId;

    private String dateTitle;

    private String remindType;

    private String repetRemind;

    private Date dateTime;

    private String attentionDate;

    private Date createTime;

    private String userId;

    private String openId;

    private Boolean gc;

    private String remark;

    private String remark1;

    private String remark2;

    private String remark3;

    private static final long serialVersionUID = 1L;

    public String getDateId() {
        return dateId;
    }

    public void setDateId(String dateId) {
        this.dateId = dateId == null ? null : dateId.trim();
    }

    public String getDateTitle() {
        return dateTitle;
    }

    public void setDateTitle(String dateTitle) {
        this.dateTitle = dateTitle == null ? null : dateTitle.trim();
    }

    public String getRemindType() {
        return remindType;
    }

    public void setRemindType(String remindType) {
        this.remindType = remindType == null ? null : remindType.trim();
    }

    public String getRepetRemind() {
        return repetRemind;
    }

    public void setRepetRemind(String repetRemind) {
        this.repetRemind = repetRemind == null ? null : repetRemind.trim();
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getAttentionDate() {
        return attentionDate;
    }

    public void setAttentionDate(String attentionDate) {
        this.attentionDate = attentionDate == null ? null : attentionDate.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Boolean getGc() {
        return gc;
    }

    public void setGc(Boolean gc) {
        this.gc = gc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dateId=").append(dateId);
        sb.append(", dateTitle=").append(dateTitle);
        sb.append(", remindType=").append(remindType);
        sb.append(", repetRemind=").append(repetRemind);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", attentionDate=").append(attentionDate);
        sb.append(", createTime=").append(createTime);
        sb.append(", userId=").append(userId);
        sb.append(", openId=").append(openId);
        sb.append(", gc=").append(gc);
        sb.append(", remark=").append(remark);
        sb.append(", remark1=").append(remark1);
        sb.append(", remark2=").append(remark2);
        sb.append(", remark3=").append(remark3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BDateList other = (BDateList) that;
        return (this.getDateId() == null ? other.getDateId() == null : this.getDateId().equals(other.getDateId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDateId() == null) ? 0 : getDateId().hashCode());
        return result;
    }
}