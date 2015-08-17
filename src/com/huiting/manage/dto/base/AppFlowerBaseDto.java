package com.huiting.manage.dto.base;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("appFlowerBaseDto")
public class AppFlowerBaseDto {
    private String modular;

    private String busiid;

    private String userid;

    private String nickname;

    private Integer flowercnt;

    private Timestamp commentime;

    public String getModular() {
        return modular;
    }

    public void setModular(String modular) {
        this.modular = modular == null ? null : modular.trim();
    }

    public String getBusiid() {
        return busiid;
    }

    public void setBusiid(String busiid) {
        this.busiid = busiid == null ? null : busiid.trim();
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

    public Integer getFlowercnt() {
        return flowercnt;
    }

    public void setFlowercnt(Integer flowercnt) {
        this.flowercnt = flowercnt;
    }

	public Timestamp getCommentime() {
		return commentime;
	}

	public void setCommentime(Timestamp commentime) {
		this.commentime = commentime;
	}

 
}