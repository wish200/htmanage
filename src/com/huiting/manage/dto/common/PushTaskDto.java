package com.huiting.manage.dto.common;

import org.apache.ibatis.type.Alias;

@Alias("pushTaskDto")
public class PushTaskDto {
	private String comcode;
	private String statdate;
	private String maindepmentcode;
	private String taskcode;
	private String indexname;
	private String acceptorcode;
	public String getComcode() {
		return comcode;
	}
	public void setComcode(String comcode) {
		this.comcode = comcode;
	}
	public String getStatdate() {
		return statdate;
	}
	public void setStatdate(String statdate) {
		this.statdate = statdate;
	}
	public String getMaindepmentcode() {
		return maindepmentcode;
	}
	public void setMaindepmentcode(String maindepmentcode) {
		this.maindepmentcode = maindepmentcode;
	}
	public String getTaskcode() {
		return taskcode;
	}
	public void setTaskcode(String taskcode) {
		this.taskcode = taskcode;
	}
	public String getIndexname() {
		return indexname;
	}
	public void setIndexname(String indexname) {
		this.indexname = indexname;
	}
	public String getAcceptorcode() {
		return acceptorcode;
	}
	public void setAcceptorcode(String acceptorcode) {
		this.acceptorcode = acceptorcode;
	}
	
	
	
}
