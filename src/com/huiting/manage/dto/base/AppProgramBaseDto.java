package com.huiting.manage.dto.base;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("appProgramBaseDto")
public class AppProgramBaseDto {
    private String programid;

    private String channelid;

    private String programname;

    private String programurl;

    private String duration;

    private String programpic;

    private Integer playcnt;

    private Integer flowercnt;

    private String sort;

    private Timestamp loadtime;

    private String description;

    private String status;

    public String getProgramid() {
        return programid;
    }

    public void setProgramid(String programid) {
        this.programid = programid == null ? null : programid.trim();
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid == null ? null : channelid.trim();
    }

    public String getProgramname() {
        return programname;
    }

    public void setProgramname(String programname) {
        this.programname = programname == null ? null : programname.trim();
    }

    public String getProgramurl() {
        return programurl;
    }

    public void setProgramurl(String programurl) {
        this.programurl = programurl == null ? null : programurl.trim();
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public String getProgrampic() {
        return programpic;
    }

    public void setProgrampic(String programpic) {
        this.programpic = programpic == null ? null : programpic.trim();
    }

    public Integer getPlaycnt() {
        return playcnt;
    }

    public void setPlaycnt(Integer playcnt) {
        this.playcnt = playcnt;
    }

    public Integer getFlowercnt() {
        return flowercnt;
    }

    public void setFlowercnt(Integer flowercnt) {
        this.flowercnt = flowercnt;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

 

    public Timestamp getLoadtime() {
		return loadtime;
	}

	public void setLoadtime(Timestamp loadtime) {
		this.loadtime = loadtime;
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}