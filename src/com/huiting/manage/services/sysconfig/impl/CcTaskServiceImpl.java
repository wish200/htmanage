 package com.huiting.manage.services.sysconfig.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dao.common.PushTaskDao;
import com.huiting.manage.dao.sysconfig.CcDepartmentDao;
import com.huiting.manage.dao.sysconfig.CcTaskDao;
import com.huiting.manage.dao.sysconfig.CdEmailRecDao;
import com.huiting.manage.dao.sysconfig.CdEmailTleDao;
//import com.huiting.manage.dao.sysconfig.CcTimeTaskDao;
import com.huiting.manage.dao.sysconfig.CcUserDao;
//import com.huiting.manage.dao.sysconfig.CdEmailTemplateDao;
//import com.huiting.manage.dto.base.CdIndexBaseDto;
import com.huiting.manage.dto.base.CdEmailTemplateBaseDto;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.PushTaskDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcDepartmentDto;
import com.huiting.manage.dto.sysconfig.CcTaskDto;
import com.huiting.manage.dto.sysconfig.CdEmailRecDto;
//import com.huiting.manage.dto.sysconfig.CcTimeTaskDto;
//import com.huiting.manage.dto.sysconfig.CdEmailRecDtoBase;
//import com.huiting.manage.dto.sysconfig.CdEmailTemplateDto;
import com.huiting.manage.services.sysconfig.CcTaskService;
import com.huiting.manage.system.util.DateUtil;
import com.huiting.manage.system.util.EmailCountTextUtil;
//import com.huiting.manage.system.util.SendEmail;
/**
  * @ClassName: CcTaskServiceImpl
  * @Description: 任务service
  * @author: zhangyangyang
  * @date 2014-2-20 上午10:38:03
 */
@Service("ccTaskServiceImpl")
public class CcTaskServiceImpl implements CcTaskService{

	@Resource(name = "ccTaskDaoImpl")
	private CcTaskDao ccTaskDao;
//	@Resource(name = "ccTimeTaskDaoImpl")
//	private CcTimeTaskDao ccTimeTaskDao;
	@Resource(name = "ccUserDaoImpl")
	private CcUserDao ccUserDao;
//	@Resource(name = "simpleMail")
//	private SendEmail mail;
	@Resource(name = "ccDepartmentDaoImpl")
	private CcDepartmentDao ccDepartmentDao;
//	@Resource(name = "cdEmailTemplateDaoImpl")
//	private CdEmailTemplateDao cdEmailTemplateDao;
	@Resource(name = "pushTaskDaoImpl")
	private PushTaskDao pushTaskDao;
	@Resource(name = "cdEmailTleDaoImpl")
	private CdEmailTleDao cdEmailTleDao;
	@Resource(name = "cdEmailRecDaoImpl")
	private CdEmailRecDao cdEmailRecDao;

	/**
	  * @Description: 任务表list 
	  * @param @param searchDto
	 */
	@Override
	public List<CcTaskDto> getList(SearchDto searchDto) {
		return ccTaskDao.selectList("searchDto", searchDto);
	}

	/**
	  * @Description: 插入 
	  * @param @param ccTaskBaseDto
	 */
	@Override
	public void insert(CcTaskDto ccTaskDto) {
		ccTaskDao.insert(ccTaskDto);
	}

	/*@Override
	public void createTask() {
		SearchDto searchDto=new SearchDto();
//		searchDto.setStatDate(DateUtil.getNowLastMonth());
		String statDate= "201311";//DateUtil.getNowLastMonth();
		searchDto.setStatDate(statDate);
		List<CcTimeTaskDto> ccTimeTaskDtos=	ccTimeTaskDao.selectList("searchDto", searchDto); 
		CcTaskDto ccTaskDto=null;
		List<CdIndexBaseDto> cdIndexBaseDtos=null;
		if(ccTimeTaskDtos!=null){
			for(int i=0;i<ccTimeTaskDtos.size();i++){
				 cdIndexBaseDtos=ccTimeTaskDtos.get(i).getCdIndexBaseDtos();
				 if(cdIndexBaseDtos!=null){
					 for(int j=0;j<cdIndexBaseDtos.size();j++){
						 ccTaskDto=new CcTaskDto();
						 ccTaskDto.setCreatetime(new Date());
						 ccTaskDto.setTaskcontent(cdIndexBaseDtos.get(j).getIndexname());
						 ccTaskDto.setModulecode("M00001");
						 ccTaskDto.setTaskparam1(cdIndexBaseDtos.get(j).getIndexcode());
						 ccTaskDto.setTaskparam2(statDate);
						 ccTaskDto.setUsercode(ccTimeTaskDtos.get(i).getUsercode());
						 ccTaskDto.setTaskstatus("0");
						 ccTaskDao.insert(ccTaskDto);
					 }
				 }
			}
		}else {
		}
	}*/

