package com.huiting.manage.services.app;

import java.util.List;

import com.huiting.manage.dto.base.AppAudioHuibenBaseDto;
import com.huiting.manage.dto.common.SearchDto;

public interface AppAudioHuibenService {
	/**
	 * 
	* @Title: add 
	* @Description: 像数据库中添加
	* @param @param ccSystemPostBaseDto    
	* @return void  
	* @throws
	 */
	void add(AppAudioHuibenBaseDto appAudioHuibenBaseDto);
	/**
	 * 
	* @Title: update 
	* @Description: 更新发布公告信息
	* @param @param ccSystemPostBaseDto    
	* @return void  
	* @throws
	 */
	void update(AppAudioHuibenBaseDto appAudioHuibenBaseDto);
	/**
	 * 
	* @Title: getSystrmPoseList 
	* @Description: 根据条件查询系统公告信息
	* @param @param searchDto
	* @param @return    
	* @return List<CcSystemPostBaseDto>  
	* @throws
	 */
	List<AppAudioHuibenBaseDto> getAudioHuibenList(SearchDto searchDto);
	/**
	 * 
	* @Title: delete 
	* @Description: TODO
	* @param @param ccSystemPostBaseDto    
	* @return void  
	* @throws
	 */
	void delete(AppAudioHuibenBaseDto appAudioHuibenBaseDto);
	/**
	* @Title: getOneSysPost 
	* @Description: 根据id查询一条数据
	* @param @param searchDto
	* @param @return    
	* @return CcSystemPostBaseDto  
	* @throws
	 */
	AppAudioHuibenBaseDto getOneAudioHuiben(SearchDto searchDto);
	AppAudioHuibenBaseDto getOneUser(SearchDto searchDto);
	AppAudioHuibenBaseDto getOnePicbook(SearchDto searchDto);
	AppAudioHuibenBaseDto getOneAudio(SearchDto searchDto);
	/**
	 * 获得系统信息条数 
	* @Title: getSystrmPoseCount 
	* @Description: TODO
	* @param @param searchDto
	* @param @return    
	* @return int  
	* @throws
	 */
	int getAudioHuibenCount(SearchDto searchDto);
	String getMaxAudioHuibenCode();
	String getNewAudioHuibenCode(String systemCode);

}
