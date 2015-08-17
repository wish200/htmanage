package com.huiting.manage.dto.base;

import org.apache.ibatis.type.Alias;
/**
 * @ClassName: ModCdTemplBaseDto 
 * @Description: TODO
 * @author zhangyangyang
 * @date 2014-6-16
 */
@Alias("modCdTemplBaseDto")
public class ModCdTemplBaseDto extends ModCdTemplBaseDtoKey {
    private String filePath;
    
	public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }
}