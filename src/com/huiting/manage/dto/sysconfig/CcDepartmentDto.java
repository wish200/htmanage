package com.huiting.manage.dto.sysconfig;

import org.apache.ibatis.type.Alias;

import com.huiting.manage.dto.base.CcDepartmentBaseDto;
@Alias("ccDepartmentDto")
public class CcDepartmentDto extends CcDepartmentBaseDto{

	private static final long serialVersionUID = 1L;
	/**是否勾选过*/
	private String checked;
	private String comName;
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	
}
