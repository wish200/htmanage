package com.huiting.manage.dao.sysconfig.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dao.sysconfig.CcTimeTaskDao;
import com.huiting.manage.dto.sysconfig.CcTimeTaskDto;
@Repository("ccTimeTaskDaoImpl")
public class CcTimeTaskDaoImpl extends BaseDaoImpl<CcTimeTaskDto, String> implements CcTimeTaskDao{
	public CcTimeTaskDaoImpl() {
		super.setSqlmapNamespace("ccTimeTaskMapper");
	}
}
