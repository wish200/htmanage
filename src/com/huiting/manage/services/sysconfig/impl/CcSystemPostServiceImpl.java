package com.huiting.manage.services.sysconfig.impl;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.sysconfig.CcSystemPostDao;
import com.huiting.manage.dto.base.CcSystemPostBaseDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.sysconfig.CcSystemPostService;
import com.huiting.manage.system.util.NumberUtil;
import com.huiting.manage.system.util.UtilAPI;
/**
 * 
* @ClassName: CcSystemPostServiceImpl 
* @Description: 公告信息管理模块
* @author Niu_ChunPing
* @date 2014-2-17 下午4:12:22
 */
@Service("ccSystemPostServiceImpl")
public class CcSystemPostServiceImpl implements CcSystemPostService {
	@Resource(name = "ccSystemPostDaoImpl")
	private CcSystemPostDao ccSystemPostDao;
	@Override
	public void add(CcSystemPostBaseDto ccSystemPostBaseDto) {
		ccSystemPostBaseDto.setValidstatus("0");
		ccSystemPostBaseDto.setCreatedate(new Date());
		ccSystemPostDao.insert(ccSystemPostBaseDto);
	}
	@Override
	public void update(CcSystemPostBaseDto ccSystemPostBaseDto) {
		ccSystemPostDao.update(ccSystemPostBaseDto);
	}
	@Override
	public List<CcSystemPostBaseDto> getSystrmPoseList(SearchDto searchDto) {
		return ccSystemPostDao.selectList("searchDto", searchDto);
	}
	@Override
	public void delete(CcSystemPostBaseDto ccSystemPostBaseDto) {
		ccSystemPostDao.deleteById(ccSystemPostBaseDto);
		
	}
	@Override
	public CcSystemPostBaseDto getOneSysPost(SearchDto searchDto) {
		return ccSystemPostDao.selectOne("searchDto", searchDto);
	}
	@Override
	public int getSystrmPoseCount(SearchDto searchDto) {
		Map<String, Object> condition=new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return ccSystemPostDao.count(condition);
	}
	/**
	  * @Description: 最大公告信息代码 
	 */
	@Override
	public String getMaxSystemCode() {
		return ccSystemPostDao.selectMaxId();
	}
	
	/**
	  * @Description: 获得新的公告信息代码 
	 */
	public String getNewSystemCode(String systemCode) {
		String tempCode = "NE000001";
		DecimalFormat df = new DecimalFormat("000000");
		if(UtilAPI.isNull(systemCode)){
		}else{
			int sort = NumberUtil.createInteger(systemCode.substring(2)) + 1;// 新的序列
			tempCode = "NE"+df.format(sort);
		}
		return tempCode;
	}

}
