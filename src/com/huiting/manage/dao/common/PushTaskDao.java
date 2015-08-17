package com.huiting.manage.dao.common;

import java.util.List;

import com.huiting.manage.dto.common.PushTaskDto;


public interface PushTaskDao extends BaseDao<PushTaskDto, String>{

	List<PushTaskDto> selectList5Day();

}
