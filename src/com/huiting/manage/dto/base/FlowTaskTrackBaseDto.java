package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: FlowTaskTrackBaseDto 
* @Description: FLOW_TASKTRACK
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:36:36 
*
 */
@Alias("flowTaskTrackBaseDto")
public class FlowTaskTrackBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String backercode;

    private String taskcode;

    private Date backdate;

    private String step1;

    private String step2;

    private String step3;

    private String step4;
    private String submitstatus;
    
    public String getBackercode() {
        return backercode;
    }

    public void setBackercode(String backercode) {
        this.backercode = backercode == null ? null : backercode.trim();
    }

    public String getTaskcode() {
        return taskcode;
    }

    public void setTaskcode(String taskcode) {
        this.taskcode = taskcode == null ? null : taskcode.trim();
    }

    public Date getBackdate() {
        return backdate;
    }

    public void setBackdate(Date backdate) {
        this.backdate = backdate;
    }

    public String getStep1() {
        return step1;
    }

    public void setStep1(String step1) {
        this.step1 = step1 == null ? null : step1.trim();
    }

    public String getStep2() {
        return step2;
    }

    public void setStep2(String step2) {
        this.step2 = step2 == null ? null : step2.trim();
    }

    public String getStep3() {
        return step3;
    }

    public void setStep3(String step3) {
        this.step3 = step3 == null ? null : step3.trim();
    }

    public String getStep4() {
        return step4;
    }

    public void setStep4(String step4) {
        this.step4 = step4 == null ? null : step4.trim();
    }

	public String getSubmitstatus() {
		return submitstatus;
	}

	public void setSubmitstatus(String submitstatus) {
		this.submitstatus = submitstatus == null ? null : submitstatus.trim();
	}
    
}