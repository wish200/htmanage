package com.huiting.manage.dto.base;


public class ModOdsCrBaseDtoKey {
    private String statdate;

    private String assetName;

    private String investType;

    private String interRateType;

    private String creditRating;

    private String investFlag;

    private String startdate;

    private String enddate;

    private String depositRate;

    private String daysNext;

    private String days;

    private String bazCode;

    public String getStatdate() {
        return statdate;
    }

    public void setStatdate(String statdate) {
        this.statdate = statdate == null ? null : statdate.trim();
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName == null ? null : assetName.trim();
    }

    public String getInvestType() {
        return investType;
    }

    public void setInvestType(String investType) {
        this.investType = investType == null ? null : investType.trim();
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

    public String getDepositRate() {
		return depositRate;
	}

	public void setDepositRate(String depositRate) {
		this.depositRate = depositRate;
	}

	public String getDaysNext() {
		return daysNext;
	}

	public void setDaysNext(String daysNext) {
		this.daysNext = daysNext;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getBazCode() {
        return bazCode;
    }

    public void setBazCode(String bazCode) {
        this.bazCode = bazCode == null ? null : bazCode.trim();
    }
}