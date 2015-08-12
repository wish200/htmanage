package com.huiting.manage.services.common;

import java.util.List;

import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcMenuDto;
import com.huiting.manage.dto.sysconfig.CcPositionMenuDto;

import java.util.Map;

public interface CcMenuService extends BaseService {

    List<CcMenuDto> findListMenu(SearchDto searchDto);
    
    Map<Integer, List<CcMenuDto>> getLevelMap(List<CcMenuDto> menuList);

	List<CcMenuDto> getAllMenuList(SearchDto searchDto);

	void insertCcPositionMenuBatch(CcPositionMenuDto ccPositionMenuDto);

	void deleteCcPositionMenu(CcPositionMenuDto ccPositionMenuDto);
}
