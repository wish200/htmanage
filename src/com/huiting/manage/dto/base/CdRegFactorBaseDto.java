package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CdRegFactorBaseDto
 * @Description: CD_REGFACTOR
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:38:53
 * 
 */
@Alias("cdRegFactorBaseDto")
public class CdRegFactorBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String maindepment;

	private String faccode;

	private String facname;

	private String factordesc;

	public String getMaindepment() {
		return maindepment;
	}

	public void setMaindepment(String maindepment) {
		this.maindepment = maindepment == null ? null : maindepment.trim();
	}

	public String getFaccode() {
		return faccode;
	}

	public void setFaccode(String faccode) {
		this.faccode = faccode == null ? null : faccode.trim();
	}

	public String getFacname() {
		return facname;
	}

	public void setFacname(String facname) {
		this.facname = facname == null ? null : facname.trim();
	}

	public String getFactordesc() {
		return factordesc;
	}

	public void setFactordesc(String factordesc) {
		this.factordesc = factordesc == null ? null : factordesc.trim();
	}
}