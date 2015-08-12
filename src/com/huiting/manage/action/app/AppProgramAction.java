package com.huiting.manage.action.app;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dto.base.AppProgramBaseDto;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppProgramService;
import com.huiting.manage.system.tag.Page;
import com.huiting.manage.system.util.Constants;

public class AppProgramAction extends BaseAction{


	private static final long serialVersionUID = 1L;
	private AppProgramBaseDto appProgramBaseDto;
	private List<AppProgramBaseDto> appProgramBaseDtos;
	@Resource(name = "appProgramServiceImpl")
	private AppProgramService appProgramService;
	private SearchDto searchDto;
	private String ProgramID;
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
			page.setTotalCount(appProgramService.getProgramCount(searchDto));
			
		}
		searchDto.setPage(page);
		appProgramBaseDtos=appProgramService.getProgramList(searchDto);
		return LIST;
	};
	/**
	 * 
	* @Title: addProgram 
	* @Description: 添加公告信息
	* @param @return    
	* @return String  
	* @throws
	 */
	public String add(){
		if(appProgramBaseDto!=null){
			String systemCode=appProgramService.getMaxProgramCode();//最大Eventno
			String newProgram=appProgramService.getNewProgramCode(systemCode);//获得新的Eventno
			appProgramBaseDto.setProgramid(newProgram);
			appProgramService.add(appProgramBaseDto);
			renderText(newProgram);
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
		appProgramBaseDto.setStatus("1");
		appProgramService.update(appProgramBaseDto);
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
		appProgramService.update(appProgramBaseDto);
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
		appProgramService.delete(appProgramBaseDto);
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
		
		appProgramBaseDto=appProgramService.getOneProgram(searchDto);
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
	
	public String getProgramID() {
		return ProgramID;
	}
	public void setProgramID(String ProgramID) {
		this.ProgramID = ProgramID;
	}
	public AppProgramBaseDto getAppProgramBaseDto() {
		return appProgramBaseDto;
	}
	public void setAppProgramBaseDto(AppProgramBaseDto appProgramBaseDto) {
		this.appProgramBaseDto = appProgramBaseDto;
	}
	public List<AppProgramBaseDto> getAppProgramBaseDtos() {
		return appProgramBaseDtos;
	}
	public void setAppProgramBaseDtos(
			List<AppProgramBaseDto> appProgramBaseDtos) {
		this.appProgramBaseDtos = appProgramBaseDtos;
	}

}
