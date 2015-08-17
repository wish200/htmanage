package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CdFactorBaseDto
 * @Description: CD_FACTOR
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:40:29
 * 
 */
@Alias("cdFactorBaseDto")
public class CdFactorBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String faccode;

	private String facname;

	private String fetchrate;

	private String fisclass;

	private String fiscompany;

	private String fischannel;

	private String inputdep;

	private String useview;

	private String usegroup;

	private String usesupervise;

	private String groupcode;

	private String supervisecode;

	private String curm;

	private String curt;

	private String curq;

	private String cury;

	private String rb12;

	private String datafromtype;

	private String datafrom;
    
	private String idxcatgorycode;
	private String facdesc;
	private String indtype;
	

	public String getFacdesc() {
		return facdesc;
	}

	public void setFacdesc(String facdesc) {
		this.facdesc = facdesc;
	}

	public String getIdxcatgorycode() {
		return idxcatgorycode;
	}

	public void setIdxcatgorycode(String idxcatgorycode) {
		this.idxcatgorycode = idxcatgorycode;
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

	public String getFetchrate() {
		return fetchrate;
	}

	public void setFetchrate(String fetchrate) {
		this.fetchrate = fetchrate == null ? null : fetchrate.trim();
	}

	
	public String getInputdep() {
		return inputdep;
	}

	public void setInputdep(String inputdep) {
		this.inputdep = inputdep == null ? null : inputdep.trim();
	}

	public String getUseview() {
		return useview;
	}

	public void setUseview(String useview) {
		this.useview = useview == null ? null : useview.trim();
	}

	public String getUsegroup() {
		return usegroup;
	}

	public void setUsegroup(String usegroup) {
		this.usegroup = usegroup == null ? null : usegroup.trim();
	}

	public String getFisclass() {
		return fisclass;
	}

	public void setFisclass(String fisclass) {
		this.fisclass = fisclass;
	}

	public String getFiscompany() {
		return fiscompany;
	}

	public void setFiscompany(String fiscompany) {
		this.fiscompany = fiscompany;
	}

	public String getFischannel() {
		return fischannel;
	}

	public void setFischannel(String fischannel) {
		this.fischannel = fischannel;
	}

	public String getUsesupervise() {
		return usesupervise;
	}

	public void setUsesupervise(String usesupervise) {
		this.usesupervise = usesupervise == null ? null : usesupervise.trim();
	}

	public String getGroupcode() {
		return groupcode;
	}

	public void setGroupcode(String groupcode) {
		this.groupcode = groupcode == null ? null : groupcode.trim();
	}

	public String getSupervisecode() {
		return supervisecode;
	}

	public void setSupervisecode(String supervisecode) {
		this.supervisecode = supervisecode == null ? null : supervisecode
				.trim();
	}

	public String getCurm() {
		return curm;
	}

	public void setCurm(String curm) {
		this.curm = curm == null ? null : curm.trim();
	}

	public String getCurt() {
		return curt;
	}

	public void setCurt(String curt) {
		this.curt = curt == null ? null : curt.trim();
	}

	public String getCurq() {
		return curq;
	}

	public void setCurq(String curq) {
		this.curq = curq == null ? null : curq.trim();
	}

	public String getCury() {
		return cury;
	}

	public void setCury(String cury) {
		this.cury = cury == null ? null : cury.trim();
	}

	public String getRb12() {
		return rb12;
	}

	public void setRb12(String rb12) {
		this.rb12 = rb12 == null ? null : rb12.trim();
	}

	public String getDatafromtype() {
		return datafromtype;
	}

	public void setDatafromtype(String datafromtype) {
		this.datafromtype = datafromtype == null ? null : datafromtype.trim();
	}

	public String getDatafrom() {
		return datafrom;
	}

	public void setDatafrom(String datafrom) {
		this.datafrom = datafrom == null ? null : datafrom.trim();
	}

	public String getIndtype() {
		return indtype;
	}

	public void setIndtype(String indtype) {
		this.indtype = indtype == null ? null : indtype.trim();
	}
	
}