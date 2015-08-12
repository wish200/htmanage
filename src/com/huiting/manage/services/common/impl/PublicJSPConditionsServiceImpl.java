package com.huiting.manage.services.common.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.common.CdRiskKindDao;
import com.huiting.manage.dao.common.PublicSQLDao;
import com.huiting.manage.dao.sysconfig.CcDepPositionDao;
import com.huiting.manage.dao.sysconfig.CcDepartmentDao;
import com.huiting.manage.dao.sysconfig.CdCompanyDao;
import com.huiting.manage.dto.base.CdDataSourceBaseDto;
import com.huiting.manage.dto.base.CdIdxCatgoryBaseDto;
import com.huiting.manage.dto.common.CdRiskKindDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcDepPositionDto;
import com.huiting.manage.dto.sysconfig.CcDepartmentDto;
import com.huiting.manage.dto.sysconfig.CdCompanyDto;
import com.huiting.manage.services.common.PublicJSPConditionsService;
import com.huiting.manage.system.util.DateUtil;

/**
 * @ClassName: PublicJSPConditionsServiceImpl
 * @Description: 页面公共查询条件service接口
 * @author Zou_ZhuoQi
 * @date 2013-12-6 上午10:05:02
 */
@Service("publicJSPConditionsServiceImpl")
public class PublicJSPConditionsServiceImpl extends BaseServiceImpl implements
		PublicJSPConditionsService {
	@Resource(name = "publicSQLDaoImpl")
	private PublicSQLDao publicSQLDao;
	@Resource(name = "cdCompanyDaoImpl")
	CdCompanyDao cdCompanyDao;
	@Resource(name = "ccDepartmentDaoImpl")
	private CcDepartmentDao ccDepartmentDao;
	@Resource(name = "ccDepPositionDaoImpl")
	private CcDepPositionDao ccDepPositionDao;
	@Resource(name="cdRiskKindDaoImpl")
	private CdRiskKindDao cdRiskKindDao;
	

	@Override
	public List<CdRiskKindDto> getCdRiskKindList(SearchDto searchDto) {
		return cdRiskKindDao.selectList("searchDto",searchDto);
	}

	@Override
	public List<Object> getCdTemplateCatnoList(SearchDto searchDto) {
		return publicSQLDao.getCdTemplateCatnoList(searchDto);
	}

	@Override
	public List<CdCompanyDto> getCompany(SearchDto searchDto) {
		return cdCompanyDao.selectList("searchDto",searchDto);
	}

	@Override
	public List<CcDepartmentDto> getDepList(SearchDto searchDto) {
		return ccDepartmentDao.selectList("searchDto",searchDto);
	}

 
	@Override
	public List<CcDepPositionDto> getDepPositionList(SearchDto searchDto) {
		return ccDepPositionDao.selectList("searchDto", searchDto);
	}

	@Override
	public List<CdDataSourceBaseDto> getDataSoureList(SearchDto searchDto) {
		return publicSQLDao.getDataSoureList(searchDto);
	}

	/**
	  * @Description: 因子大类名称 
	  * @param @param searchDto
	 */
	@Override
	public List<CdIdxCatgoryBaseDto> getIdxCatgoryList(SearchDto searchDto) {
		return publicSQLDao.getIdxCatgoryList(searchDto);
	}


	@Override
	public List<CcDepartmentDto> getInputDepList(SearchDto searchDto) {
		Map<String,Object> condition=new HashMap<String,Object>();
		condition.put("searchDto",searchDto);
		 List<CcDepartmentDto> ccDepartmentDtos=ccDepartmentDao.selectList("getDataInputList", condition);//先获得需要发送的部门---月初时候的邮件
		return ccDepartmentDtos;
	}

}
