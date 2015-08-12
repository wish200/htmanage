package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CdEmailTemplateBaseDto
 * @Description:CD_EMAIL_TEMPLATE
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:40:42
 * 
 */
@Alias("cdEmailTemplateBaseDto")
public class CdEmailTemplateBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String templatenum;

	private String headoftempl;

	private String endoftempl;

	private String signoftempl;

	private Date createtime;

	private String validstate;

	private String createusercode;

	private String templatename;

	private String remark;

	private String templatecatno;

	private String moduleid;

	private String modulename;

	private String templatecatname;

	private String comcode;

	private String bodyoftempl;

	public String getTemplatenum() {
		return templatenum;
	}

	public void setTemplatenum(String templatenum) {
		this.templatenum = templatenum == null ? null : templatenum.trim();
	}

	public String getHeadoftempl() {
		return headoftempl;
	}

	public void setHeadoftempl(String headoftempl) {
		this.headoftempl = headoftempl == null ? null : headoftempl.trim();
	}

	public String getEndoftempl() {
		return endoftempl;
	}

	public void setEndoftempl(String endoftempl) {
		this.endoftempl = endoftempl == null ? null : endoftempl.trim();
	}

	public String getSignoftempl() {
		return signoftempl;
	}

	public void setSignoftempl(String signoftempl) {
		this.signoftempl = signoftempl == null ? null : signoftempl.trim();
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getValidstate() {
		return validstate;
	}

	public void setValidstate(String validstate) {
		this.validstate = validstate == null ? null : validstate.trim();
	}

	public String getCreateusercode() {
		return createusercode;
	}

	public void setCreateusercode(String createusercode) {
		this.createusercode = createusercode == null ? null : createusercode
				.trim();
	}

	public String getTemplatename() {
		return templatename;
	}

	public void setTemplatename(String templatename) {
		this.templatename = templatename == null ? null : templatename.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getTemplatecatno() {
		return templatecatno;
	}

	public void setTemplatecatno(String templatecatno) {
		this.templatecatno = templatecatno == null ? null : templatecatno
				.trim();
	}

	public String getModuleid() {
		return moduleid;
	}

	public void setModuleid(String moduleid) {
		this.moduleid = moduleid == null ? null : moduleid.trim();
	}

	public String getModulename() {
		return modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename == null ? null : modulename.trim();
	}

	public String getTemplatecatname() {
		return templatecatname;
	}

	public void setTemplatecatname(String templatecatname) {
		this.templatecatname = templatecatname == null ? null : templatecatname
				.trim();
	}

	public String getComcode() {
		return comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode == null ? null : comcode.trim();
	}
	public String getBodyoftemplRe() {
		return bodyoftempl==null?null:bodyoftempl.replaceAll("&", "&amp").replaceAll("<", "&lt").replaceAll(">", "&gt");
	}
	public String getBodyoftempl() {
		return bodyoftempl;
	}

	public void setBodyoftempl(String bodyoftempl) {
		this.bodyoftempl = bodyoftempl == null ? null : bodyoftempl.trim();
	}
}