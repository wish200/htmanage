package com.huiting.manage.dao.sysconfig.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dao.sysconfig.CdDepRiskDao;
import com.huiting.manage.dto.sysconfig.CdDepRiskDto;
@Repository("cdDepRiskDaoImpl")
public class CdDepRiskDaoImpl  extends BaseDaoImpl<CdDepRiskDto, String> implements CdDepRiskDao{
	public CdDepRiskDaoImpl() {
		super.setSqlmapNamespace("cdDepRiskMapper");
	}
}
