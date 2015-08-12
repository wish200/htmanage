package com.huiting.manage.dao.sysconfig;

import java.util.List;

import com.huiting.manage.dao.common.BaseDao;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcDepartmentDto;

public interface CcDepartmentDao extends BaseDao<CcDepartmentDto, String> {
	/**
	 * @Description: 获取部门最大编码
	 * @param searchDto
	 */
	public String getMaxCode(SearchDto searchDto);
	/**
	 * 获得各个公司对于的主责部门
	 * @param searchDto
	 * @return
	 */
	public List<CcDepartmentDto> getCdIndexDuty(SearchDto searchDto);
	/**
	 * 根据推送期次和推送机构查询主责部门，不带有
	 * @param searchDto
	 * @return
	 */
	public List<CcDepartmentDto> selectListToFiowPsh(SearchDto searchDto);
	/**
	 * 
	 * @param string
	 * @param searchDto
	 * @return
	 */
	public List<String> selectListClass(SearchDto searchDto);
	/**
	 * 集团报送的R任务
	 * @param searchDto
	 * @return
	 */
	public List<String> selectListGroup( SearchDto searchDto);
	

}
