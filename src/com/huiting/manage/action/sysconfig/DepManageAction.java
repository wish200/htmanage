package com.huiting.manage.action.sysconfig;

import java.util.List;

import javax.annotation.Resource;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcDepChannelDto;
import com.huiting.manage.dto.sysconfig.CcDepartmentDto;
import com.huiting.manage.dto.sysconfig.CdChannelDto;
import com.huiting.manage.dto.sysconfig.CdClassDto;
import com.huiting.manage.dto.sysconfig.CdDepRiskDto;
import com.huiting.manage.dto.sysconfig.CdDepVir2EntDto;
import com.huiting.manage.services.sysconfig.DepManageService;
import com.huiting.manage.system.tag.Page;
import com.huiting.manage.system.util.Constants;

/**
 * @ClassName: DepManageAction
 * @Description: 部门管理的action访问
 * @author Niu_ChunPing
 * @date 2013-12-22 上午10:57:31
 */
public class DepManageAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@Resource(name = "depManageServiceImpl")
	private DepManageService depManageService;
	/** 部门代码 */
	private List<CcDepartmentDto> ccDepartmentDtos;
	/** 部门实体类 */
	private CcDepartmentDto ccDepartmentDto;
	/** 险种代码 */
	private List<CdClassDto> cdClassDtos;
	/** 渠道代码 */
	private List<CdChannelDto> cdChannelDtos;
	/** 部门险种表 List */
	private List<CdDepRiskDto> cdDepRiskDtoList;
	/** 部门险种表实体类 */
	private CdDepRiskDto cdDepRiskDto;
	/** 部门渠道表实体类 */
	private CcDepChannelDto ccDepChannelDto;
	/** 虚拟部门实体类 */
	private CdDepVir2EntDto cdDepVir2EntDto;

	private SearchDto searchDto;
	private Page page;

	/**
	 * @Description: 实体部门集合
	 */
	public String depList() {
		CcUserDto ccUserDto = (CcUserDto) session.get(Constants.USERLOGIN);
		if (searchDto == null) {
			searchDto = new SearchDto();
		}
		if(searchDto.getComCode()==null&&!ccUserDto.getComcode().equals("000000")){
			searchDto.setComCode(ccUserDto.getComcode());
		}
		searchDto.setDepCatg("1");
		if(page==null){
			page=new Page();
			page.setTotalCount(depManageService.getDepCount(searchDto));
		}
		searchDto.setPage(page);
		ccDepartmentDtos = depManageService.getDepList(searchDto);
		return "depList";
	}

	/**
	 * @Description: 虚拟部门集合
	 */
	public String depVirList() {
		CcUserDto ccUserDto = (CcUserDto) session.get(Constants.USERLOGIN);
		if (searchDto == null) {
			searchDto = new SearchDto();
		}
		if(searchDto.getComCode()==null){
			searchDto.setComCode(ccUserDto.getComcode());
		}
		searchDto.setDepCatg("0");
		if(page==null){
			page=new Page();
			page.setTotalCount(depManageService.getDepCount(searchDto));
		}
		searchDto.setPage(page);
		ccDepartmentDtos = depManageService.getDepList(searchDto);
		return "depVirList";
	}

	/**
	 * @Description: 实体部门-ajax页面返回
	 */
	public String editForPage() {
		if (searchDto == null) {
			searchDto = new SearchDto();
			searchDto.setDoing("add");
		} else {
			searchDto.setDoing("update");
			ccDepartmentDto = depManageService.selectDep(searchDto);
		}

		return "editForPage";
	}

	/**
	 * @Description: 虚拟部门-ajax页面返回
	 */
	public String editForPageVir() {
		if (searchDto == null) {
			searchDto = new SearchDto();
			searchDto.setDoing("add");
		} else {
			searchDto.setDoing("update");
			ccDepartmentDto = depManageService.selectDep(searchDto);
		}
		return "editForPageVir";
	}

	/**
	 * @Description: 新增 部门 信息
	 */
	public String add() {
		if (searchDto == null) {
			searchDto = new SearchDto();
		}
		String maxCode = depManageService.getMaxCode(searchDto);
		String newCode = depManageService.newCode(maxCode);

		ccDepartmentDto.setNewdepcode(newCode);
		depManageService.insertDep(ccDepartmentDto);
		return SAVE;
	}
    /**
      * @Description: 增加虚拟部门
      * @param     
      * @return String   
      * @throws
     */
	public String addVir() {
		if (searchDto == null) {
			searchDto = new SearchDto();
		}
		String maxCode = depManageService.getMaxCode(searchDto);
		String newCode = depManageService.newCode(maxCode);
		ccDepartmentDto.setNewdepcode(newCode);
		depManageService.insertDep(ccDepartmentDto);
		return "saveVir";
	}

	/**
	  * @Description: 删除虚拟部门
	  * @param @return    
	  * @return String   
	  * @throws
	 */
	public String delVir(){
		cdDepVir2EntDto=new CdDepVir2EntDto();
		ccDepartmentDto=new CcDepartmentDto();
		cdDepVir2EntDto.setVirtualdepartment(searchDto.getNewDepCode());
		ccDepartmentDto.setNewdepcode(searchDto.getNewDepCode());
		depManageService.deleteCdDepVir2Ent(cdDepVir2EntDto);//删除虚拟实体关系表
		depManageService.deleteDep(ccDepartmentDto);//删除虚拟部门表
		return "delVir";
	}
	/**
	  * @Description: 虚拟部门名称是否存在
	  * @param @return    
	  * @return String   
	  * @throws
	 */
	public String exitsDep(){
		if(!"".equals(searchDto.getDepartMentName())){
			searchDto.setDepCatg("0");
			int i=depManageService.getDepCount(searchDto);
			renderJson(i);
		}
		return null;
	}
	/**
	 * @Description: 修改 部门 信息
	 */
	public String update() {
		depManageService.updateDep(ccDepartmentDto);
		return EDIT;
	}

	public String updateVir() {
		depManageService.updateDep(ccDepartmentDto);
		return "editVir";
	}

	/**
	 * @Description: 配置险种-ajax页面返回
	 */
	public String configureClassForPage() {
		cdClassDtos = depManageService.getCdClassDtoChecked(searchDto);// 获取险种List(包含勾选)
		return "configureClassForPage";
	}
	/**
	 * @Description: 查看险种-ajax页面返回
	 */
	public String checkClassForPage() {
		cdClassDtos = depManageService.getCdClassDtoChecked(searchDto);// 获取险种List(包含勾选)
		searchDto.setDoing("check");
		return "configureClassForPage";
	}

	/**
	 * @Description: 配置险种
	 */
	public String configureClass() {
		CcUserDto ccUserDto = (CcUserDto) session.get(Constants.USERLOGIN);
		depManageService.deleteCcdepRisk(cdDepRiskDto);// 删除 部门险种表
		depManageService.insertCcdepRiskBatch(cdDepRiskDto,ccUserDto);// 插入 部门险种表
		return null;
	}

	/**
	 * @Description: 配置渠道-ajax页面返回
	 */
	public String configureChannelForPage() {
		cdChannelDtos = depManageService.getCdCannelDtoChecked(searchDto);// 获取渠道List(包含勾选)
		return "configureChannelForPage";
	}
	/**
	 * @Description: 查看渠道-ajax页面返回
	 */
	public String checkChannelForPage() {
		cdChannelDtos = depManageService.getCdCannelDtoChecked(searchDto);// 获取渠道List(包含勾选)
		searchDto.setDoing("check");
		return "configureChannelForPage";
	}

	/**
	 * @Description: 配置渠道
	 */
	public String configureChannel() {
		depManageService.deleteCcdepChannle(ccDepChannelDto);// 删除 部门渠道表
		depManageService.insertCcdepChannleBatch(ccDepChannelDto);// 插入 部门渠道表
		return null;
	}

	/**
	 * @Description: 查看虚拟部门-ajax页面返回
	 */
	public String checkFictiDepForPage() {
		CcUserDto ccUserDto = (CcUserDto) session.get(Constants.USERLOGIN);
		// 所有的实体部门
		searchDto.setDoing("check");
		searchDto.setDepCatg("1");
		searchDto.setComCode(ccUserDto.getComcode());
		ccDepartmentDtos = depManageService
				.getCdDepVir2EntDtoChecked(searchDto);// 获取部门List(包含勾选)
		return "configureFictiDepForPage";
	}

	/**
	 * @Description: 配置虚拟部门-ajax页面返回
	 */
	public String configureFictiDepForPage() {
		CcUserDto ccUserDto = (CcUserDto) session.get(Constants.USERLOGIN);
		if(searchDto.getComCode()==null){
			searchDto.setComCode(ccUserDto.getComcode());
		}
		// 所有的实体部门
		searchDto.setDepCatg("1");
		ccDepartmentDtos = depManageService
				.getCdDepVir2EntDtoChecked(searchDto);// 获取部门List(包含勾选)
		return "configureFictiDepForPage";
	}

	/**
	 * @Description: 配置虚拟部门
	 */
	public String configureFictiDep() {
		CcUserDto ccUserDto = (CcUserDto) session.get(Constants.USERLOGIN);
		depManageService.deleteCdDepVir2Ent(cdDepVir2EntDto);
		if(!"".equals(cdDepVir2EntDto.getEntitydepartment())){
		depManageService.insertCdDepVir2EntBatch(cdDepVir2EntDto);
		}
		cdDepRiskDto=new CdDepRiskDto();
		ccDepChannelDto=new CcDepChannelDto();
		cdDepRiskDto.setDepartment(cdDepVir2EntDto.getVirtualdepartment());
		ccDepChannelDto.setDepartment(cdDepVir2EntDto.getVirtualdepartment());
		
		depManageService.deleteCcdepRisk(cdDepRiskDto);
		depManageService.deleteCcdepChannle(ccDepChannelDto);
		
		depManageService.insertVirCcDepRisk(cdDepVir2EntDto,ccUserDto);//向部门险种插入数据
		depManageService.insertVirCcdepChannle(cdDepVir2EntDto,ccUserDto);//向部门险种插入数据
		
		
		return null;
	}

	public List<CdClassDto> getCdClassDtos() {
		return cdClassDtos;
	}

	public void setCdClassDtos(List<CdClassDto> cdClassDtos) {
		this.cdClassDtos = cdClassDtos;
	}

	public List<CdChannelDto> getCdChannelDtos() {
		return cdChannelDtos;
	}

	public void setCdChannelDtos(List<CdChannelDto> cdChannelDtos) {
		this.cdChannelDtos = cdChannelDtos;
	}

	public List<CcDepartmentDto> getCcDepartmentDtos() {
		return ccDepartmentDtos;
	}

	public void setCcDepartmentDtos(List<CcDepartmentDto> ccDepartmentDtos) {
		this.ccDepartmentDtos = ccDepartmentDtos;
	}

	public SearchDto getSearchDto() {
		return searchDto;
	}

	public void setSearchDto(SearchDto searchDto) {
		this.searchDto = searchDto;
	}

	public CcDepartmentDto getCcDepartmentDto() {
		return ccDepartmentDto;
	}

	public void setCcDepartmentDto(CcDepartmentDto ccDepartmentDto) {
		this.ccDepartmentDto = ccDepartmentDto;
	}

	public List<CdDepRiskDto> getCdDepRiskDtoList() {
		return cdDepRiskDtoList;
	}

	public void setCdDepRiskDtoList(List<CdDepRiskDto> cdDepRiskDtoList) {
		this.cdDepRiskDtoList = cdDepRiskDtoList;
	}

	public CdDepRiskDto getCdDepRiskDto() {
		return cdDepRiskDto;
	}

	public void setCdDepRiskDto(CdDepRiskDto cdDepRiskDto) {
		this.cdDepRiskDto = cdDepRiskDto;
	}

	public CcDepChannelDto getCcDepChannelDto() {
		return ccDepChannelDto;
	}

	public void setCcDepChannelDto(CcDepChannelDto ccDepChannelDto) {
		this.ccDepChannelDto = ccDepChannelDto;
	}

	public CdDepVir2EntDto getCdDepVir2EntDto() {
		return cdDepVir2EntDto;
	}

	public void setCdDepVir2EntDto(CdDepVir2EntDto cdDepVir2EntDto) {
		this.cdDepVir2EntDto = cdDepVir2EntDto;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
