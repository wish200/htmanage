package com.huiting.manage.dao.sysconfig.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dao.sysconfig.CdEmailTleDao;
import com.huiting.manage.dto.base.CdEmailTemplateBaseDto;
import com.huiting.manage.dto.common.SearchDto;
/**
 * 
* @ClassName: CdEmailTleDaoImpl
* @Description:  操作邮件模板表CD_EMAIL_TEMPLATE
* @author ZhangYangYang
* @date 2013-12-22 下午06:17:36
 */
@Repository("cdEmailTleDaoImpl")
public class CdEmailTleDaoImpl extends BaseDaoImpl<CdEmailTemplateBaseDto, String> 
implements CdEmailTleDao{
	public CdEmailTleDaoImpl() {
		super.setSqlmapNamespace("cdEmailTleMapper");
	}

	/**
	 * 获得最大的邮件模板代码
	 */
	@Override
	public String getMaxCode(SearchDto searchDto) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return sqlSession
				.selectOne("cdEmailTleMapper.getMaxCode", condition);
	}

}
