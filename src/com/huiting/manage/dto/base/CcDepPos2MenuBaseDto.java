package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcDepPos2MenuBaseDto
 * @Description: CC_DEP_POS2MENU
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:31:02
 * 
 */
@Alias("ccDepPos2MenuBaseDto")
public class CcDepPos2MenuBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String deppositioncode;

	private String menuid;

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
}