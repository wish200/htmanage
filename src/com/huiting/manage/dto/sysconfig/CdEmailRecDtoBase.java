package com.huiting.manage.dto.sysconfig;

import org.apache.ibatis.type.Alias;

import com.huiting.manage.dto.base.CcUserBaseDto;
import com.huiting.manage.dto.base.CdEmailRecBaseDto;

/**
 * 
* @ClassName: CdEmailRecDto
* @Description:  邮件模板接受人表CD_EMAIL_REC(扩展)
* @author ZhangYangYang
* @date 2013-12-23 下午02:14:34
 */
@Alias("cdEmailRecDtoBase")
public class CdEmailRecDtoBase extends CdEmailRecBaseDto{
	private static final long serialVersionUID = 1L;
	private CcUserBaseDto ccUserBaseDto ;
	public CcUserBaseDto getCcUserBaseDto() {
		return ccUserBaseDto;
	}
	public void setCcUserBaseDto(CcUserBaseDto ccUserBaseDto) {
		this.ccUserBaseDto = ccUserBaseDto;
	}
	
	
	
}
