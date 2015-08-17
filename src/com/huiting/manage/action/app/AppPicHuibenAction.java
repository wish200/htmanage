package com.huiting.manage.action.app;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dto.base.AppPicHuibenBaseDto;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppPicHuibenService;
import com.huiting.manage.system.tag.Page;
import com.huiting.manage.system.util.Constants;

public class AppPicHuibenAction extends BaseAction{


	private static final long serialVersionUID = 1L;
	private AppPicHuibenBaseDto appPicHuibenBaseDto;
	private List<AppPicHuibenBaseDto> appPicHuibenBaseDtos;
	@Resource(name = "appPicHuibenServiceImpl")
	private AppPicHuibenService appPicHuibenService;
	private SearchDto searchDto;
	private String HuibenID;
	private Page page;
	
	private String userid;
	private String picbookid;
	private String audioid;
	
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
			page.setTotalCount(appPicHuibenService.getPicHuibenCount(searchDto));
			
		}
		searchDto.setPage(page);
		appPicHuibenBaseDtos=appPicHuibenService.getPicHuibenList(searchDto);
		return LIST;
	};
	/**
	 * 
	* @Title: addPicHuiben 
	* @Description: 添加公告信息
	* @param @return    
	* @return String  
	* @throws
	 */
	public String add(){
		if(appPicHuibenBaseDto!=null){
			String huibenid = "";
			SearchDto searchDto1 = new SearchDto();
			AppPicHuibenBaseDto appPicHuibenBaseTempDto =null;
			while("".equals(huibenid)||appPicHuibenBaseTempDto!=null){
				huibenid = genHuibenID("PH");
				searchDto1.setHuibenid(huibenid);
				appPicHuibenBaseTempDto = appPicHuibenService.getOnePicHuiben(searchDto1);
			}

			
			appPicHuibenBaseDto.setHuibenid(huibenid);
			appPicHuibenService.add(appPicHuibenBaseDto);
			renderText(huibenid);
		}
		return null;
	}
	public String genHuibenID(String type){
		 String[] chars = new String[] {"1","2","3","4","5","6","7","8","9","0"}; 
		 StringBuffer shortBuffer = new StringBuffer(); 
		 shortBuffer.append(type);
		    String uuid = UUID.randomUUID().toString().replace("-", "");  
		    shortBuffer.append(uuid);
		    /*for (int i = 0; i < 8; i++) {  
		        String str = uuid.substring(i * 4, i * 4 + 4);  
		        int x = Integer.parseInt(str, 16);  
		        shortBuffer.append(chars[(x % 0x3E)/9]);  
		    } */ 
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
		appPicHuibenBaseDto.setStatus("1");
		appPicHuibenService.update(appPicHuibenBaseDto);
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
		appPicHuibenService.update(appPicHuibenBaseDto);
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
		appPicHuibenService.delete(appPicHuibenBaseDto);
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
		
		appPicHuibenBaseDto=appPicHuibenService.getOnePicHuiben(searchDto);
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
		appPicHuibenBaseDto=appPicHuibenService.getOneUser(searchDto);
		if(appPicHuibenBaseDto==null){
			appPicHuibenBaseDto = new AppPicHuibenBaseDto();
		}
		renderJson(appPicHuibenBaseDto);
		
	}
	public void changepicbook(){
		if(searchDto==null){
			searchDto=new SearchDto();
		}
		searchDto.setPicbookid(picbookid);
		appPicHuibenBaseDto=appPicHuibenService.getOnePicbook(searchDto);
		if(appPicHuibenBaseDto==null){
			appPicHuibenBaseDto = new AppPicHuibenBaseDto();
		}
		renderJson(appPicHuibenBaseDto);
		
	}
	public void changeaudio(){
		if(searchDto==null){
			searchDto=new SearchDto();
		}
		searchDto.setAudioid(audioid);
		appPicHuibenBaseDto=appPicHuibenService.getOneAudio(searchDto);
		if(appPicHuibenBaseDto==null){
			appPicHuibenBaseDto = new AppPicHuibenBaseDto();
		}
		renderJson(appPicHuibenBaseDto);
		
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
	
	
	public String getHuibenID() {
		return HuibenID;
	}
	public void setHuibenID(String huibenID) {
		HuibenID = huibenID;
	}
	public AppPicHuibenBaseDto getAppPicHuibenBaseDto() {
		return appPicHuibenBaseDto;
	}
	public void setAppPicHuibenBaseDto(AppPicHuibenBaseDto appPicHuibenBaseDto) {
		this.appPicHuibenBaseDto = appPicHuibenBaseDto;
	}
	public List<AppPicHuibenBaseDto> getAppPicHuibenBaseDtos() {
		return appPicHuibenBaseDtos;
	}
	public void setAppPicHuibenBaseDtos(
			List<AppPicHuibenBaseDto> appPicHuibenBaseDtos) {
		this.appPicHuibenBaseDtos = appPicHuibenBaseDtos;
	}
	public AppPicHuibenService getAppPicHuibenService() {
		return appPicHuibenService;
	}
	public void setAppPicHuibenService(AppPicHuibenService appPicHuibenService) {
		this.appPicHuibenService = appPicHuibenService;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPicbookid() {
		return picbookid;
	}
	public void setPicbookid(String picbookid) {
		this.picbookid = picbookid;
	}
	public String getAudioid() {
		return audioid;
	}
	public void setAudioid(String audioid) {
		this.audioid = audioid;
	}
	
}
