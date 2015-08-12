package com.huiting.manage.dao.app.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.app.AppChannelDao;
import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dto.base.AppChannelBaseDto;
@Repository("appChannelDaoImpl")
public class AppChannelDaoImpl extends
BaseDaoImpl<AppChannelBaseDto, String>implements AppChannelDao{
	public AppChannelDaoImpl() {
		super.setSqlmapNamespace("appChannelDaoMapper");
	}
}
