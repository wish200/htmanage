package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcDivBaseDtoKey
 * @Description: CC_DIV 主键
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:31:26
 * 
 */
@Alias("ccDivBaseDtoKey")
public class CcDivBaseDtoKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private String usercode;

	private String indexcode;

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode == null ? null : usercode.trim();
	}

	public String getIndexcode() {
		return indexcode;
	}

	public void setIndexcode(String indexcode) {
		this.indexcode = indexcode == null ? null : indexcode.trim();
	}
}