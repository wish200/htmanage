package com.huiting.manage.dao.sysconfig.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dao.sysconfig.CcDepPositionDao;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcDepPositionDto;

@Repository("ccDepPositionDaoImpl")
public class CcDepPositionDaoImpl extends BaseDaoImpl<CcDepPositionDto, String>
		implements CcDepPositionDao {
	public CcDepPositionDaoImpl() {
		super.setSqlmapNamespace("ccDepPositionMapper");
	}

	@Override
	public String getMaxCode(SearchDto searchDto) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return sqlSession
				.selectOne("ccDepPositionMapper.getMaxCode", condition);
	}
}
