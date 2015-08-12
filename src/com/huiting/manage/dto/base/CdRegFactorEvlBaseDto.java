package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
* @ClassName: CdRegFactorEvlBaseDto 
* @Description: CD_REGFACTOR_EVL
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:38:45 
*
 */
@Alias("cdRegFactorEvlBaseDto")
public class CdRegFactorEvlBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String faccode;

    private String evlindexcode;

    public String getFaccode() {
        return faccode;
    }

    public void setFaccode(String faccode) {
        this.faccode = faccode == null ? null : faccode.trim();
    }

    public String getEvlindexcode() {
        return evlindexcode;
    }

    public void setEvlindexcode(String evlindexcode) {
        this.evlindexcode = evlindexcode == null ? null : evlindexcode.trim();
    }
}