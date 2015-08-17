package com.huiting.manage.dao.sysconfig.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dao.sysconfig.CcTaskDao;
import com.huiting.manage.dto.sysconfig.CcTaskDto;
/**
  * @ClassName: CcTaskDaoImpl
  * @Description: 操作任务表cc_task
  * @author: zhangyangyang
  * @date 2014-2-20 上午10:44:37
 */
@Repository("ccTaskDaoImpl")
public class CcTaskDaoImpl extends
BaseDaoImpl<CcTaskDto, String>implements CcTaskDao{
	public CcTaskDaoImpl() {
		super.setSqlmapNamespace("ccTaskMapper");
	}
}
