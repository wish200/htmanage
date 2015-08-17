package com.huiting.manage.action.sysconfig;

import java.util.List;

import javax.annotation.Resource;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcMailSendRecordDto;
import com.huiting.manage.services.sysconfig.EmailSendRecordSevice;
import com.huiting.manage.system.tag.Page;
import com.huiting.manage.system.util.Constants;

public class EmailSendRecordAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource(name = "emailSendRecordSeviceImpl")
	private EmailSendRecordSevice emailSendRecordSevice;
	private List<CcMailSendRecordDto> ccMailSendRecordDtos;
	private Page page;
	private SearchDto searchDto;
	public String list(){
		CcUserDto ccUserDto=(CcUserDto) session.get(Constants.USERLOGIN);
		if(searchDto==null){
			searchDto=new SearchDto();
		}
		if(!ccUserDto.getComcode().equals("000000")){
			searchDto.setComCode(ccUserDto.getComcode());
		}
		if(page==null){
			page=new Page();
			page.setTotalCount(emailSendRecordSevice.getEmailCount(searchDto));
		}
		searchDto.setPage(page);
		ccMailSendRecordDtos=emailSendRecordSevice.getEmailList(searchDto);
		
		
		return LIST;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public SearchDto getSearchDto() {
		return searchDto;
	}
	public void setSearchDto(SearchDto searchDto) {
		this.searchDto = searchDto;
	}
	public List<CcMailSendRecordDto> getCcMailSendRecordDtos() {
		return ccMailSendRecordDtos;
	}
	public void setCcMailSendRecordDtos(
			List<CcMailSendRecordDto> ccMailSendRecordDtos) {
		this.ccMailSendRecordDtos = ccMailSendRecordDtos;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
