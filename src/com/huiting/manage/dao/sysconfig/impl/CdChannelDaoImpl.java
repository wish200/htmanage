package com.huiting.manage.dao.sysconfig.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dao.sysconfig.CdChannelDao;
import com.huiting.manage.dto.sysconfig.CdChannelDto;
@Repository("cdChannelDaoImpl")
public class CdChannelDaoImpl extends BaseDaoImpl<CdChannelDto, String> implements CdChannelDao{
	public CdChannelDaoImpl() {
		super.setSqlmapNamespace("cdChannelMapper");
	}
}
