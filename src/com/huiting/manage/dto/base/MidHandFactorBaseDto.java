package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: MidHandFactorBaseDto 
* @Description: MID_HANDFACTOR
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:36:30 
*
 */
@Alias("midHandFactorBaseDto")
public class MidHandFactorBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String faccode;

    private Date statdate;
    private String filltercom;

    private String fillercode;

    private String facvalue;

    private String comcode;

    private Date inputdate;

    private String remark;

    public String getFaccode() {
        return faccode;
    }

    public String getFilltercom() {
		return filltercom;
	}

	public void setFilltercom(String filltercom) {
		this.filltercom = filltercom;
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

    public String getFillercode() {
        return fillercode;
    }

    public void setFillercode(String fillercode) {
        this.fillercode = fillercode == null ? null : fillercode.trim();
    }


    public String getFacvalue() {
		return facvalue;
	}
    public String getFacvalueString() {
    	if(!isNumeric(facvalue)){
    		return facvalue;	
    	}else{
    		NumberFormat nf=NumberFormat.getInstance();
    		nf.setMinimumFractionDigits(2);
    		return nf.format(Double.parseDouble(facvalue));
    	}
	}
	public void setFacvalue(String facvalue) {
		this.facvalue = facvalue;
	}

	public String getComcode() {
        return comcode;
    }

    public void setComcode(String comcode) {
        this.comcode = comcode == null ? null : comcode.trim();
    }

    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    public static boolean isNumeric(String str){ 
	    Pattern pattern = Pattern.compile("^\\-?\\+?[0-9]+(.[0-9]*)?$"); 
	    return pattern.matcher(str).matches();    
	}
}