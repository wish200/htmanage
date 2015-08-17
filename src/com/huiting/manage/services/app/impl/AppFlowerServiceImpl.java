package com.huiting.manage.services.app.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.app.AppFlowerDao;
import com.huiting.manage.dto.base.AppFlowerBaseDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppFlowerService;
import com.huiting.manage.system.util.NumberUtil;
import com.huiting.manage.system.util.UtilAPI;
/**
 * 
* @ClassName: AppFlowerServiceImpl 
* @Description: 公告信息管理模块
* @author Niu_ChunPing
* @date 2014-2-17 下午4:12:22
 */
@Service("appFlowerServiceImpl")
public class AppFlowerServiceImpl implements AppFlowerService {
	@Resource(name = "appFlowerDaoImpl")
	private AppFlowerDao appFlowerDao;
	@Override
	public void add(AppFlowerBaseDto appFlowerBaseDto) {
		//appFlowerBaseDto.setValidstatus("0");
		//appFlowerBaseDto.setCreatedate(new Date());
		appFlowerDao.insert(appFlowerBaseDto);
	}
	@Override
	public void update(AppFlowerBaseDto appFlowerBaseDto) {
		appFlowerDao.update(appFlowerBaseDto);
	}
	@Override
	public List<AppFlowerBaseDto> getFlowerList(SearchDto searchDto) {
		return appFlowerDao.selectList("searchDto", searchDto);
	}
	@Override
	public void delete(AppFlowerBaseDto appFlowerBaseDto) {
		appFlowerDao.deleteById(appFlowerBaseDto.getBusiid());
		
	}
	@Override
	public AppFlowerBaseDto getOneFlower(SearchDto searchDto) {
		return appFlowerDao.selectOne("searchDto", searchDto);
	}
	@Override
	public AppFlowerBaseDto getOneUser(SearchDto searchDto) {
		return (AppFlowerBaseDto)appFlowerDao.selectOneUser("searchDto", searchDto);
	}
	@Override
	public int getFlowerCount(SearchDto searchDto) {
		Map<String, Object> condition=new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return appFlowerDao.count(condition);
	}
	/**
	  * @Description: 最大公告信息代码 
	 */
	@Override
	public String getMaxFlowerCode() {
		return appFlowerDao.selectMaxId();
	}
	
	/**
	  * @Description: 获得新的公告信息代码 
	 */
	public String getNewFlowerCode(String systemCode) {
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
