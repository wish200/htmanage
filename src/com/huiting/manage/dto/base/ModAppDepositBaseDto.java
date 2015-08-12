package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;
/**
 * @ClassName: ModAppDepositBaseDto 
 * @Description: TODO
 * @author zhangyangyang
 * @date 2014-6-18
 */
@Alias("modAppDepositBaseDto")
public class ModAppDepositBaseDto implements Serializable {
    /**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private String statdate;

    private String assetName;

    private String classes;

    private String depositProp;

    private String startYear;

    private String startMon;

    private String endYear;

    private String endMon;

    private String coupRate;

    private String interRateType;

    private String onetimePay;

    private String payFreq;

    private String realRate;

    private String endFaceValue;

    private String endBookValue;

    private String bank;

    private String deadline;

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

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes == null ? null : classes.trim();
    }

    public String getDepositProp() {
        return depositProp;
    }

    public void setDepositProp(String depositProp) {
        this.depositProp = depositProp == null ? null : depositProp.trim();
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

    public String getInterRateType() {
        return interRateType;
    }

    public void setInterRateType(String interRateType) {
        this.interRateType = interRateType == null ? null : interRateType.trim();
    }

    public String getOnetimePay() {
        return onetimePay;
    }

    public void setOnetimePay(String onetimePay) {
        this.onetimePay = onetimePay == null ? null : onetimePay.trim();
    }

    public String getPayFreq() {
        return payFreq;
    }

    public void setPayFreq(String payFreq) {
        this.payFreq = payFreq == null ? null : payFreq.trim();
    }

    public String getRealRate() {
        return realRate;
    }

    public void setRealRate(String realRate) {
        this.realRate = realRate == null ? null : realRate.trim();
    }

    public String getEndFaceValue() {
        return endFaceValue;
    }

    public void setEndFaceValue(String endFaceValue) {
        this.endFaceValue = endFaceValue == null ? null : endFaceValue.trim();
    }

    public String getEndBookValue() {
        return endBookValue;
    }

    public void setEndBookValue(String endBookValue) {
        this.endBookValue = endBookValue == null ? null : endBookValue.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline == null ? null : deadline.trim();
    }
    public List<String> getListString(){
    	List<String> list=new ArrayList<String>();
    	list.add("depositProp");
		list.add("startYear");
		list.add("startMon");
		list.add("endYear");
		list.add("endMon");
		list.add("coupRate");
		list.add("interRateType");
		list.add("onetimePay");
		list.add("payFreq");
		list.add("realRate");
		list.add("endFaceValue");
		list.add("endBookValue");
		list.add("bank");
    	return list;
    }
}