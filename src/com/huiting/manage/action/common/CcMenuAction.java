package com.huiting.manage.action.common;

import java.util.List;

import javax.annotation.Resource;

import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcMenuDto;
import com.huiting.manage.services.common.CcMenuService;
import com.huiting.manage.system.util.Constants;
import java.util.Map;

public class CcMenuAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private Map<Integer, List<CcMenuDto>> menuMap;
	@Resource(name = "ccMenuServiceImpl")
	private CcMenuService ccMenuService;
	private SearchDto searchDto;

	private String oneMenu;//地址名称
	private String oneUrl;
	private String twoMenu;
	private String twoMenuUrl;
	private String threeMenu;
	private String threeMennUrl;
	private String titleName;//标题名称
	
	/**
	 * @Description: 获取菜单
	 */
	public String getMenus() {
		CcUserDto ccUserDto = (CcUserDto) session.get(Constants.USERLOGIN);
		if (searchDto == null) {
			searchDto = new SearchDto();
		}
		searchDto.setDepPositionCode(ccUserDto.getDeppositioncode());
		List<CcMenuDto> ccMenuDtos = ccMenuService.findListMenu(searchDto);
		menuMap = this.ccMenuService.getLevelMap(ccMenuDtos);
		return SUCCESS;
	}

	/**
	  * @Description: 地址
	 */
	public String pathTitle(){
		return "pathTitle";
	}
	
	
	
	public SearchDto getSearchDto() {
		return searchDto;
	}

	public void setSearchDto(SearchDto searchDto) {
		this.searchDto = searchDto;
	}

	public Map<Integer, List<CcMenuDto>> getMenuMap() {
		return menuMap;
	}

	public void setMenuMap(Map<Integer, List<CcMenuDto>> menuMap) {
		this.menuMap = menuMap;
	}

	public String getOneMenu() {
		return oneMenu;
	}

	public void setOneMenu(String oneMenu) {
		this.oneMenu = oneMenu;
	}

	public String getOneUrl() {
		return oneUrl;
	}

	public void setOneUrl(String oneUrl) {
		this.oneUrl = oneUrl;
	}

	public String getTwoMenu() {
		return twoMenu;
	}

	public void setTwoMenu(String twoMenu) {
		this.twoMenu = twoMenu;
	}

	public String getTwoMenuUrl() {
		return twoMenuUrl;
	}

	public void setTwoMenuUrl(String twoMenuUrl) {
		this.twoMenuUrl = twoMenuUrl;
	}

	public String getThreeMenu() {
		
		return threeMenu;
	}

	public void setThreeMenu(String threeMenu) {
		this.threeMenu = threeMenu;
	}

	public String getThreeMennUrl() {
		return threeMennUrl;
	}

	public void setThreeMennUrl(String threeMennUrl) {
		this.threeMennUrl = threeMennUrl;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

}
