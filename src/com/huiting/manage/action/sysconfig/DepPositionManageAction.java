package com.huiting.manage.action.sysconfig;

import java.util.List;

import javax.annotation.Resource;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcDepPositionDto;
import com.huiting.manage.dto.sysconfig.CcDepartmentDto;
import com.huiting.manage.dto.sysconfig.CcMenuDto;
import com.huiting.manage.dto.sysconfig.CcPositionMenuDto;
import com.huiting.manage.services.common.CcMenuService;
import com.huiting.manage.services.sysconfig.DepManageService;
import com.huiting.manage.services.sysconfig.DepPositionManageService;
import com.huiting.manage.system.tag.Page;

/**
  * @ClassName: DepPositionManageAction
  * @Description: TODO
  * @author: zhangyangyang
  * @date 2014-3-13 上午10:26:21
  */
public class DepPositionManageAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	/** 部门岗位Service */
	@Resource(name = "depPositionManageServiceImpl")
	private DepPositionManageService depPositionManageService;
	/** 部门Service */
	@Resource(name = "depManageServiceImpl")
	private DepManageService depManageService;
	/** 菜单表Service */
	@Resource(name = "ccMenuServiceImpl")
	private CcMenuService ccMenuService;
	/** 部门岗位列表 */
	private List<CcDepPositionDto> ccDepPositionDtoList;
	/** 部门岗位实体类 */
	private CcDepPositionDto ccDepPositionDto;
	/** 部门代码 */
	private List<CcDepartmentDto> ccDepartmentDtoList;
	/** 部门实体类 */
	private CcDepartmentDto ccDepartmentDto;
	/** 菜单表List */
	private List<CcMenuDto> ccMenuDtoList;
	/** 岗位菜单关系表List */
	private List<CcPositionMenuDto> ccPositionMenuDtoList;
	/** 岗位菜单关系表List */
	private CcPositionMenuDto ccPositionMenuDto;
	private SearchDto searchDto;
	private Page page;
	

	/**
	 * 
	 * @Title: getDepPositionList
	 * @Description: 查询部门岗位List
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String getList() {
		if (searchDto == null) {
			searchDto = new SearchDto();
		}
		
		if(page==null){
			page=new Page();
			page.setTotalCount(depPositionManageService.getDepPosiCount(searchDto));
			page.setPageSize(20);
		}
		searchDto.setPage(page);
		ccDepPositionDtoList = depPositionManageService
				.getDepPositionList(searchDto);
		return LIST;
	}

	/**
	 * 
	 * @Title: editorForPage
	 * @Description: 部门岗位 添加、修改 (页面跳转)
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String editorForPage() {
		if (searchDto == null) {
			searchDto = new SearchDto();
			searchDto.setDoing("add");
		} else {
			searchDto.setDoing("update");
			ccDepPositionDto = depPositionManageService
					.selectCcDepPos(searchDto);// 查询岗位代码对应的岗位信息
		}
		ccDepartmentDtoList = depManageService.getDepList(searchDto);
		return "editorForPage";
	}

	/**
	 * 
	 * @Title: add
	 * @Description: 添加
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String add() {
		if (searchDto == null) {
			searchDto = new SearchDto();
		}
		String maxCode = depPositionManageService.getMaxCode(searchDto);
		String newCode = depPositionManageService.newCode(maxCode);
		ccDepPositionDto.setDeppositioncode(newCode);

		depPositionManageService.insertCcDepPos(ccDepPositionDto);// 添加 部门岗位
		return SAVE;
	}

	/**
	 * 
	 * @Title: update
	 * @Description: 更新
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String update() {

		depPositionManageService.updateCcDepPos(ccDepPositionDto);// 更新 部门岗位
		return EDIT;
	}

	/**
	 * 
	 * @Title: configure
	 * @Description: 配置 -ajax页面返回
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String configureForPage() {
		ccMenuDtoList = ccMenuService.getAllMenuList(searchDto);
		return "configureForPage";
	}

	/**
	 * 
	 * @Title: checkConfigureForPage
	 * @Description: 查看 配置 -ajax页面返回
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String checkConfigureForPage() {
		searchDto.setDoing("check");
		ccMenuDtoList = ccMenuService.getAllMenuList(searchDto);
		return "configureForPage";
	}

	/**
	 * 
	 * @Title: configure
	 * @Description: 配置
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String configure() {
		ccMenuService.deleteCcPositionMenu(ccPositionMenuDto);
		ccMenuService.insertCcPositionMenuBatch(ccPositionMenuDto);
		return "configure";
	}
	
	/**
	 * 
	 * @Title: searchForPage
	 * @Description: 岗位搜索页面
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String searchForPage(){
		
		return "searchForPage";
	}
	/**
	  * @Description: 查询部门下、岗位是否存在
	  * @param @return    
	  * @return String   
	  * @throws
	 */
	public String ajaxExist(){
		int i= depPositionManageService.getDepPosiCount(searchDto);// 查询岗位代码对应的岗位信息
		renderJson(i);
		return null;
	}
	
	
	public List<CcDepPositionDto> getCcDepPositionDtoList() {
		return ccDepPositionDtoList;
	}

	public void setCcDepPositionDtoList(
			List<CcDepPositionDto> ccDepPositionDtoList) {
		this.ccDepPositionDtoList = ccDepPositionDtoList;
	}

	public SearchDto getSearchDto() {
		return searchDto;
	}

	public void setSearchDto(SearchDto searchDto) {
		this.searchDto = searchDto;
	}

	public CcDepPositionDto getCcDepPositionDto() {
		return ccDepPositionDto;
	}

	public void setCcDepPositionDto(CcDepPositionDto ccDepPositionDto) {
		this.ccDepPositionDto = ccDepPositionDto;
	}

	public CcDepartmentDto getCcDepartmentDto() {
		return ccDepartmentDto;
	}

	public void setCcDepartmentDto(CcDepartmentDto ccDepartmentDto) {
		this.ccDepartmentDto = ccDepartmentDto;
	}

	public List<CcDepartmentDto> getCcDepartmentDtoList() {
		return ccDepartmentDtoList;
	}

	public void setCcDepartmentDtoList(List<CcDepartmentDto> ccDepartmentDtoList) {
		this.ccDepartmentDtoList = ccDepartmentDtoList;
	}

	public List<CcMenuDto> getCcMenuDtoList() {
		return ccMenuDtoList;
	}

	public void setCcMenuDtoList(List<CcMenuDto> ccMenuDtoList) {
		this.ccMenuDtoList = ccMenuDtoList;
	}

	public List<CcPositionMenuDto> getCcPositionMenuDtoList() {
		return ccPositionMenuDtoList;
	}

	public void setCcPositionMenuDtoList(
			List<CcPositionMenuDto> ccPositionMenuDtoList) {
		this.ccPositionMenuDtoList = ccPositionMenuDtoList;
	}

	public CcPositionMenuDto getCcPositionMenuDto() {
		return ccPositionMenuDto;
	}

	public void setCcPositionMenuDto(CcPositionMenuDto ccPositionMenuDto) {
		this.ccPositionMenuDto = ccPositionMenuDto;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
