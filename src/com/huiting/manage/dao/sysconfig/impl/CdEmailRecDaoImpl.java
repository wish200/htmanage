package com.huiting.manage.dao.sysconfig.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dao.sysconfig.CdEmailRecDao;
import com.huiting.manage.dto.sysconfig.CdEmailRecDto;
/**
 * 
* @ClassName: CdEmailRecDaoImpl
* @Description:  操作邮件模板表CD_EMAIL_TEMPLATE
* @author ZhangYangYang
* @date 2013-12-22 下午06:40:38
 */
@Repository("cdEmailRecDaoImpl")
public class CdEmailRecDaoImpl extends BaseDaoImpl<CdEmailRecDto, String> 
implements CdEmailRecDao{
	public CdEmailRecDaoImpl() {
		super.setSqlmapNamespace("cdEmailRecMapper");
	}
}
