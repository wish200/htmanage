package com.huiting.manage.dto.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("modOdsCashBaseDto")
public class ModOdsCashBaseDto extends ModOdsCashBaseDtoKey {
    private String endBookValue;

    public String getEndBookValue() {
        return endBookValue;
    }

    public void setEndBookValue(String endBookValue) {
        this.endBookValue = endBookValue == null ? null : endBookValue.trim();
    }
    
    public List<String> getListString(){
    	List<String> list=new ArrayList<String>();
    	list.add("statdate");list.add("classes");
		list.add("endBookValue");
    	return list;
    }
}