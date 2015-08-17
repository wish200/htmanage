package com.huiting.manage.dao.sysconfig.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dao.sysconfig.CdCompanyDao;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CdCompanyDto;
@Repository("cdCompanyDaoImpl")
public class CdCompanyDaoImpl extends BaseDaoImpl<CdCompanyDto, String> implements CdCompanyDao{
	public CdCompanyDaoImpl() {
		super.setSqlmapNamespace("cdCompanyMapper");
	}
}
