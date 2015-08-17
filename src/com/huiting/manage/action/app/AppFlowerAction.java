package com.huiting.manage.action.app;

import java.util.List;

import javax.annotation.Resource;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dto.base.AppFlowerBaseDto;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppFlowerService;
import com.huiting.manage.system.tag.Page;
import com.huiting.manage.system.util.Constants;

public class AppFlowerAction extends BaseAction{


	private static final long serialVersionUID = 1L;
	private AppFlowerBaseDto appFlowerBaseDto;
	private List<AppFlowerBaseDto> appFlowerBaseDtos;
	@Resource(name = "appFlowerServiceImpl")
	private AppFlowerService appFlowerService;
	private SearchDto searchDto;
	private String FlowerID;
	private Page page;
	private String userid;
	
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
			page.setTotalCount(appFlowerService.getFlowerCount(searchDto));
			
		}
		searchDto.setPage(page);
		appFlowerBaseDtos=appFlowerService.getFlowerList(searchDto);
		return LIST;
	};
	/**
	 * 
	* @Title: addFlower 
	* @Description: 添加公告信息
	* @param @return    
	* @return String  
	* @throws
	 */
	public String add(){
		if(appFlowerBaseDto!=null){
			appFlowerService.add(appFlowerBaseDto);
			renderText(appFlowerBaseDto.getBusiid());
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
		//appFlowerBaseDto.setValidstatus("1");
		appFlowerService.update(appFlowerBaseDto);
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
		appFlowerService.update(appFlowerBaseDto);
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
		appFlowerService.delete(appFlowerBaseDto);
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
		
		appFlowerBaseDto=appFlowerService.getOneFlower(searchDto);
		if(searchDto.getDoing().equals("editor")){
			return "editor";
		}else{
			return "check";
		}
		
	}
	
	public void changeuser(){
		if(searchDto==null){
			searchDto=new SearchDto();
		}
		searchDto.setUserid(userid);
		appFlowerBaseDto=appFlowerService.getOneUser(searchDto); 
		if(appFlowerBaseDto==null){
			appFlowerBaseDto = new AppFlowerBaseDto();
		}
		renderJson(appFlowerBaseDto);
		
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
	
	public String getFlowerID() {
		return FlowerID;
	}
	public void setFlowerID(String FlowerID) {
		this.FlowerID = FlowerID;
	}
	public AppFlowerBaseDto getAppFlowerBaseDto() {
		return appFlowerBaseDto;
	}
	public void setAppFlowerBaseDto(AppFlowerBaseDto appFlowerBaseDto) {
		this.appFlowerBaseDto = appFlowerBaseDto;
	}
	public List<AppFlowerBaseDto> getAppFlowerBaseDtos() {
		return appFlowerBaseDtos;
	}
	public void setAppFlowerBaseDtos(
			List<AppFlowerBaseDto> appFlowerBaseDtos) {
		this.appFlowerBaseDtos = appFlowerBaseDtos;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

}
