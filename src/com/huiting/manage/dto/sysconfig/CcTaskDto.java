package com.huiting.manage.dto.sysconfig;

import org.apache.ibatis.type.Alias;

import com.huiting.manage.dto.base.CcTaskBaseDto;
import com.huiting.manage.dto.base.CcTaskModuleBaseDto;
/**
  * @ClassName: CcTaskDto
  * @Description: cc_task 扩展
  * @author: zhangyangyang
  * @date 2014-2-20 下午1:36:18
 */
@Alias("ccTaskDto")
public class CcTaskDto extends CcTaskBaseDto{

	private static final long serialVersionUID = 1L;

	private CcTaskModuleBaseDto ccTaskModuleBaseDto;

	public CcTaskModuleBaseDto getCcTaskModuleBaseDto() {
		return ccTaskModuleBaseDto;
	}

	public void setCcTaskModuleBaseDto(CcTaskModuleBaseDto ccTaskModuleBaseDto) {
		this.ccTaskModuleBaseDto = ccTaskModuleBaseDto;
	}
	
	
}
