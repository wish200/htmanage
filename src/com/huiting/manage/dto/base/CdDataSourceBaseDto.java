package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
@Alias("cdDataSourceBaseDto")
public class CdDataSourceBaseDto implements Serializable {
	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
	private String datasourcecode;
	private String datasourcename;
	public String getDatasourcecode() {
		return datasourcecode;
	}
	public void setDatasourcecode(String datasourcecode) {
		this.datasourcecode = datasourcecode;
	}
	public String getDatasourcename() {
		return datasourcename;
	}
	public void setDatasourcename(String datasourcename) {
		this.datasourcename = datasourcename;
	}
	
}
