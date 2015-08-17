package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: CdDepRiskBaseDto 
* @Description: CC_DEPRISK
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:35:40 
*
 */
@Alias("cdDepRiskBaseDto")
public class CdDepRiskBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String department;

    private String classcode;

    private String validstate;

    private String createusercode;

    private Date createtime;

    private String remark;

    private Date disabledate;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode == null ? null : classcode.trim();
    }

    public String getValidstate() {
        return validstate;
    }

    public void setValidstate(String validstate) {
        this.validstate = validstate == null ? null : validstate.trim();
    }

    public String getCreateusercode() {
        return createusercode;
    }

    public void setCreateusercode(String createusercode) {
        this.createusercode = createusercode == null ? null : createusercode.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getDisabledate() {
        return disabledate;
    }

    public void setDisabledate(Date disabledate) {
        this.disabledate = disabledate;
    }
}