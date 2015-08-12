package com.huiting.manage.action.sysconfig;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.EmailMessageDto;
import com.huiting.manage.dto.sysconfig.EmailSendDto;
import com.huiting.manage.services.sysconfig.CcUserService;
import com.huiting.manage.services.sysconfig.EmailSendService;
import com.huiting.manage.system.util.Constants;
import com.huiting.manage.system.util.DateUtil;

/**
 * 邮箱发送列表
 * @author ncp
 *
 */
public class EmailSendAction extends BaseAction{
   /**
	 * 
	 */
   private static final long serialVersionUID = 1L;
   /** 用户集合**/
  private List<CcUserDto> ccUserDtoList;
   private List<EmailSendDto> emailSendDtos;
   private List<EmailMessageDto> emailMessageDtos;
   private SearchDto searchDto;
	@Resource(name = "emailSendServiceImpl")
   private EmailSendService emailSendService;
	/** 用户管理Service**/
	@Resource(name = "ccUserServiceImpl")
	private CcUserService ccUserService;
   public String getEmail() throws ParseException{
	   CcUserDto user = (CcUserDto) session.get(Constants.USERLOGIN);
	   if(searchDto==null){
		   searchDto=new SearchDto();
	   }
	   searchDto.setComCode(user.getComcode());
	   if("T0101000".equals(searchDto.getTemplatenum())){//问题推送与整改初次提醒
		   emailSendDtos=emailSendService.getEmailBody(searchDto);  
	   }
	   if("T0201000".equals(searchDto.getTemplatenum())){//数据采集与报送初次提醒
		   if(searchDto.getStatDate()==null){
			   SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
			   searchDto.setStatDate(DateUtil.getLastMonth(sdf.format(new Date())));
		   }
		   searchDto.setFetchrate(DateUtil.getFetchrate(searchDto.getStatDate()));
		   emailSendDtos=emailSendService.getEmailBodyHandSumbit(searchDto);  
	   }
	   if("T0203000".equals(searchDto.getTemplatenum())){//数据采集与报送重新录
		   SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
		   searchDto.setStatDate(DateUtil.getLastMonth(sdf.format(new Date())));
		   searchDto.setFetchrate(DateUtil.getFetchrate(searchDto.getStatDate()));
		   emailSendDtos=emailSendService.getEmailBodyReentry(searchDto);  
	   }
	   if("T0102000".equals(searchDto.getTemplatenum())){//问题推送与整改催办提醒
		   searchDto.setComCode(user.getComcode());
		   emailSendDtos=emailSendService.getEmailCuiBan(searchDto);  
	   }
	   if("T0202000".equals(searchDto.getTemplatenum())){//数据采集与报送逾期提醒
		   emailSendDtos=emailSendService.getEmailHandSumbitCuiBan(searchDto);  
	   }
	   return "list";
   }
   /**
    * 邮件发送
    * @return
    */
   public String sendEmail(){
	   CcUserDto user = (CcUserDto) session.get(Constants.USERLOGIN);
	   emailSendService.sendEmail(emailMessageDtos,user,searchDto);
	   return null;
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
		 CcUserDto ccUserDto = (CcUserDto) session.get(Constants.USERLOGIN);
		 if(searchDto==null){
			 searchDto=new SearchDto();	 
		 }
		 searchDto.setComCode(ccUserDto.getComcode());
		 ccUserDtoList = ccUserService.queryUserList(searchDto);/**查询用户表信息 **/
		 return "addressForPage";
	 }
   
   
   
   
   
	public List<CcUserDto> getCcUserDtoList() {
	return ccUserDtoList;
}
public void setCcUserDtoList(List<CcUserDto> ccUserDtoList) {
	this.ccUserDtoList = ccUserDtoList;
}
	public List<EmailMessageDto> getEmailMessageDtos() {
	return emailMessageDtos;
	}
	public void setEmailMessageDtos(List<EmailMessageDto> emailMessageDtos) {
		this.emailMessageDtos = emailMessageDtos;
	}
	public SearchDto getSearchDto() {
		return searchDto;
	}
	public void setSearchDto(SearchDto searchDto) {
		this.searchDto = searchDto;
	}
	public List<EmailSendDto> getEmailSendDtos() {
		return emailSendDtos;
	}
	public void setEmailSendDtos(List<EmailSendDto> emailSendDtos) {
		this.emailSendDtos = emailSendDtos;
	}
}
