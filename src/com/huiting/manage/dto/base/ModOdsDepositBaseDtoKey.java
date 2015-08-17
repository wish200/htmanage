package com.huiting.manage.dto.base;


public class ModOdsDepositBaseDtoKey {
    private String statdate;

    private String prodName;

    private String assetName;

    private String assetType;

    private String interRateType;

    private String creditRating;

    private String investFlag;

    private String startdate;

    private String enddate;

    private String coupRate;

    private String bazCode;

    public String getStatdate() {
        return statdate;
    }

    public void setStatdate(String statdate) {
        this.statdate = statdate == null ? null : statdate.trim();
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName == null ? null : prodName.trim();
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName == null ? null : assetName.trim();
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType == null ? null : assetType.trim();
    }

    public String getInterRateType() {
        return interRateType;
    }

    public void setInterRateType(String interRateType) {
        this.interRateType = interRateType == null ? null : interRateType.trim();
    }

    public String getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(String creditRating) {
        this.creditRating = creditRating == null ? null : creditRating.trim();
    }

    public String getInvestFlag() {
        return investFlag;
    }

    public void setInvestFlag(String investFlag) {
        this.investFlag = investFlag == null ? null : investFlag.trim();
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate == null ? null : startdate.trim();
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate == null ? null : enddate.trim();
    }

    public String getCoupRate() {
		return coupRate;
	}

	public void setCoupRate(String coupRate) {
		this.coupRate = coupRate;
	}

	public String getBazCode() {
        return bazCode;
    }

    public void setBazCode(String bazCode) {
        this.bazCode = bazCode == null ? null : bazCode.trim();
    }
}