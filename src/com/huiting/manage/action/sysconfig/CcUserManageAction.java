package com.huiting.manage.action.sysconfig;

import java.util.List;

import javax.annotation.Resource;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcDepPositionDto;
import com.huiting.manage.dto.sysconfig.CcDepartmentDto;
import com.huiting.manage.dto.sysconfig.CdCompanyDto;
import com.huiting.manage.services.sysconfig.CcUserService;
import com.huiting.manage.system.tag.Page;
import com.huiting.manage.system.util.Constants;

/**
 * 
 * @ClassName: CcUserManageAction
 * @Description: 用户管理模块
 * @author ZhangYangYang
 * @date 2013-12-22 上午10:36:06
 */
public class CcUserManageAction extends BaseAction {

	/** 用户管理Service **/
	@Resource(name = "ccUserServiceImpl")
	private CcUserService ccUserService;


	/** 部门岗位Service */
/*	@Resource(name = "depPositionManageServiceImpl")
	private DepPositionManageService depPositionManageService;*/

	private static final long serialVersionUID = 1L;
	private List<CcUserDto> ccUserDtoList;// 用户表List
	private CcUserDto ccUserDto;// 用户表实体类
	private SearchDto searchDto;// 查询条件
	private Page page;
	private CcDepartmentDto ccDepartmentDto;// 部门实体类
	private CcDepPositionDto ccDepPositionDto;// 部门岗位实体类
	private CdCompanyDto cdCompanyDto;// 机构代码表实体类

	private List<CcDepPositionDto> ccDepPositionDtoList;// 部门岗位List
	private List<CcDepartmentDto> ccDepartmentDtoList;// 部门代码List
	private List<CdCompanyDto> cdCompanyDtoList;// 机构代码表List

	private String ccDepartmentDtoJson;// 部门岗位Json对象
	private String ccDepPositionDtoJson;// 部门实体Json对象
	private String cdCompanyDtoJson;// 机构代码表Json对象

	/**
	 * 
	 * @Title: queryUserList
	 * @Description: 查询用户集合
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String queryUserList() {
		CcUserDto ccUserDto=(CcUserDto) session.get(Constants.USERLOGIN);
		if (searchDto == null) {
			searchDto = new SearchDto();
		}
		if(!ccUserDto.getComcode().equals("000000")){
			searchDto.setComCode(ccUserDto.getComcode());
		}
		if(page==null){
			page=new Page();
			page.setTotalCount(ccUserService.getUserCount(searchDto));
		}
		searchDto.setPage(page);
		ccUserDtoList = ccUserService.queryUserAllList(searchDto);
		return LIST;
	}

	/**
	 * 
	 * @Title: addUserForPage
	 * @Description: 添加用户-ajax返回的jsp页面
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String addUserForPage() {
		if (searchDto == null) {
			searchDto = new SearchDto();
		}
		return "addForPage";
	}

	/**
	 * 
	 * @Title: addUser
	 * @Description: 添加用户
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String addUser() {
		ccUserDto.setPassword("1111");//默认密码
		ccUserService.insertUser(ccUserDto);
		return SAVE;
	}

	/**
	 * 
	 * @Title: updateUserForPage
	 * @Description: 修改用户-ajax返回的jsp页面
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String updateUserForPage() {
		if (searchDto == null) {
			searchDto = new SearchDto();
			searchDto.setUserCode(ccUserDto.getUsercode());
		}
		ccUserDto = ccUserService.findUserByCode(searchDto);
	
		return "updateForPage";
	}

	/**
	 * 
	 * @Title: updateUser
	 * @Description: 修改用户
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String updateUser() {

		ccUserService.updateUser(ccUserDto);
		return EDIT;
	}
	
	/**
	 * 
	 * @Title: searchForPage
	 * @Description: 用户搜索页面
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String searchForPage(){
		
		return "searchForPage";
	}
	
	/**
	 * 
	 * @Title: deleteUser
	 * @Description: 删除用户
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String deleteUser() {
		ccUserService.deleteUser(ccUserDto);
		return DELETE;
	}
	/**
	  * @Description: 检验用户代码是否存在
	  * @param @return    
	  * @return String   
	  * @throws
	 */
	public String veriCode(){
		renderJson(ccUserService.veriCode(searchDto));
		return null;
	}


	public List<CcUserDto> getCcUserDtoList() {
		return ccUserDtoList;
	}

	public void setCcUserDtoList(List<CcUserDto> ccUserDtoList) {
		this.ccUserDtoList = ccUserDtoList;
	}

	public CcUserDto getCcUserDto() {
		return ccUserDto;
	}

	public void setCcUserDto(CcUserDto ccUserDto) {
		this.ccUserDto = ccUserDto;
	}

	public SearchDto getSearchDto() {
		return searchDto;
	}

	public void setSearchDto(SearchDto searchDto) {
		this.searchDto = searchDto;
	}

	public List<CcDepartmentDto> getCcDepartmentDtoList() {
		return ccDepartmentDtoList;
	}

	public void setCcDepartmentDtoList(List<CcDepartmentDto> ccDepartmentDtoList) {
		this.ccDepartmentDtoList = ccDepartmentDtoList;
	}

	public CcDepartmentDto getCcDepartmentDto() {
		return ccDepartmentDto;
	}

	public void setCcDepartmentDto(CcDepartmentDto ccDepartmentDto) {
		this.ccDepartmentDto = ccDepartmentDto;
	}

	public List<CcDepPositionDto> getCcDepPositionDtoList() {
		return ccDepPositionDtoList;
	}

	public void setCcDepPositionDtoList(
			List<CcDepPositionDto> ccDepPositionDtoList) {
		this.ccDepPositionDtoList = ccDepPositionDtoList;
	}

	public CcDepPositionDto getCcDepPositionDto() {
		return ccDepPositionDto;
	}

	public void setCcDepPositionDto(CcDepPositionDto ccDepPositionDto) {
		this.ccDepPositionDto = ccDepPositionDto;
	}

	public List<CdCompanyDto> getCdCompanyDtoList() {
		return cdCompanyDtoList;
	}

	public void setCdCompanyDtoList(List<CdCompanyDto> cdCompanyDtoList) {
		this.cdCompanyDtoList = cdCompanyDtoList;
	}

	public CdCompanyDto getCdCompanyDto() {
		return cdCompanyDto;
	}

	public void setCdCompanyDto(CdCompanyDto cdCompanyDto) {
		this.cdCompanyDto = cdCompanyDto;
	}

	public String getCcDepartmentDtoJson() {
		return ccDepartmentDtoJson;
	}

	public void setCcDepartmentDtoJson(String ccDepartmentDtoJson) {
		this.ccDepartmentDtoJson = ccDepartmentDtoJson;
	}

	public String getCcDepPositionDtoJson() {
		return ccDepPositionDtoJson;
	}

	public void setCcDepPositionDtoJson(String ccDepPositionDtoJson) {
		this.ccDepPositionDtoJson = ccDepPositionDtoJson;
	}

	public String getCdCompanyDtoJson() {
		return cdCompanyDtoJson;
	}

	public void setCdCompanyDtoJson(String cdCompanyDtoJson) {
		this.cdCompanyDtoJson = cdCompanyDtoJson;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
