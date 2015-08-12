package com.huiting.manage.dao.sysconfig.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dao.sysconfig.CdEmailTemplateDao;
import com.huiting.manage.dto.sysconfig.CdEmailTemplateDto;
/**
 * 邮件模块数据Dao
 * @author ncp
 *
 */
@Repository("cdEmailTemplateDaoImpl")
public class CdEmailTemplateDaoImpl extends BaseDaoImpl<CdEmailTemplateDto, String> implements
		CdEmailTemplateDao {
	public CdEmailTemplateDaoImpl() {
		super.setSqlmapNamespace("cdEmailTemplateMapper");
	}
}
