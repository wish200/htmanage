package com.huiting.manage.services.common;

import java.util.List;

import com.huiting.manage.dto.base.CdDataSourceBaseDto;
import com.huiting.manage.dto.base.CdIdxCatgoryBaseDto;
import com.huiting.manage.dto.common.CdRiskKindDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcDepPositionDto;
import com.huiting.manage.dto.sysconfig.CcDepartmentDto;
import com.huiting.manage.dto.sysconfig.CdCompanyDto;

/**
 * @ClassName: PublicJSPConditionsService
 * @Description: 页面公共查询条件service接口
 * @author Zou_ZhuoQi
 * @date 2013-12-6 上午10:03:41
 * 
 */

public interface PublicJSPConditionsService extends BaseService {
	/**
	 * @Description: 获取指标风险类型
	 * @param @return
	 * @return List<CdRiskKindDto>
	 * @throws
	 */
	public List<CdRiskKindDto> getCdRiskKindList(SearchDto searchDto);

	/**
	 * 
	 * @Description: 邮件类型表
	 * @param @return
	 * @return List<Object>
	 * @throws
	 */
	public List<Object> getCdTemplateCatnoList(SearchDto searchDto);

	/**
	 * 
	 * @Description: 公司、机构码表
	 * @return List<Object>
	 * @throws
	 */
	public List<CdCompanyDto> getCompany(SearchDto searchDto);

	/**
	 * 
	 * @Description: 部门码表
	 * @return List<CcDepartmentDto>
	 * @throws
	 */
	public List<CcDepartmentDto> getDepList(SearchDto searchDto);

	/**
	 * @Description: 获取岗位集合
	 * @param @param searchDto 通过部门代码获取所有的岗位
	 * @return List<CcDepPositionDto>
	 * @throws
	 */
	public List<CcDepPositionDto> getDepPositionList(SearchDto searchDto);
	/**
	 * 
	* @Title: getDataSoureList 
	* @Description: 数据源
	* @param @param searchDto
	* @param @return    
	* @return String  
	* @throws
	 */
	public List<CdDataSourceBaseDto> getDataSoureList(SearchDto searchDto);

	public List<CdIdxCatgoryBaseDto> getIdxCatgoryList(SearchDto searchDto);
	
	/**
	 * 根据时间查询需要填报的部门
	 * @param searchDto
	 * @return
	 */
	public List<CcDepartmentDto> getInputDepList(SearchDto searchDto);

}
