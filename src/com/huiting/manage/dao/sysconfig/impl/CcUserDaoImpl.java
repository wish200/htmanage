package com.huiting.manage.dao.sysconfig.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dao.sysconfig.CcUserDao;
import com.huiting.manage.dto.common.CcUserDto;

/**
 * @ClassName: CcUserDaoImpl
 * @Description: 用户操作dao
 * @author Zou_ZhuoQi
 * @date 2013-12-19 上午11:34:51
 * 
 */
@Repository("ccUserDaoImpl")
public class CcUserDaoImpl extends BaseDaoImpl<CcUserDto, String> implements
		CcUserDao {
	public CcUserDaoImpl() {
		super.setSqlmapNamespace("ccUserDtoMapper");
	}

	/**
	 * @Description: 检验用户代码
	 * @param userCode
	 */
	@Override
	public int veriCode(String userCode) {
		Integer i = sqlSession.selectOne("ccUserDtoMapper.veriCode", userCode);
		return i.intValue();
	}
}
