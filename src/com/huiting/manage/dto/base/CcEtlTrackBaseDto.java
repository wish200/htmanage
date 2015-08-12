package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcEtlTrackBaseDto
 * @Description: CC_ETLTRACK
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:31:55
 * 
 */
@Alias("ccEtlTrackBaseDto")
public class CcEtlTrackBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date statdate;

	private String exectype;

	public Date getStatdate() {
		return statdate;
	}

	public void setStatdate(Date statdate) {
		this.statdate = statdate;
	}

	public String getExectype() {
		return exectype;
	}

	public void setExectype(String exectype) {
		this.exectype = exectype == null ? null : exectype.trim();
	}
}