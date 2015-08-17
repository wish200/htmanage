package com.huiting.manage.services.app.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.app.AppActivityDao;
import com.huiting.manage.dto.base.AppActivityBaseDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppActivityService;
import com.huiting.manage.system.util.NumberUtil;
import com.huiting.manage.system.util.UtilAPI;
/**
 * 
* @ClassName: AppActivityServiceImpl 
* @Description: 公告信息管理模块
* @author Niu_ChunPing
* @date 2014-2-17 下午4:12:22
 */
@Service("appActivityServiceImpl")
public class AppActivityServiceImpl implements AppActivityService {
	@Resource(name = "appActivityDaoImpl")
	private AppActivityDao appActivityDao;
	@Override
	public void add(AppActivityBaseDto appActivityBaseDto) {
		//appActivityBaseDto.setValidstatus("0");
		//appActivityBaseDto.setCreatedate(new Date());
		appActivityDao.insert(appActivityBaseDto);
	}
	@Override
	public void update(AppActivityBaseDto appActivityBaseDto) {
		appActivityDao.update(appActivityBaseDto);
	}
	@Override
	public List<AppActivityBaseDto> getActivityList(SearchDto searchDto) {
		return appActivityDao.selectList("searchDto", searchDto);
	}
	@Override
	public void delete(AppActivityBaseDto appActivityBaseDto) {
		appActivityDao.deleteById(appActivityBaseDto.getActivityid());
		
	}
	@Override
	public AppActivityBaseDto getOneActivity(SearchDto searchDto) {
		return appActivityDao.selectOne("searchDto", searchDto);
	}
	@Override
	public int getActivityCount(SearchDto searchDto) {
		Map<String, Object> condition=new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return appActivityDao.count(condition);
	}
	/**
	  * @Description: 最大公告信息代码 
	 */
	@Override
	public String getMaxActivityCode() {
		return appActivityDao.selectMaxId();
	}
	
	/**
	  * @Description: 获得新的公告信息代码 
	 */
	public String getNewActivityCode(String activityid) {
		String tempCode = "ACT000001";
		DecimalFormat df = new DecimalFormat("000000");
		if(UtilAPI.isNull(activityid)){
		}else{
			int sort = NumberUtil.createInteger(activityid.substring(3)) + 1;// 新的序列
			tempCode = "ACT"+df.format(sort);
		}
		return tempCode;
	}

}
