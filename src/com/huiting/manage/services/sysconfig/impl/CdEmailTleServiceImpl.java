package com.huiting.manage.services.sysconfig.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.common.PublicSQLDao;
import com.huiting.manage.dao.sysconfig.CdEmailRecDao;
import com.huiting.manage.dao.sysconfig.CdEmailTemplateDao;
import com.huiting.manage.dao.sysconfig.CdEmailTleDao;
import com.huiting.manage.dto.base.CdEmailTemplateBaseDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CdEmailRecDto;
import com.huiting.manage.dto.sysconfig.CdEmailTemplateDto;
import com.huiting.manage.services.common.impl.BaseServiceImpl;
import com.huiting.manage.services.sysconfig.CdEmailTleService;
import com.huiting.manage.system.util.NumberUtil;
import com.huiting.manage.system.util.UtilAPI;
@Service("cdEmailTleServiceImpl")
public class CdEmailTleServiceImpl extends BaseServiceImpl implements CdEmailTleService{

	@Resource(name = "cdEmailTleDaoImpl")
	 CdEmailTleDao cdEmailTleDao;
	
	@Resource(name = "cdEmailRecDaoImpl")
	 CdEmailRecDao cdEmailRecDao;
	
	@Resource(name = "publicSQLDaoImpl")
	 PublicSQLDao publicSQLDao;
	@Resource(name = "cdEmailTemplateDaoImpl")
	 CdEmailTemplateDao cdEmailTemplateDao;
	

	@Override
	public void deleteEmailRec(SearchDto searchDto) {
		//  Auto-generated method stub
		cdEmailRecDao.deleteById(searchDto.getTemplatenum());
	}

	@Override
	public void deleteEmailTle(SearchDto searchDto) {
		//  Auto-generated method stub
		cdEmailTleDao.deleteById(searchDto.getTemplatenum());
	}

	@Override
	public CdEmailTemplateBaseDto findEmailTle(SearchDto searchDto) {
		return cdEmailTleDao.selectOne("searchDto", searchDto);
	}

	@Override
	public List<CdEmailTemplateBaseDto> findEmailTleForList(SearchDto searchDto) {
		return cdEmailTleDao.selectList("searchDto", searchDto);
	}

	@Override
	public void insertEmailRec(CdEmailRecDto cdEmailRecDto) {
		//  Auto-generated method stub
		cdEmailRecDao.insert(cdEmailRecDto);
	}

	@Override
	public void insertEmailTle(CdEmailTemplateBaseDto emailTemplateBaseDto) {
		//  Auto-generated method stub
		cdEmailTleDao.insert(emailTemplateBaseDto);
	}

	@Override
	public List<CdEmailRecDto> queryEmailRec(SearchDto searchDto) {
		//  Auto-generated method stub
		return cdEmailRecDao.selectList("searchDto", searchDto);
	}

	@Override
	public void updateEmailTle(CdEmailTemplateBaseDto emailTemplateBaseDto) {
		//  Auto-generated method stub
		cdEmailTleDao.update(emailTemplateBaseDto);
	}

	/**
	 * 对 邮件模板及接受人表进行批量插入。
	 */
	public void cdEmailRecBatch(CdEmailRecDto cdEmailRecDto, String[] Array,String[] depArray,CdEmailTemplateBaseDto cdEmailTemplateBaseDto,String type) {
		String sento=null;
		for (int i=0;i< Array.length ;i++) {
					sento=Array[i];
					cdEmailRecDto.setRecno(sento);
					cdEmailRecDto.setNewdepcode(depArray[i]);
					if("STO".equals(type)){
						cdEmailRecDto.setRectype("1");
					}else{
						cdEmailRecDto.setRectype("2");
					}
					if(sento!=null && !sento.equals("")){
						cdEmailRecDto.setTemplatenum(cdEmailTemplateBaseDto.getTemplatenum());
						insertEmailRec(cdEmailRecDto);
					}
		 }
	}

	@Override
	public String getMaxCode(SearchDto searchDto) {
		// TODO Auto-generated method stub
		return cdEmailTleDao.getMaxCode(searchDto);
	}

	@Override
	public String newCode(String oldCode) {
		String tempCode = "E0000001";
		DecimalFormat df = new DecimalFormat("0000000");
		if(UtilAPI.isNull(oldCode)){
		}else{
			int sort = NumberUtil.createInteger(oldCode.substring(1)) + 1;// 新的序列
			tempCode = "E"+df.format(sort);
		}
		return tempCode;
	}

	/**
	 * 
	* @Title: getUserEmailRec 
	* @Description:  获得邮件接收人表对应用户的email 
	* @param @return     
	* @return CdEmailRecDto   
	* @throws
	 */
	public List<CdEmailRecDto> getUserEmailRec(SearchDto searchDto) {
		Map<String,Object> condition=new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return cdEmailRecDao.selectList("getUserEmailRec", condition);
	}

	@Override
	public int getEmailTleCount(SearchDto searchDto) {
		Map<String,Object> condition=new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return cdEmailTleDao.count(condition);
	}

	@Override
	public List<CdEmailTemplateDto> getCdEmailTemplateList(SearchDto searchDto) {
		return cdEmailTemplateDao.selectList("searchDto", searchDto);
	}


	
	
}
