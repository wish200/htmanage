package com.huiting.manage.dto.sysconfig;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.huiting.manage.dto.base.CcUserBaseDto;
import com.huiting.manage.dto.base.CdIndexBaseDto;

/**
 * 
* @ClassName: CcTimeTaskDto 
* @Description: 定时任务的dto
* @author Niu_ChunPing
* @date 2014-2-24 上午11:23:06
 */
@Alias("ccTimeTaskDto")
public class CcTimeTaskDto extends CcUserBaseDto{

	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
	private List<CdIndexBaseDto> cdIndexBaseDtos;
	public List<CdIndexBaseDto> getCdIndexBaseDtos() {
		return cdIndexBaseDtos;
	}
	public void setCdIndexBaseDtos(List<CdIndexBaseDto> cdIndexBaseDtos) {
		this.cdIndexBaseDtos = cdIndexBaseDtos;
	}
	

}
