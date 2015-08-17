package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcIndexPowerBaseDtoKey
 * @Description: CC_INDEXPOWER 主键
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:32:35
 * 
 */
@Alias("ccIndexPowerBaseDtoKey")
public class CcIndexPowerBaseDtoKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private String powercode;

	private String powername;

	private String indexcode;

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

	public String getIndexcode() {
		return indexcode;
	}

	public void setIndexcode(String indexcode) {
		this.indexcode = indexcode == null ? null : indexcode.trim();
	}
}