package com.huiting.manage.dao.app.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.app.AppPicbookDao;
import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dto.base.AppPicbookBaseDto;
@Repository("appPicbookDaoImpl")
public class AppPicbookDaoImpl extends
BaseDaoImpl<AppPicbookBaseDto, String>implements AppPicbookDao{
	public AppPicbookDaoImpl() {
		super.setSqlmapNamespace("appPicbookDaoMapper");
	}
}
