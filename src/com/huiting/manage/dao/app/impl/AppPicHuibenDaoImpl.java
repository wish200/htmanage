package com.huiting.manage.dao.app.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.app.AppPicHuibenDao;
import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dto.base.AppPicHuibenBaseDto;
@Repository("appPicHuibenDaoImpl")
public class AppPicHuibenDaoImpl extends
BaseDaoImpl<AppPicHuibenBaseDto, String>implements AppPicHuibenDao{
	public AppPicHuibenDaoImpl() {
		super.setSqlmapNamespace("appPicHuibenDaoMapper");
	}
	
}
