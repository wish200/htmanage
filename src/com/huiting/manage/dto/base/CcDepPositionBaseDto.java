package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcDepPositionBaseDto
 * @Description: CC_DEPPOSITION
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:31:10
 * 
 */
@Alias("ccDepPositionBaseDto")
public class CcDepPositionBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String deppositioncode;

	private String deppositionname;

	private String validstate;

	private String createusercode;

	private Date createtime;

	private String importlev;

	private String remark;

	private String department;
	
	private String deppostype;

	public String getDeppostype() {
		return deppostype;
	}

	public void setDeppostype(String deppostype) {
		this.deppostype = deppostype;
	}

	public String getDeppositioncode() {
		return deppositioncode;
	}

	public void setDeppositioncode(String deppositioncode) {
		this.deppositioncode = deppositioncode == null ? null : deppositioncode
				.trim();
	}

	public String getDeppositionname() {
		return deppositionname;
	}

	public void setDeppositionname(String deppositionname) {
		this.deppositionname = deppositionname == null ? null : deppositionname
				.trim();
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

	public String getImportlev() {
		return importlev;
	}

	public void setImportlev(String importlev) {
		this.importlev = importlev == null ? null : importlev.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department == null ? null : department.trim();
	}
}