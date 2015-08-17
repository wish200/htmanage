package com.huiting.manage.services.common;

import java.util.List;

import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcMenuDto;

public interface CcUserLoginService extends BaseService {

    CcUserDto userLogin(SearchDto searchDto);

    List<CcMenuDto> getUserMenus(CcUserDto ccUserDto);

	void update(CcUserDto ccUserDto);
//
	CcUserDto userLogin4A(SearchDto searchDto);
}
