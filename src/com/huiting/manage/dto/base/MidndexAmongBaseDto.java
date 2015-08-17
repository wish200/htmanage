package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: MidndexAmongBaseDto 
* @Description: MID_INDEXAMONG
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:36:24 
*
 */
@Alias("midndexAmongBaseDto")
public class MidndexAmongBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String indexcode;

    private BigDecimal indexvalue;

    private String comcode;

    private Date statdate;

    private String classcode;

    private String channelcode;

    public String getIndexcode() {
        return indexcode;
    }

    public void setIndexcode(String indexcode) {
        this.indexcode = indexcode == null ? null : indexcode.trim();
    }

    public BigDecimal getIndexvalue() {
        return indexvalue;
    }

    public void setIndexvalue(BigDecimal indexvalue) {
        this.indexvalue = indexvalue;
    }

    public String getComcode() {
        return comcode;
    }

    public void setComcode(String comcode) {
        this.comcode = comcode == null ? null : comcode.trim();
    }

    public Date getStatdate() {
        return statdate;
    }

    public void setStatdate(Date statdate) {
        this.statdate = statdate;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode == null ? null : classcode.trim();
    }

    public String getChannelcode() {
        return channelcode;
    }

    public void setChannelcode(String channelcode) {
        this.channelcode = channelcode == null ? null : channelcode.trim();
    }
}