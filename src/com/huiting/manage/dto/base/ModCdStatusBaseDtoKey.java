package com.huiting.manage.dto.base;

import java.util.Date;

public class ModCdStatusBaseDtoKey {
    private String fillercom;

    private String reportname;

    private Date statdate;

    private String reportcode;
    
    private String riskcode;
    
    

    public String getRiskcode() {
		return riskcode;
	}

	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode;
	}

	public String getFillercom() {
        return fillercom;
    }

    public void setFillercom(String fillercom) {
        this.fillercom = fillercom == null ? null : fillercom.trim();
    }

    public String getReportname() {
        return reportname;
    }

    public void setReportname(String reportname) {
        this.reportname = reportname == null ? null : reportname.trim();
    }

    public Date getStatdate() {
        return statdate;
    }

    public void setStatdate(Date statdate) {
        this.statdate = statdate;
    }

    public String getReportcode() {
        return reportcode;
    }

    public void setReportcode(String reportcode) {
        this.reportcode = reportcode == null ? null : reportcode.trim();
    }
}