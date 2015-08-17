package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
/**
  * @ClassName: AppEvaluationBaseDto
  * @Description: APP_EVALUATION
  * @author: zhangyangyang
  * @date 2014-2-12 下午4:44:20
 */
@Alias("appEvaluationBaseDto")
public class AppEvaluationBaseDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private String indexname;

    private String indexvalue;

    private String  statdate;

    private String evlindexcode;

    private String weightvalue;

    public String getIndexname() {
        return indexname;
    }

    public void setIndexname(String indexname) {
        this.indexname = indexname == null ? "" : indexname.trim();
    }
    public String getIndexvalue() {
		return indexvalue== null ? "" : indexvalue.trim();
	}

	public void setIndexvalue(String indexvalue) {
		this.indexvalue = indexvalue;
	}

	

    public String getStatdate() {
		return statdate;
	}

	public void setStatdate(String statdate) {
		this.statdate = statdate;
	}

	public String getEvlindexcode() {
        return evlindexcode;
    }

    public void setEvlindexcode(String evlindexcode) {
        this.evlindexcode = evlindexcode == null ? "" : evlindexcode.trim();
    }

    public String getWeightvalue() {
        return weightvalue;
    }

    public void setWeightvalue(String weightvalue) {
        this.weightvalue = weightvalue == null ? "" : weightvalue.trim();
    }
}