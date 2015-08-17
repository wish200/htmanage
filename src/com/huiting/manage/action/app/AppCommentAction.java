package com.huiting.manage.action.app;

import java.util.List;

import javax.annotation.Resource;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dto.base.AppCommentBaseDto;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppCommentService;
import com.huiting.manage.system.tag.Page;
import com.huiting.manage.system.util.Constants;

public class AppCommentAction extends BaseAction{


	private static final long serialVersionUID = 1L;
	private AppCommentBaseDto appCommentBaseDto;
	private List<AppCommentBaseDto> appCommentBaseDtos;
	@Resource(name = "appCommentServiceImpl")
	private AppCommentService appCommentService;
	private SearchDto searchDto;
	private String CommentID;
	private Page page;
	
	private String concerneduserid;
	
	
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
			page.setTotalCount(appCommentService.getCommentCount(searchDto));
			
		}
		searchDto.setPage(page);
		appCommentBaseDtos=appCommentService.getCommentList(searchDto);
		return LIST;
	};
	/**
	 * 
	* @Title: addComment 
	* @Description: 添加公告信息
	* @param @return    
	* @return String  
	* @throws
	 */
	public String add(){
		if(appCommentBaseDto!=null){
			String systemCode=appCommentService.getMaxCommentCode();//最大Eventno
			String newComment=appCommentService.getNewCommentCode(systemCode);//获得新的Eventno
			appCommentBaseDto.setCommentid(newComment);
			appCommentService.add(appCommentBaseDto);
			renderText(newComment);
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
		appCommentBaseDto.setCommentstatus("1");
		appCommentService.update(appCommentBaseDto);
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
		appCommentService.update(appCommentBaseDto);
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
		appCommentService.delete(appCommentBaseDto);
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
		
		appCommentBaseDto=appCommentService.getOneComment(searchDto);
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
		searchDto.setUserid(concerneduserid);
		appCommentBaseDto=appCommentService.getOneUser(searchDto);
		renderJson(appCommentBaseDto);
		
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
	
	public String getCommentID() {
		return CommentID;
	}
	public void setCommentID(String CommentID) {
		this.CommentID = CommentID;
	}
	public AppCommentBaseDto getAppCommentBaseDto() {
		return appCommentBaseDto;
	}
	public void setAppCommentBaseDto(AppCommentBaseDto appCommentBaseDto) {
		this.appCommentBaseDto = appCommentBaseDto;
	}
	public List<AppCommentBaseDto> getAppCommentBaseDtos() {
		return appCommentBaseDtos;
	}
	public void setAppCommentBaseDtos(
			List<AppCommentBaseDto> appCommentBaseDtos) {
		this.appCommentBaseDtos = appCommentBaseDtos;
	}
	public String getConcerneduserid() {
		return concerneduserid;
	}
	public void setConcerneduserid(String concerneduserid) {
		this.concerneduserid = concerneduserid;
	}

}
