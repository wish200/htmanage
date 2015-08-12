package com.huiting.manage.services.app;

import java.util.List;

import com.huiting.manage.dto.base.AppFlowerBaseDto;
import com.huiting.manage.dto.base.AppPicbookBaseDto;
import com.huiting.manage.dto.common.SearchDto;

public interface AppPicbookService {
	/**
	 * 
	* @Title: add 
	* @Description: 像数据库中添加
	* @param @param ccSystemPostBaseDto    
	* @return void  
	* @throws
	 */
	void add(AppPicbookBaseDto appPicbookBaseDto);
	/**
	 * 
	* @Title: update 
	* @Description: 更新发布公告信息
	* @param @param ccSystemPostBaseDto    
	* @return void  
	* @throws
	 */
	void update(AppPicbookBaseDto appPicbookBaseDto);
	/**
	 * 
	* @Title: getSystrmPoseList 
	* @Description: 根据条件查询系统公告信息
	* @param @param searchDto
	* @param @return    
	* @return List<CcSystemPostBaseDto>  
	* @throws
	 */
	List<AppPicbookBaseDto> getPicbookList(SearchDto searchDto);
	/**
	 * 
	* @Title: delete 
	* @Description: TODO
	* @param @param ccSystemPostBaseDto    
	* @return void  
	* @throws
	 */
	void delete(AppPicbookBaseDto appPicbookBaseDto);
	/**
	* @Title: getOneSysPost 
	* @Description: 根据id查询一条数据
	* @param @param searchDto
	* @param @return    
	* @return CcSystemPostBaseDto  
	* @throws
	 */
	AppPicbookBaseDto getOnePicbook(SearchDto searchDto);
	AppPicbookBaseDto getOneUser(SearchDto searchDto);
	/**
	 * 获得系统信息条数 
	* @Title: getSystrmPoseCount 
	* @Description: TODO
	* @param @param searchDto
	* @param @return    
	* @return int  
	* @throws
	 */
	int getPicbookCount(SearchDto searchDto);
	String getMaxPicbookCode();
	String getNewPicbookCode(String systemCode);

}
