package com.huiting.manage.dto.base;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("appFirstPageBaseDto")
public class AppFirstPageBaseDto {
    private Integer id;

    private String picurl;

    private Timestamp createtime;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl == null ? null : picurl.trim();
    }

 

    public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}