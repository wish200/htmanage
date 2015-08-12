package com.huiting.manage.dao.sysconfig.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dao.sysconfig.CcSystemPostDao;
import com.huiting.manage.dto.base.CcSystemPostBaseDto;
import com.huiting.manage.dto.base.CcSystemPostBaseDtoKey;
@Repository("ccSystemPostDaoImpl")
public class CcSystemPostDaoImpl extends
BaseDaoImpl<CcSystemPostBaseDto, CcSystemPostBaseDtoKey>implements CcSystemPostDao{
	public CcSystemPostDaoImpl() {
		super.setSqlmapNamespace("ccSystemPostDaoMapper");
	}
}
