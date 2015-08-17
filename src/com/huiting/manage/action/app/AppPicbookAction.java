package com.huiting.manage.action.app;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dto.base.AppPicbookBaseDto;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppPicbookService;
import com.huiting.manage.system.tag.Page;
import com.huiting.manage.system.util.Constants;

public class AppPicbookAction extends BaseAction{


	private static final long serialVersionUID = 1L;
	private AppPicbookBaseDto appPicbookBaseDto;
	private List<AppPicbookBaseDto> appPicbookBaseDtos;
	@Resource(name = "appPicbookServiceImpl")
	private AppPicbookService appPicbookService;
	private SearchDto searchDto;
	private String PicbookID;
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
			page.setTotalCount(appPicbookService.getPicbookCount(searchDto));
			
		}
		searchDto.setPage(page);
		appPicbookBaseDtos=appPicbookService.getPicbookList(searchDto);
		return LIST;
	};
	/**
	 * 
	* @Title: addPicbook 
	* @Description: 添加公告信息
	* @param @return    
	* @return String  
	* @throws
	 */
	public String add(){
		if(appPicbookBaseDto!=null){
			String picbookid = "";
			SearchDto searchDto1 = new SearchDto();
			AppPicbookBaseDto appPicbookBaseTempDto =null;
			while("".equals(picbookid)||appPicbookBaseTempDto!=null){
				picbookid = genPicbookID("P");
				searchDto1.setPicbookid(picbookid);
				appPicbookBaseTempDto = appPicbookService.getOnePicbook(searchDto1);
			}
			
			appPicbookBaseDto.setPicbookid(picbookid);
			appPicbookService.add(appPicbookBaseDto);
			renderText(picbookid);
		}
		return null;
	}
	public String genPicbookID(String type){
		 String[] chars = new String[] {"1","2","3","4","5","6","7","8","9","0"}; 
		 StringBuffer shortBuffer = new StringBuffer(); 
		 shortBuffer.append(type);
		    String uuid = UUID.randomUUID().toString().replace("-", "");
		    shortBuffer.append(uuid);
		   /* for (int i = 0; i < 8; i++) {  
		        String str = uuid.substring(i * 4, i * 4 + 4);  
		        int x = Integer.parseInt(str, 16);  
		        shortBuffer.append(chars[(x % 0x3E)/9]);  
		    }*/  
		    return shortBuffer.toString(); 
		
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
		appPicbookBaseDto.setPicbookstatus("1");
		appPicbookService.update(appPicbookBaseDto);
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
		appPicbookService.update(appPicbookBaseDto);
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
		appPicbookService.delete(appPicbookBaseDto);
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
		
		appPicbookBaseDto=appPicbookService.getOnePicbook(searchDto);
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
		appPicbookBaseDto=appPicbookService.getOneUser(searchDto); 
		if(appPicbookBaseDto==null){
			appPicbookBaseDto = new AppPicbookBaseDto();
		}
		renderJson(appPicbookBaseDto);
		
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
	
	public String getPicbookID() {
		return PicbookID;
	}
	public void setPicbookID(String PicbookID) {
		this.PicbookID = PicbookID;
	}
	public AppPicbookBaseDto getAppPicbookBaseDto() {
		return appPicbookBaseDto;
	}
	public void setAppPicbookBaseDto(AppPicbookBaseDto appPicbookBaseDto) {
		this.appPicbookBaseDto = appPicbookBaseDto;
	}
	public List<AppPicbookBaseDto> getAppPicbookBaseDtos() {
		return appPicbookBaseDtos;
	}
	public void setAppPicbookBaseDtos(
			List<AppPicbookBaseDto> appPicbookBaseDtos) {
		this.appPicbookBaseDtos = appPicbookBaseDtos;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

}
