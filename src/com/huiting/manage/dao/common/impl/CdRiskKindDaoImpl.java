package com.huiting.manage.dao.common.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.CdRiskKindDao;
import com.huiting.manage.dto.common.CdRiskKindDto;

/**
 * @ClassName: CdRiskKindDaoImpl
 * @Description: 风险等级
 * @author Zou_ZhuoQi
 * @date 2014-1-3 上午9:43:17
 */
@Repository("cdRiskKindDaoImpl")
public class CdRiskKindDaoImpl extends BaseDaoImpl<CdRiskKindDto, String>
		implements CdRiskKindDao {
	public CdRiskKindDaoImpl() {
		super.setSqlmapNamespace("cdRiskKindMapper");
	}

	@Override
	public String getRiskName(Map<String, Object> condition) {
		return sqlSession.selectOne("cdRiskKindMapper.getRiskName", condition);
	}
}
