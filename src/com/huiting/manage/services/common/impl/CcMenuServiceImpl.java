package com.huiting.manage.services.common.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.sysconfig.CcMenuDao;
import com.huiting.manage.dao.sysconfig.CcPositionMenuDao;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcMenuDto;
import com.huiting.manage.dto.sysconfig.CcPositionMenuDto;
import com.huiting.manage.services.common.CcMenuService;

@Service("ccMenuServiceImpl")
public class CcMenuServiceImpl extends BaseServiceImpl implements CcMenuService {

    @Resource(name = "ccMenuDaoImpl")
    private CcMenuDao ccMenuDao;
    
    @Resource(name = "ccPositionMenuDaoImpl")
    private CcPositionMenuDao ccPositionMenuDao;

    @Override
    public List<CcMenuDto> findListMenu(SearchDto searchDto) {
        List<CcMenuDto> list = ccMenuDao.selectList("searchDto", searchDto);
        return list;
    }

    @Override
    public Map<Integer, List<CcMenuDto>> getLevelMap(List<CcMenuDto> menuList) {
      
        Map<Integer, List<CcMenuDto>> menuMap = new HashMap<Integer, List<CcMenuDto>>();
        List<CcMenuDto> oneMenuList = new ArrayList<CcMenuDto>();
        List<CcMenuDto> twoMenuList = new ArrayList<CcMenuDto>();
        List<CcMenuDto> threeMenuList = new ArrayList<CcMenuDto>();
        
        for (CcMenuDto ccMenuDto : menuList) {
            if (2 == ccMenuDto.getMenulevel().intValue()) {
                oneMenuList.add(ccMenuDto);
            } else if (3 == ccMenuDto.getMenulevel().intValue()) {
                twoMenuList.add(ccMenuDto);
            } else if (4 == ccMenuDto.getMenulevel().intValue()) {
                threeMenuList.add(ccMenuDto);
            }
        }
        menuMap.put(2, oneMenuList);
        menuMap.put(3, twoMenuList);
        menuMap.put(4, threeMenuList);
        
        return menuMap;
    }

    /**
     * 全部菜单List
     */
	public List<CcMenuDto> getAllMenuList(SearchDto searchDto) {
		Map< String, Object> condition=new HashMap<String, Object>();
		   condition.put("searchDto", searchDto);
		return ccMenuDao.selectList("getMenuList", condition);
	}

	/**
	 * 插入 岗位菜单关系表
	 */
	public void insertCcPositionMenuBatch(CcPositionMenuDto ccPositionMenuDto) {
		String classCode[]=ccPositionMenuDto.getMenuid().split(",");
		List<CcPositionMenuDto> ccPositionMenuDtoList=new ArrayList<CcPositionMenuDto>();
		CcPositionMenuDto c  = null;
			for(String s:classCode){
				c=new CcPositionMenuDto();
				c.setMenuid(s);
				c.setDeppositioncode(ccPositionMenuDto.getDeppositioncode());
				ccPositionMenuDtoList.add(c);
			}
			ccPositionMenuDao.insertList(ccPositionMenuDtoList);
	}
	/**
	 * 删除 岗位菜单关系表
	 */
	public void deleteCcPositionMenu(CcPositionMenuDto ccPositionMenuDto) {
		ccPositionMenuDao.deleteById(ccPositionMenuDto.getDeppositioncode());
	}
}
