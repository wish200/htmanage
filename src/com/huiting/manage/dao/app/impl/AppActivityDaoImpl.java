package com.huiting.manage.dao.app.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.app.AppActivityDao;
import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dto.base.AppActivityBaseDto;
@Repository("appActivityDaoImpl")
public class AppActivityDaoImpl extends
BaseDaoImpl<AppActivityBaseDto, String>implements AppActivityDao{
	public AppActivityDaoImpl() {
		super.setSqlmapNamespace("appActivityDaoMapper");
	}
}
