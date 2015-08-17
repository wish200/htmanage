package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/***
 * 
 * @ClassName: CdRegFactorReportBaseDto
 * @Description: CD_REGFACTOR_REPORT
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:38:22
 * 
 */
@Alias("cdRegFactorReportBaseDto")
public class CdRegFactorReportBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date filldate;

	private String fillercode;

	private String maindepment;

	private BigDecimal facvalue;

	public Date getFilldate() {
		return filldate;
	}

	public void setFilldate(Date filldate) {
		this.filldate = filldate;
	}

	public String getFillercode() {
		return fillercode;
	}

	public void setFillercode(String fillercode) {
		this.fillercode = fillercode == null ? null : fillercode.trim();
	}

	public String getMaindepment() {
		return maindepment;
	}

	public void setMaindepment(String maindepment) {
		this.maindepment = maindepment == null ? null : maindepment.trim();
	}

	public BigDecimal getFacvalue() {
		return facvalue;
	}

	public void setFacvalue(BigDecimal facvalue) {
		this.facvalue = facvalue;
	}
}