package com.huiting.manage.dao.app.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.app.AppFirstPageDao;
import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dto.base.AppFirstPageBaseDto;
@Repository("appFirstPageDaoImpl")
public class AppFirstPageDaoImpl extends
BaseDaoImpl<AppFirstPageBaseDto, String>implements AppFirstPageDao{
	public AppFirstPageDaoImpl() {
		super.setSqlmapNamespace("appFirstPageDaoMapper");
	}
}
