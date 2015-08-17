package com.huiting.manage.dto.base;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;



@Alias("appActivityBaseDto")
public class AppActivityBaseDto {
    private String activityid;

    private String activityname;

    private String activitytype;

    private String activitydesc;

    private String activitypicurl;

    private Timestamp activitytime;
    
    private String validstatus;

    public String getActivityid() {
        return activityid;
    }

    public void setActivityid(String activityid) {
        this.activityid = activityid == null ? null : activityid.trim();
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname == null ? null : activityname.trim();
    }

    public String getActivitytype() {
        return activitytype;
    }

    public void setActivitytype(String activitytype) {
        this.activitytype = activitytype == null ? null : activitytype.trim();
    }

    public String getActivitydesc() {
        return activitydesc;
    }

    public void setActivitydesc(String activitydesc) {
        this.activitydesc = activitydesc == null ? null : activitydesc.trim();
    }

    public String getActivitypicurl() {
        return activitypicurl;
    }

    public void setActivitypicurl(String activitypicurl) {
        this.activitypicurl = activitypicurl == null ? null : activitypicurl.trim();
    }

	public Timestamp getActivitytime() {
		return activitytime;
	}

	public void setActivitytime(Timestamp activitytime) {
		this.activitytime = activitytime;
	}

	public String getValidstatus() {
		return validstatus;
	}

	public void setValidstatus(String validstatus) {
		this.validstatus = validstatus;
	}

	

    
}