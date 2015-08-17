package com.huiting.manage.action.app;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dto.base.AppAudioBaseDto;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppAudioService;
import com.huiting.manage.system.tag.Page;
import com.huiting.manage.system.util.Constants;

public class AppAudioAction extends BaseAction{


	private static final long serialVersionUID = 1L;
	private AppAudioBaseDto appAudioBaseDto;
	private List<AppAudioBaseDto> appAudioBaseDtos;
	@Resource(name = "appAudioServiceImpl")
	private AppAudioService appAudioService;
	private SearchDto searchDto;
	private String AudioID;
	private Page page;
	private String userid;
	private String programid;
	
	
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
			page.setTotalCount(appAudioService.getAudioCount(searchDto));
			
		}
		searchDto.setPage(page);
		appAudioBaseDtos=appAudioService.getAudioList(searchDto);
		return LIST;
	};
	/**
	 * 
	* @Title: addAudio 
	* @Description: 添加公告信息
	* @param @return    
	* @return String  
	* @throws
	 */
	public String add(){
		if(appAudioBaseDto!=null){
			String audioid = "";
			SearchDto searchDto1 = new SearchDto();
			AppAudioBaseDto appAudioBaseTempDto =null;
			while("".equals(audioid)||appAudioBaseTempDto!=null){
				audioid = genAudioID("A");
				searchDto1.setAudioid(audioid);
				appAudioBaseTempDto = appAudioService.getOneAudio(searchDto1);
			}
			
			appAudioBaseDto.setAudioid(audioid);
			appAudioService.add(appAudioBaseDto);
			renderText(audioid);
		}
		return null;
	}
	public String genAudioID(String type){
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
		appAudioBaseDto.setAudiostatus("1");
		appAudioService.update(appAudioBaseDto);
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
		appAudioService.update(appAudioBaseDto);
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
		appAudioService.delete(appAudioBaseDto);
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
		
		appAudioBaseDto=appAudioService.getOneAudio(searchDto);
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
		appAudioBaseDto=appAudioService.getOneUser(searchDto); 
		if(appAudioBaseDto==null){
			appAudioBaseDto = new AppAudioBaseDto();
		}
		renderJson(appAudioBaseDto);
		
	}
	
	public void changeprogram(){
		if(searchDto==null){
			searchDto=new SearchDto();
		}
		searchDto.setProgramid(programid);
		appAudioBaseDto=appAudioService.getOneObject(searchDto); 
		if(appAudioBaseDto==null){
			appAudioBaseDto = new AppAudioBaseDto();
		}
		renderJson(appAudioBaseDto);
		
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
	
	public String getAudioID() {
		return AudioID;
	}
	public void setAudioID(String AudioID) {
		this.AudioID = AudioID;
	}
	public AppAudioBaseDto getAppAudioBaseDto() {
		return appAudioBaseDto;
	}
	public void setAppAudioBaseDto(AppAudioBaseDto appAudioBaseDto) {
		this.appAudioBaseDto = appAudioBaseDto;
	}
	public List<AppAudioBaseDto> getAppAudioBaseDtos() {
		return appAudioBaseDtos;
	}
	public void setAppAudioBaseDtos(
			List<AppAudioBaseDto> appAudioBaseDtos) {
		this.appAudioBaseDtos = appAudioBaseDtos;
	}
	public AppAudioService getAppAudioService() {
		return appAudioService;
	}
	public void setAppAudioService(AppAudioService appAudioService) {
		this.appAudioService = appAudioService;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getProgramid() {
		return programid;
	}
	public void setProgramid(String programid) {
		this.programid = programid;
	}

	
}
