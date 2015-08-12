package com.huiting.manage.dto.base;

import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;
/**
 * 
 * @ClassName: ModPtBazBaseDto 
 * @Description: TODO MOD_PT_BAZ
 * @author zhangyangyang
 * @date 2014-6-11
 */
@Alias("modPtBazBaseDto")
public class ModPtBazBaseDto extends ModPtBazBaseDtoKey {
    /**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private String ptFacvalue;

    private BigDecimal cinaBaz;

    private BigDecimal cinaBook;

    private BigDecimal cineBaz;

    private BigDecimal cineProfit;

    private BigDecimal cineOvr;

    private BigDecimal seqno;


	public String getPtFacvalue() {
		return ptFacvalue;
	}

	public void setPtFacvalue(String ptFacvalue) {
		this.ptFacvalue = ptFacvalue;
	}

	public BigDecimal getCinaBaz() {
        return cinaBaz;
    }

    public void setCinaBaz(BigDecimal cinaBaz) {
        this.cinaBaz = cinaBaz;
    }

    public BigDecimal getCinaBook() {
        return cinaBook;
    }

    public void setCinaBook(BigDecimal cinaBook) {
        this.cinaBook = cinaBook;
    }

    public BigDecimal getCineBaz() {
        return cineBaz;
    }

    public void setCineBaz(BigDecimal cineBaz) {
        this.cineBaz = cineBaz;
    }

    public BigDecimal getCineProfit() {
        return cineProfit;
    }

    public void setCineProfit(BigDecimal cineProfit) {
        this.cineProfit = cineProfit;
    }

    public BigDecimal getCineOvr() {
        return cineOvr;
    }

    public void setCineOvr(BigDecimal cineOvr) {
        this.cineOvr = cineOvr;
    }

    public BigDecimal getSeqno() {
        return seqno;
    }

    public void setSeqno(BigDecimal seqno) {
        this.seqno = seqno;
    }
}