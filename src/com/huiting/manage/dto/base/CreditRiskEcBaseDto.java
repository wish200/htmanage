package com.huiting.manage.dto.base;

import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;
@Alias("creditRiskEcBaseDto")
public class CreditRiskEcBaseDto extends CreditRiskEcBaseDtoKey {
    private BigDecimal oriInsEc;

    private BigDecimal reinInsEc;

    private BigDecimal inverstEc;

    private BigDecimal overallEc;

    public BigDecimal getOriInsEc() {
        return oriInsEc;
    }

    public void setOriInsEc(BigDecimal oriInsEc) {
        this.oriInsEc = oriInsEc;
    }

    public BigDecimal getReinInsEc() {
        return reinInsEc;
    }

    public void setReinInsEc(BigDecimal reinInsEc) {
        this.reinInsEc = reinInsEc;
    }

    public BigDecimal getInverstEc() {
        return inverstEc;
    }

    public void setInverstEc(BigDecimal inverstEc) {
        this.inverstEc = inverstEc;
    }

    public BigDecimal getOverallEc() {
        return overallEc;
    }

    public void setOverallEc(BigDecimal overallEc) {
        this.overallEc = overallEc;
    }
}