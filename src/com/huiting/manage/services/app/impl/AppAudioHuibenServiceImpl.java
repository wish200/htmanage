package com.huiting.manage.services.app.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.app.AppAudioHuibenDao;
import com.huiting.manage.dto.base.AppAudioHuibenBaseDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppAudioHuibenService;
import com.huiting.manage.system.util.NumberUtil;
import com.huiting.manage.system.util.UtilAPI;
/**
 * 
* @ClassName: AppAudioHuibenServiceImpl 
* @Description: 公告信息管理模块
* @author Niu_ChunPing
* @date 2014-2-17 下午4:12:22
 */
@Service("appAudioHuibenServiceImpl")
public class AppAudioHuibenServiceImpl implements AppAudioHuibenService {
	@Resource(name = "appAudioHuibenDaoImpl")
	private AppAudioHuibenDao appAudioHuibenDao;
	@Override
	public void add(AppAudioHuibenBaseDto appAudioHuibenBaseDto) {
		//appAudioHuibenBaseDto.setValidstatus("0");
		//appAudioHuibenBaseDto.setCreatedate(new Date());
		appAudioHuibenDao.insert(appAudioHuibenBaseDto);
	}
	@Override
	public void update(AppAudioHuibenBaseDto appAudioHuibenBaseDto) {
		appAudioHuibenDao.update(appAudioHuibenBaseDto);
	}
	@Override
	public List<AppAudioHuibenBaseDto> getAudioHuibenList(SearchDto searchDto) {
		return appAudioHuibenDao.selectList("searchDto", searchDto);
	}
	@Override
	public void delete(AppAudioHuibenBaseDto appAudioHuibenBaseDto) {
		appAudioHuibenDao.deleteById(appAudioHuibenBaseDto.getHuibenid());
		
	}
	@Override
	public AppAudioHuibenBaseDto getOneAudioHuiben(SearchDto searchDto) {
		return appAudioHuibenDao.selectOne("searchDto", searchDto);
	}
	@Override
	public AppAudioHuibenBaseDto getOneUser(SearchDto searchDto) {
		return (AppAudioHuibenBaseDto)appAudioHuibenDao.selectOneUser("searchDto", searchDto);
	}
	@Override
	public AppAudioHuibenBaseDto getOnePicbook(SearchDto searchDto) {
		return (AppAudioHuibenBaseDto)appAudioHuibenDao.selectOnePicbook("searchDto", searchDto);
	}
	@Override
	public AppAudioHuibenBaseDto getOneAudio(SearchDto searchDto) {
		return (AppAudioHuibenBaseDto)appAudioHuibenDao.selectOneAudio("searchDto", searchDto);
	}
	@Override
	public int getAudioHuibenCount(SearchDto searchDto) {
		Map<String, Object> condition=new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return appAudioHuibenDao.count(condition);
	}
	/**
	  * @Description: 最大公告信息代码 
	 */
	@Override
	public String getMaxAudioHuibenCode() {
		return appAudioHuibenDao.selectMaxId();
	}
	
	/**
	  * @Description: 获得新的公告信息代码 
	 */
	public String getNewAudioHuibenCode(String AudioHuibenid) {
		String tempCode = "ACT000001";
		DecimalFormat df = new DecimalFormat("000000");
		if(UtilAPI.isNull(AudioHuibenid)){
		}else{
			int sort = NumberUtil.createInteger(AudioHuibenid.substring(3)) + 1;// 新的序列
			tempCode = "ACT"+df.format(sort);
		}
		return tempCode;
	}

}
