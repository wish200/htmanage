package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
/**
  * @ClassName: CdregRiskBaseDto
  * @Description: CD_REGRISK
  * @author: zhangyangyang
  * @date 2014-3-13 下午2:01:18
 */
@Alias("cdregRiskBaseDto")
public class CdregRiskBaseDto implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String indexcode;

    private String regindexcode;

    private String regindexname;

    private String validstate;

    private String rptType;

    private String indexdesc;

    public String getIndexcode() {
        return indexcode;
    }

    public void setIndexcode(String indexcode) {
        this.indexcode = indexcode == null ? null : indexcode.trim();
    }

    public String getRegindexcode() {
        return regindexcode;
    }

    public void setRegindexcode(String regindexcode) {
        this.regindexcode = regindexcode == null ? null : regindexcode.trim();
    }

    public String getRegindexname() {
        return regindexname;
    }

    public void setRegindexname(String regindexname) {
        this.regindexname = regindexname == null ? null : regindexname.trim();
    }

    public String getValidstate() {
        return validstate;
    }

    public void setValidstate(String validstate) {
        this.validstate = validstate == null ? null : validstate.trim();
    }

    public String getRptType() {
        return rptType;
    }

    public void setRptType(String rptType) {
        this.rptType = rptType == null ? null : rptType.trim();
    }

    public String getIndexdesc() {
        return indexdesc;
    }

    public void setIndexdesc(String indexdesc) {
        this.indexdesc = indexdesc == null ? null : indexdesc.trim();
    }
}