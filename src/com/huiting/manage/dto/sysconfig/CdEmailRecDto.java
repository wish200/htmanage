package com.huiting.manage.dto.sysconfig;

import org.apache.ibatis.type.Alias;

import com.huiting.manage.dto.base.CdEmailRecBaseDto;
import com.huiting.manage.dto.base.CdEmailTemplateBaseDto;
import com.huiting.manage.dto.common.CcUserDto;

/**
 * 
* @ClassName: CdEmailRecDto
* @Description:  邮件模板接受人表CD_EMAIL_REC(扩展)
* @author ZhangYangYang
* @date 2013-12-23 下午02:14:34
 */
@Alias("cdEmailRecDto")
public class CdEmailRecDto extends CdEmailRecBaseDto{
	private static final long serialVersionUID = 1L;

	/** 用户信息 **/
	private CcUserDto ccUserDto;
	/** 邮件模板类型 **/
	private CdEmailTemplateBaseDto cdEmailTemplateBaseDto;
	
	public CdEmailTemplateBaseDto getCdEmailTemplateBaseDto() {
		return cdEmailTemplateBaseDto;
	}


	public void setCdEmailTemplateBaseDto(
			CdEmailTemplateBaseDto cdEmailTemplateBaseDto) {
		this.cdEmailTemplateBaseDto = cdEmailTemplateBaseDto;
	}
	public CcUserDto getCcUserDto() {
		return ccUserDto;
	}

	public void setCcUserDto(CcUserDto ccUserDto) {
		this.ccUserDto = ccUserDto;
	}
	
}
