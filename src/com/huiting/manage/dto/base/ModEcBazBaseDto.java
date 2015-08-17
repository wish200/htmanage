package com.huiting.manage.dto.base;

import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;
/**
 * 市场风险经济资本
 * @ClassName: ModPtBazBaseDto 
 * @Description: TODO MOD_PT_BAZ
 * @author zhangyangyang
 * @date 2014-6-11
 */
@Alias("modEcBazBaseDto")
public class ModEcBazBaseDto {
    private String statdate;
    
    private BigDecimal ecInterRate;//利率风险经济资本

    private BigDecimal ecInterMarg;//利差风险经济资本

    private BigDecimal ecExchRate;//汇率风险经济资本

    private BigDecimal ecEquitPric;//权益价格风险经济资本

    private BigDecimal ecEstatPric;//房地产价格风险经济资本

    private BigDecimal dispEff;//分散效应

    private BigDecimal ecTotBaz;//总体市场风险经济资本

    private String validstate;

    private BigDecimal quant;//分位点
    private BigDecimal ecInterRate1;//利率风险经济资本--账面

    private BigDecimal ecInterMarg1;//利差风险经济资本--账面

    private BigDecimal ecExchRate1;//汇率风险经济资本--账面

    private BigDecimal ecEquitPric1;//权益价格风险经济资本--账面

    private BigDecimal ecEstatPric1;//房地产价格风险经济资本--账面

    private BigDecimal dispEff1;//分散效应--账面

    private BigDecimal ecTotBaz1;//总体市场风险经济资本--账面

    public String getStatdate() {
        return statdate;
    }

    public void setStatdate(String statdate) {
        this.statdate = statdate == null ? null : statdate.trim();
    }
    /**
     *利率风险经济资本
     * @return
     */
    public BigDecimal getEcInterRate() {
    	this.ecInterRate =  ecInterRate == null ? new BigDecimal(0) : ecInterRate;
        return ecInterRate;
    }

    public void setEcInterRate(BigDecimal ecInterRate) {
        this.ecInterRate = ecInterRate;
    }
    /**
     * 利差风险经济资本
     * @return
     */
    public BigDecimal getEcInterMarg() {
    	this.ecInterMarg =  ecInterMarg == null ? new BigDecimal(0) : ecInterMarg;
        return ecInterMarg;
    }

    public void setEcInterMarg(BigDecimal ecInterMarg) {
        this.ecInterMarg = ecInterMarg;
    }
    /**
     * 汇率风险经济资本
     * @return
     */
    public BigDecimal getEcExchRate() {
    	this.ecExchRate = (BigDecimal) (ecExchRate == null ? new BigDecimal(0) : ecExchRate);
        return ecExchRate;
    }

    public void setEcExchRate(BigDecimal ecExchRate) {
        this.ecExchRate = ecExchRate;
    }
    /**
     * 权益价格风险经济资本
     * @return
     */
    public BigDecimal getEcEquitPric() {
    	this.ecEquitPric = (BigDecimal) (ecEquitPric == null ? new BigDecimal(0) : ecEquitPric);
        return ecEquitPric;
    }

    public void setEcEquitPric(BigDecimal ecEquitPric) {
        this.ecEquitPric = ecEquitPric;
    }
    /**
     * 房地产价格风险经济资本
     * @return
     */
    public BigDecimal getEcEstatPric() {
    	this.ecEstatPric = (BigDecimal) (ecEstatPric == null ? new BigDecimal(0) : ecEstatPric);
        return ecEstatPric;
    }

    public void setEcEstatPric(BigDecimal ecEstatPric) {
        this.ecEstatPric = ecEstatPric;
    }
    /**
     * 分散效应
     * @return
     */
    public BigDecimal getDispEff() {
        return dispEff;
    }

    public void setDispEff(BigDecimal dispEff) {
        this.dispEff = dispEff;
    }
    /**
     * 总体市场风险经济资本
     * @return
     */
    public BigDecimal getEcTotBaz() {
    	this.ecTotBaz = (BigDecimal) (ecTotBaz == null ? new BigDecimal(0) : ecTotBaz);
        return ecTotBaz;
    }

    public void setEcTotBaz(BigDecimal ecTotBaz) {
        this.ecTotBaz = ecTotBaz;
    }

    public String getValidstate() {
        return validstate;
    }

    public void setValidstate(String validstate) {
        this.validstate = validstate == null ? null : validstate.trim();
    }
    /**
     * 分位点
     * @return
     */
    public BigDecimal getQuant() {
        return quant;
    }

    public void setQuant(BigDecimal quant) {
        this.quant = quant;
    }

	public BigDecimal getEcInterRate1() {
		this.ecInterRate1 = (BigDecimal) (ecInterRate1 == null ? new BigDecimal(0) : ecInterRate1);
		return ecInterRate1;
	}

	public void setEcInterRate1(BigDecimal ecInterRate1) {
		this.ecInterRate1 = ecInterRate1;
	}

	public BigDecimal getEcInterMarg1() {
		this.ecInterMarg1 =  ecInterMarg1 == null ? new BigDecimal(0) : ecInterMarg1;
		return ecInterMarg1;
	}

	public void setEcInterMarg1(BigDecimal ecInterMarg1) {
		this.ecInterMarg1 = ecInterMarg1;
	}

	public BigDecimal getEcExchRate1() {
		this.ecExchRate1 = (BigDecimal) (ecExchRate1 == null ? new BigDecimal(0) : ecExchRate1);
		return ecExchRate1;
	}

	public void setEcExchRate1(BigDecimal ecExchRate1) {
		this.ecExchRate1 = ecExchRate1;
	}

	public BigDecimal getEcEquitPric1() {
		this.ecEquitPric1 = (BigDecimal) (ecEquitPric1 == null ? new BigDecimal(0) : ecEquitPric1);
		return ecEquitPric1;
	}

	public void setEcEquitPric1(BigDecimal ecEquitPric1) {
		this.ecEquitPric1 = ecEquitPric1;
	}

	public BigDecimal getEcEstatPric1() {
		this.ecEstatPric1 = (BigDecimal) (ecEstatPric1 == null ? new BigDecimal(0) : ecEstatPric1);
		return ecEstatPric1;
	}

	public void setEcEstatPric1(BigDecimal ecEstatPric1) {
		this.ecEstatPric1 = ecEstatPric1;
	}

	public BigDecimal getDispEff1() {
		return dispEff1;
	}

	public void setDispEff1(BigDecimal dispEff1) {
		this.dispEff1 = dispEff1;
	}

	public BigDecimal getEcTotBaz1() {
		this.ecTotBaz1 = (BigDecimal) (ecTotBaz1 == null ? new BigDecimal(0) : ecTotBaz1);
		return ecTotBaz1;
	}

	public void setEcTotBaz1(BigDecimal ecTotBaz1) {
		this.ecTotBaz1 = ecTotBaz1;
	}
    
    
}