package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CdDepRelationBaseDto
 * @Description: CD_DEPRELATION
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:35:29
 * 
 */
@Alias("cdDepRelationBaseDto")
public class CdDepRelationBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String newdepcode;

	private String olddepcode;

	public String getNewdepcode() {
		return newdepcode;
	}

	public void setNewdepcode(String newdepcode) {
		this.newdepcode = newdepcode == null ? null : newdepcode.trim();
	}

	public String getOlddepcode() {
		return olddepcode;
	}

	public void setOlddepcode(String olddepcode) {
		this.olddepcode = olddepcode == null ? null : olddepcode.trim();
	}
}