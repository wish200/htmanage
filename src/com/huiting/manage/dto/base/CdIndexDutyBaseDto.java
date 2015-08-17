package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CdIndexDutyBaseDto
 * @Description: CD_INDEXDUTY
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:39:23
 * 
 */
@Alias("cdIndexDutyBaseDto")
public class CdIndexDutyBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String indexcode;

	private String maindepment;

	private String p2acceptrole;

	private Date createtime;

	private Date valliddate;

	private Date disabledate;

	private String validstate;

	public String getIndexcode() {
		return indexcode;
	}

	public void setIndexcode(String indexcode) {
		this.indexcode = indexcode == null ? null : indexcode.trim();
	}

	public String getMaindepment() {
		return maindepment;
	}

	public void setMaindepment(String maindepment) {
		this.maindepment = maindepment == null ? null : maindepment.trim();
	}

	public String getP2acceptrole() {
		return p2acceptrole;
	}

	public void setP2acceptrole(String p2acceptrole) {
		this.p2acceptrole = p2acceptrole == null ? null : p2acceptrole.trim();
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getValliddate() {
		return valliddate;
	}

	public void setValliddate(Date valliddate) {
		this.valliddate = valliddate;
	}

	public Date getDisabledate() {
		return disabledate;
	}

	public void setDisabledate(Date disabledate) {
		this.disabledate = disabledate;
	}

	public String getValidstate() {
		return validstate;
	}

	public void setValidstate(String validstate) {
		this.validstate = validstate == null ? null : validstate.trim();
	}
}