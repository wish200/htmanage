package com.huiting.manage.dao.app.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.app.AppUserDao;
import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dto.base.AppUserBaseDto;
@Repository("appUserDaoImpl")
public class AppUserDaoImpl extends
BaseDaoImpl<AppUserBaseDto, String>implements AppUserDao{
	public AppUserDaoImpl() {
		super.setSqlmapNamespace("appUserDaoMapper");
	}
}
