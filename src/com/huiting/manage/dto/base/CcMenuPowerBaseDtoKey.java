package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcMenuPowerBaseDtoKey
 * @Description: CC_MENUPOWER 主键
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:33:00
 * 
 */
@Alias("ccMenuPowerBaseDtoKey")
public class CcMenuPowerBaseDtoKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private String powercode;

	private String powername;

	private String menuid;

	public String getPowercode() {
		return powercode;
	}

	public void setPowercode(String powercode) {
		this.powercode = powercode == null ? null : powercode.trim();
	}

	public String getPowername() {
		return powername;
	}

	public void setPowername(String powername) {
		this.powername = powername == null ? null : powername.trim();
	}

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid == null ? null : menuid.trim();
	}
}