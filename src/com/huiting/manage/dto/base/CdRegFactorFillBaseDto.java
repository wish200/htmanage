package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CdRegFactorFillBaseDto
 * @Description: CD_REGFACTOR_FILL
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:38:30
 * 
 */
@Alias("cdRegFactorFillBaseDto")
public class CdRegFactorFillBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date filldate;

	private String fillercode;

	private String fillercom;

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

	public String getFillercom() {
		return fillercom;
	}

	public void setFillercom(String fillercom) {
		this.fillercom = fillercom == null ? null : fillercom.trim();
	}

	public BigDecimal getFacvalue() {
		return facvalue;
	}

	public void setFacvalue(BigDecimal facvalue) {
		this.facvalue = facvalue;
	}
}