package com.huiting.manage.dao.app.impl;



import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.app.AppHuibenDao;
import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dto.base.AppHuibenBaseDto;
@Repository("appHuibenDaoImpl")
public class AppHuibenDaoImpl extends
BaseDaoImpl<AppHuibenBaseDto, String>implements AppHuibenDao{
	public AppHuibenDaoImpl() {
		super.setSqlmapNamespace("appHuibenDaoMapper");
	}
	
	
}
