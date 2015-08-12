package com.huiting.manage.services.sysconfig;

import java.util.List;

import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcDepChannelDto;
import com.huiting.manage.dto.sysconfig.CcDepartmentDto;
import com.huiting.manage.dto.sysconfig.CdChannelDto;
import com.huiting.manage.dto.sysconfig.CdClassDto;
import com.huiting.manage.dto.sysconfig.CdDepRiskDto;
import com.huiting.manage.dto.sysconfig.CdDepVir2EntDto;
import com.huiting.manage.services.common.BaseService;

/**
 * 
 * @ClassName: DepManageService
 * @Description: 部门管理的service
 * @author Niu_ChunPing
 * @date 2013-12-22 下午1:03:06
 */
public interface DepManageService extends BaseService {

	List<CcDepartmentDto> getDepList(SearchDto searchDto);

	List<CdClassDto> getCdclass(SearchDto searchDto);

	SearchDto getHaveCdClassCode(SearchDto searchDto);

	List<CdClassDto> getAllCdclass();

	List<CdChannelDto> getAllCdChannel();

	SearchDto getHaveCdChannelCode(SearchDto searchDto);

	List<CdChannelDto> getCdChannel(SearchDto searchDto);

	// void upDepChannel(SearchDto searchDto);

	SearchDto getHaveDepCode(SearchDto searchDto);

	// void upDataVirtual(SearchDto searchDto);

	void insertDep(CcDepartmentDto ccDepartmentDto);

	CcDepartmentDto selectDep(SearchDto searchDto);

	void updateDep(CcDepartmentDto ccDepartmentDto);

	void insertCcdepRiskBatch(CdDepRiskDto cdDepRiskDto,CcUserDto ccUserDto);

	List<CdDepRiskDto> getCcdepRiskList(SearchDto searchDto);

	List<CdClassDto> getCdClassDtoChecked(SearchDto searchDto);

	List<CdChannelDto> getCdCannelDtoChecked(SearchDto searchDto);

	void deleteCcdepRisk(CdDepRiskDto cdDepRiskDto);

	void deleteCcdepChannle(CcDepChannelDto ccDepChannelDto);

	void insertCcdepChannleBatch(CcDepChannelDto ccDepChannelDto);

	void deleteCdDepVir2Ent(CdDepVir2EntDto cdDepVir2EntDto);

	void insertCdDepVir2EntBatch(CdDepVir2EntDto cdDepVir2EntDto);

	List<CcDepartmentDto> getCdDepVir2EntDtoChecked(SearchDto searchDto);

	/**
	 * @Description: 获取部门最大编码
	 * @param @param searchDto
	 */
	public String getMaxCode(SearchDto searchDto);

	/**
	 * @Description: 生成新的部门代码
	 * @param @param oldCode ，当前最大的部门代码
	 * @return String 返回一个新的部门代码
	 */
	public String newCode(String oldCode);

	void insertVirCcDepRisk(CdDepVir2EntDto cdDepVir2EntDto,CcUserDto ccUserDto );

	void insertVirCcdepChannle(CdDepVir2EntDto cdDepVir2EntDto,CcUserDto ccUserDto );
	/**
	 * 
	* @Title: getDepCount 
	* @Description: 查询部门有多少个
	* @param @param searchDto
	* @param @return    
	* @return int  
	* @throws
	 */
	int getDepCount(SearchDto searchDto);

	void deleteDep(CcDepartmentDto ccDepartmentDto);

	List<CcDepartmentDto> selectIndexDep(SearchDto searchDto);


}
