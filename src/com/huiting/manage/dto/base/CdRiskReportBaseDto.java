package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: CdRiskReportBaseDto 
* @Description: CD_RISH_REPORT
* @author zhanglei
* @date 2014-1-10 下午04:10:17
 */
@Alias("cdRiskReportBaseDto")
public class CdRiskReportBaseDto implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String reportid;

    private String reportcode;

    private String reporttype;

    private String reporttitle;

    private Date submitdate;

    private String submittor;

    private String attchment;

    private String stauts;

    private String remark;

    private Date modifydate;

    private String comcode;

    private String modifcode;

    public String getReportid() {
        return reportid;
    }

    public void setReportid(String reportid) {
        this.reportid = reportid == null ? null : reportid.trim();
    }

    public String getReportcode() {
        return reportcode;
    }

    public void setReportcode(String reportcode) {
        this.reportcode = reportcode == null ? null : reportcode.trim();
    }

    public String getReporttype() {
        return reporttype;
    }

    public void setReporttype(String reporttype) {
        this.reporttype = reporttype == null ? null : reporttype.trim();
    }

    public String getReporttitle() {
        return reporttitle;
    }

    public void setReporttitle(String reporttitle) {
        this.reporttitle = reporttitle == null ? null : reporttitle.trim();
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