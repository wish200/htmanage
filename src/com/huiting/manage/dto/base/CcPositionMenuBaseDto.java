package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcPositionMenuBaseDto
 * @Description: CC_POSITIONMENU
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:33:11
 * 
 */
@Alias("ccPositionMenuBaseDto")
public class CcPositionMenuBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String deppositioncode;

	private String menuid;

	private String validstate;

	private String createusercode;

	private Date createtime;

	private String remark;

	private String importlev;

	public String getDeppositioncode() {
		return deppositioncode;
	}

	public void setDeppositioncode(String deppositioncode) {
		this.deppositioncode = deppositioncode == null ? null : deppositioncode
				.trim();
	}

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid == null ? null : menuid.trim();
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

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getImportlev() {
		return importlev;
	}

	public void setImportlev(String importlev) {
		this.importlev = importlev == null ? null : importlev.trim();
	}
}