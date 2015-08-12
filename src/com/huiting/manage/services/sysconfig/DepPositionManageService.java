package com.huiting.manage.services.sysconfig;

import java.util.List;

import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcDepPositionDto;
import com.huiting.manage.services.common.BaseService;

/**
 * 
 * @ClassName: DepPositionManageService
 * @Description: 部门岗位管理的service
 * @author Niu_ChunPing
 * @date 2013-12-22 下午1:03:26
 */
public interface DepPositionManageService extends BaseService {

	List<CcDepPositionDto> getDepPositionList(SearchDto searchDto);

	CcDepPositionDto selectCcDepPos(SearchDto searchDto);

	void insertCcDepPos(CcDepPositionDto ccDepPositionDto);

	void updateCcDepPos(CcDepPositionDto ccDepPositionDto);

	/**
	 * @Description: 获取部门岗位最大编码
	 * @param @param searchDto
	 */
	public String getMaxCode(SearchDto searchDto);

	/**
	 * @Description: 生成新的部门岗位代码
	 * @param @param oldCode ，当前最大的部门岗位代码
	 * @return String 返回一个新的岗位代码
	 */
	public String newCode(String oldCode);

	int getDepPosiCount(SearchDto searchDto);
}
