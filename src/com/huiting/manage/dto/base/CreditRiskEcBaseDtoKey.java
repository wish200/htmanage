package com.huiting.manage.dto.base;

import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;

@Alias("creditRiskEcBaseDtoKey")
public class CreditRiskEcBaseDtoKey {
    private BigDecimal quant;

    private String statdate;

    public BigDecimal getQuant() {
        return quant;
    }

    public void setQuant(BigDecimal quant) {
        this.quant = quant;
    }

    public String getStatdate() {
        return statdate;
    }

    public void setStatdate(String statdate) {
        this.statdate = statdate == null ? null : statdate.trim();
    }
}