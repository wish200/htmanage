package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcSystemPostBaseDtoKey
 * @Description: CC_SYSTEMPOST 主键
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:33:51
 * 
 */
@Alias("ccSystemPostBaseDtoKey")
public class CcSystemPostBaseDtoKey implements Serializable {

	private static final long serialVersionUID = 1L;

	private String systemcode;


	public String getSystemcode() {
		return systemcode;
	}

	public void setSystemcode(String systemcode) {
		this.systemcode = systemcode == null ? null : systemcode.trim();
	}
}