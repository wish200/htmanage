package com.huiting.manage.action.app;

import java.util.List;

import javax.annotation.Resource;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dto.base.AppFirstPageBaseDto;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppFirstPageService;
import com.huiting.manage.system.tag.Page;
import com.huiting.manage.system.util.Constants;

public class AppFirstPageAction extends BaseAction{


	private static final long serialVersionUID = 1L;
	private AppFirstPageBaseDto appFirstPageBaseDto;
	private List<AppFirstPageBaseDto> appFirstPageBaseDtos;
	@Resource(name = "appFirstPageServiceImpl")
	private AppFirstPageService appFirstPageService;
	private SearchDto searchDto;
	private String FirstPageID;
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
			page.setTotalCount(appFirstPageService.getFirstPageCount(searchDto));
			
		}
		searchDto.setPage(page);
		appFirstPageBaseDtos=appFirstPageService.getFirstPageList(searchDto);
		return LIST;
	};
	/**
	 * 
	* @Title: addFirstPage 
	* @Description: 添加公告信息
	* @param @return    
	* @return String  
	* @throws
	 */
	public String add(){
		if(appFirstPageBaseDto!=null){
			String systemCode=appFirstPageService.getMaxFirstPageCode();//最大Eventno
			String newFirstPage=appFirstPageService.getNewFirstPageCode(systemCode);//获得新的Eventno
			appFirstPageBaseDto.setId(Integer.parseInt(newFirstPage));
			appFirstPageService.add(appFirstPageBaseDto);
			renderText(newFirstPage);
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
		appFirstPageBaseDto.setStatus("1");
		appFirstPageService.update(appFirstPageBaseDto);
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
		appFirstPageService.update(appFirstPageBaseDto);
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
		appFirstPageService.delete(appFirstPageBaseDto);
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
		
		appFirstPageBaseDto=appFirstPageService.getOneFirstPage(searchDto);
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
	
	public String getFirstPageID() {
		return FirstPageID;
	}
	public void setFirstPageID(String FirstPageID) {
		this.FirstPageID = FirstPageID;
	}
	public AppFirstPageBaseDto getAppFirstPageBaseDto() {
		return appFirstPageBaseDto;
	}
	public void setAppFirstPageBaseDto(AppFirstPageBaseDto appFirstPageBaseDto) {
		this.appFirstPageBaseDto = appFirstPageBaseDto;
	}
	public List<AppFirstPageBaseDto> getAppFirstPageBaseDtos() {
		return appFirstPageBaseDtos;
	}
	public void setAppFirstPageBaseDtos(
			List<AppFirstPageBaseDto> appFirstPageBaseDtos) {
		this.appFirstPageBaseDtos = appFirstPageBaseDtos;
	}

}
