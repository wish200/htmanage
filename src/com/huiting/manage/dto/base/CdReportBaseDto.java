package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 下载报送用的附表
 * @author ncp
 *
 */
@Alias("cdReportBaseDto")
public class CdReportBaseDto  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String reportcode;

    private String validstate;

    private String reportname;

    private String datatabname;

    private String reprate;

    private String reptype;
    private String tabletype;

    public String getReportcode() {
        return reportcode;
    }

    public void setReportcode(String reportcode) {
        this.reportcode = reportcode == null ? null : reportcode.trim();
    }

    public String getValidstate() {
        return validstate;
    }

    public void setValidstate(String validstate) {
        this.validstate = validstate == null ? null : validstate.trim();
    }

    public String getReportname() {
        return reportname;
    }

    public void setReportname(String reportname) {
        this.reportname = reportname == null ? null : reportname.trim();
    }

    public String getDatatabname() {
        return datatabname;
    }

    public void setDatatabname(String datatabname) {
        this.datatabname = datatabname == null ? null : datatabname.trim();
    }

    public String getReprate() {
        return reprate;
    }

    public void setReprate(String reprate) {
        this.reprate = reprate == null ? null : reprate.trim();
    }

    public String getReptype() {
        return reptype;
    }

    public void setReptype(String reptype) {
        this.reptype = reptype == null ? null : reptype.trim();
    }

	public String getTabletype() {
		return tabletype;
	}

	public void setTabletype(String tabletype) {
		this.tabletype = tabletype == null ? null : tabletype.trim();;
	}
    
    
}