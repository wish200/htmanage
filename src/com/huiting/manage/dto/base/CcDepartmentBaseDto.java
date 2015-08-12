package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcDepartmentBaseDto
 * @Description: CC_DEPARTMENT
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:30:43
 * 
 */
@Alias("ccDepartmentBaseDto")
public class CcDepartmentBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String depname;

	private String depcatg;

	private Date createtime;

	private String remark;
	private String comcode;

	private String importlev;

	private String validstate;

	private String createusercode;

	private String newdepcode;

	private String depkindcode;

	private String depkindname;

	public String getDepname() {
		return depname;
	}
	public String getComcode() {
		return comcode;
	}
	public void setComcode(String comcode) {
		this.comcode = comcode;
	}
	public void setDepname(String depname) {
		this.depname = depname == null ? null : depname.trim();
	}
	public String getDepcatg() {
		return depcatg;
	}
	public void setDepcatg(String depcatg) {
		this.depcatg = depcatg == null ? null : depcatg.trim();
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
	public String getNewdepcode() {
		return newdepcode;
	}
	public void setNewdepcode(String newdepcode) {
		this.newdepcode = newdepcode == null ? null : newdepcode.trim();
	}
	public String getDepkindcode() {
		return depkindcode;
	}
	public void setDepkindcode(String depkindcode) {
		this.depkindcode = depkindcode == null ? null : depkindcode.trim();
	}
	public String getDepkindname() {
		return depkindname;
	}
	public void setDepkindname(String depkindname) {
		this.depkindname = depkindname == null ? null : depkindname.trim();
	}
}