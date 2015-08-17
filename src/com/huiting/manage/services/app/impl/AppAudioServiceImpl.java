package com.huiting.manage.services.app.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.app.AppAudioDao;
import com.huiting.manage.dto.base.AppAudioBaseDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppAudioService;
import com.huiting.manage.system.util.NumberUtil;
import com.huiting.manage.system.util.UtilAPI;
/**
 * 
* @ClassName: AppAudioServiceImpl 
* @Description: 公告信息管理模块
* @author Niu_ChunPing
* @date 2014-2-17 下午4:12:22
 */
@Service("appAudioServiceImpl")
public class AppAudioServiceImpl implements AppAudioService {
	@Resource(name = "appAudioDaoImpl")
	private AppAudioDao appAudioDao;
	@Override
	public void add(AppAudioBaseDto appAudioBaseDto) {
		//appAudioBaseDto.setValidstatus("0");
		//appAudioBaseDto.setCreatedate(new Date());
		appAudioDao.insert(appAudioBaseDto);
	}
	@Override
	public void update(AppAudioBaseDto appAudioBaseDto) {
		appAudioDao.update(appAudioBaseDto);
	}
	@Override
	public List<AppAudioBaseDto> getAudioList(SearchDto searchDto) {
		return appAudioDao.selectList("searchDto", searchDto);
	}
	@Override
	public void delete(AppAudioBaseDto appAudioBaseDto) {
		appAudioDao.deleteById(appAudioBaseDto.getAudioid());
		
	}
	@Override
	public AppAudioBaseDto getOneAudio(SearchDto searchDto) {
		return appAudioDao.selectOne("searchDto", searchDto);
	}
	@Override
	public AppAudioBaseDto getOneUser(SearchDto searchDto) {
		return (AppAudioBaseDto)appAudioDao.selectOneUser("searchDto", searchDto);
	}
	@Override
	public AppAudioBaseDto getOneObject(SearchDto searchDto) {
		return (AppAudioBaseDto)appAudioDao.selectOneObject("selectOneProgram","searchDto", searchDto);
	}
	@Override
	public int getAudioCount(SearchDto searchDto) {
		Map<String, Object> condition=new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return appAudioDao.count(condition);
	}
	/**
	  * @Description: 最大公告信息代码 
	 */
	@Override
	public String getMaxAudioCode() {
		return appAudioDao.selectMaxId();
	}
	
	/**
	  * @Description: 获得新的公告信息代码 
	 */
	public String getNewAudioCode(String systemCode) {
		String tempCode = "A000001";
		DecimalFormat df = new DecimalFormat("000000");
		if(UtilAPI.isNull(systemCode)){
		}else{
			int sort = NumberUtil.createInteger(systemCode.substring(1)) + 1;// 新的序列
			tempCode = "A"+df.format(sort);
		}
		return tempCode;
	}

}
