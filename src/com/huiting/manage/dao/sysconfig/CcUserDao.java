package com.huiting.manage.dao.sysconfig;

import com.huiting.manage.dao.common.BaseDao;
import com.huiting.manage.dto.common.CcUserDto;

/**
 * @ClassName: CcUserDao
 * @Description: 
 * @author Zou_ZhuoQi
 * @date 2013-12-19 下午3:19:55
 * 
 */

public interface CcUserDao extends BaseDao<CcUserDto, String> {

	int veriCode(String userCode);

	
}
