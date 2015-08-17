package com.huiting.manage.dao.app.impl;


import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.app.AppAudioHuibenDao;
import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dto.base.AppAudioHuibenBaseDto;
@Repository("appAudioHuibenDaoImpl")
public class AppAudioHuibenDaoImpl extends
BaseDaoImpl<AppAudioHuibenBaseDto, String>implements AppAudioHuibenDao{
	public AppAudioHuibenDaoImpl() {
		super.setSqlmapNamespace("appAudioHuibenDaoMapper");
	}
	
}
