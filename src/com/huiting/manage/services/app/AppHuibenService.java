package com.huiting.manage.services.app;

import java.util.List;

import com.huiting.manage.dto.base.AppHuibenBaseDto;
import com.huiting.manage.dto.common.SearchDto;

public interface AppHuibenService {
	/**
	 * 
	* @Title: add 
	* @Description: 像数据库中添加
	* @param @param ccSystemPostBaseDto    
	* @return void  
	* @throws
	 */
	void add(AppHuibenBaseDto appHuibenBaseDto);
	/**
	 * 
	* @Title: update 
	* @Description: 更新发布公告信息
	* @param @param ccSystemPostBaseDto    
	* @return void  
	* @throws
	 */
	void update(AppHuibenBaseDto appHuibenBaseDto);
	/**
	 * 
	* @Title: getSystrmPoseList 
	* @Description: 根据条件查询系统公告信息
	* @param @param searchDto
	* @param @return    
	* @return List<CcSystemPostBaseDto>  
	* @throws
	 */
	List<AppHuibenBaseDto> getHuibenList(SearchDto searchDto);
	/**
	 * 
	* @Title: delete 
	* @Description: TODO
	* @param @param ccSystemPostBaseDto    
	* @return void  
	* @throws
	 */
	void delete(AppHuibenBaseDto appHuibenBaseDto);
	/**
	* @Title: getOneSysPost 
	* @Description: 根据id查询一条数据
	* @param @param searchDto
	* @param @return    
	* @return CcSystemPostBaseDto  
	* @throws
	 */
	AppHuibenBaseDto getOneHuiben(SearchDto searchDto);
	AppHuibenBaseDto getOneUser(SearchDto searchDto);
	AppHuibenBaseDto getOnePicbook(SearchDto searchDto);
	AppHuibenBaseDto getOneAudio(SearchDto searchDto);
	/**
	 * 获得系统信息条数 
	* @Title: getSystrmPoseCount 
	* @Description: TODO
	* @param @param searchDto
	* @param @return    
	* @return int  
	* @throws
	 */
	int getHuibenCount(SearchDto searchDto);
	String getMaxHuibenCode();
	String getNewHuibenCode(String systemCode);

}
