package com.huiting.manage.dto.sysconfig;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.huiting.manage.dto.base.CcMailReceiverBaseDto;
import com.huiting.manage.dto.base.CcMailSendRecordBaseDto;
/**
 * 邮件发送历史记录表
 * @author ncp
 *
 */
@Alias("ccMailSendRecordDto")
public class CcMailSendRecordDto extends CcMailSendRecordBaseDto {
	private String moduleName;//模块名称
	private String functionName;//功能名称
	private String comName;//机构名称
	private String depName;//部门名称
	
	private List<CcMailReceiverBaseDto> ccMailReceiverBaseDtos;
	
	
	
	
	
	
	
	
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public List<CcMailReceiverBaseDto> getCcMailReceiverBaseDtos() {
		return ccMailReceiverBaseDtos;
	}
	public void setCcMailReceiverBaseDtos(
			List<CcMailReceiverBaseDto> ccMailReceiverBaseDtos) {
		this.ccMailReceiverBaseDtos = ccMailReceiverBaseDtos;
	}
}
