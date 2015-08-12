package com.huiting.manage.services.app.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.app.AppChannelDao;
import com.huiting.manage.dto.base.AppChannelBaseDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppChannelService;
import com.huiting.manage.system.util.NumberUtil;
import com.huiting.manage.system.util.UtilAPI;
/**
 * 
* @ClassName: AppChannelServiceImpl 
* @Description: 公告信息管理模块
* @author Niu_ChunPing
* @date 2014-2-17 下午4:12:22
 */
@Service("appChannelServiceImpl")
public class AppChannelServiceImpl implements AppChannelService {
	@Resource(name = "appChannelDaoImpl")
	private AppChannelDao appChannelDao;
	@Override
	public void add(AppChannelBaseDto appChannelBaseDto) {
		//appChannelBaseDto.setValidstatus("0");
		//appChannelBaseDto.setCreatedate(new Date());
		appChannelDao.insert(appChannelBaseDto);
	}
	@Override
	public void update(AppChannelBaseDto appChannelBaseDto) {
		appChannelDao.update(appChannelBaseDto);
	}
	@Override
	public List<AppChannelBaseDto> getChannelList(SearchDto searchDto) {
		return appChannelDao.selectList("searchDto", searchDto);
	}
	@Override
	public void delete(AppChannelBaseDto appChannelBaseDto) {
		appChannelDao.deleteById(appChannelBaseDto.getChannelid());
		
	}
	@Override
	public AppChannelBaseDto getOneChannel(SearchDto searchDto) {
		return appChannelDao.selectOne("searchDto", searchDto);
	}
	@Override
	public int getChannelCount(SearchDto searchDto) {
		Map<String, Object> condition=new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return appChannelDao.count(condition);
	}
	/**
	  * @Description: 最大公告信息代码 
	 */
	@Override
	public String getMaxChannelCode() {
		return appChannelDao.selectMaxId();
	}
	
	/**
	  * @Description: 获得新的公告信息代码 
	 */
	public String getNewChannelCode(String systemCode) {
		String tempCode = "CH000001";
		DecimalFormat df = new DecimalFormat("000000");
		if(UtilAPI.isNull(systemCode)){
		}else{
			int sort = NumberUtil.createInteger(systemCode.substring(2)) + 1;// 新的序列
			tempCode = "CH"+df.format(sort);
		}
		return tempCode;
	}

}
