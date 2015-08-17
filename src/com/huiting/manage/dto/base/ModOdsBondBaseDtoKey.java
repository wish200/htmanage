package com.huiting.manage.dto.base;


public class ModOdsBondBaseDtoKey {
    private String statdate;

    private String bondType;

    private String interRateType;

    private String haveType;

    private String creditRating;

    private String investFlag;

    private String startdate;

    private String enddate;

    private String numsPay;

    private String daysNext;

    private String faceValue;

    private String facevalue;

    private String days;

    private String daysHave;

    private String bazCode;

    private String coupRate;

    private String cost;

    public String getStatdate() {
        return statdate;
    }

    public void setStatdate(String statdate) {
        this.statdate = statdate == null ? null : statdate.trim();
    }

    public String getBondType() {
        return bondType;
    }

    public void setBondType(String bondType) {
        this.bondType = bondType == null ? null : bondType.trim();
    }

    public String getInterRateType() {
        return interRateType;
    }

    public void setInterRateType(String interRateType) {
        this.interRateType = interRateType == null ? null : interRateType.trim();
    }

    public String getHaveType() {
        return haveType;
    }

    public void setHaveType(String haveType) {
        this.haveType = haveType == null ? null : haveType.trim();
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

	public String getNumsPay() {
		return numsPay;
	}

	public void setNumsPay(String numsPay) {
		this.numsPay = numsPay;
	}

	public String getDaysNext() {
		return daysNext;
	}

	public void setDaysNext(String daysNext) {
		this.daysNext = daysNext;
	}

	public String getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(String faceValue) {
		this.faceValue = faceValue;
	}

	public String getFacevalue() {
		return facevalue;
	}

	public void setFacevalue(String facevalue) {
		this.facevalue = facevalue;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getDaysHave() {
		return daysHave;
	}

	public void setDaysHave(String daysHave) {
		this.daysHave = daysHave;
	}

	public String getBazCode() {
		return bazCode;
	}

	public void setBazCode(String bazCode) {
		this.bazCode = bazCode;
	}

	public String getCoupRate() {
		return coupRate;
	}

	public void setCoupRate(String coupRate) {
		this.coupRate = coupRate;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

}