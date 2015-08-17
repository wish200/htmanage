package com.huiting.manage.dao.common.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.PushTaskDao;
import com.huiting.manage.dto.common.PushTaskDto;
@Repository("pushTaskDaoImpl")
public class PushTaskDaoImpl extends BaseDaoImpl<PushTaskDto, String> implements
		PushTaskDao {
	public PushTaskDaoImpl() {
		super.setSqlmapNamespace("pushTaskMapper");
	}

	@Override
	public List<PushTaskDto> selectList5Day() {
		return this.sqlSession.selectList("pushTaskMapper.selectList5Day");
	}
}
