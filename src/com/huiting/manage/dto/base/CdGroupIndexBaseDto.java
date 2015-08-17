package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: CdGroupIndexBaseDto 
* @Description: CD_GROUPINDEX
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:40:02 
*
 */
@Alias("cdGroupIndexBaseDto")
public class CdGroupIndexBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String indexcode;

    private String groupindexcode;

    private String validstate;

    private String fathercode;

    private BigDecimal levelcode;

    private String groupindexname;

    public String getIndexcode() {
        return indexcode;
    }

    public void setIndexcode(String indexcode) {
        this.indexcode = indexcode == null ? null : indexcode.trim();
    }

    public String getGroupindexcode() {
        return groupindexcode;
    }

    public void setGroupindexcode(String groupindexcode) {
        this.groupindexcode = groupindexcode == null ? null : groupindexcode.trim();
    }

    public String getValidstate() {
        return validstate;
    }

    public void setValidstate(String validstate) {
        this.validstate = validstate == null ? null : validstate.trim();
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

    public String getGroupindexname() {
        return groupindexname;
    }

    public void setGroupindexname(String groupindexname) {
        this.groupindexname = groupindexname == null ? null : groupindexname.trim();
    }
}