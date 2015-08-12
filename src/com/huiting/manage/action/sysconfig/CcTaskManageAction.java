package com.huiting.manage.action.sysconfig;

import java.util.List;

import javax.annotation.Resource;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcTaskDto;
import com.huiting.manage.services.sysconfig.CcTaskService;
import com.huiting.manage.system.tag.Page;
import com.huiting.manage.system.util.Constants;

public class CcTaskManageAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	@Resource(name = "ccTaskServiceImpl")
	private CcTaskService ccTaskService;
	
	private SearchDto searchDto;
	/** 任务表  **/
	private CcTaskDto ccTaskDto;
	/** 任务表list  **/
	private List<CcTaskDto> ccTaskDtoList;
	private Page page;
	
	/**
	  * @Description: 任务列表list
	  * @param @return    
	  * @return String   
	  * @throws
	 */
	public String list(){
		CcUserDto user = (CcUserDto) session.get(Constants.USERLOGIN);
		if(searchDto==null){
			searchDto=new SearchDto();
		}
//		searchDto.setUserCode(user.getUsercode());
		searchDto.setComCode(user.getComcode());
		searchDto.setNewDepCode(user.getNewdepcode());
		searchDto.setDepPositionCode(user.getDeppositioncode());
		if(page==null){
			page=new Page();
			page.setTotalCount(ccTaskService.getUserTaskCount(searchDto));
		}
		searchDto.setPage(page);
		ccTaskDtoList=ccTaskService.getList(searchDto);
		return "list";
	}

	public SearchDto getSearchDto() {
		return searchDto;
	}

	public void setSearchDto(SearchDto searchDto) {
		this.searchDto = searchDto;
	}

	public CcTaskDto getCcTaskDto() {
		return ccTaskDto;
	}

	public void setCcTaskDto(CcTaskDto ccTaskDto) {
		this.ccTaskDto = ccTaskDto;
	}

	public List<CcTaskDto> getCcTaskDtoList() {
		return ccTaskDtoList;
	}

	public void setCcTaskDtoList(List<CcTaskDto> ccTaskDtoList) {
		this.ccTaskDtoList = ccTaskDtoList;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
