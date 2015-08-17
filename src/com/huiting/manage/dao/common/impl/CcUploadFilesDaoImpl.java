package com.huiting.manage.dao.common.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.CcUploadFilesDao;
import com.huiting.manage.dto.common.CcUploadFilesDto;
@Repository("ccUploadFilesDaoImpl")
public class CcUploadFilesDaoImpl extends BaseDaoImpl<CcUploadFilesDto, String> implements CcUploadFilesDao {

	public CcUploadFilesDaoImpl() {
		super.setSqlmapNamespace("ccUploadFilesDtoMapper");
	}

}
