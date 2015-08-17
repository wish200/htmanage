package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
/**
 * 
 * @ClassName: ModPtBazBaseDtoKey 
 * @Description: TODO MOD_PT_BAZ
 * @author zhangyangyang
 * @date 2014-6-11
 */
@Alias("modPtBazBaseDtoKey")
public class ModPtBazBaseDtoKey implements Serializable{
    /**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private String ptScen;

    private String statdate;


    public String getPtScen() {
		return ptScen;
	}

	public void setPtScen(String ptScen) {
		this.ptScen = ptScen;
	}

	public String getStatdate() {
        return statdate;
    }

    public void setStatdate(String statdate) {
        this.statdate = statdate == null ? null : statdate.trim();
    }
}