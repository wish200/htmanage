package com.huiting.manage.services.app.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.app.AppProgramDao;
import com.huiting.manage.dto.base.AppProgramBaseDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppProgramService;
import com.huiting.manage.system.util.NumberUtil;
import com.huiting.manage.system.util.UtilAPI;
/**
 * 
* @ClassName: AppProgramServiceImpl 
* @Description: 公告信息管理模块
* @author Niu_ChunPing
* @date 2014-2-17 下午4:12:22
 */
@Service("appProgramServiceImpl")
public class AppProgramServiceImpl implements AppProgramService {
	@Resource(name = "appProgramDaoImpl")
	private AppProgramDao appProgramDao;
	@Override
	public void add(AppProgramBaseDto appProgramBaseDto) {
		//appProgramBaseDto.setValidstatus("0");
		//appProgramBaseDto.setCreatedate(new Date());
		appProgramDao.insert(appProgramBaseDto);
	}
	@Override
	public void update(AppProgramBaseDto appProgramBaseDto) {
		appProgramDao.update(appProgramBaseDto);
	}
	@Override
	public List<AppProgramBaseDto> getProgramList(SearchDto searchDto) {
		return appProgramDao.selectList("searchDto", searchDto);
	}
	@Override
	public void delete(AppProgramBaseDto appProgramBaseDto) {
		appProgramDao.deleteById(appProgramBaseDto.getProgramid());
		
	}
	@Override
	public AppProgramBaseDto getOneProgram(SearchDto searchDto) {
		return appProgramDao.selectOne("searchDto", searchDto);
	}
	@Override
	public int getProgramCount(SearchDto searchDto) {
		Map<String, Object> condition=new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return appProgramDao.count(condition);
	}
	/**
	  * @Description: 最大公告信息代码 
	 */
	@Override
	public String getMaxProgramCode() {
		return appProgramDao.selectMaxId();
	}
	
	/**
	  * @Description: 获得新的公告信息代码 
	 */
	public String getNewProgramCode(String systemCode) {
		String tempCode = "P000001";
		DecimalFormat df = new DecimalFormat("000000");
		if(UtilAPI.isNull(systemCode)){
		}else{
			int sort = NumberUtil.createInteger(systemCode.substring(1)) + 1;// 新的序列
			tempCode = "P"+df.format(sort);
		}
		return tempCode;
	}

}
