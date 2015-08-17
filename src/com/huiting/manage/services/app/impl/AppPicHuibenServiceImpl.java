package com.huiting.manage.services.app.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.app.AppPicHuibenDao;
import com.huiting.manage.dto.base.AppPicHuibenBaseDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppPicHuibenService;
import com.huiting.manage.system.util.NumberUtil;
import com.huiting.manage.system.util.UtilAPI;
/**
 * 
* @ClassName: AppPicHuibenServiceImpl 
* @Description: 公告信息管理模块
* @author Niu_ChunPing
* @date 2014-2-17 下午4:12:22
 */
@Service("appPicHuibenServiceImpl")
public class AppPicHuibenServiceImpl implements AppPicHuibenService {
	@Resource(name = "appPicHuibenDaoImpl")
	private AppPicHuibenDao appPicHuibenDao;
	@Override
	public void add(AppPicHuibenBaseDto appPicHuibenBaseDto) {
		//appPicHuibenBaseDto.setValidstatus("0");
		//appPicHuibenBaseDto.setCreatedate(new Date());
		appPicHuibenDao.insert(appPicHuibenBaseDto);
	}
	@Override
	public void update(AppPicHuibenBaseDto appPicHuibenBaseDto) {
		appPicHuibenDao.update(appPicHuibenBaseDto);
	}
	@Override
	public List<AppPicHuibenBaseDto> getPicHuibenList(SearchDto searchDto) {
		return appPicHuibenDao.selectList("searchDto", searchDto);
	}
	@Override
	public void delete(AppPicHuibenBaseDto appPicHuibenBaseDto) {
		appPicHuibenDao.deleteById(appPicHuibenBaseDto.getHuibenid());
		
	}
	@Override
	public AppPicHuibenBaseDto getOnePicHuiben(SearchDto searchDto) {
		return appPicHuibenDao.selectOne("searchDto", searchDto);
	}
	@Override
	public AppPicHuibenBaseDto getOneUser(SearchDto searchDto) {
		return (AppPicHuibenBaseDto)appPicHuibenDao.selectOneUser("searchDto", searchDto);
	}
	@Override
	public AppPicHuibenBaseDto getOnePicbook(SearchDto searchDto) {
		return (AppPicHuibenBaseDto)appPicHuibenDao.selectOnePicbook("searchDto", searchDto);
	}
	@Override
	public AppPicHuibenBaseDto getOneAudio(SearchDto searchDto) {
		return (AppPicHuibenBaseDto)appPicHuibenDao.selectOneAudio("searchDto", searchDto);
	}
	@Override
	public int getPicHuibenCount(SearchDto searchDto) {
		Map<String, Object> condition=new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return appPicHuibenDao.count(condition);
	}
	/**
	  * @Description: 最大公告信息代码 
	 */
	@Override
	public String getMaxPicHuibenCode() {
		return appPicHuibenDao.selectMaxId();
	}
	
	/**
	  * @Description: 获得新的公告信息代码 
	 */
	public String getNewPicHuibenCode(String PicHuibenid) {
		String tempCode = "ACT000001";
		DecimalFormat df = new DecimalFormat("000000");
		if(UtilAPI.isNull(PicHuibenid)){
		}else{
			int sort = NumberUtil.createInteger(PicHuibenid.substring(3)) + 1;// 新的序列
			tempCode = "ACT"+df.format(sort);
		}
		return tempCode;
	}

}
