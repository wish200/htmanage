package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CdClassBaseDto
 * @Description:CD_CLASS
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:35:10
 * 
 */
@Alias("cdClassBaseDto")
public class CdClassBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String classcode;

	private String classname;

	private String fathercode;

	private String levelcode;

	private String remark;

	public String getClasscode() {
		return classcode;
	}

	public void setClasscode(String classcode) {
		this.classcode = classcode == null ? null : classcode.trim();
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname == null ? null : classname.trim();
	}

	public String getFathercode() {
		return fathercode;
	}

	public void setFathercode(String fathercode) {
		this.fathercode = fathercode == null ? null : fathercode.trim();
	}

	public String getLevelcode() {
		return levelcode;
	}

	public void setLevelcode(String levelcode) {
		this.levelcode = levelcode == null ? null : levelcode.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}