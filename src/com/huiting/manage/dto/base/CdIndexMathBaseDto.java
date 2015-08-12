package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
* @ClassName: CdIndexMathBaseDto 
* @Description: CD_INDEXMATH
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:38:59 
*
 */
@Alias("cdIndexMathBaseDto")
public class CdIndexMathBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String indexcode;

    private String indexmatch;

    public String getIndexcode() {
        return indexcode;
    }

    public void setIndexcode(String indexcode) {
        this.indexcode = indexcode == null ? null : indexcode.trim();
    }

	public String getIndexmatch() {
		return indexmatch;
	}

	public void setIndexmatch(String indexmatch) {
		this.indexmatch = indexmatch;
	}

}