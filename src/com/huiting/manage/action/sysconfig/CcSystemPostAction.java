package com.huiting.manage.action.sysconfig;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dto.base.CcSystemPostBaseDto;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.sysconfig.CcSystemPostService;
import com.huiting.manage.system.tag.Page;
import com.huiting.manage.system.util.Constants;
import com.sun.servicetag.SystemEnvironment;

public class CcSystemPostAction extends BaseAction{


	private static final long serialVersionUID = 1L;
	private CcSystemPostBaseDto ccSystemPostBaseDto;
	private List<CcSystemPostBaseDto> ccSystemPostBaseDtos;
	@Resource(name = "ccSystemPostServiceImpl")
	private CcSystemPostService ccSystemPostService;
	private SearchDto searchDto;
	private String sysPostCode;
	private Page page;
	
	
	/**
	 * 
	* @Title: addSysPost 
	* @Description: 公告信息list
	* @param @return    
	* @return String  
	* @throws
	 */ 
	public String getSystrmPoseList(){
		CcUserDto ccUserDto=(CcUserDto) session.get(Constants.USERLOGIN);
		if(searchDto==null){
			searchDto=new SearchDto();
		}
		System.out.println("1----serch--------------"+searchDto.getPostdesc()+searchDto.getPage());
		if("1".equals(ccUserDto.getCcDepPositionBaseDto().getDeppostype())&&"1".equals(ccUserDto.getCcDepPositionBaseDto().getImportlev())){
		}else {
			searchDto.setValidstate("1");
		}
		if(page==null){
			page=new Page();
			page.setTotalCount(ccSystemPostService.getSystrmPoseCount(searchDto));
		}
		searchDto.setPage(page);
		ccSystemPostBaseDtos=ccSystemPostService.getSystrmPoseList(searchDto);
		System.out.println(ccSystemPostBaseDtos.size());
		return LIST;
	};
	/**
	 * 
	* @Title: addSysPost 
	* @Description: 添加公告信息
	* @param @return    
	* @return String  
	* @throws
	 */
	public String addSysPost(){
		if(ccSystemPostBaseDto!=null){
			String systemCode=ccSystemPostService.getMaxSystemCode();//最大Eventno
			String newSystemCode=ccSystemPostService.getNewSystemCode(systemCode);//获得新的Eventno
			ccSystemPostBaseDto.setSystemcode(newSystemCode);
			ccSystemPostService.add(ccSystemPostBaseDto);
			renderText(newSystemCode);
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
	public String sendSysPost(){
		ccSystemPostBaseDto.setValidstatus("1");
		ccSystemPostBaseDto.setStartdate(new Date());
		ccSystemPostService.update(ccSystemPostBaseDto);
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
	public String updateSysPost(){
		ccSystemPostService.update(ccSystemPostBaseDto);
		return "updateSysPost";
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
		ccSystemPostService.delete(ccSystemPostBaseDto);
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
		System.out.println(searchDto.getSystemcode()+"--syspost serch");
		ccSystemPostBaseDto=ccSystemPostService.getOneSysPost(searchDto);
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
	public String getSysPostCode() {
		return sysPostCode;
	}
	public void setSysPostCode(String sysPostCode) {
		this.sysPostCode = sysPostCode;
	}
	public CcSystemPostBaseDto getCcSystemPostBaseDto() {
		return ccSystemPostBaseDto;
	}
	public void setCcSystemPostBaseDto(CcSystemPostBaseDto ccSystemPostBaseDto) {
		this.ccSystemPostBaseDto = ccSystemPostBaseDto;
	}
	public List<CcSystemPostBaseDto> getCcSystemPostBaseDtos() {
		return ccSystemPostBaseDtos;
	}
	public void setCcSystemPostBaseDtos(
			List<CcSystemPostBaseDto> ccSystemPostBaseDtos) {
		this.ccSystemPostBaseDtos = ccSystemPostBaseDtos;
	}

}
