package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcFacInPutTrackBaseDtoKey
 * @Description: CC_FACINPUTTRACK 主键
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:32:18
 * 
 */
@Alias("ccFacInPutTrackBaseDtoKey")
public class CcFacInPutTrackBaseDtoKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private String faccode;

	private Date statdate;
	private String filltercom;

	public String getFaccode() {
		return faccode;
	}
	
	public String getFilltercom() {
		return filltercom;
	}

	public void setFilltercom(String filltercom) {
		this.filltercom = filltercom;
	}

	public void setFaccode(String faccode) {
		this.faccode = faccode == null ? null : faccode.trim();
	}

	public Date getStatdate() {
		return statdate;
	}

	public void setStatdate(Date statdate) {
		this.statdate = statdate;
	}
}