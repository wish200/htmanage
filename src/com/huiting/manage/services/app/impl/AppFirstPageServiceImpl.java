package com.huiting.manage.services.app.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.app.AppFirstPageDao;
import com.huiting.manage.dto.base.AppFirstPageBaseDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppFirstPageService;
import com.huiting.manage.system.util.NumberUtil;
import com.huiting.manage.system.util.UtilAPI;
/**
 * 
* @ClassName: AppFirstPageServiceImpl 
* @Description: 公告信息管理模块
* @author Niu_ChunPing
* @date 2014-2-17 下午4:12:22
 */
@Service("appFirstPageServiceImpl")
public class AppFirstPageServiceImpl implements AppFirstPageService {
	@Resource(name = "appFirstPageDaoImpl")
	private AppFirstPageDao appFirstPageDao;
	@Override
	public void add(AppFirstPageBaseDto appFirstPageBaseDto) {
		//appFirstPageBaseDto.setValidstatus("0");
		//appFirstPageBaseDto.setCreatedate(new Date());
		appFirstPageDao.insert(appFirstPageBaseDto);
	}
	@Override
	public void update(AppFirstPageBaseDto appFirstPageBaseDto) {
		appFirstPageDao.update(appFirstPageBaseDto);
	}
	@Override
	public List<AppFirstPageBaseDto> getFirstPageList(SearchDto searchDto) {
		return appFirstPageDao.selectList("searchDto", searchDto);
	}
	@Override
	public void delete(AppFirstPageBaseDto appFirstPageBaseDto) {
		appFirstPageDao.deleteById(appFirstPageBaseDto.getId()+"");
		
	}
	@Override
	public AppFirstPageBaseDto getOneFirstPage(SearchDto searchDto) {
		return appFirstPageDao.selectOne("searchDto", searchDto);
	}
	@Override
	public int getFirstPageCount(SearchDto searchDto) {
		Map<String, Object> condition=new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return appFirstPageDao.count(condition);
	}
	/**
	  * @Description: 最大公告信息代码 
	 */
	@Override
	public String getMaxFirstPageCode() {
		return appFirstPageDao.selectMaxId();
	}
	
	/**
	  * @Description: 获得新的公告信息代码 
	 */
	public String getNewFirstPageCode(String systemCode) {
		String tempCode = "000001";
		DecimalFormat df = new DecimalFormat("000000");
		if(UtilAPI.isNull(systemCode)){
		}else{
			int sort = NumberUtil.createInteger(systemCode) + 1;// 新的序列
			tempCode = df.format(sort);
		}
		return tempCode;
	}

}
