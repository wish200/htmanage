package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcUserBaseDto
 * @Description: CC_USER
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:34:00
 * 
 */
@Alias("ccUserBaseDto")
public class CcUserBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String validstatus;

	private String usercode;

	private String remark;

	private String password;

	private Date inputdate;

	private String flag;

	private String username;

	private String comcode;

	private String email;

	private String riskremark;

	private String department;

	private String deppositioncode;

	private String newdepcode;
	private int logintimes;
	
	public int getLogintimes() {
		return logintimes;
	}

	public void setLogintimes(int logintimes) {
		this.logintimes = logintimes;
	}

	public String getValidstatus() {
		return validstatus;
	}

	public void setValidstatus(String validstatus) {
		this.validstatus = validstatus == null ? null : validstatus.trim();
	}

	public String getUsercode() {
		return usercode== null ? null : usercode.trim();
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode == null ? null : usercode.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Date getInputdate() {
		return inputdate;
	}

	public void setInputdate(Date inputdate) {
		this.inputdate = inputdate;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag == null ? null : flag.trim();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getComcode() {
		return comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode == null ? null : comcode.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getRiskremark() {
		return riskremark;
	}

	public void setRiskremark(String riskremark) {
		this.riskremark = riskremark == null ? null : riskremark.trim();
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department == null ? null : department.trim();
	}

	public String getDeppositioncode() {
		return deppositioncode;
	}

	public void setDeppositioncode(String deppositioncode) {
		this.deppositioncode = deppositioncode == null ? null : deppositioncode
				.trim();
	}

	public String getNewdepcode() {
		return newdepcode;
	}

	public void setNewdepcode(String newdepcode) {
		this.newdepcode = newdepcode == null ? null : newdepcode.trim();
	}
}