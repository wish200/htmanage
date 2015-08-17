package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
* @ClassName: CdRiskKindBaseDto 
* @Description: CD_RISKKIND
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:38:08 
*
 */
@Alias("cdRiskKindBaseDto")
public class CdRiskKindBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String riskcode;

    private String riskname;

    private String levelcode;

    private String fathercode;

    public String getRiskcode() {
        return riskcode;
    }

    public void setRiskcode(String riskcode) {
        this.riskcode = riskcode == null ? null : riskcode.trim();
    }

    public String getRiskname() {
        return riskname;
    }

    public void setRiskname(String riskname) {
        this.riskname = riskname == null ? null : riskname.trim();
    }

    public String getLevelcode() {
        return levelcode;
    }

    public void setLevelcode(String levelcode) {
        this.levelcode = levelcode == null ? null : levelcode.trim();
    }

    public String getFathercode() {
        return fathercode;
    }

    public void setFathercode(String fathercode) {
        this.fathercode = fathercode == null ? null : fathercode.trim();
    }
}