package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcDepIndexBaseDto
 * @Description: CC_DEPINDEX
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:30:55
 * 
 */
@Alias("ccDepIndexBaseDto")
public class CcDepIndexBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String indexcode;

	private String validstate;

	private String createusercode;

	private Date createtime;

	private String importlev;

	private String remark;

	private String department;

	public String getIndexcode() {
		return indexcode;
	}

	public void setIndexcode(String indexcode) {
		this.indexcode = indexcode == null ? null : indexcode.trim();
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