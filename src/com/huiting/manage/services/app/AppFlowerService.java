package com.huiting.manage.services.app;

import java.util.List;

import com.huiting.manage.dto.base.AppFlowerBaseDto;
import com.huiting.manage.dto.common.SearchDto;

public interface AppFlowerService {
	/**
	 * 
	* @Title: add 
	* @Description: 像数据库中添加
	* @param @param ccSystemPostBaseDto    
	* @return void  
	* @throws
	 */
	void add(AppFlowerBaseDto appFlowerBaseDto);
	/**
	 * 
	* @Title: update 
	* @Description: 更新发布公告信息
	* @param @param ccSystemPostBaseDto    
	* @return void  
	* @throws
	 */
	void update(AppFlowerBaseDto appFlowerBaseDto);
	/**
	 * 
	* @Title: getSystrmPoseList 
	* @Description: 根据条件查询系统公告信息
	* @param @param searchDto
	* @param @return    
	* @return List<CcSystemPostBaseDto>  
	* @throws
	 */
	List<AppFlowerBaseDto> getFlowerList(SearchDto searchDto);
	/**
	 * 
	* @Title: delete 
	* @Description: TODO
	* @param @param ccSystemPostBaseDto    
	* @return void  
	* @throws
	 */
	void delete(AppFlowerBaseDto appFlowerBaseDto);
	/**
	* @Title: getOneSysPost 
	* @Description: 根据id查询一条数据
	* @param @param searchDto
	* @param @return    
	* @return CcSystemPostBaseDto  
	* @throws
	 */
	AppFlowerBaseDto getOneFlower(SearchDto searchDto);
	AppFlowerBaseDto getOneUser(SearchDto searchDto);
	/**
	 * 获得系统信息条数 
	* @Title: getSystrmPoseCount 
	* @Description: TODO
	* @param @param searchDto
	* @param @return    
	* @return int  
	* @throws
	 */
	int getFlowerCount(SearchDto searchDto);
	String getMaxFlowerCode();
	String getNewFlowerCode(String systemCode);

}
