package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: FlowIndexCheckBaseDtoKey 
* @Description: FLOW_INDEXCHECK 主键
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:37:15 
*
 */
@Alias("flowIndexCheckBaseDtoKey")
public class FlowIndexCheckBaseDtoKey implements Serializable {

	private static final long serialVersionUID = 1L;
    private String indexcode;

    private Integer auditcount;
    
    private Date subtime;

    public String getIndexcode() {
        return indexcode;
    }

    public void setIndexcode(String indexcode) {
        this.indexcode = indexcode == null ? null : indexcode.trim();
    }

    public Date getSubtime() {
        return subtime;
    }

    public void setSubtime(Date subtime) {
        this.subtime = subtime;
    }

	public Integer getAuditcount() {
		return auditcount;
	}

	public void setAuditcount(Integer auditcount) {
		this.auditcount = auditcount;
	}
    
}