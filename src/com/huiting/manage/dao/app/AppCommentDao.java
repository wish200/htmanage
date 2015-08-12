package com.huiting.manage.dao.app;

import com.huiting.manage.dao.common.BaseDao;
import com.huiting.manage.dto.base.AppCommentBaseDto;

public interface AppCommentDao extends BaseDao<AppCommentBaseDto, String> {
	public Object selectOneUser(String property, Object value);
}
