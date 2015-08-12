package com.huiting.manage.dao.sysconfig;

import com.huiting.manage.dao.common.BaseDao;
import com.huiting.manage.dto.base.CdEmailTemplateBaseDto;
import com.huiting.manage.dto.common.SearchDto;
/**
 * 
* @ClassName: CcEmailTleDao
* @Description:  操作邮件模板表CD_EMAIL_TEMPLATE
* @author ZhangYangYang
* @date 2013-12-22 下午01:48:00
 */
public interface CdEmailTleDao  extends BaseDao<CdEmailTemplateBaseDto, String>{

	String getMaxCode(SearchDto searchDto);

}
