package com.huiting.manage.services.sysconfig.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.sysconfig.CcDepPositionDao;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcDepPositionDto;
import com.huiting.manage.services.common.impl.BaseServiceImpl;
import com.huiting.manage.services.sysconfig.DepPositionManageService;
import com.huiting.manage.system.util.NumberUtil;
import com.huiting.manage.system.util.UtilAPI;

/**
 * 
 * @ClassName: DepPositionManageServiceImpl
 * @Description: 部门管理的实现类
 * @author Niu_ChunPing
 * @date 2013-12-22 下午1:04:03
 */
@Service("depPositionManageServiceImpl")
public class DepPositionManageServiceImpl extends BaseServiceImpl implements
		DepPositionManageService {
	@Resource(name = "ccDepPositionDaoImpl")
	private CcDepPositionDao ccDepPositionDao;

	@Override
	public List<CcDepPositionDto> getDepPositionList(SearchDto searchDto) {
		return ccDepPositionDao.selectList("searchDto", searchDto);
	}

	/**
	 * 查询部门岗位信息（单个）
	 */
	public CcDepPositionDto selectCcDepPos(SearchDto searchDto) {
		return ccDepPositionDao.selectOne("searchDto", searchDto);
	}

	/**
	 * 添加 部门岗位
	 */
	public void insertCcDepPos(CcDepPositionDto ccDepPositionDto) {
		ccDepPositionDao.insert(ccDepPositionDto);
	}

	/**
	 * 更新 部门岗位
	 */
	public void updateCcDepPos(CcDepPositionDto ccDepPositionDto) {
		ccDepPositionDao.update(ccDepPositionDto);
	}

	@Override
	public String getMaxCode(SearchDto searchDto) {
		return ccDepPositionDao.getMaxCode(searchDto);
	}

	@Override
	public String newCode(String oldCode) {
		String tempCode = "P0000001";
		DecimalFormat df = new DecimalFormat("0000000");
		if(UtilAPI.isNull(oldCode)){
		}else{
			int sort = NumberUtil.createInteger(oldCode.substring(1)) + 1;// 新的序列
			tempCode = "P"+df.format(sort);
		}
		return tempCode;
	}
	/**
	  * @Description: 部门岗位总数
	  * @param  searchDto
	 */
	@Override
	public int getDepPosiCount(SearchDto searchDto) {
		Map<String,Object> condition=new HashMap<String,Object>();
		condition.put("searchDto",searchDto);
		return ccDepPositionDao.count(condition);
	}
	 
}
