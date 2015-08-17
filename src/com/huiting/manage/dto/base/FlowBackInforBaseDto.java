package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: FlowBackInforBaseDto 
* @Description: FLOW_BACKINFOR
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:37:33 
*
 */
@Alias("flowBackInforBaseDto")
public class FlowBackInforBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String reason1;

    private String taskcode;

    private String reason3;

    private String reason2;

    private String reason4;

    private String bstep1;

    private String bstep2;

    private String bstep3;

    private String bstep4;

    private Date backdate;

    private String backercode;

    public String getReason1() {
        return reason1;
    }

    public void setReason1(String reason1) {
        this.reason1 = reason1 == null ? null : reason1.trim();
    }

    public String getTaskcode() {
        return taskcode;
    }

    public void setTaskcode(String taskcode) {
        this.taskcode = taskcode == null ? null : taskcode.trim();
    }

    public String getReason3() {
        return reason3;
    }

    public void setReason3(String reason3) {
        this.reason3 = reason3 == null ? null : reason3.trim();
    }

    public String getReason2() {
        return reason2;
    }

    public void setReason2(String reason2) {
        this.reason2 = reason2 == null ? null : reason2.trim();
    }

    public String getReason4() {
        return reason4;
    }

    public void setReason4(String reason4) {
        this.reason4 = reason4 == null ? null : reason4.trim();
    }


    public Date getBackdate() {
        return backdate;
    }

    public void setBackdate(Date backdate) {
        this.backdate = backdate;
    }

    public String getBackercode() {
        return backercode;
    }

    public void setBackercode(String backercode) {
        this.backercode = backercode == null ? null : backercode.trim();
    }

	public String getBstep1() {
		return bstep1;
	}

	public void setBstep1(String bstep1) {
		this.bstep1 = bstep1;
	}

	public String getBstep2() {
		return bstep2;
	}

	public void setBstep2(String bstep2) {
		this.bstep2 = bstep2;
	}

	public String getBstep3() {
		return bstep3;
	}

	public void setBstep3(String bstep3) {
		this.bstep3 = bstep3;
	}

	public String getBstep4() {
		return bstep4;
	}

	public void setBstep4(String bstep4) {
		this.bstep4 = bstep4;
	}
    
}