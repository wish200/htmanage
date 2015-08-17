package com.huiting.manage.services.sysconfig.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.sysconfig.CcDepChannelDao;
import com.huiting.manage.dao.sysconfig.CcDepartmentDao;
import com.huiting.manage.dao.sysconfig.CdChannelDao;
import com.huiting.manage.dao.sysconfig.CdClassDao;
import com.huiting.manage.dao.sysconfig.CdDepRiskDao;
import com.huiting.manage.dao.sysconfig.CdDepVir2EntDao;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcDepChannelDto;
import com.huiting.manage.dto.sysconfig.CcDepartmentDto;
import com.huiting.manage.dto.sysconfig.CdChannelDto;
import com.huiting.manage.dto.sysconfig.CdClassDto;
import com.huiting.manage.dto.sysconfig.CdDepRiskDto;
import com.huiting.manage.dto.sysconfig.CdDepVir2EntDto;
import com.huiting.manage.services.common.impl.BaseServiceImpl;
import com.huiting.manage.services.sysconfig.DepManageService;
import com.huiting.manage.system.util.NumberUtil;
import com.huiting.manage.system.util.UtilAPI;

/**
 * 
 * @ClassName: DepManageServiceImpl
 * @Description: 部门管理的实现类
 * @author Niu_ChunPing
 * @date 2013-12-22 下午1:03:44
 */
