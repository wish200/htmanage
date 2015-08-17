package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcEmailTrackBaseDto
 * @Description: CC_EMAIL_TRACK
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:31:33
 * 
 */
@Alias("ccEmailTrackBaseDto")
public class CcEmailTrackBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String templatenum;

	private String emailthe;

	private String emailnum;

	private Date senddate;

	private String emaildetail;

	private String indexcollect;

	private String receivers;

	private String ccrecs;

	public String getTemplatenum() {
		return templatenum;
	}

	public void setTemplatenum(String templatenum) {
		this.templatenum = templatenum == null ? null : templatenum.trim();
	}

	public String getEmailthe() {
		return emailthe;
	}

	public void setEmailthe(String emailthe) {
		this.emailthe = emailthe == null ? null : emailthe.trim();
	}

	public String getEmailnum() {
		return emailnum;
	}

	public void setEmailnum(String emailnum) {
		this.emailnum = emailnum == null ? null : emailnum.trim();
	}

	public Date getSenddate() {
		return senddate;
	}

	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}

	public String getEmaildetail() {
		return emaildetail;
	}

	public void setEmaildetail(String emaildetail) {
		this.emaildetail = emaildetail;
	}

	public String getIndexcollect() {
		return indexcollect;
	}

	public void setIndexcollect(String indexcollect) {
		this.indexcollect = indexcollect;
	}

	public String getReceivers() {
		return receivers;
	}

	public void setReceivers(String receivers) {
		this.receivers = receivers;
	}

	public String getCcrecs() {
		return ccrecs;
	}

	public void setCcrecs(String ccrecs) {
		this.ccrecs = ccrecs;
	}

}