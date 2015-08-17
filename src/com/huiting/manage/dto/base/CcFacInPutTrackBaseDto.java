package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CcFacInPutTrackBaseDto
 * @Description: CC_FACINPUTTRACK
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:32:11
 * 
 */
@Alias("ccFacInPutTrackBaseDto")
public class CcFacInPutTrackBaseDto extends CcFacInPutTrackBaseDtoKey implements
		Serializable {

	private static final long serialVersionUID = 1L;
	private String inputstate;

	private Date inputdate;

	public String getInputstate() {
		return inputstate;
	}

	public void setInputstate(String inputstate) {
		this.inputstate = inputstate == null ? null : inputstate.trim();
	}

	public Date getInputdate() {
		return inputdate;
	}

	public void setInputdate(Date inputdate) {
		this.inputdate = inputdate;
	}
}