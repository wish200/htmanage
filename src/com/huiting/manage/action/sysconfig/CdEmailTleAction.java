package com.huiting.manage.action.sysconfig;

import java.util.List;

import javax.annotation.Resource;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dto.base.CdEmailTemplateBaseDto;
import com.huiting.manage.dto.base.CdTemplateCatNoBaseDto;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CdEmailRecDto;
import com.huiting.manage.services.sysconfig.CcUserService;
import com.huiting.manage.services.sysconfig.CdEmailTleService;
import com.huiting.manage.system.tag.Page;
import com.huiting.manage.system.util.Constants;

/**
 * 
* @ClassName: CcEmailTemplateAction
* @Description:  邮件模板管理
* @author ZhangYangYang
* @date 2013-12-22 下午01:35:54
 */
public class CdEmailTleAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	/** 模板管理Service**/
	@Resource(name = "cdEmailTleServiceImpl")
	private CdEmailTleService cdEmailTleService;
	/** 用户管理Service**/
	@Resource(name = "ccUserServiceImpl")
	private CcUserService ccUserService;
	
	/** 邮件模板List**/
	private List<CdEmailTemplateBaseDto> cdEmailTemplateBaseDtoList;
	/** 邮件模板表**/
	private CdEmailTemplateBaseDto cdEmailTemplateBaseDto;
	/** 查询条件 */
	private SearchDto searchDto;
	/** 模板类型表 */
	private CdTemplateCatNoBaseDto cdTemplateCatNoBaseDto;
	/** 模板类型表List */
    private List<CdTemplateCatNoBaseDto> cdTemplateCatNoBaseDtoList;
	/** 用户集合**/
	private List<CcUserDto> ccUserDtoList;
	/** 用户实体类*/
	private CcUserDto ccUserDto;
	/** 邮件模板接受人表**/
	private CdEmailRecDto cdEmailRecDto;
	/** 邮件模板接受人表List**/
	private List<CdEmailRecDto> cdEmailRecDtoList;
	/** 收件人**/
	private String sentToCode;
	/** 抄送人**/
	private String  BCCCode;
	/** 收件人名字**/
    private String sentToName;
    /**部门代码*/
    private String BCCDepCode;
    
    /** 抄送人名字**/
    private String BCCName;
    private Page page;
	 /**
	  * 
	 * @Title: findEmailTemplate 
	 * @Description:  [查看] 模板信息 (单个)
	 * @param @return     
	 * @return String   
	 * @throws
	  */
    public String queryEmailTle(){
    	ccUserDto = (CcUserDto) session.get(Constants.USERLOGIN);
    	/**查询邮件模板表List **/
//    	
    	/**查询邮件模板接受人表List **/
//    	cdEmailRecDtoList=cdEmailTleService.queryEmailRec(searchDto);
    	/**查询单个模板信息 **/
    	cdEmailTemplateBaseDto=cdEmailTleService.findEmailTle(searchDto);
		/*sentToName="";
		BCCName="";
		sentToCode="";
		BCCCode="";
		BCCDepCode="";
		for(CdEmailRecDto cdedto : cdEmailRecDtoList){
			if(("1").equals(cdedto.getRectype()) && cdedto.getCcUserDto().getUsername()!=null){
				sentToName+=cdedto.getCcUserDto().getUsername()+",";
				sentToCode+=cdedto.getRecno()+",";
				BCCDepCode+=cdedto.getNewdepcode()+",";
			}else if(("2").equals(cdedto.getRectype()) && cdedto.getCcUserDto().getUsername()!=null){
				BCCName+=cdedto.getCcUserDto().getUsername()+",";
				BCCCode+=cdedto.getRecno()+",";
				BCCDepCode+=cdedto.getNewdepcode()+",";
			}
		}
		if(BCCName!=null && BCCName!=""){
			BCCName=BCCName.substring(0,BCCName.length()-1);
			BCCCode=BCCCode.substring(0,BCCCode.length()-1);
			BCCDepCode=BCCDepCode.substring(0, BCCDepCode.length()-1);
		}*/
    	if("query".equals(searchDto.getDoing())){
    		return VIEW;
    	}else{
    		cdEmailTemplateBaseDtoList=cdEmailTleService.findEmailTleForList(searchDto);
    		return "editPage";
    	}
    }
    /**
     * 
    * @Title: findEmailTemplateForList 
    * @Description:  [查找] 模板信息(List)
    * @param @return     
    * @return String   
    * @throws
     */
    public String queryEmailTleForList(){
    	if(searchDto==null){
    		searchDto = new SearchDto();
    	}
    	ccUserDto = (CcUserDto) session.get(Constants.USERLOGIN);
		searchDto.setComCode(ccUserDto.getComcode());
    	if(page==null){
			page=new Page();
			page.setTotalCount(cdEmailTleService.getEmailTleCount(searchDto));
		}
		searchDto.setPage(page);
    	cdEmailTemplateBaseDtoList=cdEmailTleService.findEmailTleForList(searchDto);
   	    return LIST;
    }
	 /**
	  * 
	 * @Title: insertEmailTemplateForPage 
	 * @Description:  [插入] 模板信息-跳转页面
	 * @param @return     
	 * @return String   
	 * @throws
	  */
	 public String insertEmailTleForPage(){
		 if(searchDto==null){
	    		searchDto = new SearchDto();
	    	}
		 ccUserDto = (CcUserDto) session.get(Constants.USERLOGIN);
		 searchDto.setComCode(ccUserDto.getComcode());
		 cdEmailTemplateBaseDtoList=cdEmailTleService.findEmailTleForList(searchDto);
		 return "insertForPage";
	 }
	 /**
	   * @Description: 模板名称是否存在
	   * @param @return    
	   * @return String   
	   * @throws
	  */
	 public String exitsTepName(){
		 CcUserDto ccUserDto = (CcUserDto) session.get(Constants.USERLOGIN);
		 searchDto.setComCode(ccUserDto.getComcode());
		 int i=cdEmailTleService.getEmailTleCount(searchDto);
			renderJson(i);
		 return null;
	 }
	 /**
	  * 
	 * @Title: insertEmailTemplate 
	 * @Description:  [插入] 模板信息
	 * @param @return     
	 * @return String   
	 * @throws
	  */
	 public String insertEmailTle(){
		 ccUserDto = (CcUserDto) session.get(Constants.USERLOGIN);
		 String maxCode=cdEmailTleService.getMaxCode(searchDto);
		 String newCode=cdEmailTleService.newCode(maxCode);
		 cdEmailTemplateBaseDto.setTemplatenum(newCode);//新的代码
		 cdEmailTemplateBaseDto.setComcode(ccUserDto.getComcode());//机构代码
		 cdEmailTleService.insertEmailTle(cdEmailTemplateBaseDto);//插入模板信息
		 /*String[] BCCArray=null;
		 String[] BCCDepCodeArray=null;
		 if(BCCCode!=null){
			 BCCArray= BCCCode.split(",");
			 BCCDepCodeArray=BCCDepCode.split(",");
			 cdEmailRecDto=new CdEmailRecDto();
			 cdEmailTleService.cdEmailRecBatch(cdEmailRecDto,BCCArray,BCCDepCodeArray,cdEmailTemplateBaseDto,"BCC");
		 }*/
		 return SAVE;
	 }
	 /**
	  * 
	 * @Title: EmailTemplateForAddressPage 
	 * @Description:  模板信息 -收件人 ajax返回jsp页面
	 * @param @return     
	 * @return String   
	 * @throws
	  */
	 public String addressForPage(){
		 ccUserDto = (CcUserDto) session.get(Constants.USERLOGIN);
		 if(searchDto==null){
			 searchDto=new SearchDto();	 
		 }
		 searchDto.setComCode(ccUserDto.getComcode());
		 ccUserDtoList = ccUserService.queryUserList(searchDto);/**查询用户表信息 **/
		 return "addressForPage";
	 }
	 /**
	  * 
	 * @Title: updateEmailTemplate 
	 * @Description:  [更新] 模板信息
	 * @param @return     
	 * @return String   
	 * @throws
	  */
	 public String updateEmailTle(){
		 ccUserDto = (CcUserDto) session.get(Constants.USERLOGIN);
		 
		
		 searchDto=new SearchDto();
		 searchDto.setTemplatenum(cdEmailTemplateBaseDto.getTemplatenum());
		 cdEmailTleService.deleteEmailRec(searchDto);//删除邮件模板接受人表 
		 cdEmailTleService.deleteEmailTle(searchDto);//删除邮件模板信息
		 
		 cdEmailRecDto=new CdEmailRecDto();
		 cdEmailTemplateBaseDto.setComcode(ccUserDto.getComcode());//机构代码
		 cdEmailTleService.insertEmailTle(cdEmailTemplateBaseDto);//插入邮件模板信息
		 /*if(BCCCode!=null){
			 String[] BCCArray= BCCCode.split(",");
			 String[] BCCDepCodeArray= BCCDepCode.split(",");
			 cdEmailTleService.cdEmailRecBatch(cdEmailRecDto,BCCArray,BCCDepCodeArray,cdEmailTemplateBaseDto,"BCC");
		 }*/
		 return EDIT;
	 }
	 /**
	  * 
	 * @Title: deleteEmailTemplate 
	 * @Description:  [删除] 模板信息
	 * @param @return     
	 * @return String   
	 * @throws
	  */
	 public String deleteEmailTle(){
		 cdEmailTleService.deleteEmailTle(searchDto);//删除邮件模板信息
		 cdEmailTleService.deleteEmailRec(searchDto);//删除邮件模板接受人表 
		 return DELETE;
	 }
	 
	 
	 
	 
	 
	public List<CdEmailTemplateBaseDto> getCdEmailTemplateBaseDtoList() {
		return cdEmailTemplateBaseDtoList;
	}
	public void setCdEmailTemplateBaseDtoList(
			List<CdEmailTemplateBaseDto> cdEmailTemplateBaseDtoList) {
		this.cdEmailTemplateBaseDtoList = cdEmailTemplateBaseDtoList;
	}
	public CdEmailTemplateBaseDto getCdEmailTemplateBaseDto() {
		return cdEmailTemplateBaseDto;
	}
	public void setCdEmailTemplateBaseDto(
			CdEmailTemplateBaseDto cdEmailTemplateBaseDto) {
		this.cdEmailTemplateBaseDto = cdEmailTemplateBaseDto;
	}
	public SearchDto getSearchDto() {
		return searchDto;
	}
	public void setSearchDto(SearchDto searchDto) {
		this.searchDto = searchDto;
	}
	public CdTemplateCatNoBaseDto getCdTemplateCatNoBaseDto() {
		return cdTemplateCatNoBaseDto;
	}
	public void setCdTemplateCatNoBaseDto(
			CdTemplateCatNoBaseDto cdTemplateCatNoBaseDto) {
		this.cdTemplateCatNoBaseDto = cdTemplateCatNoBaseDto;
	}
	public List<CdTemplateCatNoBaseDto> getCdTemplateCatNoBaseDtoList() {
		return cdTemplateCatNoBaseDtoList;
	}
	public void setCdTemplateCatNoBaseDtoList(
			List<CdTemplateCatNoBaseDto> cdTemplateCatNoBaseDtoList) {
		this.cdTemplateCatNoBaseDtoList = cdTemplateCatNoBaseDtoList;
	}
	public List<CcUserDto> getCcUserDtoList() {
		return ccUserDtoList;
	}
	public void setCcUserDtoList(List<CcUserDto> ccUserDtoList) {
		this.ccUserDtoList = ccUserDtoList;
	}
	public CdEmailRecDto getCdEmailRecDto() {
		return cdEmailRecDto;
	}
	public void setCdEmailRecDto(CdEmailRecDto cdEmailRecDto) {
		this.cdEmailRecDto = cdEmailRecDto;
	}
	public List<CdEmailRecDto> getCdEmailRecDtoList() {
		return cdEmailRecDtoList;
	}
	public void setCdEmailRecDtoList(List<CdEmailRecDto> cdEmailRecDtoList) {
		this.cdEmailRecDtoList = cdEmailRecDtoList;
	}
	public String getSentToCode() {
		return sentToCode;
	}
	public void setSentToCode(String sentToCode) {
		this.sentToCode = sentToCode;
	}
	public String getBCCCode() {
		return BCCCode;
	}
	public void setBCCCode(String bCCCode) {
		BCCCode = bCCCode;
	}
	public String getSentToName() {
		return sentToName;
	}
	public void setSentToName(String sentToName) {
		this.sentToName = sentToName;
	}
	public String getBCCName() {
		return BCCName;
	}
	public void setBCCName(String bCCName) {
		BCCName = bCCName;
	}
	public CcUserDto getCcUserDto() {
		return ccUserDto;
	}
	public void setCcUserDto(CcUserDto ccUserDto) {
		this.ccUserDto = ccUserDto;
	}
	public String getBCCDepCode() {
		return BCCDepCode;
	}
	public void setBCCDepCode(String bCCDepCode) {
		BCCDepCode = bCCDepCode;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	
	
}
