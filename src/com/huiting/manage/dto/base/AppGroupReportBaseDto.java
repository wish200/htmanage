package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: AppGroupReportBaseDto
 * @Description: APP_GROUPREPORT
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:23:59
 * 
 */
@Alias("appGroupReportBaseDto")
public class AppGroupReportBaseDto extends AppGroupReportBaseDtoKey implements
		Serializable {

	private static final long serialVersionUID = 1L;
	
	private String groupindcode;

	private String validstate;

	public String getGroupindcode() {
		return groupindcode;
	}

	public void setGroupindcode(String groupindcode) {
		this.groupindcode = groupindcode == null ? null : groupindcode.trim();
	}

	public String getValidstate() {
		return validstate;
	}

	public void setValidstate(String validstate) {
		this.validstate = validstate == null ? null : validstate.trim();
	}
}