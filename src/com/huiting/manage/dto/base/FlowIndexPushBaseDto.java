package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: FlowIndexPushBaseDto 
* @Description: FLOW_INDEXPUSH
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:37:03 
*
 */
@Alias("flowIndexPushBaseDto")
public class FlowIndexPushBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String indexcode;

    private Date statdate;

    private String pushstate;

 

    private String comcode;

    private String channelcode;

    private String classcode;


    private String color;

    private BigDecimal indexvalue;
    private String hispushstate;


    public String getIndexcode() {
        return indexcode;
    }

    public void setIndexcode(String indexcode) {
        this.indexcode = indexcode == null ? null : indexcode.trim();
    }

    public Date getStatdate() {
        return statdate;
    }

    public void setStatdate(Date statdate) {
        this.statdate = statdate;
    }

    public String getPushstate() {
        return pushstate;
    }

    public void setPushstate(String pushstate) {
        this.pushstate = pushstate == null ? null : pushstate.trim();
    }

   

    public String getComcode() {
        return comcode;
    }

    public void setComcode(String comcode) {
        this.comcode = comcode == null ? null : comcode.trim();
    }

    public String getChannelcode() {
        return channelcode;
    }

    public void setChannelcode(String channelcode) {
        this.channelcode = channelcode == null ? null : channelcode.trim();
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode == null ? null : classcode.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public BigDecimal getIndexvalue() {
        return indexvalue;
    }

    public void setIndexvalue(BigDecimal indexvalue) {
        this.indexvalue = indexvalue;
    }

	public String getHispushstate() {
		return hispushstate;
	}

	public void setHispushstate(String hispushstate) {
		this.hispushstate = hispushstate;
	}
    
    
}