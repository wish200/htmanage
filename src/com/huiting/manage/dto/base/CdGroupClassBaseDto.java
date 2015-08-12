package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: CdGroupClassBaseDto 
* @Description: CD_GROUPCLASS
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:40:16 
*
 */
@Alias("cdGroupClassBaseDto")
public class CdGroupClassBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String classcode;

    private String groupclasscode;

    private String groupclassname;

    private BigDecimal levelcode;

    private String fathercode;

    private String validstate;

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode == null ? null : classcode.trim();
    }

    public String getGroupclasscode() {
        return groupclasscode;
    }

    public void setGroupclasscode(String groupclasscode) {
        this.groupclasscode = groupclasscode == null ? null : groupclasscode.trim();
    }

    public String getGroupclassname() {
        return groupclassname;
    }

    public void setGroupclassname(String groupclassname) {
        this.groupclassname = groupclassname == null ? null : groupclassname.trim();
    }

    public BigDecimal getLevelcode() {
        return levelcode;
    }

    public void setLevelcode(BigDecimal levelcode) {
        this.levelcode = levelcode;
    }

    public String getFathercode() {
        return fathercode;
    }

    public void setFathercode(String fathercode) {
        this.fathercode = fathercode == null ? null : fathercode.trim();
    }

    public String getValidstate() {
        return validstate;
    }

    public void setValidstate(String validstate) {
        this.validstate = validstate == null ? null : validstate.trim();
    }
}