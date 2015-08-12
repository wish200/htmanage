package com.huiting.manage.dao.sysconfig;

import com.huiting.manage.dao.common.BaseDao;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcDepPositionDto;

public interface CcDepPositionDao extends BaseDao<CcDepPositionDto, String> {
	/**
	 * @Description: 获取部门岗位最大编码
	 * @param @param searchDto
	 * @throws
	 */
	public String getMaxCode(SearchDto searchDto);
}
