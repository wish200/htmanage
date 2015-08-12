package com.huiting.manage.services.sysconfig;

import java.util.List;

import com.huiting.manage.dto.base.CdEmailTemplateBaseDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CdEmailRecDto;
import com.huiting.manage.dto.sysconfig.CdEmailTemplateDto;
import com.huiting.manage.services.common.BaseService;

/**
 * 
* @ClassName: CcEmailTleService
* @Description:   cd_email_template数据库逻辑处理接口
* @author ZhangYangYang
* @date 2013-12-22 下午01:53:13
 */
public interface CdEmailTleService extends BaseService{

	/**
	 * 
	* @Title: queryEmailRec 
	* @Description:    [查询] 邮件模板接受人表
	* @param @param searchDto
	* @param @return     
	* @return List<CdEmailRecDto>   
	* @throws
	 */
	public List<CdEmailRecDto> queryEmailRec(SearchDto searchDto);
	/**
	 * 
	* @Title: deleteEmailRec 
	* @Description:    [删除] 邮件模板接受人表
	* @param      
	* @return void   
	* @throws
	 */
	public void deleteEmailRec(SearchDto searchDto);
	/**
	 * 
	* @Title: insertEmailRec 
	* @Description:    [插入] 邮件模板接受人表
	* @param @param cdEmailRecBaseDto     
	* @return void   
	* @throws
	 */
	public void insertEmailRec(CdEmailRecDto cdEmailRecDto);
	/**
	 * 
	* @Title: getUserEmailRec 
	* @Description:  获得邮件接收人表对应用户的email 
	* @param @return     
	* @return CdEmailRecDto   
	* @throws
	 */
	public List<CdEmailRecDto>  getUserEmailRec(SearchDto searchDto);
	
	
	
	/**
	 * 
	* @Title: insert
	* @Description:    [插入] 模板信息表
	* @param @param emailTemplateBaseDto     
	* @return void   
	* @throws
	 */
	public void insertEmailTle(CdEmailTemplateBaseDto emailTemplateBaseDto);
	/**
	 * 
	* @Title: update 
	* @Description:    [更新] 模板信息表
	* @param @param searchDto     
	* @return void   
	* @throws
	 */
	public void updateEmailTle(CdEmailTemplateBaseDto emailTemplateBaseDto);
	/**
	 * 
	* @Title: delete 
	* @Description:    [删除] 模板信息表
	* @param @param searchDto     
	* @return void   
	* @throws
	 */
	public void deleteEmailTle(SearchDto searchDto);
	/**
	 * 
	* @Title: findEmailTemplate 
	* @Description:    [查找] 模板信息List
	* @param @param searchDto
	* @param @return     
	* @return List<EmailTemplateBaseDto>   
	* @throws
	 */
	public List<CdEmailTemplateBaseDto> findEmailTleForList(SearchDto searchDto);
	/**
	 * 
	* @Title: findEmailTemplate 
	* @Description:    [查找] 单个模板信息
	* @param @param searchDto
	* @param @return     
	* @return EmailTemplateBaseDto   
	* @throws
	 */
	public CdEmailTemplateBaseDto findEmailTle(SearchDto searchDto);
	/**
	 * 
	* @Title: cdEmailRecBatch 
	* @Description:  对邮件接受人表进行批量操作
	* @param @param cdEmailTemplateBaseDto
	* @param @param sentToArray     
	* @return void   
	* @throws
	 */
	public void cdEmailRecBatch(CdEmailRecDto cdEmailRecDto,String[] Array,String[] depArray,CdEmailTemplateBaseDto cdEmailTemplateBaseDto,String type);
	
	/**
	 * @Description: 获取邮件模板最大编码
	 * @param @param searchDto
	 */
	public String getMaxCode(SearchDto searchDto);

	/**
	 * @Description: 生成新的邮件模板代码
	 * @param @param oldCode ，当前最大的邮件模板代码
	 * @return String 返回一个新的邮件模板代码
	 */
	public String newCode(String oldCode);
	/**
	 * 
	* @Title: getEmailTleCount 
	* @Description: 查询邮件模板数量
	* @param @param searchDto
	* @param @return    
	* @return int  
	* @throws
	 */
	public int getEmailTleCount(SearchDto searchDto);
	/**
	 * 根据条件查询邮件模板
	 * @return
	 */
	public List<CdEmailTemplateDto> getCdEmailTemplateList(SearchDto searchDto);
	
	
}
