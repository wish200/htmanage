package com.huiting.manage.dao.app.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.app.AppProgramDao;
import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dto.base.AppProgramBaseDto;
@Repository("appProgramDaoImpl")
public class AppProgramDaoImpl extends
BaseDaoImpl<AppProgramBaseDto, String>implements AppProgramDao{
	public AppProgramDaoImpl() {
		super.setSqlmapNamespace("appProgramDaoMapper");
	}
}
