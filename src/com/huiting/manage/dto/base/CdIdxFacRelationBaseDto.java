package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: CdIdxFacRelationBaseDto
 * @Description: CD_IDXFACRELATION
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:39:55
 * 
 */
@Alias("cdIdxFacRelationBaseDto")
public class CdIdxFacRelationBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String indexcode;

	private String faccode;

	private Integer seqno;

	public String getIndexcode() {
		return indexcode;
	}

	public void setIndexcode(String indexcode) {
		this.indexcode = indexcode == null ? null : indexcode.trim();
	}

	public String getFaccode() {
		return faccode;
	}

	public void setFaccode(String faccode) {
		this.faccode = faccode == null ? null : faccode.trim();
	}

	public Integer getSeqno() {
		return seqno;
	}

	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}

}