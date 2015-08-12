package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: CdPeriodicaBaseDto
* @Description: cd_periodica
* @author ZhangYangYang
* @date 2014-1-8 下午06:21:29
 */
@Alias("cdPeriodicaBaseDto")
public class CdPeriodicaBaseDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String periodicaid;

    private String periodicacode;

    private String periodicatype;

    private String periodicatitle;

    private Date submitdate;

    private String submittor;

    private String attchment;

    private String stauts;

    private String remark;

    private Date modifydate;

    private String comcode;

    private String modifcode;

    public String getPeriodicaid() {
        return periodicaid;
    }

    public void setPeriodicaid(String periodicaid) {
        this.periodicaid = periodicaid == null ? null : periodicaid.trim();
    }

    public String getPeriodicacode() {
        return periodicacode;
    }

    public void setPeriodicacode(String periodicacode) {
        this.periodicacode = periodicacode == null ? null : periodicacode.trim();
    }

    public String getPeriodicatype() {
        return periodicatype;
    }

    public void setPeriodicatype(String periodicatype) {
        this.periodicatype = periodicatype == null ? null : periodicatype.trim();
    }

    public String getPeriodicatitle() {
        return periodicatitle;
    }

    public void setPeriodicatitle(String periodicatitle) {
        this.periodicatitle = periodicatitle == null ? null : periodicatitle.trim();
    }

    public Date getSubmitdate() {
        return submitdate;
    }

    public void setSubmitdate(Date submitdate) {
        this.submitdate = submitdate;
    }

    public String getSubmittor() {
        return submittor;
    }

    public void setSubmittor(String submittor) {
        this.submittor = submittor == null ? null : submittor.trim();
    }

    public String getAttchment() {
        return attchment;
    }

    public void setAttchment(String attchment) {
        this.attchment = attchment == null ? null : attchment.trim();
    }

    public String getStauts() {
        return stauts;
    }

    public void setStauts(String stauts) {
        this.stauts = stauts == null ? null : stauts.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public String getComcode() {
        return comcode;
    }

    public void setComcode(String comcode) {
        this.comcode = comcode == null ? null : comcode.trim();
    }

    public String getModifcode() {
        return modifcode;
    }

    public void setModifcode(String modifcode) {
        this.modifcode = modifcode == null ? null : modifcode.trim();
    }
}