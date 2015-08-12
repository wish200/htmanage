package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: FlowIndexTaskBaseDto 
* @Description: FLOW_INDEXTASK
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:36:57 
*
 */
@Alias("flowIndexTaskBaseDto")
public class FlowIndexTaskBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String taskcode;
    private Date statdate;
    private String indexcode;
    private Date lastupdate;
    private String answerstate;

    private String pushercode;

    private Date pushdate;

    private Date enddate;

    private String pushadvise;

    private String backrate;

    private int backnums;

    private String pushrequire;
    private String acceptorcode;
    private String channelcode;
    private String classcode;
    private String comcode;
    private String maindepmentcode;
    private String changestate;

    private String backstate;
    private String emailsend;//EMAILSEND

    public String getTaskcode() {
        return taskcode;
    }

    public void setTaskcode(String taskcode) {
        this.taskcode = taskcode == null ? null : taskcode.trim();
    }

    public String getPushercode() {
        return pushercode;
    }

    public void setPushercode(String pushercode) {
        this.pushercode = pushercode == null ? null : pushercode.trim();
    }

    public Date getPushdate() {
        return pushdate;
    }

    public void setPushdate(Date pushdate) {
        this.pushdate = pushdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getPushadvise() {
        return pushadvise;
    }

    public void setPushadvise(String pushadvise) {
        this.pushadvise = pushadvise == null ? null : pushadvise.trim();
    }

    public String getBackrate() {
        return backrate;
    }

    public void setBackrate(String backrate) {
        this.backrate = backrate == null ? null : backrate.trim();
    }

    public int getBacknums() {
        return backnums;
    }

    public void setBacknums(int backnums) {
        this.backnums = backnums;
    }

    public String getPushrequire() {
        return pushrequire;
    }
    

    public Date getStatdate() {
		return statdate;
	}
	public void setStatdate(Date statdate) {
		this.statdate = statdate;
	}
	public String getIndexcode() {
		return indexcode;
	}
	public void setIndexcode(String indexcode) {
		this.indexcode = indexcode;
	}
	public String getAcceptorcode() {
		return acceptorcode;
	}
	public void setAcceptorcode(String acceptorcode) {
		this.acceptorcode = acceptorcode;
	}
	public String getChannelcode() {
		return channelcode;
	}

	public void setChannelcode(String channelcode) {
		this.channelcode = channelcode;
	}

	public String getClasscode() {
		return classcode;
	}

	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}

	public String getComcode() {
		return comcode;
	}
	public void setComcode(String comcode) {
		this.comcode = comcode;
	}
	public String getMaindepmentcode() {
		return maindepmentcode;
	}
	public void setMaindepmentcode(String maindepmentcode) {
		this.maindepmentcode = maindepmentcode;
	}
	public Date getLastupdate() {
		return lastupdate;
	}
	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}
	public String getAnswerstate() {
		return answerstate;
	}
	public void setAnswerstate(String answerstate) {
		this.answerstate = answerstate;
	}

	public void setPushrequire(String pushrequire) {
        this.pushrequire = pushrequire == null ? null : pushrequire.trim();
    }
	public String getEmailsend() {
		return emailsend;
	}
	public void setEmailsend(String emailsend) {
		this.emailsend = emailsend;
	}
	public String getChangestate() {
	        return changestate;
	}
	public void setChangestate(String changestate) {
	        this.changestate = changestate == null ? null : changestate.trim();
	}
	public String getBackstate() {
	        return backstate;
	 }
    public void setBackstate(String backstate) {
	        this.backstate = backstate == null ? null : backstate.trim();
	}
}