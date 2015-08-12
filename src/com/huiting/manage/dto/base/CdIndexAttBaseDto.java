package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
* @ClassName: CdIndexAttBaseDto 
* @Description: CD_INDEXATT
* @author Zou_ZhuoQi
* @date 2013-12-20 下午1:39:32 
*
 */
@Alias("cdIndexAttBaseDto")
public class CdIndexAttBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String indexcode;

    private String attcode;

    private String attname;

    private String atttype;
    private String attfullname;
    private String flag;

    public String getIndexcode() {
        return indexcode;
    }

    public void setIndexcode(String indexcode) {
        this.indexcode = indexcode == null ? null : indexcode.trim();
    }

    public String getAttcode() {
        return attcode;
    }

    public void setAttcode(String attcode) {
        this.attcode = attcode == null ? null : attcode.trim();
    }

    public String getAttname() {
        return attname;
    }

    public void setAttname(String attname) {
        this.attname = attname == null ? null : attname.trim();
    }

    public String getAtttype() {
        return atttype;
    }

    public void setAtttype(String atttype) {
        this.atttype = atttype == null ? null : atttype.trim();
    }

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getAttfullname() {
		return attfullname;
	}

	public void setAttfullname(String attfullname) {
		this.attfullname = attfullname;
	}
    
}