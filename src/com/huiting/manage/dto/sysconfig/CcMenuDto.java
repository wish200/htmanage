/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huiting.manage.dto.sysconfig;

import com.huiting.manage.dto.base.CcMenuBaseDto;
import org.apache.ibatis.type.Alias;

/**
 *
 * @author Administrator
 */
@Alias("ccMenuDto")
public class CcMenuDto extends CcMenuBaseDto {
    
	private static final long serialVersionUID = 1L;
	/**是否勾选*/
	private String checked;
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
}
