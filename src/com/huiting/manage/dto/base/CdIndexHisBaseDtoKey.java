package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName: CdIndexHisBaseDtoKey
 * @Description: 指标历史表主键 cd_index_his
 * @author Zou_ZhuoQi
 * @date 2013-12-24 上午10:28:35
 */
@Alias("cdIndexHisBaseDtoKey")
public class CdIndexHisBaseDtoKey implements Serializable {

	private static final long serialVersionUID = 1L;
	// 指标代码
	private String indexcode;
	// 修改时间
	private Date updatetime;
	// 修改人代码
	private String modifcode;
	private String comcode;

	public String getIndexcode() {
		return indexcode;
	}

	public void setIndexcode(String indexcode) {
		this.indexcode = indexcode == null ? null : indexcode.trim();
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getModifcode() {
		return modifcode;
	}

	public void setModifcode(String modifcode) {
		this.modifcode = modifcode == null ? null : modifcode.trim();
	}

	public String getComcode() {
		return comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode;
	}
	
}