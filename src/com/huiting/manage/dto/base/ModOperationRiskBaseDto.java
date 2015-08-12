package com.huiting.manage.dto.base;

import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;
@Alias("modOperationRiskBaseDto")
public class ModOperationRiskBaseDto extends ModOperationRiskBaseDtoKey {
    private BigDecimal supervisionAmt;

    private BigDecimal assetsAmt;

    private BigDecimal lawAmt;

    private BigDecimal outAmt;

    private BigDecimal failedRecovery;

    private BigDecimal busiInterrupt;

    private BigDecimal paperAmt;

    private BigDecimal lossAmount;

    private BigDecimal tosaveAmt;

    private BigDecimal lastAmt;

    private String remark;

    public BigDecimal getSupervisionAmt() {
        return supervisionAmt;
    }

    public void setSupervisionAmt(BigDecimal supervisionAmt) {
        this.supervisionAmt = supervisionAmt;
    }

    public BigDecimal getAssetsAmt() {
        return assetsAmt;
    }

    public void setAssetsAmt(BigDecimal assetsAmt) {
        this.assetsAmt = assetsAmt;
    }

    public BigDecimal getLawAmt() {
        return lawAmt;
    }

    public void setLawAmt(BigDecimal lawAmt) {
        this.lawAmt = lawAmt;
    }

    public BigDecimal getOutAmt() {
        return outAmt;
    }

    public void setOutAmt(BigDecimal outAmt) {
        this.outAmt = outAmt;
    }

    public BigDecimal getFailedRecovery() {
        return failedRecovery;
    }

    public void setFailedRecovery(BigDecimal failedRecovery) {
        this.failedRecovery = failedRecovery;
    }

    public BigDecimal getBusiInterrupt() {
        return busiInterrupt;
    }

    public void setBusiInterrupt(BigDecimal busiInterrupt) {
        this.busiInterrupt = busiInterrupt;
    }

    public BigDecimal getPaperAmt() {
        return paperAmt;
    }

    public void setPaperAmt(BigDecimal paperAmt) {
        this.paperAmt = paperAmt;
    }

    public BigDecimal getLossAmount() {
        return lossAmount;
    }

    public void setLossAmount(BigDecimal lossAmount) {
        this.lossAmount = lossAmount;
    }

    public BigDecimal getTosaveAmt() {
        return tosaveAmt;
    }

    public void setTosaveAmt(BigDecimal tosaveAmt) {
        this.tosaveAmt = tosaveAmt;
    }

    public BigDecimal getLastAmt() {
        return lastAmt;
    }

    public void setLastAmt(BigDecimal lastAmt) {
        this.lastAmt = lastAmt;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}