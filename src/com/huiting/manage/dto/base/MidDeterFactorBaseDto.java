package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: MidDeterFactorBaseDto
* @Description: mid_deterfactor
* @author ZhangYangYang
* @date 2014-1-9 下午04:56:56
 */
@Alias("midDeterFactorBaseDto")
public class MidDeterFactorBaseDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private String indexcode;

    private String facvalue;

    private String facdesc;

    private String factype;

    private String faccode;

    private Date statdate;

    private String fillercode;

    private Date inputdate;

    private String fillercom;

    private String facname;

    private String comcode;
    
    private String mvalidstate;
    
    private String remark;


	public String getMvalidstate() {
		return mvalidstate;
	}

	public void setMvalidstate(String mvalidstate) {
		this.mvalidstate = mvalidstate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIndexcode() {
        return indexcode;
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
    public void setIndexcode(String indexcode) {
        this.indexcode = indexcode == null ? null : indexcode.trim();
    }

    public String getFacvalue() {
        return facvalue;
    }

    public void setFacvalue(String facvalue) {
        this.facvalue = facvalue == null ? null : facvalue.trim();
    }

    public String getFacdesc() {
        return facdesc;
    }

    public void setFacdesc(String facdesc) {
        this.facdesc = facdesc == null ? null : facdesc.trim();
    }

    public String getFactype() {
        return factype;
    }

    public void setFactype(String factype) {
        this.factype = factype == null ? null : factype.trim();
    }

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

    public String getFillercode() {
        return fillercode;
    }

    public void setFillercode(String fillercode) {
        this.fillercode = fillercode == null ? null : fillercode.trim();
    }

    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }

    public String getFillercom() {
        return fillercom;
    }

    public void setFillercom(String fillercom) {
        this.fillercom = fillercom == null ? null : fillercom.trim();
    }

    public String getFacname() {
        return facname;
    }

    public void setFacname(String facname) {
        this.facname = facname == null ? null : facname.trim();
    }

    public String getComcode() {
        return comcode;
    }

    public void setComcode(String comcode) {
        this.comcode = comcode == null ? null : comcode.trim();
    }
    public static boolean isNumeric(String str){ 
	    Pattern pattern = Pattern.compile("^\\-?\\+?[0-9]+(.[0-9]*)?$"); 
	    return pattern.matcher(str).matches();    
	}
}