package com.huiting.manage.dto.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName: ModOdsRealtyBaseDto 
 * @Description: TODO
 * @author zhangyangyang
 * @date 2014-6-17
 */
@Alias("modOdsRealtyBaseDto")
public class ModOdsRealtyBaseDto {
    private String statdate;

    private String historicCost;

    private String endBookValue;

    public String getStatdate() {
        return statdate;
    }

    public void setStatdate(String statdate) {
        this.statdate = statdate == null ? null : statdate.trim();
    }

    public String getHistoricCost() {
        return historicCost;
    }

    public void setHistoricCost(String historicCost) {
        this.historicCost = historicCost == null ? null : historicCost.trim();
    }

    public String getEndBookValue() {
        return endBookValue;
    }

    public void setEndBookValue(String endBookValue) {
        this.endBookValue = endBookValue == null ? null : endBookValue.trim();
    }
    public List<String> getListString(){
    	List<String> list=new ArrayList<String>();
    	list.add("statdate");list.add("historicCost");
		list.add("endBookValue");
    	return list;
    }
}