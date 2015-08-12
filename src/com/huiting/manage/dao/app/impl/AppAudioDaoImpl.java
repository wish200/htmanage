package com.huiting.manage.dao.app.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.app.AppAudioDao;
import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dto.base.AppAudioBaseDto;
@Repository("appAudioDaoImpl")
public class AppAudioDaoImpl extends
BaseDaoImpl<AppAudioBaseDto, String>implements AppAudioDao{
	public AppAudioDaoImpl() {
		super.setSqlmapNamespace("appAudioDaoMapper");
	}
}
