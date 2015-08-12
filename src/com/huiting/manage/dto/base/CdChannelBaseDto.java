package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CdChannelBaseDto
 * @Description: CD_CHANNEL
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:35:02
 * 
 */
@Alias("cdChannelBaseDto")
public class CdChannelBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String channelcode;

	private String channelname;

	private String fathercode;

	private String levelcode;

	private String remark;

	public String getChannelcode() {
		return channelcode;
	}

	public void setChannelcode(String channelcode) {
		this.channelcode = channelcode == null ? null : channelcode.trim();
	}

	public String getChannelname() {
		return channelname;
	}

	public void setChannelname(String channelname) {
		this.channelname = channelname == null ? null : channelname.trim();
	}

	public String getFathercode() {
		return fathercode;
	}

	public void setFathercode(String fathercode) {
		this.fathercode = fathercode == null ? null : fathercode.trim();
	}

	public String getLevelcode() {
		return levelcode;
	}

	public void setLevelcode(String levelcode) {
		this.levelcode = levelcode == null ? null : levelcode.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}