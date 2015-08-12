package com.huiting.manage.services.app;

import java.util.List;

import com.huiting.manage.dto.base.AppPicHuibenBaseDto;
import com.huiting.manage.dto.common.SearchDto;

public interface AppPicHuibenService {
	/**
	 * 
	* @Title: add 
	* @Description: 像数据库中添加
	* @param @param ccSystemPostBaseDto    
	* @return void  
	* @throws
	 */
	void add(AppPicHuibenBaseDto appPicHuibenBaseDto);
	/**
	 * 
	* @Title: update 
	* @Description: 更新发布公告信息
	* @param @param ccSystemPostBaseDto    
	* @return void  
	* @throws
	 */
	void update(AppPicHuibenBaseDto appPicHuibenBaseDto);
	/**
	 * 
	* @Title: getSystrmPoseList 
	* @Description: 根据条件查询系统公告信息
	* @param @param searchDto
	* @param @return    
	* @return List<CcSystemPostBaseDto>  
	* @throws
	 */
	List<AppPicHuibenBaseDto> getPicHuibenList(SearchDto searchDto);
	/**
	 * 
	* @Title: delete 
	* @Description: TODO
	* @param @param ccSystemPostBaseDto    
	* @return void  
	* @throws
	 */
	void delete(AppPicHuibenBaseDto appPicHuibenBaseDto);
	/**
	* @Title: getOneSysPost 
	* @Description: 根据id查询一条数据
	* @param @param searchDto
	* @param @return    
	* @return CcSystemPostBaseDto  
	* @throws
	 */
	AppPicHuibenBaseDto getOnePicHuiben(SearchDto searchDto);
	AppPicHuibenBaseDto getOneUser(SearchDto searchDto);
	AppPicHuibenBaseDto getOnePicbook(SearchDto searchDto);
	AppPicHuibenBaseDto getOneAudio(SearchDto searchDto);
	/**
	 * 获得系统信息条数 
	* @Title: getSystrmPoseCount 
	* @Description: TODO
	* @param @param searchDto
	* @param @return    
	* @return int  
	* @throws
	 */
	int getPicHuibenCount(SearchDto searchDto);
	String getMaxPicHuibenCode();
	String getNewPicHuibenCode(String systemCode);

}
