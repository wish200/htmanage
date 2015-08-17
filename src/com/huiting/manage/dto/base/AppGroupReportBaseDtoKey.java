package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: AppGroupReportBaseDtoKey
 * @Description:APP_GROUPREPORT 主键
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:29:35
 * 
 */
@Alias("appGroupReportBaseDtoKey")
public class AppGroupReportBaseDtoKey implements Serializable {

	private static final long serialVersionUID = 1L;

	private String reportcode;

	private String indexcode;

	public String getReportcode() {
		return reportcode;
	}

	public void setReportcode(String reportcode) {
		this.reportcode = reportcode == null ? null : reportcode.trim();
	}

	public String getIndexcode() {
		return indexcode;
	}

	public void setIndexcode(String indexcode) {
		this.indexcode = indexcode == null ? null : indexcode.trim();
	}
}