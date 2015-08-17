package com.huiting.manage.dto.sysconfig;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.huiting.manage.dto.base.CdEmailTemplateBaseDto;
/*邮件模板DTO
 * 
 */
@Alias("cdEmailTemplateDto")
public class CdEmailTemplateDto extends CdEmailTemplateBaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CdEmailRecDtoBase> CdEmailRecDtoBases;
	public List<CdEmailRecDtoBase> getCdEmailRecDtoBases() {
		return CdEmailRecDtoBases;
	}
	public void setCdEmailRecDtoBases(List<CdEmailRecDtoBase> cdEmailRecDtoBases) {
		CdEmailRecDtoBases = cdEmailRecDtoBases;
	}
	
	
	

}
