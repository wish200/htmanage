package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcUserRoleBaseDtoKey
 * @Description: CC_USERROLE 主键
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:34:48
 * 
 */
@Alias("ccUserRoleBaseDtoKey")
public class CcUserRoleBaseDtoKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private String usercode;

	private String rolename;

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode == null ? null : usercode.trim();
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename == null ? null : rolename.trim();
	}
}