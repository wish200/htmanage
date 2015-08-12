package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/***
 * 
* @ClassName: CdCompanyBaseDto 
* @Description: CD_COMPANY
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:35:18 
*
 */
@Alias("cdCompanyBaseDto")
public class CdCompanyBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String comcode;

    private String fathercode;

    private String levelcode;

    private String comname;

    private String remark;

    private String validstate;

    public String getComcode() {
        return comcode;
    }

    public void setComcode(String comcode) {
        this.comcode = comcode == null ? null : comcode.trim();
    }

    public String getFathercode() {
        return fathercode;
    }

    public void setFathercode(String fathercode) {
        this.fathercode = fathercode == null ? null : fathercode.trim();
    }

    public String getLevelcode() {
        return levelcode;
    }

    public void setLevelcode(String levelcode) {
        this.levelcode = levelcode == null ? null : levelcode.trim();
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname == null ? null : comname.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getValidstate() {
        return validstate;
    }

    public void setValidstate(String validstate) {
        this.validstate = validstate == null ? null : validstate.trim();
    }
}