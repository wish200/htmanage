package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: CdIndexBaseDto 
* @Description: CD_INDEX
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:39:13 
*
 */
@Alias("cdIndexBaseDto")
public class CdIndexBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String indexname;

    private String indexdesc;

    private String indmatch;

    private String fetchrate;

    private String validstate;

    private String importvalid;

    private String indtype;

    private String comparetype;

    private BigDecimal indexweight;

    private String lev1riskcode;

    private String lev1riskname;

    private String lev2riskcode;

    private String lev2riskname;

    private String lev3riskname;

    private String lev3riskcode;

    private String dataunit;

    private String indexcode;

    private String riskdesc;

    private Date valliddate;

    private String isclasss;

    private String iscompany;

    private String ischannel;

    private String datafromtype;

    private String inputdep;

    private String datafrom;

    private String indmatchdesc;

    private String maindepment;

    private String isaddition;

    private String tegimeBase;

    private String vptaccord;

    private String department;

    private String cenriskflag;
    
    private String proriskflag;
    
    private BigDecimal cenriskweight;
    
    private BigDecimal proriskweight;
    private int indexorder;
    
    private String isviewlevel;
    
    
    
    public String getIsviewlevel() {
		return isviewlevel;
	}

	public void setIsviewlevel(String isviewlevel) {
		this.isviewlevel = isviewlevel;
	}

	public int getIndexorder() {
		return indexorder;
	}

	public void setIndexorder(int indexorder) {
		this.indexorder = indexorder;
	}

	public String getCenriskflag() {
		return cenriskflag;
	}

	public void setCenriskflag(String cenriskflag) {
		this.cenriskflag = cenriskflag;
	}

	public String getProriskflag() {
		return proriskflag;
	}

	public void setProriskflag(String proriskflag) {
		this.proriskflag = proriskflag;
	}

	public BigDecimal getCenriskweight() {
		return cenriskweight;
	}

	public void setCenriskweight(BigDecimal cenriskweight) {
		this.cenriskweight = cenriskweight;
	}

	public BigDecimal getProriskweight() {
		return proriskweight;
	}

	public void setProriskweight(BigDecimal proriskweight) {
		this.proriskweight = proriskweight;
	}

	public String getIndexname() {
        return indexname;
    }

    public void setIndexname(String indexname) {
        this.indexname = indexname == null ? null : indexname.trim();
    }

    public String getIndexdesc() {
        return indexdesc;
    }

    public void setIndexdesc(String indexdesc) {
        this.indexdesc = indexdesc == null ? null : indexdesc.trim();
    }

    public String getIndmatch() {
        return indmatch;
    }

    public void setIndmatch(String indmatch) {
        this.indmatch = indmatch == null ? null : indmatch.trim();
    }

    public String getFetchrate() {
        return fetchrate;
    }

    public void setFetchrate(String fetchrate) {
        this.fetchrate = fetchrate == null ? null : fetchrate.trim();
    }

    public String getValidstate() {
        return validstate;
    }

    public void setValidstate(String validstate) {
        this.validstate = validstate == null ? null : validstate.trim();
    }

    public String getImportvalid() {
        return importvalid;
    }

    public void setImportvalid(String importvalid) {
        this.importvalid = importvalid == null ? null : importvalid.trim();
    }

    public String getIndtype() {
        return indtype;
    }

    public void setIndtype(String indtype) {
        this.indtype = indtype == null ? null : indtype.trim();
    }

    public String getComparetype() {
        return comparetype;
    }

    public void setComparetype(String comparetype) {
        this.comparetype = comparetype == null ? null : comparetype.trim();
    }

    public BigDecimal getIndexweight() {
        return indexweight;
    }

    public void setIndexweight(BigDecimal indexweight) {
        this.indexweight = indexweight;
    }

    public String getLev1riskcode() {
        return lev1riskcode;
    }

    public void setLev1riskcode(String lev1riskcode) {
        this.lev1riskcode = lev1riskcode == null ? null : lev1riskcode.trim();
    }

    public String getLev1riskname() {
        return lev1riskname;
    }

    public void setLev1riskname(String lev1riskname) {
        this.lev1riskname = lev1riskname == null ? null : lev1riskname.trim();
    }

    public String getLev2riskcode() {
        return lev2riskcode;
    }

    public void setLev2riskcode(String lev2riskcode) {
        this.lev2riskcode = lev2riskcode == null ? null : lev2riskcode.trim();
    }

    public String getLev2riskname() {
        return lev2riskname;
    }

    public void setLev2riskname(String lev2riskname) {
        this.lev2riskname = lev2riskname == null ? null : lev2riskname.trim();
    }

    public String getLev3riskname() {
        return lev3riskname;
    }

    public void setLev3riskname(String lev3riskname) {
        this.lev3riskname = lev3riskname == null ? null : lev3riskname.trim();
    }

    public String getLev3riskcode() {
        return lev3riskcode;
    }

    public void setLev3riskcode(String lev3riskcode) {
        this.lev3riskcode = lev3riskcode == null ? null : lev3riskcode.trim();
    }

    public String getDataunit() {
        return dataunit;
    }

    public void setDataunit(String dataunit) {
        this.dataunit = dataunit == null ? null : dataunit.trim();
    }

    public String getIndexcode() {
        return indexcode;
    }

    public void setIndexcode(String indexcode) {
        this.indexcode = indexcode == null ? null : indexcode.trim();
    }

    public String getRiskdesc() {
        return riskdesc;
    }

    public void setRiskdesc(String riskdesc) {
        this.riskdesc = riskdesc == null ? null : riskdesc.trim();
    }

    public Date getValliddate() {
        return valliddate;
    }

    public void setValliddate(Date valliddate) {
        this.valliddate = valliddate;
    }

    public String getIsclasss() {
        return isclasss;
    }

    public void setIsclasss(String isclasss) {
        this.isclasss = isclasss == null ? null : isclasss.trim();
    }

    public String getIscompany() {
        return iscompany;
    }

    public void setIscompany(String iscompany) {
        this.iscompany = iscompany == null ? null : iscompany.trim();
    }

    public String getIschannel() {
        return ischannel;
    }

    public void setIschannel(String ischannel) {
        this.ischannel = ischannel == null ? null : ischannel.trim();
    }

    public String getDatafromtype() {
        return datafromtype;
    }

    public void setDatafromtype(String datafromtype) {
        this.datafromtype = datafromtype == null ? null : datafromtype.trim();
    }

    public String getInputdep() {
        return inputdep;
    }

    public void setInputdep(String inputdep) {
        this.inputdep = inputdep == null ? null : inputdep.trim();
    }

    public String getDatafrom() {
        return datafrom;
    }

    public void setDatafrom(String datafrom) {
        this.datafrom = datafrom == null ? null : datafrom.trim();
    }

    public String getIndmatchdesc() {
        return indmatchdesc;
    }

    public void setIndmatchdesc(String indmatchdesc) {
        this.indmatchdesc = indmatchdesc == null ? null : indmatchdesc.trim();
    }

    public String getMaindepment() {
        return maindepment;
    }

    public void setMaindepment(String maindepment) {
        this.maindepment = maindepment == null ? null : maindepment.trim();
    }

    public String getIsaddition() {
        return isaddition;
    }

    public void setIsaddition(String isaddition) {
        this.isaddition = isaddition == null ? null : isaddition.trim();
    }

    public String getTegimeBase() {
        return tegimeBase;
    }

    public void setTegimeBase(String tegimeBase) {
        this.tegimeBase = tegimeBase == null ? null : tegimeBase.trim();
    }

    public String getVptaccord() {
        return vptaccord;
    }

    public void setVptaccord(String vptaccord) {
        this.vptaccord = vptaccord == null ? null : vptaccord.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }
}