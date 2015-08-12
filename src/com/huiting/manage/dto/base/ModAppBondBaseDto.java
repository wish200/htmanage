package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;
/**
 * @ClassName: ModAppBondBaseDto 
 * @Description: TODO
 * @author zhangyangyang
 * @date 2014-6-18
 */
@Alias("modAppBondBaseDto")
public class ModAppBondBaseDto implements Serializable {
    /**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private String statdate;

    private String bondType;

    private String interRateType;

    private String haveType;

    private String creditRating;

    private String handAccount;

    private String startYear;

    private String startMon;

    private String endYear;

    private String endMon;

    private String coupRate;

    private String payFreq;

    private String costPrice;

    private String facevalue;

    private String realRate;

    private String endBookValue;

    private String endBazValue;

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

    public String getHandAccount() {
        return handAccount;
    }

    public void setHandAccount(String handAccount) {
        this.handAccount = handAccount == null ? null : handAccount.trim();
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear == null ? null : startYear.trim();
    }

    public String getStartMon() {
        return startMon;
    }

    public void setStartMon(String startMon) {
        this.startMon = startMon == null ? null : startMon.trim();
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear == null ? null : endYear.trim();
    }

    public String getEndMon() {
        return endMon;
    }

    public void setEndMon(String endMon) {
        this.endMon = endMon == null ? null : endMon.trim();
    }

    public String getCoupRate() {
        return coupRate;
    }

    public void setCoupRate(String coupRate) {
        this.coupRate = coupRate == null ? null : coupRate.trim();
    }

    public String getPayFreq() {
        return payFreq;
    }

    public void setPayFreq(String payFreq) {
        this.payFreq = payFreq == null ? null : payFreq.trim();
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice == null ? null : costPrice.trim();
    }

    public String getFacevalue() {
        return facevalue;
    }

    public void setFacevalue(String facevalue) {
        this.facevalue = facevalue == null ? null : facevalue.trim();
    }

    public String getRealRate() {
        return realRate;
    }

    public void setRealRate(String realRate) {
        this.realRate = realRate == null ? null : realRate.trim();
    }

    public String getEndBookValue() {
        return endBookValue;
    }

    public void setEndBookValue(String endBookValue) {
        this.endBookValue = endBookValue == null ? null : endBookValue.trim();
    }

    public String getEndBazValue() {
        return endBazValue;
    }

    public void setEndBazValue(String endBazValue) {
        this.endBazValue = endBazValue == null ? null : endBazValue.trim();
    }
    public List<String> getListString(){
    	List<String> list=new ArrayList<String>();
    	list.add("bondType");
    	list.add("interRateType");
    	list.add("haveType");
    	list.add("creditRating");
    	list.add("handAccount");
    	list.add("startYear");
    	list.add("startMon");
    	list.add("endYear");
    	list.add("endMon");
    	list.add("coupRate");
    	list.add("payFreq");
    	list.add("costPrice");
    	list.add("facevalue");
    	list.add("realRate");
    	list.add("endBookValue");
    	list.add("endBazValue");
    	return list;
    }
}