package com.huiting.manage.dto.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName: ModOdsLteiBaseDto 
 * @Description: TODO
 * @author zhangyangyang
 * @date 2014-6-17
 */
@Alias("modOdsLteiBaseDto")
public class ModOdsLteiBaseDto {
    private String statdate;

    private String endBookValue;

    public String getStatdate() {
        return statdate;
    }

    public void setStatdate(String statdate) {
        this.statdate = statdate == null ? null : statdate.trim();
    }

    public String getEndBookValue() {
        return endBookValue;
    }

    public void setEndBookValue(String endBookValue) {
        this.endBookValue = endBookValue == null ? null : endBookValue.trim();
    }
    public List<String> getListString(){
    	List<String> list=new ArrayList<String>();
    	list.add("statdate");
		list.add("endBookValue");
    	return list;
    }
}