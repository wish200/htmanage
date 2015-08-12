package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
* @ClassName: CdEmailRecBaseDto 
* @Description: CD_EMAIL_REC
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:36:05 
*
 */
@Alias("cdEmailRecBaseDto")
public class CdEmailRecBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String templatenum;

    private String recno;

    private String rectype;
    private String newdepcode;
    

    public String getTemplatenum() {
        return templatenum;
    }

    public void setTemplatenum(String templatenum) {
        this.templatenum = templatenum == null ? null : templatenum.trim();
    }

    public String getRecno() {
        return recno;
    }

    public void setRecno(String recno) {
        this.recno = recno == null ? null : recno.trim();
    }

    public String getRectype() {
        return rectype;
    }

    public void setRectype(String rectype) {
        this.rectype = rectype == null ? null : rectype.trim();
    }

	public String getNewdepcode() {
		return newdepcode;
	}

	public void setNewdepcode(String newdepcode) {
		this.newdepcode = newdepcode;
	}
    
}