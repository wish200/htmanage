package com.huiting.manage.dao.sysconfig.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dao.sysconfig.CdDepVir2EntDao;
import com.huiting.manage.dto.sysconfig.CdDepVir2EntDto;
@Repository("cdDepVir2EntDaoImpl")
public class CdDepVir2EntDaoImpl extends BaseDaoImpl<CdDepVir2EntDto, String> implements CdDepVir2EntDao{
	public CdDepVir2EntDaoImpl() {
		super.setSqlmapNamespace("cdDepVir2EntMapper");
	}
}
