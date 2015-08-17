package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: MppPerriskFactorBaseDto
* @Description: MPP_PERRISK_FACTOR
* @author ZhangYangYang
* @date 2014-1-14 下午05:48:33
 */
@Alias("mppPerriskFactorBaseDto")
public class MppPerriskFactorBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String perfactor;

    private String riskfaccode;

    private String facname;

    private String rptType;

    private String factordesc;

    private String usesupervise;

    public String getPerfactor() {
        return perfactor;
    }

    public void setPerfactor(String perfactor) {
        this.perfactor = perfactor == null ? null : perfactor.trim();
    }

    public String getRiskfaccode() {
        return riskfaccode;
    }

    public void setRiskfaccode(String riskfaccode) {
        this.riskfaccode = riskfaccode == null ? null : riskfaccode.trim();
    }

    public String getFacname() {
        return facname;
    }

    public void setFacname(String facname) {
        this.facname = facname == null ? null : facname.trim();
    }

    public String getRptType() {
        return rptType;
    }

    public void setRptType(String rptType) {
        this.rptType = rptType == null ? null : rptType.trim();
    }

    public String getFactordesc() {
        return factordesc;
    }

    public void setFactordesc(String factordesc) {
        this.factordesc = factordesc == null ? null : factordesc.trim();
    }

    public String getUsesupervise() {
        return usesupervise;
    }

    public void setUsesupervise(String usesupervise) {
        this.usesupervise = usesupervise == null ? null : usesupervise.trim();
    }
}