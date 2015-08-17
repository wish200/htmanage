package com.huiting.manage.dto.base;

import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;
/**
 * @ClassName: ModTotalEcBaseDto 
 * @Description: 总体风险经济资本表
 * @author zhangyangyang
 * @date 2014-7-29
 */
@Alias("modTotalEcBaseDto")
public class ModTotalEcBaseDto {
    private BigDecimal modEcIns;

    private BigDecimal modEcCredit;

    private BigDecimal modEcBaz;

    private BigDecimal modEcOper;

    private BigDecimal dispEff;

    private BigDecimal modEcTotal;

    private String statdate;

    private BigDecimal quant;

    public BigDecimal getModEcIns() {
        return modEcIns;
    }

    public void setModEcIns(BigDecimal modEcIns) {
        this.modEcIns = modEcIns;
    }

    public BigDecimal getModEcCredit() {
        return modEcCredit;
    }

    public void setModEcCredit(BigDecimal modEcCredit) {
        this.modEcCredit = modEcCredit;
    }

    public BigDecimal getModEcBaz() {
        return modEcBaz;
    }

    public void setModEcBaz(BigDecimal modEcBaz) {
        this.modEcBaz = modEcBaz;
    }

    public BigDecimal getModEcOper() {
        return modEcOper;
    }

    public void setModEcOper(BigDecimal modEcOper) {
        this.modEcOper = modEcOper;
    }

    public BigDecimal getDispEff() {
        return dispEff;
    }

    public void setDispEff(BigDecimal dispEff) {
        this.dispEff = dispEff;
    }

    public BigDecimal getModEcTotal() {
        return modEcTotal;
    }

    public void setModEcTotal(BigDecimal modEcTotal) {
        this.modEcTotal = modEcTotal;
    }

    public String getStatdate() {
        return statdate;
    }

    public void setStatdate(String statdate) {
        this.statdate = statdate == null ? null : statdate.trim();
    }

    public BigDecimal getQuant() {
        return quant;
    }

    public void setQuant(BigDecimal quant) {
        this.quant = quant;
    }
}