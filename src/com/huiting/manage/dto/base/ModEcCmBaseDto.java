package com.huiting.manage.dto.base;


import org.apache.ibatis.type.Alias;
@Alias("modEcCmBaseDto")
public class ModEcCmBaseDto {
    private String riskname;

    private String xcoord;

    private String ycoord;

    private String correlation;

    public String getRiskname() {
        return riskname;
    }
    public void setRiskname(String riskname) {
        this.riskname = riskname == null ? null : riskname.trim();
    }
    public String getXcoord() {
		return xcoord;
	}
	public void setXcoord(String xcoord) {
		this.xcoord = xcoord;
	}
	public String getYcoord() {
		return ycoord;
	}
	public void setYcoord(String ycoord) {
		this.ycoord = ycoord;
	}
	public String getCorrelation() {
        return correlation;
    }
    public void setCorrelation(String correlation) {
        this.correlation = correlation;
    }
}