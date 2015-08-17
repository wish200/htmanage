package com.huiting.manage.dto.base;

import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
 * @ClassName: ModCdStatusBaseDto 
 * @Description: TODO
 * @author zhangyangyang
 * @date 2014-6-16
 */
@Alias("modCdStatusBaseDto")
public class ModCdStatusBaseDto extends ModCdStatusBaseDtoKey {
    private String filePath;

    private String operate;

    private Date inputdate;
    private String uptype;
   
    
    private String templatenum;

    
    public String getTemplatenum() {
		return templatenum;
	}

	public void setTemplatenum(String templatenum) {
		this.templatenum = templatenum;
	}

	public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate == null ? null : operate.trim();
    }

    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }

	public String getUptype() {
		return uptype;
	}

	public void setUptype(String uptype) {
		this.uptype = uptype;
	}
    
}