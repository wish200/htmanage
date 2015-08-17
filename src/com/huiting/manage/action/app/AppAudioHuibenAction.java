package com.huiting.manage.action.app;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dto.base.AppAudioHuibenBaseDto;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppAudioHuibenService;
import com.huiting.manage.system.tag.Page;
import com.huiting.manage.system.util.Constants;

public class AppAudioHuibenAction extends BaseAction{


	private static final long serialVersionUID = 1L;
	private AppAudioHuibenBaseDto appAudioHuibenBaseDto;
	private List<AppAudioHuibenBaseDto> appAudioHuibenBaseDtos;
	@Resource(name = "appAudioHuibenServiceImpl")
	private AppAudioHuibenService appAudioHuibenService;
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
			page.setTotalCount(appAudioHuibenService.getAudioHuibenCount(searchDto));
			
		}
		searchDto.setPage(page);
		appAudioHuibenBaseDtos=appAudioHuibenService.getAudioHuibenList(searchDto);
		return LIST;
	};
	/**
	 * 
	* @Title: addAudioHuiben 
	* @Description: 添加公告信息
	* @param @return    
	* @return String  
	* @throws
	 */
	public String add(){
		if(appAudioHuibenBaseDto!=null){
			String huibenid = "";
			SearchDto searchDto1 = new SearchDto();
			AppAudioHuibenBaseDto appAudioHuibenBaseTempDto =null;
			while("".equals(huibenid)||appAudioHuibenBaseTempDto!=null){
				huibenid = genHuibenID("AH");
				searchDto1.setHuibenid(huibenid);
				appAudioHuibenBaseTempDto = appAudioHuibenService.getOneAudioHuiben(searchDto1);
			}
			
			
			appAudioHuibenBaseDto.setHuibenid(huibenid);
			appAudioHuibenService.add(appAudioHuibenBaseDto);
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
		appAudioHuibenBaseDto.setStatus("1");
		appAudioHuibenService.update(appAudioHuibenBaseDto);
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
		appAudioHuibenService.update(appAudioHuibenBaseDto);
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
		appAudioHuibenService.delete(appAudioHuibenBaseDto);
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
		
		appAudioHuibenBaseDto=appAudioHuibenService.getOneAudioHuiben(searchDto);
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
		appAudioHuibenBaseDto=appAudioHuibenService.getOneUser(searchDto);
		if(appAudioHuibenBaseDto==null){
			appAudioHuibenBaseDto = new AppAudioHuibenBaseDto();
		}
		renderJson(appAudioHuibenBaseDto);
		
	}
	public void changepicbook(){
		if(searchDto==null){
			searchDto=new SearchDto();
		}
		searchDto.setPicbookid(picbookid);
		appAudioHuibenBaseDto=appAudioHuibenService.getOnePicbook(searchDto);
		if(appAudioHuibenBaseDto==null){
			appAudioHuibenBaseDto = new AppAudioHuibenBaseDto();
		}
		renderJson(appAudioHuibenBaseDto);
		
	}
	public void changeaudio(){
		if(searchDto==null){
			searchDto=new SearchDto();
		}
		searchDto.setAudioid(audioid);
		appAudioHuibenBaseDto=appAudioHuibenService.getOneAudio(searchDto);
		if(appAudioHuibenBaseDto==null){
			appAudioHuibenBaseDto = new AppAudioHuibenBaseDto();
		}
		renderJson(appAudioHuibenBaseDto);
		
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
	
	
	public AppAudioHuibenService getAppAudioHuibenService() {
		return appAudioHuibenService;
	}
	public void setAppAudioHuibenService(AppAudioHuibenService appAudioHuibenService) {
		this.appAudioHuibenService = appAudioHuibenService;
	}
	public String getHuibenID() {
		return HuibenID;
	}
	public void setHuibenID(String huibenID) {
		HuibenID = huibenID;
	}
	public AppAudioHuibenBaseDto getAppAudioHuibenBaseDto() {
		return appAudioHuibenBaseDto;
	}
	public void setAppAudioHuibenBaseDto(AppAudioHuibenBaseDto appAudioHuibenBaseDto) {
		this.appAudioHuibenBaseDto = appAudioHuibenBaseDto;
	}
	public List<AppAudioHuibenBaseDto> getAppAudioHuibenBaseDtos() {
		return appAudioHuibenBaseDtos;
	}
	public void setAppAudioHuibenBaseDtos(
			List<AppAudioHuibenBaseDto> appAudioHuibenBaseDtos) {
		this.appAudioHuibenBaseDtos = appAudioHuibenBaseDtos;
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
