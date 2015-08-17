package com.huiting.manage.dto.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName: ModOdsStockBaseDto 
 * @Description: TODO
 * @author zhangyangyang
 * @date 2014-6-17
 */
@Alias("modOdsStockBaseDto")
public class ModOdsStockBaseDto extends ModOdsStockBaseDtoKey {
    private String historicCost;

    private String endBookValue;

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
    	list.add("statdate");list.add("handAccount");
		list.add("historicCost");list.add("endBookValue");
    	return list;
    }
}