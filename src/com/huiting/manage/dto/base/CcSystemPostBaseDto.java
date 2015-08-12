package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcSystemPostBaseDto
 * @Description: CC_SYSTEMPOST
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:33:42
 * 
 */
@Alias("ccSystemPostBaseDto")
public class CcSystemPostBaseDto extends CcSystemPostBaseDtoKey implements
		Serializable {

	private static final long serialVersionUID = 1L;
	private String postdesc;
	private	Date enddate;
	private Date createdate;
	private Date startdate;
	private String styleflag;

	private String isnewflag;

	private String validstatus;

	private String remark;

	private String flag;

	public String getPostdesc() {
		return postdesc;
	}

	public void setPostdesc(String postdesc) {
		this.postdesc = postdesc == null ? null : postdesc.trim();
	}

	public String getStyleflag() {
		return styleflag;
	}

	public void setStyleflag(String styleflag) {
		this.styleflag = styleflag == null ? null : styleflag.trim();
	}

	public String getIsnewflag() {
		return isnewflag;
	}

	public void setIsnewflag(String isnewflag) {
		this.isnewflag = isnewflag == null ? null : isnewflag.trim();
	}

	public String getValidstatus() {
		return validstatus;
	}

	public void setValidstatus(String validstatus) {
		this.validstatus = validstatus == null ? null : validstatus.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag == null ? null : flag.trim();
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
	
}