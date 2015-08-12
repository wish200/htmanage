package com.huiting.manage.dto.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;
@Alias("modOdsDepositBaseDto")
public class ModOdsDepositBaseDto extends ModOdsDepositBaseDtoKey {
    private String endValue;

    private String realYield;

    public String getEndValue() {
		return endValue;
	}

	public void setEndValue(String endValue) {
		this.endValue = endValue;
	}

	public String getRealYield() {
		return realYield;
	}

	public void setRealYield(String realYield) {
		this.realYield = realYield;
	}

	public List<String> getListString(){
    	List<String> list=new ArrayList<String>();
    	list.add("statdate");
		list.add("prodName");
		list.add("assetName");
		list.add("assetType");
		list.add("interRateType");
		list.add("creditRating");
		list.add("investFlag");
		list.add("startdate");
		list.add("enddate");
		list.add("coupRate");
		list.add("bazCode");
		list.add("endValue");
		list.add("realYield");
    	return list;
    }
}