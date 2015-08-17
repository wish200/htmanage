package com.huiting.manage.dao.sysconfig.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dao.sysconfig.CdClassDao;
import com.huiting.manage.dto.sysconfig.CdClassDto;
@Repository("cdClassDaoImpl")
public class CdClassDaoImpl extends BaseDaoImpl<CdClassDto, String> implements CdClassDao{
	public CdClassDaoImpl() {
		super.setSqlmapNamespace("cdClassMapper");
	}
}
