package com.huiting.manage.dto.common;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.huiting.manage.dto.base.CcDepPositionBaseDto;
import com.huiting.manage.dto.base.CcDepartmentBaseDto;
import com.huiting.manage.dto.base.CcUserBaseDto;
import com.huiting.manage.dto.base.CdCompanyBaseDto;
/**
 * 
* @ClassName: CcUserDto 
* @Description: 
* @author Zou_ZhuoQi
* @date 2013-12-20 下午4:35:59 
*
 */
@Alias("ccUserDto")
public class CcUserDto extends CcUserBaseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	/**归属机构*/
	private CdCompanyBaseDto cdCompanyBaseDto;
	/**部门码表*/
	private CcDepartmentBaseDto ccDepartmentBaseDto;
	/**部门岗位*/
	private CcDepPositionBaseDto ccDepPositionBaseDto;
//	private 
	
	
	
	public CdCompanyBaseDto getCdCompanyBaseDto() {
		return cdCompanyBaseDto;
	}
	public void setCdCompanyBaseDto(CdCompanyBaseDto cdCompanyBaseDto) {
		this.cdCompanyBaseDto = cdCompanyBaseDto;
	}
	public CcDepartmentBaseDto getCcDepartmentBaseDto() {
		return ccDepartmentBaseDto;
	}
	public void setCcDepartmentBaseDto(CcDepartmentBaseDto ccDepartmentBaseDto) {
		this.ccDepartmentBaseDto = ccDepartmentBaseDto;
	}
	public CcDepPositionBaseDto getCcDepPositionBaseDto() {
		return ccDepPositionBaseDto;
	}
	public void setCcDepPositionBaseDto(CcDepPositionBaseDto ccDepPositionBaseDto) {
		this.ccDepPositionBaseDto = ccDepPositionBaseDto;
	}
	
}
