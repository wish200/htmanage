package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcAppClickStatTimeBaseDtoKey
 * @Description: CC_APPCLICKSTATTIME 主键
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:30:24
 * 
 */
@Alias("ccAppClickStatTimeBaseDtoKey")
public class CcAppClickStatTimeBaseDtoKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private String usercode;

	private Date logintime;

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode == null ? null : usercode.trim();
	}

	public Date getLogintime() {
		return logintime;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}
}