package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CdIdxRangsHisBaseDto
 * @Description: CD_IDXRANGS_HIS
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:39:39
 * 
 */
@Alias("cdIdxRangsHisBaseDto")
public class CdIdxRangsHisBaseDto extends CdIdxRangsHisBaseDtoKey implements
		Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal rl1;

	private BigDecimal yl1;

	private BigDecimal yh1;

	private BigDecimal gl1;

	private BigDecimal rh1;

	private BigDecimal gh1;

	private BigDecimal rl2;

	private BigDecimal rh2;

	private BigDecimal yl2;

	private BigDecimal yh2;

	private BigDecimal gl2;

	private BigDecimal gh2;

	private String vptaccord;

	private String rremark;

	private String yremark;

	private String gremark;

	private String rwarning;

	private String ywarning;

	private String gwarning;

	private Date passtime;

	private String rlf1;

	private String rhf1;

	private String glf1;

	private String ghf1;

	private String yhf1;

	private String ylf1;

	private String rlf2;

	private String rhf2;

	private String glf2;

	private String ghf2;

	private String ylf2;

	private String yhf2;

	private String isvalidate;
	
	public BigDecimal getRl1() {
		return rl1;
	}

	public void setRl1(BigDecimal rl1) {
		this.rl1 = rl1;
	}

	public BigDecimal getYl1() {
		return yl1;
	}

	public void setYl1(BigDecimal yl1) {
		this.yl1 = yl1;
	}

	public BigDecimal getYh1() {
		return yh1;
	}

	public void setYh1(BigDecimal yh1) {
		this.yh1 = yh1;
	}

	public BigDecimal getGl1() {
		return gl1;
	}

	public void setGl1(BigDecimal gl1) {
		this.gl1 = gl1;
	}

	public BigDecimal getRh1() {
		return rh1;
	}

	public void setRh1(BigDecimal rh1) {
		this.rh1 = rh1;
	}

	public BigDecimal getGh1() {
		return gh1;
	}

	public void setGh1(BigDecimal gh1) {
		this.gh1 = gh1;
	}

	public BigDecimal getRl2() {
		return rl2;
	}

	public void setRl2(BigDecimal rl2) {
		this.rl2 = rl2;
	}

	public BigDecimal getRh2() {
		return rh2;
	}

	public void setRh2(BigDecimal rh2) {
		this.rh2 = rh2;
	}

	public BigDecimal getYl2() {
		return yl2;
	}

	public void setYl2(BigDecimal yl2) {
		this.yl2 = yl2;
	}

	public BigDecimal getYh2() {
		return yh2;
	}

	public void setYh2(BigDecimal yh2) {
		this.yh2 = yh2;
	}

	public BigDecimal getGl2() {
		return gl2;
	}

	public void setGl2(BigDecimal gl2) {
		this.gl2 = gl2;
	}

	public BigDecimal getGh2() {
		return gh2;
	}

	public void setGh2(BigDecimal gh2) {
		this.gh2 = gh2;
	}

	public String getVptaccord() {
		return vptaccord;
	}

	public void setVptaccord(String vptaccord) {
		this.vptaccord = vptaccord == null ? null : vptaccord.trim();
	}

	public String getRremark() {
		return rremark;
	}

	public void setRremark(String rremark) {
		this.rremark = rremark == null ? null : rremark.trim();
	}

	public String getYremark() {
		return yremark;
	}

	public void setYremark(String yremark) {
		this.yremark = yremark == null ? null : yremark.trim();
	}

	public String getGremark() {
		return gremark;
	}

	public void setGremark(String gremark) {
		this.gremark = gremark == null ? null : gremark.trim();
	}

	public String getRwarning() {
		return rwarning;
	}

	public void setRwarning(String rwarning) {
		this.rwarning = rwarning == null ? null : rwarning.trim();
	}

	public String getYwarning() {
		return ywarning;
	}

	public void setYwarning(String ywarning) {
		this.ywarning = ywarning == null ? null : ywarning.trim();
	}

	public String getGwarning() {
		return gwarning;
	}

	public void setGwarning(String gwarning) {
		this.gwarning = gwarning == null ? null : gwarning.trim();
	}

	public Date getPasstime() {
		return passtime;
	}

	public void setPasstime(Date passtime) {
		this.passtime = passtime;
	}

	public String getRlf1() {
		return rlf1;
	}

	public void setRlf1(String rlf1) {
		this.rlf1 = rlf1 == null ? null : rlf1.trim();
	}

	public String getRhf1() {
		return rhf1;
	}

	public void setRhf1(String rhf1) {
		this.rhf1 = rhf1 == null ? null : rhf1.trim();
	}

	public String getGlf1() {
		return glf1;
	}

	public void setGlf1(String glf1) {
		this.glf1 = glf1 == null ? null : glf1.trim();
	}

	public String getGhf1() {
		return ghf1;
	}

	public void setGhf1(String ghf1) {
		this.ghf1 = ghf1 == null ? null : ghf1.trim();
	}

	public String getYhf1() {
		return yhf1;
	}

	public void setYhf1(String yhf1) {
		this.yhf1 = yhf1 == null ? null : yhf1.trim();
	}

	public String getYlf1() {
		return ylf1;
	}

	public void setYlf1(String ylf1) {
		this.ylf1 = ylf1 == null ? null : ylf1.trim();
	}

	public String getRlf2() {
		return rlf2;
	}

	public void setRlf2(String rlf2) {
		this.rlf2 = rlf2 == null ? null : rlf2.trim();
	}

	public String getRhf2() {
		return rhf2;
	}

	public void setRhf2(String rhf2) {
		this.rhf2 = rhf2 == null ? null : rhf2.trim();
	}

	public String getGlf2() {
		return glf2;
	}

	public void setGlf2(String glf2) {
		this.glf2 = glf2 == null ? null : glf2.trim();
	}

	public String getGhf2() {
		return ghf2;
	}

	public void setGhf2(String ghf2) {
		this.ghf2 = ghf2 == null ? null : ghf2.trim();
	}

	public String getYlf2() {
		return ylf2;
	}

	public void setYlf2(String ylf2) {
		this.ylf2 = ylf2 == null ? null : ylf2.trim();
	}

	public String getYhf2() {
		return yhf2;
	}

	public void setYhf2(String yhf2) {
		this.yhf2 = yhf2 == null ? null : yhf2.trim();
	}

	public String getIsvalidate() {
		return isvalidate;
	}

	public void setIsvalidate(String isvalidate) {
		this.isvalidate = isvalidate;
	}
	
}