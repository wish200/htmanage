package com.huiting.manage.dto.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName: ModOdsFundBaseDto 
 * @Description: TODO
 * @author zhangyangyang
 * @date 2014-6-17
 */
@Alias("modOdsFundBaseDto")
public class ModOdsFundBaseDto extends ModOdsFundBaseDtoKey {
    private String endBookValue;

    private String historicCost;

    private String classes;

    public String getEndBookValue() {
        return endBookValue;
    }

    public void setEndBookValue(String endBookValue) {
        this.endBookValue = endBookValue == null ? null : endBookValue.trim();
    }

    public String getHistoricCost() {
        return historicCost;
    }

    public void setHistoricCost(String historicCost) {
        this.historicCost = historicCost == null ? null : historicCost.trim();
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes == null ? null : classes.trim();
    }
    public List<String> getListString(){
    	List<String> list=new ArrayList<String>();
    	list.add("statdate");list.add("handAccount");list.add("classes");
		list.add("historicCost");list.add("endBookValue");
    	return list;
    }
}