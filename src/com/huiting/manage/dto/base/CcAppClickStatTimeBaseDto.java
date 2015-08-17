package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcAppClickStatTimeBaseDto
 * @Description: CC_APPCLICKSTATTIME
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:30:12
 * 
 */
@Alias("ccAppClickStatTimeBaseDto")
public class CcAppClickStatTimeBaseDto extends CcAppClickStatTimeBaseDtoKey
		implements Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal moduleid;

	private Date logouttime;

	private Date operatortime;

	private String sessionid;

	private String flag;

	private String remark;

	public BigDecimal getModuleid() {
		return moduleid;
	}

	public void setModuleid(BigDecimal moduleid) {
		this.moduleid = moduleid;
	}

	public Date getLogouttime() {
		return logouttime;
	}

	public void setLogouttime(Date logouttime) {
		this.logouttime = logouttime;
	}

	public Date getOperatortime() {
		return operatortime;
	}

	public void setOperatortime(Date operatortime) {
		this.operatortime = operatortime;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid == null ? null : sessionid.trim();
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag == null ? null : flag.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}