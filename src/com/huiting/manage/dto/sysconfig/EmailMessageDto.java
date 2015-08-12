package com.huiting.manage.dto.sysconfig;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("emailMessageDto")
public class EmailMessageDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String headoftempl;//邮件标题
	private String bodyoftempl;//邮件内容
	private String newdepcode;//邮件归属部门
	private String templatenum;//邮件模型
	private String bccs;//抄送人
	private String stcs;//接收人
	private String statdate;//数据期次
	public String getHeadoftempl() {
		return headoftempl;
	}
	public void setHeadoftempl(String headoftempl) {
		this.headoftempl = headoftempl;
	}
	public String getBodyoftempl() {
		return bodyoftempl==null?null:bodyoftempl.replaceAll("\\？", "");
	}
	public void setBodyoftempl(String bodyoftempl) {
		this.bodyoftempl = bodyoftempl;
	}
	public String getNewdepcode() {
		return newdepcode;
	}
	public void setNewdepcode(String newdepcode) {
		this.newdepcode = newdepcode;
	}
	public String getTemplatenum() {
		return templatenum;
	}
	public void setTemplatenum(String templatenum) {
		this.templatenum = templatenum;
	}
	public String getBccs() {
		return bccs;
	}
	public void setBccs(String bccs) {
		this.bccs = bccs;
	}
	public String getStcs() {
		return stcs;
	}
	public void setStcs(String stcs) {
		this.stcs = stcs;
	}
	public String getStatdate() {
		return statdate;
	}
	public void setStatdate(String statdate) {
		this.statdate = statdate;
	}
}
