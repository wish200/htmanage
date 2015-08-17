package com.huiting.manage.action.app;
 
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dto.base.AppHuibenBaseDto;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppHuibenService;
import com.huiting.manage.system.tag.Page;
import com.huiting.manage.system.util.Constants;

public class AppHuibenAction extends BaseAction{


	private static final long serialVersionUID = 1L;
	private AppHuibenBaseDto appHuibenBaseDto;
	private List<AppHuibenBaseDto> appHuibenBaseDtos;
	@Resource(name = "appHuibenServiceImpl")
	private AppHuibenService appHuibenService;
	private SearchDto searchDto;
	private String huibenid;
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
			page.setTotalCount(appHuibenService.getHuibenCount(searchDto));
			
		}
		searchDto.setPage(page);
		appHuibenBaseDtos=appHuibenService.getHuibenList(searchDto);
		return LIST;
	};
	/**
	 * 
	* @Title: addHuiben 
	* @Description: 添加公告信息
	* @param @return    
	* @return String  
	* @throws
	 */
	public String add(){
		if(appHuibenBaseDto!=null){
			String huibenid = "";
			SearchDto searchDto1 = new SearchDto();
			AppHuibenBaseDto appHuibenBaseTempDto =null;
			while("".equals(huibenid)||appHuibenBaseTempDto!=null){
				huibenid = genHuibenID("H");
				searchDto1.setHuibenid(huibenid);
				appHuibenBaseTempDto = appHuibenService.getOneHuiben(searchDto1);
			}
			
			appHuibenBaseDto.setHuibenid(huibenid);
			appHuibenService.add(appHuibenBaseDto);
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
		    }  */
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
		appHuibenBaseDto.setStatus("1");
		appHuibenService.update(appHuibenBaseDto);
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
		appHuibenService.update(appHuibenBaseDto);
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
		appHuibenService.delete(appHuibenBaseDto);
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
		
		appHuibenBaseDto=appHuibenService.getOneHuiben(searchDto);
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
		appHuibenBaseDto=appHuibenService.getOneUser(searchDto);
		System.out.println("bnickname="+appHuibenBaseDto.getNickname());
		if(appHuibenBaseDto==null){
			appHuibenBaseDto = new AppHuibenBaseDto();
		}
		renderJson(appHuibenBaseDto);
		
	}
	public void changepicbook(){
		if(searchDto==null){
			searchDto=new SearchDto();
		}
		searchDto.setPicbookid(picbookid);
		appHuibenBaseDto=appHuibenService.getOnePicbook(searchDto);
		if(appHuibenBaseDto==null){
			appHuibenBaseDto = new AppHuibenBaseDto();
		}
		renderJson(appHuibenBaseDto);
		
	}
	public void changeaudio(){
		if(searchDto==null){
			searchDto=new SearchDto();
		}
		searchDto.setAudioid(audioid);
		appHuibenBaseDto=appHuibenService.getOneAudio(searchDto);
		if(appHuibenBaseDto==null){
			appHuibenBaseDto = new AppHuibenBaseDto();
		}
		renderJson(appHuibenBaseDto);
		
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
	
	
	public AppHuibenBaseDto getAppHuibenBaseDto() {
		return appHuibenBaseDto;
	}
	public void setAppHuibenBaseDto(AppHuibenBaseDto appHuibenBaseDto) {
		this.appHuibenBaseDto = appHuibenBaseDto;
	}
	public List<AppHuibenBaseDto> getAppHuibenBaseDtos() {
		return appHuibenBaseDtos;
	}
	public void setAppHuibenBaseDtos(
			List<AppHuibenBaseDto> appHuibenBaseDtos) {
		this.appHuibenBaseDtos = appHuibenBaseDtos;
	}
	public AppHuibenService getAppHuibenService() {
		return appHuibenService;
	}
	public void setAppHuibenService(AppHuibenService appHuibenService) {
		this.appHuibenService = appHuibenService;
	}
	public String getHuibenid() {
		return huibenid;
	}
	public void setHuibenid(String huibenid) {
		this.huibenid = huibenid;
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
