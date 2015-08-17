package com.huiting.manage.dto.base;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("appPicbookBaseDto")
public class AppPicbookBaseDto {
    private String picbookid;

    private String picbookname;

    private String picbookurl;

    private String userid;

    private String nickname;

    private String piccatalog;

    private String picscene;

    private String picbooksource;

    private Timestamp uploadtime;

    private String picbookstatus;

    private Integer flowercnt;

    public String getPicbookid() {
        return picbookid;
    }

    public void setPicbookid(String picbookid) {
        this.picbookid = picbookid == null ? null : picbookid.trim();
    }

    public String getPicbookname() {
        return picbookname;
    }

    public void setPicbookname(String picbookname) {
        this.picbookname = picbookname == null ? null : picbookname.trim();
    }

    public String getPicbookurl() {
        return picbookurl;
    }

    public void setPicbookurl(String picbookurl) {
        this.picbookurl = picbookurl == null ? null : picbookurl.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPiccatalog() {
        return piccatalog;
    }

    public void setPiccatalog(String piccatalog) {
        this.piccatalog = piccatalog == null ? null : piccatalog.trim();
    }

    public String getPicscene() {
        return picscene;
    }

    public void setPicscene(String picscene) {
        this.picscene = picscene == null ? null : picscene.trim();
    }

    public String getPicbooksource() {
        return picbooksource;
    }

    public void setPicbooksource(String picbooksource) {
        this.picbooksource = picbooksource == null ? null : picbooksource.trim();
    }

 

    public Timestamp getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(Timestamp uploadtime) {
		this.uploadtime = uploadtime;
	}

	public String getPicbookstatus() {
        return picbookstatus;
    }

    public void setPicbookstatus(String picbookstatus) {
        this.picbookstatus = picbookstatus == null ? null : picbookstatus.trim();
    }

    public Integer getFlowercnt() {
        return flowercnt;
    }

    public void setFlowercnt(Integer flowercnt) {
        this.flowercnt = flowercnt;
    }
}