package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
  * @ClassName: CcTaskBaseDto
  * @Description: cc_task
  * @author: zhangyangyang
  * @date 2014-2-20 上午10:19:37
 */
@Alias("ccTaskBaseDto")
public class CcTaskBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String taskcode;

//    private String usercode;

    private String taskcontent;

    private Date createtime;
    
    private String modulecode;

    private String taskparam1;
    
    private String taskparam2;

    private String taskstatus;
    
    private String comcode;
    
    private String newdepcode;
    
    private String deppositioncode;
    
    
    
    public String getDeppositioncode() {
		return deppositioncode;
	}

	public void setDeppositioncode(String deppositioncode) {
		this.deppositioncode = deppositioncode;
	}

	public String getComcode() {
		return comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode;
	}

	public String getNewdepcode() {
		return newdepcode;
	}

	public void setNewdepcode(String newdepcode) {
		this.newdepcode = newdepcode;
	}

	public String getTaskcode() {
        return taskcode;
    }

    public void setTaskcode(String taskcode) {
        this.taskcode = taskcode == null ? null : taskcode.trim();
    }

//    public String getUsercode() {
//        return usercode;
//    }
//
//    public void setUsercode(String usercode) {
//        this.usercode = usercode == null ? null : usercode.trim();
//    }

    public String getModulecode() {
        return modulecode;
    }

    public void setModulecode(String modulecode) {
        this.modulecode = modulecode == null ? null : modulecode.trim();
    }


    public String getTaskparam1() {
		return taskparam1;
	}

	public void setTaskparam1(String taskparam1) {
		this.taskparam1 = taskparam1;
	}

	public String getTaskparam2() {
		return taskparam2;
	}

	public void setTaskparam2(String taskparam2) {
		this.taskparam2 = taskparam2;
	}

	public String getTaskstatus() {
        return taskstatus;
    }

    public void setTaskstatus(String taskstatus) {
        this.taskstatus = taskstatus == null ? null : taskstatus.trim();
    }

	public String getTaskcontent() {
		return taskcontent;
	}

	public void setTaskcontent(String taskcontent) {
		this.taskcontent = taskcontent;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
}