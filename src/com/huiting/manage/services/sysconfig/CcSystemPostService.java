package com.huiting.manage.services.sysconfig;

import java.util.List;

import com.huiting.manage.dto.base.CcSystemPostBaseDto;
import com.huiting.manage.dto.common.SearchDto;

public interface CcSystemPostService {
	/**
	 * 
	* @Title: add 
	* @Description: 像数据库中添加
	* @param @param ccSystemPostBaseDto    
	* @return void  
	* @throws
	 */
	void add(CcSystemPostBaseDto ccSystemPostBaseDto);
	/**
	 * 
	* @Title: update 
	* @Description: 更新发布公告信息
	* @param @param ccSystemPostBaseDto    
	* @return void  
	* @throws
	 */
	void update(CcSystemPostBaseDto ccSystemPostBaseDto);
	/**
	 * 
	* @Title: getSystrmPoseList 
	* @Description: 根据条件查询系统公告信息
	* @param @param searchDto
	* @param @return    
	* @return List<CcSystemPostBaseDto>  
	* @throws
	 */
	List<CcSystemPostBaseDto> getSystrmPoseList(SearchDto searchDto);
	/**
	 * 
	* @Title: delete 
	* @Description: TODO
	* @param @param ccSystemPostBaseDto    
	* @return void  
	* @throws
	 */
	void delete(CcSystemPostBaseDto ccSystemPostBaseDto);
	/**
	* @Title: getOneSysPost 
	* @Description: 根据id查询一条数据
	* @param @param searchDto
	* @param @return    
	* @return CcSystemPostBaseDto  
	* @throws
	 */
	CcSystemPostBaseDto getOneSysPost(SearchDto searchDto);
	/**
	 * 获得系统信息条数 
	* @Title: getSystrmPoseCount 
	* @Description: TODO
	* @param @param searchDto
	* @param @return    
	* @return int  
	* @throws
	 */
	int getSystrmPoseCount(SearchDto searchDto);
	String getMaxSystemCode();
	String getNewSystemCode(String systemCode);

}
