package com.huiting.manage.services.app.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.app.AppHuibenDao;
import com.huiting.manage.dto.base.AppHuibenBaseDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppHuibenService;
import com.huiting.manage.system.util.NumberUtil;
import com.huiting.manage.system.util.UtilAPI;
/**
 * 
* @ClassName: AppHuibenServiceImpl 
* @Description: 公告信息管理模块
* @author Niu_ChunPing
* @date 2014-2-17 下午4:12:22
 */
@Service("appHuibenServiceImpl")
public class AppHuibenServiceImpl implements AppHuibenService {
	@Resource(name = "appHuibenDaoImpl")
	private AppHuibenDao appHuibenDao;
	@Override
	public void add(AppHuibenBaseDto appHuibenBaseDto) {
		//appHuibenBaseDto.setValidstatus("0");
		//appHuibenBaseDto.setCreatedate(new Date());
		appHuibenDao.insert(appHuibenBaseDto);
	}
	@Override
	public void update(AppHuibenBaseDto appHuibenBaseDto) {
		appHuibenDao.update(appHuibenBaseDto);
	}
	@Override
	public List<AppHuibenBaseDto> getHuibenList(SearchDto searchDto) {
		return appHuibenDao.selectList("searchDto", searchDto);
	}
	@Override
	public void delete(AppHuibenBaseDto appHuibenBaseDto) {
		appHuibenDao.deleteById(appHuibenBaseDto.getHuibenid());
		
	}
	@Override
	public AppHuibenBaseDto getOneHuiben(SearchDto searchDto) {
		return appHuibenDao.selectOne("searchDto", searchDto);
	}
	@Override
	public AppHuibenBaseDto getOneUser(SearchDto searchDto) {
		return (AppHuibenBaseDto)appHuibenDao.selectOneUser("searchDto", searchDto);
	}
	@Override
	public AppHuibenBaseDto getOnePicbook(SearchDto searchDto) {
		return (AppHuibenBaseDto)appHuibenDao.selectOnePicbook("searchDto", searchDto);
	}
	@Override
	public AppHuibenBaseDto getOneAudio(SearchDto searchDto) {
		return (AppHuibenBaseDto)appHuibenDao.selectOneAudio("searchDto", searchDto);
	}
	@Override
	public int getHuibenCount(SearchDto searchDto) {
		Map<String, Object> condition=new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return appHuibenDao.count(condition);
	}
	/**
	  * @Description: 最大公告信息代码 
	 */
	@Override
	public String getMaxHuibenCode() {
		return appHuibenDao.selectMaxId();
	}
	
	/**
	  * @Description: 获得新的公告信息代码 
	 */
	public String getNewHuibenCode(String Huibenid) {
		String tempCode = "ACT000001";
		DecimalFormat df = new DecimalFormat("000000");
		if(UtilAPI.isNull(Huibenid)){
		}else{
			int sort = NumberUtil.createInteger(Huibenid.substring(3)) + 1;// 新的序列
			tempCode = "ACT"+df.format(sort);
		}
		return tempCode;
	}

}
