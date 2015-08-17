package com.huiting.manage.dao.common;

import java.util.Map;

import com.huiting.manage.dto.common.CdRiskKindDto;

/**
 * @Description: 风险等级
 * @author Zou_ZhuoQi
 * @date 2014-1-3 上午9:40:09
 */

public interface CdRiskKindDao extends BaseDao<CdRiskKindDto, String> {
	/**
	 * @Description: 通过条件查询 风险名称
	 * @param @param condition
	 * @return  风险名称
	 */
	public String getRiskName(Map<String, Object> condition);
}
