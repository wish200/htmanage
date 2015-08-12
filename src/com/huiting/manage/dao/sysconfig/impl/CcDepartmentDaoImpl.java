package com.huiting.manage.dao.sysconfig.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dao.sysconfig.CcDepartmentDao;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcDepartmentDto;

@Repository("ccDepartmentDaoImpl")
public class CcDepartmentDaoImpl extends BaseDaoImpl<CcDepartmentDto, String>
		implements CcDepartmentDao {
	public CcDepartmentDaoImpl() {
		super.setSqlmapNamespace("ccDepartmentMapper");
	}

	@Override
	public String getMaxCode(SearchDto searchDto) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return sqlSession
				.selectOne("ccDepartmentMapper.getMaxCode", condition);
	}

	@Override
	public List<CcDepartmentDto> getCdIndexDuty(SearchDto searchDto) {
		return sqlSession.selectList("ccDepartmentMapper.getCdIndexDuty", searchDto);
	}

	@Override
	public List<CcDepartmentDto> selectListToFiowPsh(SearchDto searchDto) {
		return sqlSession.selectList("ccDepartmentMapper.selectListToFiowPsh", searchDto);
	}

	@Override
	public List<String> selectListClass( SearchDto searchDto) {
		return this.sqlSession.selectList("ccDepartmentMapper.getDataInputListUperviseString",searchDto);
	}


	@Override
	public List<String> selectListGroup(SearchDto searchDto) {
		return this.sqlSession.selectList("ccDepartmentMapper.getDataInputListGroupString",searchDto);
	}
	
}
