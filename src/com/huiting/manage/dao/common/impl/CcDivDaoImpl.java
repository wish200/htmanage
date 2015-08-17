package com.huiting.manage.dao.common.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.CcDivDao;
import com.huiting.manage.dto.base.CcDivBaseDto;
@Repository("ccDivDaoImpl")
public class CcDivDaoImpl extends BaseDaoImpl<CcDivBaseDto, String> implements CcDivDao{
	public CcDivDaoImpl() {
		super.setSqlmapNamespace("ccDivDaoMapper");
	}

}
