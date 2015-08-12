package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
/**
  * @ClassName: CdIdxCatgoryBaseDto
  * @Description: cd_idxcatgory
  * @author: zhangyangyang
  * @date 2014-2-12 上午11:42:14
 */
@Alias("cdIdxCatgoryBaseDto")
public class CdIdxCatgoryBaseDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private String idxcatgorycode;

    private String idxcatgoryname;

    public String getIdxcatgorycode() {
        return idxcatgorycode;
    }

    public void setIdxcatgorycode(String idxcatgorycode) {
        this.idxcatgorycode = idxcatgorycode == null ? null : idxcatgorycode.trim();
    }

    public String getIdxcatgoryname() {
        return idxcatgoryname;
    }

    public void setIdxcatgoryname(String idxcatgoryname) {
        this.idxcatgoryname = idxcatgoryname == null ? null : idxcatgoryname.trim();
    }
}