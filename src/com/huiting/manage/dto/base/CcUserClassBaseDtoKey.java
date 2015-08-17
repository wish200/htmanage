package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcUserClassBaseDtoKey
 * @Description: CC_USERCLASS 主键
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:34:17
 * 
 */
@Alias("ccUserClassBaseDtoKey")
public class CcUserClassBaseDtoKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private String usercode;

	private String classcode;

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode == null ? null : usercode.trim();
	}

	public String getClasscode() {
		return classcode;
	}

	public void setClasscode(String classcode) {
		this.classcode = classcode == null ? null : classcode.trim();
	}
}