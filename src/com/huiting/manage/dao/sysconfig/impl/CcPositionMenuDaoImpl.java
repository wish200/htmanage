package com.huiting.manage.dao.sysconfig.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dao.sysconfig.CcPositionMenuDao;
import com.huiting.manage.dto.sysconfig.CcPositionMenuDto;
/**
 * 
* @ClassName: CcPositionMenuDaoImpl
* @Description: 操作 岗位菜单关系表
* @author ZhangYangYang
* @date 2013-12-29 下午01:46:20
 */
@Repository("ccPositionMenuDaoImpl")
public class CcPositionMenuDaoImpl extends BaseDaoImpl<CcPositionMenuDto, String> 
implements CcPositionMenuDao{
	public CcPositionMenuDaoImpl() {
		super.setSqlmapNamespace("ccPositionMenuMapper");
	}
}
