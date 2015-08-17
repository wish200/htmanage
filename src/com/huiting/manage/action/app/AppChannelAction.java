package com.huiting.manage.action.app;

import java.util.List;

import javax.annotation.Resource;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dto.base.AppChannelBaseDto;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppChannelService;
import com.huiting.manage.system.tag.Page;
import com.huiting.manage.system.util.Constants;

public class AppChannelAction extends BaseAction{


	private static final long serialVersionUID = 1L;
	private AppChannelBaseDto appChannelBaseDto;
	private List<AppChannelBaseDto> appChannelBaseDtos;
	@Resource(name = "appChannelServiceImpl")
	private AppChannelService appChannelService;
	private SearchDto searchDto;
	private String ChannelID;
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
			page.setTotalCount(appChannelService.getChannelCount(searchDto));
			
		}
		searchDto.setPage(page);
		appChannelBaseDtos=appChannelService.getChannelList(searchDto);
		return LIST;
	};
	/**
	 * 
	* @Title: addChannel 
	* @Description: 添加公告信息
	* @param @return    
	* @return String  
	* @throws
	 */
	public String add(){
		if(appChannelBaseDto!=null){
			String systemCode=appChannelService.getMaxChannelCode();//最大Eventno
			String newChannel=appChannelService.getNewChannelCode(systemCode);//获得新的Eventno
			appChannelBaseDto.setChannelid(newChannel);
			appChannelService.add(appChannelBaseDto);
			renderText(newChannel);
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
		appChannelBaseDto.setStatus("1");
		appChannelService.update(appChannelBaseDto);
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
		appChannelService.update(appChannelBaseDto);
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
		appChannelService.delete(appChannelBaseDto);
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
		
		appChannelBaseDto=appChannelService.getOneChannel(searchDto);
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
	
	public String getChannelID() {
		return ChannelID;
	}
	public void setChannelID(String ChannelID) {
		this.ChannelID = ChannelID;
	}
	public AppChannelBaseDto getAppChannelBaseDto() {
		return appChannelBaseDto;
	}
	public void setAppChannelBaseDto(AppChannelBaseDto appChannelBaseDto) {
		this.appChannelBaseDto = appChannelBaseDto;
	}
	public List<AppChannelBaseDto> getAppChannelBaseDtos() {
		return appChannelBaseDtos;
	}
	public void setAppChannelBaseDtos(
			List<AppChannelBaseDto> appChannelBaseDtos) {
		this.appChannelBaseDtos = appChannelBaseDtos;
	}

}
