package com.huiting.manage.dao.app.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.app.AppFlowerDao;
import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dto.base.AppFlowerBaseDto;
@Repository("appFlowerDaoImpl")
public class AppFlowerDaoImpl extends
BaseDaoImpl<AppFlowerBaseDto, String>implements AppFlowerDao{
	public AppFlowerDaoImpl() {
		super.setSqlmapNamespace("appFlowerDaoMapper");
	}
}
