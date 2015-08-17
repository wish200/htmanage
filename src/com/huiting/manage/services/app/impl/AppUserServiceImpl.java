package com.huiting.manage.services.app.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.app.AppUserDao;
import com.huiting.manage.dto.base.AppUserBaseDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppUserService;
import com.huiting.manage.system.util.NumberUtil;
import com.huiting.manage.system.util.UtilAPI;
/**
 * 
* @ClassName: AppUserServiceImpl 
* @Description: 公告信息管理模块
* @author Niu_ChunPing
* @date 2014-2-17 下午4:12:22
 */
@Service("appUserServiceImpl")
public class AppUserServiceImpl implements AppUserService {
	@Resource(name = "appUserDaoImpl")
	private AppUserDao appUserDao;
	@Override
	public void add(AppUserBaseDto appUserBaseDto) {
		//appUserBaseDto.setValidstatus("0");
		//appUserBaseDto.setCreatedate(new Date());
		appUserDao.insert(appUserBaseDto);
	}
	@Override
	public void update(AppUserBaseDto appUserBaseDto) {
		appUserDao.update(appUserBaseDto);
	}
	@Override
	public List<AppUserBaseDto> getUserList(SearchDto searchDto) {
		return appUserDao.selectList("searchDto", searchDto);
	}
	@Override
	public void delete(AppUserBaseDto appUserBaseDto) {
		appUserDao.deleteById(appUserBaseDto.getUserid());
		
	}
	@Override
	public AppUserBaseDto getOneUser(SearchDto searchDto) {
		return appUserDao.selectOne("searchDto", searchDto);
	}
	@Override
	public int getUserCount(SearchDto searchDto) {
		Map<String, Object> condition=new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return appUserDao.count(condition);
	}
	/**
	  * @Description: 最大公告信息代码 
	 */
	@Override
	public String getMaxUserCode() {
		return appUserDao.selectMaxId();
	}
	
	/**
	  * @Description: 获得新的公告信息代码 
	 */
	public String getNewUserCode(String systemCode) {
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
