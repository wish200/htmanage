package com.huiting.manage.services.app.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.app.AppPicbookDao;
import com.huiting.manage.dto.base.AppPicbookBaseDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppPicbookService;
import com.huiting.manage.system.util.NumberUtil;
import com.huiting.manage.system.util.UtilAPI;
/**
 * 
* @ClassName: AppPicbookServiceImpl 
* @Description: 公告信息管理模块
* @author Niu_ChunPing
* @date 2014-2-17 下午4:12:22
 */
@Service("appPicbookServiceImpl")
public class AppPicbookServiceImpl implements AppPicbookService {
	@Resource(name = "appPicbookDaoImpl")
	private AppPicbookDao appPicbookDao;
	@Override
	public void add(AppPicbookBaseDto appPicbookBaseDto) {
		//appPicbookBaseDto.setValidstatus("0");
		//appPicbookBaseDto.setCreatedate(new Date());
		appPicbookDao.insert(appPicbookBaseDto);
	}
	@Override
	public void update(AppPicbookBaseDto appPicbookBaseDto) {
		appPicbookDao.update(appPicbookBaseDto);
	}
	@Override
	public List<AppPicbookBaseDto> getPicbookList(SearchDto searchDto) {
		return appPicbookDao.selectList("searchDto", searchDto);
	}
	@Override
	public void delete(AppPicbookBaseDto appPicbookBaseDto) {
		appPicbookDao.deleteById(appPicbookBaseDto.getPicbookid());
		
	}
	@Override
	public AppPicbookBaseDto getOnePicbook(SearchDto searchDto) {
		return appPicbookDao.selectOne("searchDto", searchDto);
	}
	@Override
	public AppPicbookBaseDto getOneUser(SearchDto searchDto) {
		return (AppPicbookBaseDto)appPicbookDao.selectOneUser("searchDto", searchDto);
	}
	@Override
	public int getPicbookCount(SearchDto searchDto) {
		Map<String, Object> condition=new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return appPicbookDao.count(condition);
	}
	/**
	  * @Description: 最大公告信息代码 
	 */
	@Override
	public String getMaxPicbookCode() {
		return appPicbookDao.selectMaxId();
	}
	
	/**
	  * @Description: 获得新的公告信息代码 
	 */
	public String getNewPicbookCode(String systemCode) {
		String tempCode = "PIC000001";
		DecimalFormat df = new DecimalFormat("000000");
		if(UtilAPI.isNull(systemCode)){
		}else{
			int sort = NumberUtil.createInteger(systemCode.substring(3)) + 1;// 新的序列
			tempCode = "PIC"+df.format(sort);
		}
		return tempCode;
	}

}
