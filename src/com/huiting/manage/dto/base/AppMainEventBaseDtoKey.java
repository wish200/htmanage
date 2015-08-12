package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
 * 
 * @ClassName: AppMainEventBaseDto
 * @Description: APP_MAINEVENT主键
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:29:54
 * 
 */
@Alias("appMainEventBaseDtoKey")
public class AppMainEventBaseDtoKey implements Serializable{
	private static final long serialVersionUID = 1L;

	private String eventname;

    private String comname;

    private String infosource;

    private String submittor;

    private Date subtime;

    private String accurtime;

    private String eventno;

    private Date updatetime;
    
    

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname == null ? null : eventname.trim();
    }

	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	public String getInfosource() {
        return infosource;
    }

    public void setInfosource(String infosource) {
        this.infosource = infosource == null ? null : infosource.trim();
    }

    public String getSubmittor() {
        return submittor;
    }

    public void setSubmittor(String submittor) {
        this.submittor = submittor == null ? null : submittor.trim();
    }

    public Date getSubtime() {
        return subtime;
    }

    public void setSubtime(Date subtime) {
        this.subtime = subtime;
    }

    public String getAccurtime() {
        return accurtime;
    }

    public void setAccurtime(String accurtime) {
        this.accurtime = accurtime == null ? null : accurtime.trim();
    }

    public String getEventno() {
        return eventno;
    }

    public void setEventno(String eventno) {
        this.eventno = eventno == null ? null : eventno.trim();
    }
}