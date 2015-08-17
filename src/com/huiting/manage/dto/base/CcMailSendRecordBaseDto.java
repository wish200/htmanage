package com.huiting.manage.dto.base;

import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
 * 邮件发送历史记录表
 * @author ncp
 *
 */
@Alias("ccMailSendRecordBaseDto")
public class CcMailSendRecordBaseDto {
    private String modtype;

    private String emaildetail;

    private String mailid;

    private String attadress;

    private String comcode;

    private String department;

    private String sendperson;

    private Date senddate;

    private String emailthe;


    public String getModtype() {
		return modtype;
	}

	public void setModtype(String modtype) {
		this.modtype = modtype;
	}
	

	public String getEmaildetail() {
        return emaildetail==null?null:emaildetail.trim().replaceAll("\\？", "");
    }

    public void setEmaildetail(String emaildetail) {
        this.emaildetail = emaildetail == null ? null : emaildetail.trim().replaceAll("\\？", "");
    }
	public String getMailid() {
        return mailid;
    }

    public void setMailid(String mailid) {
        this.mailid = mailid == null ? null : mailid.trim();
    }

    public String getAttadress() {
        return attadress;
    }

    public void setAttadress(String attadress) {
        this.attadress = attadress == null ? null : attadress.trim();
    }

    public String getComcode() {
        return comcode;
    }

    public void setComcode(String comcode) {
        this.comcode = comcode == null ? null : comcode.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getSendperson() {
        return sendperson;
    }

    public void setSendperson(String sendperson) {
        this.sendperson = sendperson == null ? null : sendperson.trim();
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }

    public String getEmailthe() {
        return emailthe;
    }

    public void setEmailthe(String emailthe) {
        this.emailthe = emailthe == null ? null : emailthe.trim();
    }
}