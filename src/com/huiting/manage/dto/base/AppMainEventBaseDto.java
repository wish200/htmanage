package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: AppMainEventBaseDto
 * @Description: APP_MAINEVENT
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:29:54
 * 
 */
@Alias("appMainEventBaseDto")
public class AppMainEventBaseDto extends AppMainEventBaseDtoKey implements Serializable{
	private static final long serialVersionUID = 1L;

	private String eventreason;

    private String estloss;

    private String measures;

    private String others;
    
    private String validstate; 
    
    private String newdepcode;

    
    public String getNewdepcode() {
		return newdepcode;
	}

	public void setNewdepcode(String newdepcode) {
		this.newdepcode = newdepcode;
	}

	public String getEventreason() {
        return eventreason;
    }

    public void setEventreason(String eventreason) {
        this.eventreason = eventreason == null ? null : eventreason.trim();
    }

    public String getEstloss() {
        return estloss;
    }

    public void setEstloss(String estloss) {
        this.estloss = estloss == null ? null : estloss.trim();
    }

    public String getMeasures() {
        return measures;
    }

    public void setMeasures(String measures) {
        this.measures = measures == null ? null : measures.trim();
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others == null ? null : others.trim();
    }

	public String getValidstate() {
		return validstate;
	}

	public void setValidstate(String validstate) {
		this.validstate = validstate;
	}
}