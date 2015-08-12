package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcDivBaseDto
 * @Description: CC_DIV
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:31:17
 * 
 */
@Alias("ccDivBaseDto")
public class CcDivBaseDto extends CcDivBaseDtoKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date createtime;

	private String validstate;

	private String remark;

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getValidstate() {
		return validstate;
	}

	public void setValidstate(String validstate) {
		this.validstate = validstate == null ? null : validstate.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}