@Service("depManageServiceImpl")
public class DepManageServiceImpl extends BaseServiceImpl implements
		DepManageService {
	@Resource(name = "ccDepartmentDaoImpl")
	private CcDepartmentDao ccDepartmentDao;
	@Resource(name = "cdChannelDaoImpl")
	private CdChannelDao cdChannelDao;
	@Resource(name = "cdClassDaoImpl")
	private CdClassDao cdClassDao;
	@Resource(name = "ccDepChannelDaoImpl")
	private CcDepChannelDao ccDepChannelDao;
	@Resource(name = "cdDepVir2EntDaoImpl")
	private CdDepVir2EntDao cdDepVir2EntDao;
	// 部门险种表
	@Resource(name = "cdDepRiskDaoImpl")
	private CdDepRiskDao cdDepRiskDao;

	@Override
	public List<CcDepartmentDto> getDepList(SearchDto searchDto) {
		return ccDepartmentDao.selectList("searchDto", searchDto);
	}

	@Override
	public List<CdClassDto> getCdclass(SearchDto searchDto) {
		return cdClassDao.selectList("searchDto", searchDto);
	}

	@Override
	public SearchDto getHaveCdClassCode(SearchDto searchDto) {
		List<CdClassDto> haveCdClassCodes = getCdclass(searchDto);
		System.out.println(haveCdClassCodes.size());
		StringBuffer sb = new StringBuffer();
		if (haveCdClassCodes != null && haveCdClassCodes.size() > 0) {
			for (CdClassDto cdClassDto : haveCdClassCodes) {
				sb.append(",").append(cdClassDto.getClasscode());
			}
		}
		searchDto.setHavaClassCodes(sb.toString());
		return searchDto;
	}

	@Override
	public List<CdClassDto> getAllCdclass() {
		return cdClassDao.selectList();
	}

	@Override
	public List<CdChannelDto> getAllCdChannel() {
		return cdChannelDao.selectList();
	}

	@Override
	public SearchDto getHaveCdChannelCode(SearchDto searchDto) {
		List<CdChannelDto> haveCdChannelCodes = getCdChannel(searchDto);
		StringBuffer sb = new StringBuffer();
		if (haveCdChannelCodes != null && haveCdChannelCodes.size() > 0) {
			for (CdChannelDto cdChannelDto : haveCdChannelCodes) {
				sb.append(",").append(cdChannelDto.getChannelcode());
			}
		}
		searchDto.setHavaChannelCodes(sb.toString());
		return searchDto;
	}

	@Override
	public List<CdChannelDto> getCdChannel(SearchDto searchDto) {
		return cdChannelDao.selectList("searchDto", searchDto);
	}

	// @Override
	// public void upDepChannel(SearchDto searchDto) {
	// ccDepChannelDao.deleteById(searchDto.getNewDepCode());
	// if (searchDto.getHavaChannelCodes()!=null) {
	// String channel[]=searchDto.getHavaChannelCodes().split(",");
	// List<CcDepChannelBaseDto> ccDeChannelBaseDtos=new
	// ArrayList<CcDepChannelBaseDto>();
	// CcDepChannelBaseDto ccDeChannelBaseDto=null;
	// Date date=new Date();
	// for(int i=0;i<channel.length;i++){
	// ccDeChannelBaseDto=new CcDepChannelBaseDto();
	// ccDeChannelBaseDto.setChannelcode(channel[i]);
	// ccDeChannelBaseDto.setDepartment(searchDto.getNewDepCode());
	// ccDeChannelBaseDto.setCreatetime(date);
	// ccDeChannelBaseDto.setCreateusercode(searchDto.getUserCode());
	// ccDeChannelBaseDtos.add(ccDeChannelBaseDto);
	// }
	// ccDepChannelDao.insertList(ccDeChannelBaseDtos);
	// }
	// }

	@Override
	public SearchDto getHaveDepCode(SearchDto searchDto) {
		List<CcDepartmentDto> haveCcDepartments = getHaveDep(searchDto);
		StringBuffer sb = new StringBuffer();
		if (haveCcDepartments != null && haveCcDepartments.size() > 0) {
			for (CcDepartmentDto ccDepartmentDto : haveCcDepartments) {
				sb.append(",").append(ccDepartmentDto.getNewdepcode());
			}
		}
		searchDto.setHaveDepCodes(sb.toString());
		return searchDto;
	}

	public List<CcDepartmentDto> getHaveDep(SearchDto searchDto) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return ccDepartmentDao.selectList("getHaveDep", condition);
	}

	/**
	 * 更新虚拟部门代码 先删除虚拟实体部门管理表中的代码
	 */
	// @Override
	// public void upDataVirtual(SearchDto searchDto) {
	// cdDepVir2EntDao.deleteById(searchDto.getNewDepCode());
	// //对渠道表进行删除更新
	// ccDepChannelDao.deleteById(searchDto.getNewDepCode());
	// if(searchDto.getHaveDepCodes()!=null){
	// List<String> depCodes=new ArrayList<String>();//放入包含的部门实体部门代码
	// String haveDepCodes[]=searchDto.getHaveDepCodes().split(",");
	// List<CdDepVir2EntBaseDto> cdDepVir2EntBaseDtos=new
	// ArrayList<CdDepVir2EntBaseDto>();
	// CdDepVir2EntBaseDto cdDepVir2EntBaseDto=null;
	// for(int i=0;i<haveDepCodes.length;i++){
	// cdDepVir2EntBaseDto=new CdDepVir2EntBaseDto();
	// cdDepVir2EntBaseDto.setVirtualdepartment(searchDto.getNewDepCode());
	// cdDepVir2EntBaseDto.setEntitydepartment(haveDepCodes[i]);
	// cdDepVir2EntBaseDtos.add(cdDepVir2EntBaseDto);
	// depCodes.add(haveDepCodes[i]);
	// }
	// cdDepVir2EntDao.insertList(cdDepVir2EntBaseDtos);
	// SearchDto searchDto2 =new SearchDto();
	// searchDto2.setDempList(depCodes);
	// List<CdChannelDto> cdChannelDtos=cdChannelDao.selectList("searchDto",
	// searchDto2);
	// if(cdChannelDtos!=null){
	// List<CcDepChannelBaseDto> ccDeChannelBaseDtos=new
	// ArrayList<CcDepChannelBaseDto>();
	// CcDepChannelBaseDto ccDeChannelBaseDto=null;
	// Date date=new Date();
	// for(int i=0;i<cdChannelDtos.size();i++){
	// ccDeChannelBaseDto=new CcDepChannelBaseDto();
	// ccDeChannelBaseDto.setDepartment(searchDto.getNewDepCode());
	// ccDeChannelBaseDto.setChannelcode(cdChannelDtos.get(i).getChannelcode());
	// ccDeChannelBaseDto.setCreateusercode(searchDto.getUserCode());
	// ccDeChannelBaseDto.setCreatetime(date);
	// ccDeChannelBaseDtos.add(ccDeChannelBaseDto);
	// }
	// ccDepChannelDao.insertList(ccDeChannelBaseDtos);
	// }
	// }
	// }
	/**
	 * 
	 * @Title: insertDep 新增 部门信息
	 * @Description: 
	 * @param @param ccDepartmentDto
	 * @return void
	 * @throws
	 */
	@Override
	public void insertDep(CcDepartmentDto ccDepartmentDto) {
		ccDepartmentDao.insert(ccDepartmentDto);
	}

	/**
	 * 查询 部门信息
	 */
	@Override
	public CcDepartmentDto selectDep(SearchDto searchDto) {
		return ccDepartmentDao.selectOne("searchDto", searchDto);
	}

	/**
	 * 修改 部门信息
	 */
	@Override
	public void updateDep(CcDepartmentDto ccDepartmentDto) {
		ccDepartmentDao.update(ccDepartmentDto);
	}

	/**
	 * 插入 部门险种表
	 */
	@Override
	public void insertCcdepRiskBatch(CdDepRiskDto cdDepRiskDto,CcUserDto ccUserDto) {
		String classCode[] = cdDepRiskDto.getClasscode().split(",");
		List<CdDepRiskDto> cdDepRiskDtoList = new ArrayList<CdDepRiskDto>();
		CdDepRiskDto c = null;
		Date d=new Date(); 
		for (String s : classCode) {
			c = new CdDepRiskDto();
			c.setClasscode(s);
			c.setCreatetime(d);
			c.setValidstate("1");
			c.setCreateusercode(ccUserDto.getUsercode());
			c.setDepartment(cdDepRiskDto.getDepartment());
			cdDepRiskDtoList.add(c);
		}
		cdDepRiskDao.insertList(cdDepRiskDtoList);
	}

	/**
	 * 查看已经配置的险种
	 */
	@Override
	public List<CdDepRiskDto> getCcdepRiskList(SearchDto searchDto) {

		return cdDepRiskDao.selectList("searchDto", searchDto);
	}

	/**
	 * 获取险种List（包含勾选）
	 */
	@Override
	public List<CdClassDto> getCdClassDtoChecked(SearchDto searchDto) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return cdClassDao.selectList("selectListChecked", condition);
	}

	/**
	 * 获取渠道List（包含勾选）
	 */
	@Override
	public List<CdChannelDto> getCdCannelDtoChecked(SearchDto searchDto) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return cdChannelDao.selectList("selectListChecked", condition);
	}

	/**
	 * 删除险种
	 */
	@Override
	public void deleteCcdepRisk(CdDepRiskDto cdDepRiskDto) {
		cdDepRiskDao.deleteById(cdDepRiskDto.getDepartment());
	}

	/**
	 * 删除渠道
	 */
	@Override
	public void deleteCcdepChannle(CcDepChannelDto ccDepChannelDto) {
		ccDepChannelDao.deleteById(ccDepChannelDto.getDepartment());
	}

	/**
	 * 插入 部门渠道表
	 */
	@Override
	public void insertCcdepChannleBatch(CcDepChannelDto ccDepChannelDto) {
		String classCode[] = ccDepChannelDto.getChannelcode().split(",");
		List<CcDepChannelDto> ccDepChannelDtoList = new ArrayList<CcDepChannelDto>();
		CcDepChannelDto c = null;
		for (String s : classCode) {
			c = new CcDepChannelDto();
			c.setChannelcode(s);
			c.setDepartment(ccDepChannelDto.getDepartment());
			ccDepChannelDtoList.add(c);
		}
		ccDepChannelDao.insertList(ccDepChannelDtoList);

	}

	/**
	 * 删除虚拟部门
	 */
	@Override
	public void deleteCdDepVir2Ent(CdDepVir2EntDto cdDepVir2EntDto) {
		cdDepVir2EntDao.deleteById(cdDepVir2EntDto.getVirtualdepartment());
	}

	/**
	 * 插入虚拟部门
	 */
	@Override
	public void insertCdDepVir2EntBatch(CdDepVir2EntDto cdDepVir2EntDto) {
		String classCode[] = cdDepVir2EntDto.getEntitydepartment().split(",");
		List<CdDepVir2EntDto> cdDepVir2EntDtoList = new ArrayList<CdDepVir2EntDto>();
		CdDepVir2EntDto c = null;
		for (String s : classCode) {
			c = new CdDepVir2EntDto();
			c.setVirtualdepartment(cdDepVir2EntDto.getVirtualdepartment());
			c.setEntitydepartment(s);
			cdDepVir2EntDtoList.add(c);
		}
		cdDepVir2EntDao.insertList(cdDepVir2EntDtoList);
	}

	/**
	 * 获取部门List（包含勾选）
	 */
	@Override
	public List<CcDepartmentDto> getCdDepVir2EntDtoChecked(SearchDto searchDto) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return ccDepartmentDao.selectList("selectListChecked", condition);
	}

	 
	@Override
	public String getMaxCode(SearchDto searchDto) {
		return ccDepartmentDao.getMaxCode(searchDto);
	}

	@Override
	public String newCode(String oldCode) {
		String tempCode = "D0000001";
		DecimalFormat df = new DecimalFormat("0000000");
		if(UtilAPI.isNull(oldCode)){
		}else{
			int sort = NumberUtil.createInteger(oldCode.substring(1,8)) + 1;// 新的序列
			tempCode = "D"+df.format(sort)+"Y";
		}
		return tempCode;
	}

	/**
	 * 虚拟部门配置，向部门险种添加数据
	 */
	public void insertVirCcDepRisk(CdDepVir2EntDto cdDepVir2EntDto,CcUserDto ccUserDto ) {
		String[] depcode=cdDepVir2EntDto.getEntitydepartment().split(",");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("depcode", depcode);
		List<CdDepRiskDto> cdDepRiskDtoList=cdDepRiskDao.selectList("getDepRiskList", map);
		Date date=new Date();
		for (CdDepRiskDto cdDepRiskDto : cdDepRiskDtoList) {
			cdDepRiskDto.setDepartment(cdDepVir2EntDto.getVirtualdepartment());
			cdDepRiskDto.setCreatetime(date);
			cdDepRiskDto.setCreateusercode(ccUserDto.getUsercode());
		}
		cdDepRiskDao.insertList(cdDepRiskDtoList);
		
	}

	/**
	 * 虚拟部门配置，向部门渠道添加数据
	 */
	public void insertVirCcdepChannle(CdDepVir2EntDto cdDepVir2EntDto,CcUserDto ccUserDto ) {
		String[] depcode=cdDepVir2EntDto.getEntitydepartment().split(",");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("depcode", depcode);
		Date date=new Date();
		List<CcDepChannelDto> ccDepChannelDtoList=ccDepChannelDao.selectList("getDepChannelList",map);
		for (CcDepChannelDto ccDepChannelDto : ccDepChannelDtoList) {
			ccDepChannelDto.setDepartment(cdDepVir2EntDto.getVirtualdepartment());
			ccDepChannelDto.setCreatetime(date);
			ccDepChannelDto.setCreateusercode(ccUserDto.getUsercode());
		}
		ccDepChannelDao.insertList(ccDepChannelDtoList);
	}

	@Override
	public int getDepCount(SearchDto searchDto) {
		Map<String,Object> condition=new HashMap<String,Object>();
		condition.put("searchDto", searchDto);
		return ccDepartmentDao.count(condition);
	}

	/**
	  * @Description: 删除虚拟部门 
	 */
	@Override
	public void deleteDep(CcDepartmentDto ccDepartmentDto) {
		ccDepartmentDao.deleteById(ccDepartmentDto.getNewdepcode());
	}

	/**
	  * @Description: 查看指标对应的主责部门 
	 */
	@Override
	public List<CcDepartmentDto> selectIndexDep(SearchDto searchDto) {
		Map<String,Object> condition=new HashMap<String,Object>();
		condition.put("searchDto", searchDto);
		return ccDepartmentDao.selectList("selectIndexDep",condition);
	}

}
