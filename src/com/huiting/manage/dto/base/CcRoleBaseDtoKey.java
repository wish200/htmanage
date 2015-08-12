package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcRoleBaseDtoKey
 * @Description: CC_ROLE 主键
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:33:32
 * 
 */
@Alias("ccRoleBaseDtoKey")
public class CcRoleBaseDtoKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private String rolecode;

	private String rolename;

	private String powercodeMenu;

	private String classcode;

	private String powercodeIndex;

	public String getRolecode() {
		return rolecode;
	}

	public void setRolecode(String rolecode) {
		this.rolecode = rolecode == null ? null : rolecode.trim();
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename == null ? null : rolename.trim();
	}

	public String getPowercodeMenu() {
		return powercodeMenu;
	}

	public void setPowercodeMenu(String powercodeMenu) {
		this.powercodeMenu = powercodeMenu == null ? null : powercodeMenu
				.trim();
	}

	public String getClasscode() {
		return classcode;
	}

	public void setClasscode(String classcode) {
		this.classcode = classcode == null ? null : classcode.trim();
	}

	public String getPowercodeIndex() {
		return powercodeIndex;
	}

	public void setPowercodeIndex(String powercodeIndex) {
		this.powercodeIndex = powercodeIndex == null ? null : powercodeIndex
				.trim();
	}
}