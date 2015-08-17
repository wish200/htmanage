package com.huiting.manage.dto.base;

import java.text.NumberFormat;
import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
 * 附表数据
 * @author ncp
 *
 */
@Alias("appAttSpecBaseDto")
public class AppAttSpecBaseDto {
    private String vfaccode;

    private Date statdate;

    private String comcode;

    private String facvalue;

    private String rate;

    private String facname;

    public String getVfaccode() {
        return vfaccode;
    }

    public void setVfaccode(String vfaccode) {
        this.vfaccode = vfaccode == null ? null : vfaccode.trim();
    }

    public Date getStatdate() {
        return statdate;
    }

    public void setStatdate(Date statdate) {
        this.statdate = statdate;
    }

    public String getComcode() {
        return comcode;
    }

    public void setComcode(String comcode) {
        this.comcode = comcode == null ? null : comcode.trim();
    }

    public String getFacvalue() {
    	NumberFormat nf=NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
        return facvalue== null ? "--" :nf.format(Double.parseDouble(facvalue.trim())); 
    }

    public void setFacvalue(String facvalue) {
        this.facvalue = facvalue == null ? "--" : facvalue.trim();
    }

    public String getRate() {
        return rate == null ? "--" : rate.trim();
    }

    public void setRate(String rate) {
        this.rate = rate == null ? "--" : rate.trim();
    }

    public String getFacname() {
        return facname;
    }

    public void setFacname(String facname) {
        this.facname = facname == null ? null : facname.trim();
    }
}