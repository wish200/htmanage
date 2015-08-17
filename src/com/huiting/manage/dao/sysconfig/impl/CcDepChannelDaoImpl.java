package com.huiting.manage.dao.sysconfig.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dao.sysconfig.CcDepChannelDao;
import com.huiting.manage.dto.sysconfig.CcDepChannelDto;
@Repository("ccDepChannelDaoImpl")
public class CcDepChannelDaoImpl extends BaseDaoImpl<CcDepChannelDto, String> implements CcDepChannelDao{
	public CcDepChannelDaoImpl() {
		super.setSqlmapNamespace("ccDepChannelMapper");
	}
}
