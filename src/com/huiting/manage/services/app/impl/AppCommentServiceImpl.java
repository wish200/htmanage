package com.huiting.manage.services.app.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.app.AppCommentDao;
import com.huiting.manage.dto.base.AppCommentBaseDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.app.AppCommentService;
import com.huiting.manage.system.util.NumberUtil;
import com.huiting.manage.system.util.UtilAPI;
/**
 * 
* @ClassName: AppcommentServiceImpl 
* @Description: 公告信息管理模块
* @author Niu_ChunPing
* @date 2014-2-17 下午4:12:22
 */
@Service("appCommentServiceImpl")
public class AppCommentServiceImpl implements AppCommentService {
	@Resource(name = "appCommentDaoImpl")
	private AppCommentDao appCommentDao;
	@Override
	public void add(AppCommentBaseDto appCommentBaseDto) {
		//appCommentBaseDto.setValidstatus("0");
		//appCommentBaseDto.setCreatedate(new Date());
		appCommentDao.insert(appCommentBaseDto);
	}
	@Override
	public void update(AppCommentBaseDto appCommentBaseDto) {
		appCommentDao.update(appCommentBaseDto);
	}
	@Override
	public List<AppCommentBaseDto> getCommentList(SearchDto searchDto) {
		return appCommentDao.selectList("searchDto", searchDto);
	}
	@Override
	public void delete(AppCommentBaseDto appCommentBaseDto) {
		appCommentDao.deleteById(appCommentBaseDto.getCommentid());
		
	}
	@Override
	public AppCommentBaseDto getOneComment(SearchDto searchDto) {
		return appCommentDao.selectOne("searchDto", searchDto);
	}
	@Override
	public int getCommentCount(SearchDto searchDto) {
		Map<String, Object> condition=new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return appCommentDao.count(condition);
	}
	
	@Override
	public AppCommentBaseDto getOneUser(SearchDto searchDto) {
		return (AppCommentBaseDto)appCommentDao.selectOneUser("searchDto", searchDto);
	}
	/**
	  * @Description: 最大公告信息代码 
	 */
	@Override
	public String getMaxCommentCode() {
		return appCommentDao.selectMaxId();
	}
	
	/**
	  * @Description: 获得新的公告信息代码 
	 */
	public String getNewCommentCode(String systemCode) {
		String tempCode = "M000001";
		DecimalFormat df = new DecimalFormat("000000");
		if(UtilAPI.isNull(systemCode)){
		}else{
			int sort = NumberUtil.createInteger(systemCode.substring(2)) + 1;// 新的序列
			tempCode = "M"+df.format(sort);
		}
		return tempCode;
	}

}
