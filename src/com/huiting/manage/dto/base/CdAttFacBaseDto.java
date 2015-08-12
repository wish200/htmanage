package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
/**
 * 
 * @author ncp
 *附表对应因子表
 */
@Alias("cdAttFacBaseDto")
public class CdAttFacBaseDto implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String attcode;

    private String vfaccode;

    private String mfaccode;

    private String facorder;

    private String vfacname;

    private String mfacname;

    private String remark;

    private String basefaccode;

    public String getAttcode() {
        return attcode;
    }

    public void setAttcode(String attcode) {
        this.attcode = attcode == null ? null : attcode.trim();
    }

    public String getVfaccode() {
        return vfaccode;
    }

    public void setVfaccode(String vfaccode) {
        this.vfaccode = vfaccode == null ? null : vfaccode.trim();
    }

    public String getMfaccode() {
        return mfaccode;
    }

    public void setMfaccode(String mfaccode) {
        this.mfaccode = mfaccode == null ? null : mfaccode.trim();
    }

    public String getFacorder() {
        return facorder;
    }

    public void setFacorder(String facorder) {
        this.facorder = facorder == null ? null : facorder.trim();
    }

    public String getVfacname() {
        return vfacname;
    }

    public void setVfacname(String vfacname) {
        this.vfacname = vfacname == null ? null : vfacname.trim();
    }

    public String getMfacname() {
        return mfacname;
    }

    public void setMfacname(String mfacname) {
        this.mfacname = mfacname == null ? null : mfacname.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getBasefaccode() {
        return basefaccode;
    }

    public void setBasefaccode(String basefaccode) {
        this.basefaccode = basefaccode == null ? null : basefaccode.trim();
    }
}