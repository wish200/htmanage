package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;

/**
 * 
* @ClassName: CdTemplateCatNoBaseDto 
* @Description: CD_TEMPLATECATNO
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:37:52 
*
 */
@Alias("cdTemplateCatNoBaseDto")
public class CdTemplateCatNoBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String templatecatno;

    private String templatecatname;

    private String validstate;

    private BigDecimal levelcode;

    private String fathercode;

    private String remark;

    public String getTemplatecatno() {
        return templatecatno;
    }

    public void setTemplatecatno(String templatecatno) {
        this.templatecatno = templatecatno == null ? null : templatecatno.trim();
    }

    public String getTemplatecatname() {
        return templatecatname;
    }

    public void setTemplatecatname(String templatecatname) {
        this.templatecatname = templatecatname == null ? null : templatecatname.trim();
    }

    public String getValidstate() {
        return validstate;
    }

    public void setValidstate(String validstate) {
        this.validstate = validstate == null ? null : validstate.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}