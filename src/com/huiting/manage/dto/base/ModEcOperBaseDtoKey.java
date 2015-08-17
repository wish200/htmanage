package com.huiting.manage.dto.base;

import java.math.BigDecimal;

public class ModEcOperBaseDtoKey {
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