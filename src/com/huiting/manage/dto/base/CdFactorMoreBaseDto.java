package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
* @ClassName: CdFactorMoreBaseDto 
* @Description: CD_FACTOR_MORE
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:40:23 
*
 */
@Alias("cdFactorMoreBaseDto")
public class CdFactorMoreBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String factorcode;

    private String factorname;

    private String updatefre;

    private String iscom;

    private String isrisk;

    private String ischa;

    private String mores;

    private String remark;

    public String getFactorcode() {
        return factorcode;
    }

    public void setFactorcode(String factorcode) {
        this.factorcode = factorcode == null ? null : factorcode.trim();
    }

    public String getFactorname() {
        return factorname;
    }

    public void setFactorname(String factorname) {
        this.factorname = factorname == null ? null : factorname.trim();
    }

    public String getUpdatefre() {
        return updatefre;
    }

    public void setUpdatefre(String updatefre) {
        this.updatefre = updatefre == null ? null : updatefre.trim();
    }

    public String getIscom() {
        return iscom;
    }

    public void setIscom(String iscom) {
        this.iscom = iscom == null ? null : iscom.trim();
    }

    public String getIsrisk() {
        return isrisk;
    }

    public void setIsrisk(String isrisk) {
        this.isrisk = isrisk == null ? null : isrisk.trim();
    }

    public String getIscha() {
        return ischa;
    }

    public void setIscha(String ischa) {
        this.ischa = ischa == null ? null : ischa.trim();
    }

    public String getMores() {
        return mores;
    }

    public void setMores(String mores) {
        this.mores = mores == null ? null : mores.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}