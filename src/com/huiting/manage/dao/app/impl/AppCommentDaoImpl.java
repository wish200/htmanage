package com.huiting.manage.dao.app.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.app.AppCommentDao;
import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dto.base.AppCommentBaseDto;
@Repository("appCommentDaoImpl")
public class AppCommentDaoImpl extends
BaseDaoImpl<AppCommentBaseDto, String>implements AppCommentDao{
	public AppCommentDaoImpl() {
		super.setSqlmapNamespace("appCommentDaoMapper");
	}
	public Object selectOneUser(String property, Object value) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put(property, value);
		return selectOne("selectOneUser", condition);
	}
}
