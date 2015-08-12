package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcMenuBaseDto
 * @Description: CC_MENU
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:32:43
 * 
 */
@Alias("ccMenuBaseDto")
public class CcMenuBaseDto implements Serializable {

	private static final long serialVersionUID = -6600966650257971484L;

	private String menuid;

	private String parentmenuid;

	private String menuname;

	private BigDecimal menulevel;

	private BigDecimal displayno;

	private String havesubmenu;

	private String validstatus;

	private String remark;

	private String flag;

	private String menuurl;
	
	private String fullmenuname;
	

	public String getFullmenuname() {
		return fullmenuname;
	}

	public void setFullmenuname(String fullmenuname) {
		this.fullmenuname = fullmenuname;
	}

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid == null ? null : menuid.trim();
	}

	public String getParentmenuid() {
		return parentmenuid;
	}

	public void setParentmenuid(String parentmenuid) {
		this.parentmenuid = parentmenuid == null ? null : parentmenuid.trim();
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname == null ? null : menuname.trim();
	}

	public BigDecimal getMenulevel() {
		return menulevel;
	}

	public void setMenulevel(BigDecimal menulevel) {
		this.menulevel = menulevel;
	}

	public BigDecimal getDisplayno() {
		return displayno;
	}

	public void setDisplayno(BigDecimal displayno) {
		this.displayno = displayno;
	}

	public String getHavesubmenu() {
		return havesubmenu;
	}

	public void setHavesubmenu(String havesubmenu) {
		this.havesubmenu = havesubmenu == null ? null : havesubmenu.trim();
	}

	public String getValidstatus() {
		return validstatus;
	}

	public void setValidstatus(String validstatus) {
		this.validstatus = validstatus == null ? null : validstatus.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag == null ? null : flag.trim();
	}

	public String getMenuurl() {
		return menuurl;
	}

	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl == null ? null : menuurl.trim();
	}
}