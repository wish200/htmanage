package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: AppIndexViewBaseDtoKey
 * @Description: APP_INDEXVIEW 主键
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:30:04
 * 
 */
@Alias("appIndexViewBaseDtoKey")
public class AppIndexViewBaseDtoKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected String indexcode;

	private Date statdate;

	private String classcode;

	private String channelcode;

	private String comcode;

	public String getIndexcode() {
		return indexcode;
	}

	public void setIndexcode(String indexcode) {
		this.indexcode = indexcode == null ? null : indexcode.trim();
	}

	public Date getStatdate() {
		return statdate;
	}

	public void setStatdate(Date statdate) {
		this.statdate = statdate;
	}

	public String getClasscode() {
		return classcode;
	}

	public void setClasscode(String classcode) {
		this.classcode = classcode == null ? null : classcode.trim();
	}

	public String getChannelcode() {
		return channelcode;
	}

	public void setChannelcode(String channelcode) {
		this.channelcode = channelcode == null ? null : channelcode.trim();
	}

	public String getComcode() {
		return comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode == null ? null : comcode.trim();
	}
}