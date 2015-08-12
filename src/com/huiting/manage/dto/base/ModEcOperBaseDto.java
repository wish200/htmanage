package com.huiting.manage.dto.base;

import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;
/**
 * 操作风险经济资本实体类
 * @author ncp
 *
 */
@Alias("modEcOperBaseDto")
public class ModEcOperBaseDto extends ModEcOperBaseDtoKey {
    private BigDecimal ec;

    private String filePath;
   

    public BigDecimal getEc() {
        return ec;
    }

    public void setEc(BigDecimal ec) {
        this.ec = ec;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }
    
}