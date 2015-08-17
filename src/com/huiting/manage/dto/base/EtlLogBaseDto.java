package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: EtlLogBaseDto 
* @Description: ETL_LOG
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:37:46 
*
 */
@Alias("etlLogBaseDto")
public class EtlLogBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String procName;

    private BigDecimal errCode;

    private String errMess;

    private Date starttime;

    private Date endtime;

    public String getProcName() {
        return procName;
    }

    public void setProcName(String procName) {
        this.procName = procName == null ? null : procName.trim();
    }

    public BigDecimal getErrCode() {
        return errCode;
    }

    public void setErrCode(BigDecimal errCode) {
        this.errCode = errCode;
    }

    public String getErrMess() {
        return errMess;
    }

    public void setErrMess(String errMess) {
        this.errMess = errMess == null ? null : errMess.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}