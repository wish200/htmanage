package com.huiting.manage.dto.base;

import org.apache.ibatis.type.Alias;
/**
 * 邮件发送历史历史记录人员表
 * @author ncp
 *
 */
@Alias("ccMailReceiverBaseDto")
public class CcMailReceiverBaseDto {
    private String mailid;

    private String senderid;
    private String username;

    private String usertype;


    public String getMailid() {
        return mailid;
    }

    public void setMailid(String mailid) {
        this.mailid = mailid == null ? null : mailid.trim();
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid == null ? null : senderid.trim();
    }

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}