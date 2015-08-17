package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
@Alias("cdReportTabBaseDto")
public class CdReportTabBaseDto implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String tablename;

    private String clsname;

    private String clsview;

    private Short clsno;

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public String getClsname() {
        return clsname;
    }

    public void setClsname(String clsname) {
        this.clsname = clsname == null ? null : clsname.trim();
    }

    public String getClsview() {
        return clsview;
    }

    public void setClsview(String clsview) {
        this.clsview = clsview == null ? null : clsview.trim();
    }

    public Short getClsno() {
        return clsno;
    }

    public void setClsno(Short clsno) {
        this.clsno = clsno;
    }
}