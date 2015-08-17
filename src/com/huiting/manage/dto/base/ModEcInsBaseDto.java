package com.huiting.manage.dto.base;

import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;
/**
 * @ClassName: ModEcInsBaseDto 
 * @Description: 保险风险经济资本
 * @author zhangyangyang
 * @date 2014-7-29
 */
@Alias("modEcInsBaseDto")
public class ModEcInsBaseDto {
    private BigDecimal vehicleRiskEc;

    private BigDecimal vehiResEc;

    private BigDecimal vehiPreResEc;

    private BigDecimal propPreEc;

    private BigDecimal propResEc;

    private BigDecimal propPreResEc;

    private BigDecimal cargoPreEc;

    private BigDecimal cargoResEc;

    private BigDecimal cargoPreResEc;

    private BigDecimal libPreEc;

    private BigDecimal libResEc;

    private BigDecimal libPreResEc;

    private BigDecimal agrPreEc;

    private BigDecimal agrResEc;

    private BigDecimal agrPreResEc;

    private BigDecimal crePreEc;

    private BigDecimal creResEc;

    private BigDecimal crePreResEc;

    private BigDecimal totalPreEc;

    private BigDecimal totalResEc;

    private BigDecimal totalPreResEc;

    private BigDecimal accPreEc;

    private BigDecimal accResEc;

    private BigDecimal accPreResEc;
    
    private BigDecimal cataRiskEc;

    private BigDecimal dispEff;

    private BigDecimal overallInsEc;

    private String statdate;

    private BigDecimal quant;

    public BigDecimal getVehicleRiskEc() {
        return vehicleRiskEc;
    }

    public void setVehicleRiskEc(BigDecimal vehicleRiskEc) {
        this.vehicleRiskEc = vehicleRiskEc;
    }

    public BigDecimal getVehiResEc() {
        return vehiResEc;
    }

    public void setVehiResEc(BigDecimal vehiResEc) {
        this.vehiResEc = vehiResEc;
    }

    public BigDecimal getVehiPreResEc() {
        return vehiPreResEc;
    }

    public void setVehiPreResEc(BigDecimal vehiPreResEc) {
        this.vehiPreResEc = vehiPreResEc;
    }

    public BigDecimal getPropPreEc() {
        return propPreEc;
    }

    public void setPropPreEc(BigDecimal propPreEc) {
        this.propPreEc = propPreEc;
    }

    public BigDecimal getPropResEc() {
        return propResEc;
    }

    public void setPropResEc(BigDecimal propResEc) {
        this.propResEc = propResEc;
    }

    public BigDecimal getPropPreResEc() {
        return propPreResEc;
    }

    public void setPropPreResEc(BigDecimal propPreResEc) {
        this.propPreResEc = propPreResEc;
    }

    public BigDecimal getCargoPreEc() {
        return cargoPreEc;
    }

    public void setCargoPreEc(BigDecimal cargoPreEc) {
        this.cargoPreEc = cargoPreEc;
    }

    public BigDecimal getCargoResEc() {
        return cargoResEc;
    }

    public void setCargoResEc(BigDecimal cargoResEc) {
        this.cargoResEc = cargoResEc;
    }

    public BigDecimal getCargoPreResEc() {
        return cargoPreResEc;
    }

    public void setCargoPreResEc(BigDecimal cargoPreResEc) {
        this.cargoPreResEc = cargoPreResEc;
    }

    public BigDecimal getLibPreEc() {
        return libPreEc;
    }

    public void setLibPreEc(BigDecimal libPreEc) {
        this.libPreEc = libPreEc;
    }

    public BigDecimal getLibResEc() {
        return libResEc;
    }

    public void setLibResEc(BigDecimal libResEc) {
        this.libResEc = libResEc;
    }

    public BigDecimal getLibPreResEc() {
        return libPreResEc;
    }

    public void setLibPreResEc(BigDecimal libPreResEc) {
        this.libPreResEc = libPreResEc;
    }

    public BigDecimal getAgrPreEc() {
        return agrPreEc;
    }

    public void setAgrPreEc(BigDecimal agrPreEc) {
        this.agrPreEc = agrPreEc;
    }

    public BigDecimal getAgrResEc() {
        return agrResEc;
    }

    public void setAgrResEc(BigDecimal agrResEc) {
        this.agrResEc = agrResEc;
    }

    public BigDecimal getAgrPreResEc() {
        return agrPreResEc;
    }

    public void setAgrPreResEc(BigDecimal agrPreResEc) {
        this.agrPreResEc = agrPreResEc;
    }

    public BigDecimal getCrePreEc() {
        return crePreEc;
    }

    public void setCrePreEc(BigDecimal crePreEc) {
        this.crePreEc = crePreEc;
    }

    public BigDecimal getCreResEc() {
        return creResEc;
    }

    public void setCreResEc(BigDecimal creResEc) {
        this.creResEc = creResEc;
    }

    public BigDecimal getCrePreResEc() {
        return crePreResEc;
    }

    public void setCrePreResEc(BigDecimal crePreResEc) {
        this.crePreResEc = crePreResEc;
    }

    public BigDecimal getTotalPreEc() {
        return totalPreEc;
    }

    public void setTotalPreEc(BigDecimal totalPreEc) {
        this.totalPreEc = totalPreEc;
    }

    public BigDecimal getTotalResEc() {
        return totalResEc;
    }

    public void setTotalResEc(BigDecimal totalResEc) {
        this.totalResEc = totalResEc;
    }

    public BigDecimal getTotalPreResEc() {
        return totalPreResEc;
    }

    public void setTotalPreResEc(BigDecimal totalPreResEc) {
        this.totalPreResEc = totalPreResEc;
    }

    public BigDecimal getCataRiskEc() {
        return cataRiskEc;
    }

    public void setCataRiskEc(BigDecimal cataRiskEc) {
        this.cataRiskEc = cataRiskEc;
    }

    public BigDecimal getDispEff() {
        return dispEff;
    }

    public void setDispEff(BigDecimal dispEff) {
        this.dispEff = dispEff;
    }

    public BigDecimal getOverallInsEc() {
        return overallInsEc;
    }

    public void setOverallInsEc(BigDecimal overallInsEc) {
        this.overallInsEc = overallInsEc;
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

	public BigDecimal getAccPreEc() {
		return accPreEc;
	}

	public void setAccPreEc(BigDecimal accPreEc) {
		this.accPreEc = accPreEc;
	}

	public BigDecimal getAccResEc() {
		return accResEc;
	}

	public void setAccResEc(BigDecimal accResEc) {
		this.accResEc = accResEc;
	}

	public BigDecimal getAccPreResEc() {
		return accPreResEc;
	}

	public void setAccPreResEc(BigDecimal accPreResEc) {
		this.accPreResEc = accPreResEc;
	}
}