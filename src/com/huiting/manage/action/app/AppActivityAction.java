package com.huiting.manage.action.app;

import java.util.List;

import javax.annotation.Resource;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dto.base.AppActivityBaseDto;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppActivityService;
import com.huiting.manage.system.tag.Page;
import com.huiting.manage.system.util.Constants;

public class AppActivityAction extends BaseAction{


	private static final long serialVersionUID = 1L;
	private AppActivityBaseDto appActivityBaseDto;
	private List<AppActivityBaseDto> appActivityBaseDtos;
	@Resource(name = "appActivityServiceImpl")
	private AppActivityService appActivityService;
	private SearchDto searchDto;
	private String activityID;
	private Page page;
	
	
	/**
	 * 
	* @Title: addSysPost 
	* @Description: 公告信息list
	* @param @return    
	* @return String  
	* @throws
	 */ 
	public String getList(){
		CcUserDto ccUserDto=(CcUserDto) session.get(Constants.USERLOGIN);
		if(searchDto==null){
			searchDto=new SearchDto();
		}
		
		/*if("1".equals(ccUserDto.getCcDepPositionBaseDto().getDeppostype())&&"1".equals(ccUserDto.getCcDepPositionBaseDto().getImportlev())){
		}else {
			searchDto.setValidstate("1");
		}*/
		if(page==null){
			page=new Page();
			page.setTotalCount(appActivityService.getActivityCount(searchDto));
			
		}
		searchDto.setPage(page);
		appActivityBaseDtos=appActivityService.getActivityList(searchDto);
		return LIST;
	};
	/**
	 * 
	* @Title: addActivity 
	* @Description: 添加公告信息
	* @param @return    
	* @return String  
	* @throws
	 */
	public String add(){
		if(appActivityBaseDto!=null){
			String activityid=appActivityService.getMaxActivityCode();//最大Eventno
			String newActivity=appActivityService.getNewActivityCode(activityid);//获得新的Eventno
			appActivityBaseDto.setActivityid(newActivity);
			appActivityService.add(appActivityBaseDto);
			renderText(newActivity);
		}
		return null;
	}
	/**
	 * 
	* @Title: updateSysPost 
	* @Description: 发布公告信息
	* @param @return    
	* @return String  
	* @throws
	 */
	public String send(){
		appActivityBaseDto.setValidstatus("1");
		appActivityService.update(appActivityBaseDto);
		return "returnlist";
	}
	/**
	 * 
	* @Title: updateSysPost 
	* @Description: TODO
	* @param @return    
	* @return String  
	* @throws
	 */
	public String update(){
		appActivityService.update(appActivityBaseDto);
		return "update";
	}
	/**
	 * 
	* @Title: delete 
	* @Description: TODO
	* @param @return    
	* @return String  
	* @throws
	 */
	public String delete(){
		appActivityService.delete(appActivityBaseDto);
		return "returnlist";
	}
	/**
	 * 
	* @Title: getOneSysPost 
	* @Description: TODO
	* @param @return    
	* @return String  
	* @throws
	 */
	public String check(){
		
		appActivityBaseDto=appActivityService.getOneActivity(searchDto);
		if(searchDto.getDoing().equals("editor")){
			return "editor";
		}else{
			return "check";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public SearchDto getSearchDto() {
		return searchDto;
	}
	public void setSearchDto(SearchDto searchDto) {
		this.searchDto = searchDto;
	}
	
	public String getActivityID() {
		return activityID;
	}
	public void setActivityID(String activityID) {
		this.activityID = activityID;
	}
	public AppActivityBaseDto getAppActivityBaseDto() {
		return appActivityBaseDto;
	}
	public void setAppActivityBaseDto(AppActivityBaseDto appActivityBaseDto) {
		this.appActivityBaseDto = appActivityBaseDto;
	}
	public List<AppActivityBaseDto> getAppActivityBaseDtos() {
		return appActivityBaseDtos;
	}
	public void setAppActivityBaseDtos(
			List<AppActivityBaseDto> appActivityBaseDtos) {
		this.appActivityBaseDtos = appActivityBaseDtos;
	}

}
