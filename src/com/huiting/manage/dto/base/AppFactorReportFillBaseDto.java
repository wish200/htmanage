package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: AppFactorReportDataBaseDto
* @Description: app_factor_reportfill
* @author ZhangYangYang
* @date 2014-1-14 上午09:30:01
 */
@Alias("appFactorReportFillBaseDto")
public class AppFactorReportFillBaseDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private BigDecimal indexvalue;

    private String indexcode;

    private Date statdate;

    private String indexname;

    private String remark;

    private String datafrom;

    public BigDecimal getIndexvalue() {
        return indexvalue;
    }

    public void setIndexvalue(BigDecimal indexvalue) {
        this.indexvalue = indexvalue;
    }

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

    public String getIndexname() {
        return indexname;
    }

    public void setIndexname(String indexname) {
        this.indexname = indexname == null ? null : indexname.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDatafrom() {
        return datafrom;
    }

    public void setDatafrom(String datafrom) {
        this.datafrom = datafrom == null ? null : datafrom.trim();
    }
}