	/**
	  * @Description 定时的手工填表任务表
	 */
	@Override
	public void creteDataInputTask() {
		GregorianCalendar calendar=new GregorianCalendar(); 
		Date now=new Date();
		calendar.setTime(now);
		int day=calendar.get(Calendar.DAY_OF_MONTH);//今天是几号了---
		int month=calendar.get(Calendar.MONTH);//这个月是几月---月数小1
		int year=calendar.get(Calendar.YEAR);//今年的年号
		
		String statDate=DateUtil.getYearMonth(now);//获得当前时间
		try {
			if(month==1&&(day==4||day==3)){//如果是2月4号跟2月5号就将时间设置为去年12月的数据
				statDate=year-1+"12";
			}else {
				statDate=DateUtil.getLastMonth(statDate);//将时间设为上个月
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SearchDto searchDto=new SearchDto();
		searchDto.setStatDate(statDate);//条件添加了时间
		searchDto.setFetchrate(DateUtil.getFetchrate(statDate));//设置频率
		Map<String,Object> condition=new HashMap<String,Object>();
		List<CcDepartmentDto> ccDepartmentDtos=null;
		searchDto.setValidstate("1");//邮箱部门
		condition.put("searchDto",searchDto);
		if(day==1){//每月1号
			 ccDepartmentDtos=ccDepartmentDao.selectList("getDataInputList", condition);//先获得需要发送的部门---月初时候的邮件
		}else if (month%3!=0&&(day==12||day==11)){//月度
			ccDepartmentDtos=ccDepartmentDao.selectList("getDataInputListGroup", condition);//先获得需要发送的部门---过期提醒---因子填表初分类监管外
		}else if(month%3==0&&(day==6||day==7)){//季度的分类监管
			ccDepartmentDtos=ccDepartmentDao.selectList("getDataInputListUpervise", condition);//先获得需要发送的部门---截止日期
		}else if(month%3==0&&(day==21||day==20)){//季度的集团报送
			ccDepartmentDtos=ccDepartmentDao.selectList("getDataInputListGroup", condition);//先获得需要发送的部门---过期提醒---因子填表初分类监管外
		}else if(month==1&&(day==4||day==3)){//遇到年度数据的最后提醒日期为2月4跟2月5号
			ccDepartmentDtos=ccDepartmentDao.selectList("getDataInputListGroup", condition);//先获得需要发送的部门---过期提醒---因子填表初分类监管外
		}
		if(ccDepartmentDtos!=null){
			//先拿到邮件模块
			searchDto.setComCode("000000");//总公司的人员才有填报功能
			searchDto.setValidstate("1");//有效的用户
			/**需要更改*/
			if(day==1){
				searchDto.setTemplatecatno("T0201000");//邮件类型-初次提醒
			}else{
				searchDto.setTemplatecatno("T0202000");//邮件类型-初次提醒
			}
			CdEmailTemplateBaseDto cdEmailTemplateBaseDto=cdEmailTleDao.selectOne(condition);//获得这个公司的邮件膜拜吧
			List<String > listFile =new ArrayList<String>();
			 listFile.add(BaseAction.getRootPath()+"数据上报时间要求.docx");
				Map<String, String> map=new HashMap<String, String>();
				map.put("2\\*\\*\\*", statDate.substring(0, 4));
				map.put("\\*\\*</span>期次",  statDate.substring(4, 6)+"期次");
				map.put("\\*</span>月", statDate.substring(4, 6)+"月");
			String  cdEmail=null;
			if(cdEmailTemplateBaseDto!=null){
				 cdEmail=EmailCountTextUtil.getCountText(cdEmailTemplateBaseDto.getBodyoftempl(), map);//替换内容	
			}
			if(cdEmail!=null){//邮件模板不为空再继续下面操作
				CcDepartmentDto ccDepartmentDto=null;
				Map<String, String> toMap=null;
				CcTaskDto ccTaskDto=null;
				for(int i=0;i<ccDepartmentDtos.size();i++){
					ccDepartmentDto=ccDepartmentDtos.get(i);//获得部门
					if(day==1){
						//初次提醒的时间添加任务
						ccTaskDto=new CcTaskDto();
						ccTaskDto.setCreatetime(now);//创建时间
						ccTaskDto.setTaskcontent("手工录入-提交录入数据"+statDate+"期次");//工作内容
						ccTaskDto.setComcode("000000");
						ccTaskDto.setNewdepcode(ccDepartmentDto.getNewdepcode());
						if(ccDepartmentDto.getNewdepcode().equals("20120625221937093756pw0")){//合规部门
							ccTaskDto.setDeppositioncode("DP0000004");
						}else{
							ccTaskDto.setDeppositioncode("DP0000005");
						}
						ccTaskDto.setModulecode("M00005");//模块代码
						ccTaskDto.setTaskparam1(statDate);//参数1
						
						ccTaskDao.deleteByCondition("ccTaskDto", ccTaskDto);
						ccTaskDto.setTaskstatus("0");//任务状态
						insert(ccTaskDto);
					}
					searchDto.setNewDepCode(ccDepartmentDto.getNewdepcode());//设置查询部门
					if(ccDepartmentDto.getNewdepcode().equals("20120625221937093756pw0")){//合规部门
						searchDto.setDepPositionCode("DP0000004");
					}else{
						searchDto.setDepPositionCode("DP0000005");
					}
					List<CcUserDto> ccUserDtos=ccUserDao.selectList(condition);//查询这个部门下的岗位的
					CcUserDto ccUserDto=null;
						if(ccUserDtos!=null){//发送人不为空再继续
							toMap=new HashMap<String, String>();
							for(int j=0;j<ccUserDtos.size();j++){//获得这个岗位的人员
								ccUserDto=ccUserDtos.get(j);
								toMap.put(ccUserDto.getEmail(),ccUserDto.getUsername());//设置发件人
							}
							Map<String, String> ccMap=null;
							List<CdEmailRecDto> cdEmailRecDtoList=cdEmailRecDao.selectList("searchDto", searchDto);//查询这个部门下抄送的人员--传入部门代码
							int emialRecSize=cdEmailRecDtoList==null?0:cdEmailRecDtoList.size();
							if(cdEmailRecDtoList!=null){
								ccMap=new HashMap<String, String>();
								ccMap=new HashMap<String, String>();
								CdEmailRecDto cdEmailRecDto=null;
							 	for(int j=0;j<emialRecSize;j++){
							 		cdEmailRecDto=cdEmailRecDtoList.get(j);
							 		ccMap.put(cdEmailRecDto.getCcUserDto().getEmail(), cdEmailRecDto.getCcUserDto().getUsername());
							 	}
							}
//							mail.sendMail(cdEmailTemplateBaseDto.getHeadoftempl(),cdEmail , toMap, ccMap, listFile);//发送邮件
					  }
				}
			}
		}
	}
	/**
	  * @Description: 分类监管报送提醒 
	 *//*
	@Override
	public void creteClassSubmitTask() {
		Date now=new Date();
		String statDate=DateUtil.getYearMonth(now);
		SearchDto searchDto=new SearchDto();
		searchDto.setStatDate(statDate);
		searchDto.setDeppostype("5");
		Map<String,Object> condition=new HashMap<String,Object>();
		condition.put("searchDto",searchDto);
		List<CcTimeTaskDto> ccTimeTaskDtos=	ccTimeTaskDao.selectList("getDataInputList", condition);
		CcTaskDto ccTaskDto=null;
		for(int i=0;i<ccTimeTaskDtos.size();i++){
			CcTimeTaskDto cc=ccTimeTaskDtos.get(i);
			ccTaskDto=new CcTaskDto();
			ccTaskDto.setCreatetime(now);//创建时间
			ccTaskDto.setTaskcontent("分类监管报送-下载报送数据文档");//工作内容
			ccTaskDto.setUsercode(cc.getUsercode());//人员代码
			ccTaskDto.setModulecode("M00003");//模块代码
			ccTaskDto.setTaskparam1(statDate);//参数1
			ccTaskDto.setTaskstatus("0");//任务状态
			insert(ccTaskDto);
		}
	}*/

	/**
	  * @Description: 集团数据报送提醒 
	 */
	/*@Override
	public void creteGroupSubmitTask() {
		Date now=new Date();
		String statDate=DateUtil.getYearMonth(now);
		SearchDto searchDto=new SearchDto();
		searchDto.setStatDate(statDate);
		searchDto.setDeppostype("6");
		Map<String,Object> condition=new HashMap<String,Object>();
		condition.put("searchDto",searchDto);
		List<CcTimeTaskDto> ccTimeTaskDtos=	ccTimeTaskDao.selectList("getDataInputList", condition);
		CcTaskDto ccTaskDto=null;
		for(int i=0;i<ccTimeTaskDtos.size();i++){
			CcTimeTaskDto cc=ccTimeTaskDtos.get(i);
			ccTaskDto=new CcTaskDto();
			ccTaskDto.setCreatetime(now);//创建时间
			ccTaskDto.setTaskcontent("集团数据报送-下载报送数据文档");//工作内容
			ccTaskDto.setUsercode(cc.getUsercode());//人员代码
			ccTaskDto.setModulecode("M00006");//模块代码
			ccTaskDto.setTaskparam1(statDate);//参数1
			ccTaskDto.setTaskstatus("0");//任务状态
			insert(ccTaskDto);
		}
		
	}*/

	@Override
	public int getUserTaskCount(SearchDto searchDto) {
		Map< String, Object> condition=new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return ccTaskDao.count(condition);
	}

	@Override
	public void createPushToEmail() {
		List<PushTaskDto> pushTaskDtos=pushTaskDao.selectList();
		List<PushTaskDto> pushTaskDtos5day=pushTaskDao.selectList5Day();//初次--5天之后的任务会被
		if(pushTaskDtos5day!=null&&pushTaskDtos5day.size()>0){
			if(pushTaskDtos==null){
				pushTaskDtos=new ArrayList<PushTaskDto>();
			}
			for (PushTaskDto pushTaskDto : pushTaskDtos5day) {
				pushTaskDtos.add(pushTaskDto);
			}
		}
		if(pushTaskDtos!=null&&pushTaskDtos.size()>0){
			PushTaskDto pushTaskDto=null; 
			SearchDto searchDto=null;
			Map<String,Object> condition=null;
			Map<String, String> toMap=null;
			for(int i=0;i<pushTaskDtos.size();i++){
				pushTaskDto=pushTaskDtos.get(i);
				searchDto=new SearchDto();
				searchDto.setNewDepCode(pushTaskDto.getMaindepmentcode());
				searchDto.setComCode(pushTaskDto.getComcode());
				searchDto.setDeppostype("2");
				searchDto.setTemplatecatno("T0103000");//设置邮件模板类型
				condition=new HashMap<String,Object>();
				condition.put("searchDto", searchDto);
				
				
				CcTaskDto ccTaskDto=new CcTaskDto();//任务
				ccTaskDto.setCreatetime(new Date());
				ccTaskDto.setTaskcontent(pushTaskDto.getIndexname());
				ccTaskDto.setModulecode("M00002");
				ccTaskDto.setComcode(pushTaskDto.getComcode());
				ccTaskDto.setNewdepcode(pushTaskDto.getMaindepmentcode());
				ccTaskDto.setDeppositioncode(pushTaskDto.getAcceptorcode());
				ccTaskDto.setTaskstatus("0");
				ccTaskDto.setTaskparam1(pushTaskDto.getTaskcode());
				ccTaskDao.deleteByCondition("ccTaskDto", ccTaskDto);
				ccTaskDao.insert(ccTaskDto);
				
				 CdEmailTemplateBaseDto cdEmailTemplateBaseDto=cdEmailTleDao.selectOne(condition);//获得这个公司的邮件膜拜吧
				 Map<String, String> map=new HashMap<String, String>();
					map.put("2\\*\\*\\*",pushTaskDto.getStatdate().substring(0, 4));
					map.put("\\*\\*</span>期次",  pushTaskDto.getStatdate().substring(4, 6)+"</span>期次");
					map.put("\\*</span>月", pushTaskDto.getStatdate().substring(4, 6)+"</span>月");
					map.put("\\*\\*</span>指标",pushTaskDto.getIndexname()+"</span>指标");
					String  cdEmail=null;
				if(cdEmailTemplateBaseDto!=null){
					 cdEmail=EmailCountTextUtil.getCountText(cdEmailTemplateBaseDto.getBodyoftempl(), map);//替换内容	
				}
				if(cdEmail!=null){//邮件模板不为空后再发送邮件
						List<CcUserDto> ccUserDtos=ccUserDao.selectList(condition);//查询这个部门下的岗位的
						if(ccUserDtos!=null&&ccUserDtos.size()>0){
							toMap=new HashMap<String, String>();
							CcUserDto ccUserDto=null;
						    for(int j=0;j<ccUserDtos.size();j++){
						    	ccUserDto=ccUserDtos.get(j);
						    	toMap.put(ccUserDto.getEmail(), ccUserDto.getUsername());
						    	//需要添加任务表
						}
						 if(toMap!=null){//发送人不为空
							 List<CdEmailRecDto> cdEmailRecDtoList=cdEmailRecDao.selectList("searchDto", searchDto);//查询这个部门下抄送的人员--传入部门代码
							 int emialRecSize=cdEmailRecDtoList==null?0:cdEmailRecDtoList.size();
							 Map<String, String> ccMap=null;
							 if(cdEmailRecDtoList!=null){
								 ccMap=new HashMap<String, String>();
								 CdEmailRecDto cdEmailRecDto=null;
								 for(int j=0;j<emialRecSize;j++){
									 cdEmailRecDto=cdEmailRecDtoList.get(j);
									 ccMap.put(cdEmailRecDto.getCcUserDto().getEmail(), cdEmailRecDto.getCcUserDto().getUsername());
								 }
							 }
//							 mail.sendMail(cdEmailTemplateBaseDto.getHeadoftempl(), cdEmail, toMap, ccMap, null);//发送邮件
						 }
				}
				
				    
				   
						
//				    CdEmailTemplateDto cdEmailTemplateDto=cdEmailTemplateDao.selectOne(condition);//获得这个部门下的邮件模板
					/*if(cdEmailTemplateBaseDto!=null){
							Map<String, String> ccMap=null;
							ccMap=new HashMap<String, String>();
							List<CdEmailRecDtoBase> cdEmailRecDtoBases=cdEmailTemplateDto.getCdEmailRecDtoBases();
							if(cdEmailRecDtoBases!=null){
								for(int j=0;j<cdEmailRecDtoBases.size();j++){
									CdEmailRecDtoBase CdEmailRecDtoBase=cdEmailRecDtoBases.get(j);
									if(CdEmailRecDtoBase.getCcUserBaseDto().getEmail()!=null&&CdEmailRecDtoBase.getCcUserBaseDto().getUsername()!=null){
										ccMap.put(CdEmailRecDtoBase.getCcUserBaseDto().getEmail(), CdEmailRecDtoBase.getCcUserBaseDto().getUsername());//设置发件人员
									}
								}
							}
							
							mail.sendMail(cdEmailTemplateDto.getHeadoftempl(), cdEmailTemplateDto.getBodyoftempl(), toMap, ccMap, null);//发送邮件
					}*/
				    
				    
				}
				
			}
		}
		
	}

	@Override
	public void creatHandDataInputTask() {
		 Date now=new Date();
		String statDate=DateUtil.getYearMonth(now);//获得当前时间
		statDate=DateUtil.getPreYearMonth(statDate);
		SearchDto searchDto=new SearchDto();
		searchDto.setStatDate(statDate);//条件添加了时间
		searchDto.setFetchrate(DateUtil.getFetchrate(statDate));//设置频率
		Map<String,Object> condition=new HashMap<String,Object>();
		searchDto.setValidstate("1");//邮箱部门
		condition.put("searchDto",searchDto);
		List<CcDepartmentDto> ccDepartmentDtos=ccDepartmentDao.selectList("getDataInputList", condition);//先获得需要发送的部门---月初时候的邮件;
		CcTaskDto ccTaskDto=null;
		if(ccDepartmentDtos!=null){
			CcDepartmentDto ccDepartmentDto=null;
			for(int i=0;i<ccDepartmentDtos.size();i++){
				ccDepartmentDto=ccDepartmentDtos.get(i);
				//初次提醒的时间添加任务
				ccTaskDto=new CcTaskDto();
				ccTaskDto.setCreatetime(now);//创建时间
				ccTaskDto.setTaskcontent("手工录入-提交录入数据"+statDate+"期次");//工作内容
				ccTaskDto.setComcode("000000");
				ccTaskDto.setNewdepcode(ccDepartmentDto.getNewdepcode());
				if(ccDepartmentDto.getNewdepcode().equals("20120625221937093756pw0")){//合规部门
					ccTaskDto.setDeppositioncode("DP0000004");
				}else{
					ccTaskDto.setDeppositioncode("DP0000005");
				}
				ccTaskDto.setModulecode("M00005");//模块代码
				ccTaskDto.setTaskparam1(statDate);//参数1
				
				ccTaskDao.deleteByCondition("ccTaskDto", ccTaskDto);
				ccTaskDto.setTaskstatus("0");//任务状态
				insert(ccTaskDto);
			}
			
		}
	}
	
}
