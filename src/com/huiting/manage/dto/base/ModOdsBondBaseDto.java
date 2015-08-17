package com.huiting.manage.dto.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;
@Alias("modOdsBondBaseDto")
public class ModOdsBondBaseDto extends ModOdsBondBaseDtoKey {
    private String endValue;

    private String realRate;

    private String realRateHave;

    
    public String getEndValue() {
		return endValue;
	}


	public void setEndValue(String endValue) {
		this.endValue = endValue;
	}


	public String getRealRate() {
		return realRate;
	}


	public void setRealRate(String realRate) {
		this.realRate = realRate;
	}


	public String getRealRateHave() {
		return realRateHave;
	}


	public void setRealRateHave(String realRateHave) {
		this.realRateHave = realRateHave;
	}


	public List<String> getListString(){
    	List<String> list=new ArrayList<String>();
    	list.add("statdate");
		list.add("bondType");
		list.add("interRateType");
		list.add("haveType");
		list.add("creditRating");
		list.add("investFlag");
		list.add("startdate");
		list.add("enddate");
		list.add("numsPay");
		list.add("daysNext");
		list.add("faceValue");
		list.add("facevalue");
		list.add("days");
		list.add("daysHave");
		list.add("bazCode");
		list.add("coupRate");
		list.add("cost");
		list.add("endValue");
		list.add("realRate");
		list.add("realRateHave");
    	return list;
    }
}