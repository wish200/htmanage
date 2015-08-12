package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
/**
  * @ClassName: MppReportBaseDto
  * @Description: mpp_report
  * @author: zhangyangyang
  * @date 2014-2-10 下午5:43:53
 */
@Alias("mppReportBaseDto")
public class MppReportBaseDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String tablename;

    private String bksstype;

    private String tabletype;
    private String tableuse;

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public String getBksstype() {
        return bksstype;
    }

    public void setBksstype(String bksstype) {
        this.bksstype = bksstype == null ? null : bksstype.trim();
    }

    public String getTabletype() {
        return tabletype;
    }

    public void setTabletype(String tabletype) {
        this.tabletype = tabletype == null ? null : tabletype.trim();
    }

	public String getTableuse() {
		return tableuse;
	}

	public void setTableuse(String tableuse) {
		this.tableuse = tableuse;
	}
    
}