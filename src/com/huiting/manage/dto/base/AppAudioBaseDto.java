package com.huiting.manage.dto.base;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("appAudioBaseDto")
public class AppAudioBaseDto {
    private String audioid;

    private String audioname;

    private String audiourl;

    private String userid;

    private String nickname;

    private String audiocatalog;

    private String audiosource;

    private Timestamp uploadtime;

    private String audiostatus;

    private Integer flowercnt;

    private String audiolength;

    private String audiocontent;

    private String backgoundpic;
    private String programid;
    private String programurl;

    public String getAudioid() {
        return audioid;
    }

    public void setAudioid(String audioid) {
        this.audioid = audioid == null ? null : audioid.trim();
    }

    public String getAudioname() {
        return audioname;
    }

    public void setAudioname(String audioname) {
        this.audioname = audioname == null ? null : audioname.trim();
    }

    public String getAudiourl() {
        return audiourl;
    }

    public void setAudiourl(String audiourl) {
        this.audiourl = audiourl == null ? null : audiourl.trim();
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

    public String getAudiocatalog() {
        return audiocatalog;
    }

    public void setAudiocatalog(String audiocatalog) {
        this.audiocatalog = audiocatalog == null ? null : audiocatalog.trim();
    }

    public String getAudiosource() {
        return audiosource;
    }

    public void setAudiosource(String audiosource) {
        this.audiosource = audiosource == null ? null : audiosource.trim();
    }

 

    public Timestamp getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(Timestamp uploadtime) {
		this.uploadtime = uploadtime;
	}

	public String getAudiostatus() {
        return audiostatus;
    }

    public void setAudiostatus(String audiostatus) {
        this.audiostatus = audiostatus == null ? null : audiostatus.trim();
    }

    public Integer getFlowercnt() {
        return flowercnt;
    }

    public void setFlowercnt(Integer flowercnt) {
        this.flowercnt = flowercnt;
    }

    public String getAudiolength() {
        return audiolength;
    }

    public void setAudiolength(String audiolength) {
        this.audiolength = audiolength == null ? null : audiolength.trim();
    }

    public String getAudiocontent() {
        return audiocontent;
    }

    public void setAudiocontent(String audiocontent) {
        this.audiocontent = audiocontent == null ? null : audiocontent.trim();
    }

    public String getBackgoundpic() {
        return backgoundpic;
    }

    public void setBackgoundpic(String backgoundpic) {
        this.backgoundpic = backgoundpic == null ? null : backgoundpic.trim();
    }

	public String getProgramid() {
		return programid;
	}

	public void setProgramid(String programid) {
		this.programid = programid;
	}

	public String getProgramurl() {
		return programurl;
	}

	public void setProgramurl(String programurl) {
		this.programurl = programurl;
	}
    
}