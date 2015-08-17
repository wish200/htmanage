package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: MidSudoFactorBaseDto 
* @Description: MID_SUDOFACTOR
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:36:16 
*
 */
@Alias("midSudoFactorBaseDto")
public class MidSudoFactorBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String faccode;

    private Date statdate;

    private Date inputdate;

    private String fillercode;

    private String facvalue;

    private String datafrom;

    private String comcode;

    private String channelcode;

    private String classcode;

    public String getFaccode() {
        return faccode;
    }

    public void setFaccode(String faccode) {
        this.faccode = faccode == null ? null : faccode.trim();
    }

    public Date getStatdate() {
        return statdate;
    }

    public void setStatdate(Date statdate) {
        this.statdate = statdate;
    }

    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }

    public String getFillercode() {
        return fillercode;
    }

    public void setFillercode(String fillercode) {
    	
    	
        this.fillercode = fillercode == null ? "--" : fillercode.trim();
    }

    public String getFacvalue() {
    	NumberFormat nf=NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		String facValue = "";
		if (facvalue.matches("\\d+(.\\d+)?")) {
			facValue = nf.format(Double.parseDouble(facvalue.trim()));
		} else {
			facValue = facvalue == null ? "--":facvalue;
		}
		return facValue;//facvalue == null ? "--" :nf.format(Double.parseDouble(facvalue.trim()));
	}

	public void setFacvalue(String facvalue) {
		this.facvalue = facvalue;
	}

	public String getDatafrom() {
        return datafrom;
    }

    public void setDatafrom(String datafrom) {
        this.datafrom = datafrom == null ? null : datafrom.trim();
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
}