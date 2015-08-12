package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName: AppIdxMainDepBaseDto 
 * @Description: app_idxmaindep 指标与主责部门的表
 * @author zhangyangyang
 */
@Alias("appIdxMainDepBaseDto")
public class AppIdxMainDepBaseDto implements Serializable{
	
    /**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private String indexcode;

    private String maindepName;

    private String comcode;

    public String getIndexcode() {
        return indexcode;
    }

    public void setIndexcode(String indexcode) {
        this.indexcode = indexcode == null ? null : indexcode.trim();
    }

    public String getMaindepName() {
        return maindepName;
    }

    public void setMaindepName(String maindepName) {
        this.maindepName = maindepName == null ? null : maindepName.trim();
    }

    public String getComcode() {
        return comcode;
    }

    public void setComcode(String comcode) {
        this.comcode = comcode == null ? null : comcode.trim();
    }
}