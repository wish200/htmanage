package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;
/**
 * 
* @ClassName: CdEvaluationBaseDto 
* @Description: CD_EVALUATION
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:40:36 
*
 */
@Alias("cdEvaluationBaseDto")
public class CdEvaluationBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String evlindexcode;

    private String evlindexname;

    private String evlindexlevel;

    private BigDecimal weight;

    private String indexdesc;

    private String graderole;
    
    private  int evlindexorder;
    
    private String upevlindexcode;
    
    private int evlweightorder;


	public int getEvlindexorder() {
		return evlindexorder;
	}

	public void setEvlindexorder(int evlindexorder) {
		this.evlindexorder = evlindexorder;
	}

	public void setEvlweightorder(int evlweightorder) {
		this.evlweightorder = evlweightorder;
	}

	public String getUpevlindexcode() {
		return upevlindexcode;
	}

	public void setUpevlindexcode(String upevlindexcode) {
		this.upevlindexcode = upevlindexcode;
	}

	public int getEvlweightorder() {
		return evlweightorder;
	}

	public String getEvlindexcode() {
        return evlindexcode;
    }

    public void setEvlindexcode(String evlindexcode) {
        this.evlindexcode = evlindexcode == null ? "" : evlindexcode.trim();
    }

    public String getEvlindexname() {
        return evlindexname;
    }

    public void setEvlindexname(String evlindexname) {
        this.evlindexname = evlindexname == null ? "" : evlindexname.trim();
    }

    public String getEvlindexlevel() {
        return evlindexlevel;
    }

    public void setEvlindexlevel(String evlindexlevel) {
        this.evlindexlevel = evlindexlevel == null ? "" : evlindexlevel.trim();
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getIndexdesc() {
        return indexdesc;
    }

    public void setIndexdesc(String indexdesc) {
        this.indexdesc = indexdesc == null ? "" : indexdesc.trim();
    }

    public String getGraderole() {
        return graderole;
    }

    public void setGraderole(String graderole) {
        this.graderole = graderole == null ? "" : graderole.trim();
    }
}