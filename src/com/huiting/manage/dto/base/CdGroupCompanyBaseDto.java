package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: CdGroupCompanyBaseDto 
* @Description: CD_GROUPCOMPANY
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:40:09 
*
 */
@Alias("cdGroupCompanyBaseDto")
public class CdGroupCompanyBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String comcode;

    private String groupcomname;

    private String fathercode;

    private BigDecimal levelcode;

    private String groupcomcode;

    private String validstate;

    public String getComcode() {
        return comcode;
    }

    public void setComcode(String comcode) {
        this.comcode = comcode == null ? null : comcode.trim();
    }

    public String getGroupcomname() {
        return groupcomname;
    }

    public void setGroupcomname(String groupcomname) {
        this.groupcomname = groupcomname == null ? null : groupcomname.trim();
    }

    public String getFathercode() {
        return fathercode;
    }

    public void setFathercode(String fathercode) {
        this.fathercode = fathercode == null ? null : fathercode.trim();
    }

    public BigDecimal getLevelcode() {
        return levelcode;
    }

    public void setLevelcode(BigDecimal levelcode) {
        this.levelcode = levelcode;
    }

    public String getGroupcomcode() {
        return groupcomcode;
    }

    public void setGroupcomcode(String groupcomcode) {
        this.groupcomcode = groupcomcode == null ? null : groupcomcode.trim();
    }

    public String getValidstate() {
        return validstate;
    }

    public void setValidstate(String validstate) {
        this.validstate = validstate == null ? null : validstate.trim();
    }
}