package com.huiting.manage.services.common.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcMenuDto;
import com.huiting.manage.services.common.CcMenuService;
import com.huiting.manage.services.common.CcUserLoginService;
import com.huiting.manage.services.sysconfig.CcUserService;

@Service("ccUserLoginServiceImpl")
public class CcUserLoginServiceImpl extends BaseServiceImpl implements CcUserLoginService {

    @Resource(name = "ccUserServiceImpl")
    private CcUserService ccUserService;
    @Resource(name = "ccMenuServiceImpl")
    private CcMenuService ccMenuService;

    @Override
    public CcUserDto userLogin(SearchDto searchDto) {
        return ccUserService.userLogin(searchDto);
    }

    @Override
    public List<CcMenuDto> getUserMenus(CcUserDto ccUserDto) {
        SearchDto searchDto = new SearchDto();
        searchDto.setDepPositionCode(ccUserDto.getDeppositioncode());
//        searchDto.setMenuLevel(1);
        return ccMenuService.findListMenu(searchDto);
    }

    /**
      * @Description: 修改用户信息 
     */
	@Override
	public void update(CcUserDto ccUserDto) {
		ccUserService.updateUser(ccUserDto);
	}

	@Override
	public CcUserDto userLogin4A(SearchDto searchDto) {
		// TODO Auto-generated method stub
		return ccUserService.userLogin4A(searchDto);
	}
}
