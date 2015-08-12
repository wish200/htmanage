package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CdDepVir2EntBaseDto
 * @Description: CD_DEP_VIR2ENT
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:35:47
 * 
 */
@Alias("cdDepVir2EntBaseDto")
public class CdDepVir2EntBaseDto  implements Serializable {

	private static final long serialVersionUID = 1L;
	private String virtualdepartment;

	private String entitydepartment;

	public String getVirtualdepartment() {
		return virtualdepartment;
	}

	public void setVirtualdepartment(String virtualdepartment) {
		this.virtualdepartment = virtualdepartment == null ? null
				: virtualdepartment.trim();
	}

	public String getEntitydepartment() {
		return entitydepartment;
	}

	public void setEntitydepartment(String entitydepartment) {
		this.entitydepartment = entitydepartment == null ? null
				: entitydepartment.trim();
	}
}