package com.huiting.manage.dto.sysconfig;

import org.apache.ibatis.type.Alias;

import com.huiting.manage.dto.base.CcDepPositionBaseDto;
/**
 * 
* @ClassName: CcDepPositionDto
* @Description: 部门岗位表 扩展
* @author ZhangYangYang
* @date 2013-12-27 下午06:25:07
 */
@Alias("ccDepPositionDto")
public class CcDepPositionDto extends CcDepPositionBaseDto{
	
	private static final long serialVersionUID = 1L;

	/** 部门代码表 */
	private CcDepartmentDto ccDepartmentDto;

	public CcDepartmentDto getCcDepartmentDto() {
		return ccDepartmentDto;
	}

	public void setCcDepartmentDto(CcDepartmentDto ccDepartmentDto) {
		this.ccDepartmentDto = ccDepartmentDto;
	} 
	
}
