package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;
import org.apache.ibatis.type.Alias;

/**
 * @ClassName: CdIdxRangsHisBaseDtoKey
 * @Description: 指标罚值区间历史表主键 cd_idxrangs_his
 * @author Zou_ZhuoQi
 * @date 2013-12-24 上午10:24:23
 */

@Alias("cdIdxRangsHisBaseDtoKey")
public class CdIdxRangsHisBaseDtoKey implements Serializable {
	private static final long serialVersionUID = 1L;
	// 指标代码
	private String indexcode;
	// 修改时间
	private Date updatetime;
	// 修改人代码
	private String modifcode;

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
}