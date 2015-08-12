package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: FlowIndexCheckBaseDto 
* @Description: FLOW_INDEXCHECK
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:37:26 
*
 */
@Alias("flowIndexCheckBaseDto")
public class FlowIndexCheckBaseDto extends FlowIndexCheckBaseDtoKey implements Serializable {

	private static final long serialVersionUID = 1L;
    private String modifcode;

    private String auditorvalid;

    private String auditorcode;

    private Date auditortime;

    private String auditopinion;

    public String getModifcode() {
        return modifcode;
    }

    public void setModifcode(String modifcode) {
        this.modifcode = modifcode == null ? null : modifcode.trim();
    }

    public String getAuditorvalid() {
        return auditorvalid;
    }

    public void setAuditorvalid(String auditorvalid) {
        this.auditorvalid = auditorvalid == null ? null : auditorvalid.trim();
    }

    public String getAuditorcode() {
        return auditorcode;
    }

    public void setAuditorcode(String auditorcode) {
        this.auditorcode = auditorcode == null ? null : auditorcode.trim();
    }

    public Date getAuditortime() {
        return auditortime;
    }

    public void setAuditortime(Date auditortime) {
        this.auditortime = auditortime;
    }

    public String getAuditopinion() {
        return auditopinion;
    }

    public void setAuditopinion(String auditopinion) {
        this.auditopinion = auditopinion == null ? null : auditopinion.trim();
    }
}