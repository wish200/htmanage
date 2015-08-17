package com.huiting.manage.services.sysconfig.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.dao.sysconfig.CcDepartmentDao;
import com.huiting.manage.dao.sysconfig.CcMailSendRecordDao;
import com.huiting.manage.dao.sysconfig.CcTaskDao;
import com.huiting.manage.dao.sysconfig.EmailSendDao;
import com.huiting.manage.dto.base.CcFacinputtrackChangeBaseDto;
import com.huiting.manage.dto.base.CcMailReceiverBaseDto;
import com.huiting.manage.dto.base.CcMailSendRecordBaseDto;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcTaskDto;
import com.huiting.manage.dto.sysconfig.EmailMessageDto;
import com.huiting.manage.dto.sysconfig.EmailSendDto;
import com.huiting.manage.services.common.impl.BaseServiceImpl;
import com.huiting.manage.services.sysconfig.EmailSendService;
import com.huiting.manage.system.util.DateUtil;
import com.huiting.manage.system.util.PasswordEncode;
import com.huiting.manage.system.util.SendEmail;
@Service("emailSendServiceImpl")
public class EmailSendServiceImpl extends BaseServiceImpl implements
		EmailSendService {
	/** 部门岗位Service */
	@Resource(name = "emailSendDaoImpl")
	private EmailSendDao emailSendDao;
	@Resource(name = "simpleMail")
	private SendEmail mail;
	@Resource(name = "ccMailSendRecordDaoImpl")
	private CcMailSendRecordDao ccMailSendRecordDao;
	@Resource(name = "ccDepartmentDaoImpl")
	private CcDepartmentDao ccDepartmentDao;
	@Resource(name = "ccTaskDaoImpl")
	private CcTaskDao ccTaskDao;
	@Override
	public List<EmailSendDto> getEmailBody(SearchDto searchDto) {
		return emailSendDao.selectList("searchDto", searchDto);
	}
	@Override
	public List<EmailSendDto> getEmailBodyHandSumbit(SearchDto searchDto) {
		return emailSendDao.getEmailBodyHandSumbit( searchDto);
	}
	@Override
	public List<EmailSendDto> getEmailBodyReentry(SearchDto searchDto) {
		return emailSendDao.getEmailBodyReentry(searchDto);
	}
	@Override
	public List<EmailSendDto> getEmailCuiBan(SearchDto searchDto) {
		return emailSendDao.getEmailCuiBan(searchDto);
	}
	@Override
	public List<EmailSendDto> getEmailHandSumbitCuiBan(SearchDto searchDto) {
		List<EmailSendDto>  emailSendDtos=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
		   Date date=new Date();
		   Calendar calendar=Calendar.getInstance();
		   calendar.setTime(date);
		   int month=calendar.get(Calendar.MONTH);
		   Set<String> depCodes=new HashSet<String>();
		   try {
				searchDto.setStatDate(DateUtil.getLastMonth(sdf.format(date)));//设置数据期次
				searchDto.setFetchrate(DateUtil.getFetchrate(searchDto.getStatDate()));
		   } catch (ParseException e) {
				e.printStackTrace();
		   }
		   if(month%3==0){//季度值--
			   if(calendar.get(Calendar.DAY_OF_MONTH)>=6){//添加上分类监管的任务
				   List<String> depCodesclass=ccDepartmentDao.selectListClass(searchDto);
				   depCodes.addAll(depCodesclass);
			   }
			   if(calendar.get(Calendar.DAY_OF_MONTH)>=20){//集团报送---每季度22日截止
				   List<String> depCodesclass=ccDepartmentDao.selectListGroup(searchDto);
				   depCodes.addAll(depCodesclass);
			   }
		   }else{//月度
			   if(calendar.get(Calendar.DAY_OF_MONTH)>=11){//集团报送---每月13日截止
				   List<String> depCodesclass=ccDepartmentDao.selectListGroup(searchDto);
				   depCodes.addAll(depCodesclass);
			   }
		   }
		   searchDto.setDepcodes(depCodes);
		   if(depCodes.size()>0){
			   emailSendDtos=emailSendDao.getEmailHandSumbitCuiBan(searchDto);
		   }
		   if(month==1&&calendar.get(Calendar.DAY_OF_MONTH)>=3){//如果是2月份--2月五号
			   searchDto.setStatDate((calendar.get(Calendar.YEAR)-1)+"12");
			   searchDto.setFetchrate("Y");
			   List<String> depCodesclass=ccDepartmentDao.selectListGroup(searchDto);//s集团报送的年报
			   depCodes=new HashSet<String>();
			   depCodes.addAll(depCodesclass);
			   searchDto.setDepcodes(depCodes);
			   if(emailSendDtos==null){
				   emailSendDtos=emailSendDao.getEmailHandSumbitCuiBan(searchDto);
			   }else{
				   emailSendDtos.addAll(emailSendDao.getEmailHandSumbitCuiBan(searchDto));
			   }
		   }
		   return emailSendDtos;
	}
	@Override
	public void sendEmail(List<EmailMessageDto> emailMessageDtos,CcUserDto user,SearchDto searchDto) {
		List<String> fileNameList=null;
		if(searchDto.getTemplatenum().equals("T0201000")){
			//手工报送的话，就添加附件
			fileNameList=new ArrayList<String>();
			fileNameList.add(BaseAction.getRootPath()+"/数据上报时间要求.doc");
		}
		List<CcMailSendRecordBaseDto> ccMailSendRecordBaseDtos=null;//邮件发送历史记录
		List<CcMailReceiverBaseDto> ccMailReceiverBaseDtos=null;//邮件发送历史记录 人员表
		  List<CcFacinputtrackChangeBaseDto> ccFacinputtrackChangeBaseDtos=null; //重录提醒
		  CcFacinputtrackChangeBaseDto ccFacinputtrackChangeBaseDto=null;//重录提醒
		if(emailMessageDtos!=null&&emailMessageDtos.size()>0){
			  CcMailSendRecordBaseDto ccMailSendRecordBaseDto=null;//邮件发送历史记录一条
			  CcMailReceiverBaseDto ccMailReceiverBaseDto=null;
			   int esize=emailMessageDtos.size();
			   EmailMessageDto emailMessageDto=null;
			   Map<String, String> toMap=null;//发送人信息
			   Map<String, String> ccMap=null;//发送人信息
			   ccMailSendRecordBaseDtos=new ArrayList<CcMailSendRecordBaseDto>();//初始化历史记录
			   ccMailReceiverBaseDtos=new ArrayList<CcMailReceiverBaseDto>();//
			    
			   if(searchDto.getTemplatenum().equals("T0203000")){
				   ccFacinputtrackChangeBaseDtos=new ArrayList<CcFacinputtrackChangeBaseDto>();
			   }
			   for(int i=0;i<esize;i++){
				   emailMessageDto=emailMessageDtos.get(i);//一个部门妈的信息 --发一信息
				   CcTaskDto ccTaskDto=null;
				   Date now=new Date();
				   if(searchDto.getTemplatenum().equals("T0101000")){//部门是一的话，那就更新这个部门
					   SearchDto searchDto1=new SearchDto();
					   searchDto1.setNewDepCode(emailMessageDto.getNewdepcode());//那个部门的任务发送了
					   searchDto1.setStatDate(emailMessageDto.getStatdate());//数据期次
					   //flowIndexDao.updateByCondition(searchDto1);
					   
				   }
				   if(searchDto.getTemplatenum().equals("T0201000")){
					 //初次提醒的时间添加任务
						ccTaskDto=new CcTaskDto();
						ccTaskDto.setCreatetime(now);//创建时间
						ccTaskDto.setTaskcontent("手工录入-提交录入数据"+emailMessageDto.getStatdate()+"期次");//工作内容
						ccTaskDto.setComcode("000000");
						ccTaskDto.setNewdepcode(emailMessageDto.getNewdepcode());
						if(emailMessageDto.getNewdepcode().equals("20120625221937093756pw0")){//合规部门
							ccTaskDto.setDeppositioncode("DP0000004");
						}else{
							ccTaskDto.setDeppositioncode("DP0000005");
						}
						ccTaskDto.setModulecode("M00005");//模块代码
						ccTaskDto.setTaskparam1(emailMessageDto.getStatdate());//参数1
						
						ccTaskDao.deleteByCondition("ccTaskDto", ccTaskDto);
						ccTaskDto.setTaskstatus("0");//任务状态
						ccTaskDao.insert(ccTaskDto);  
				   }
				   if(searchDto.getTemplatenum().equals("T0203000")){//重录提醒
					   ccFacinputtrackChangeBaseDto=new CcFacinputtrackChangeBaseDto();
					   ccFacinputtrackChangeBaseDto.setEmailsend("1");
					   ccFacinputtrackChangeBaseDto.setNewdepcode(emailMessageDto.getNewdepcode());
					   ccFacinputtrackChangeBaseDto.setStatdate(emailMessageDto.getStatdate());
					   ccFacinputtrackChangeBaseDtos.add(ccFacinputtrackChangeBaseDto);
				   }
				   if(emailMessageDto.getStcs()!=null&&emailMessageDto.getStcs().split(",").length>0&&!"".equals(emailMessageDto.getStcs().trim())){//发送人
					  String mailid=PasswordEncode.digestPassword(System.currentTimeMillis()+"");
					  ccMailSendRecordBaseDto=new CcMailSendRecordBaseDto();
					  ccMailSendRecordBaseDto.setAttadress(fileNameList==null?null:"/数据上报时间要求.doc");
					  ccMailSendRecordBaseDto.setComcode(user.getComcode());//机构
					  ccMailSendRecordBaseDto.setDepartment(emailMessageDto.getNewdepcode());//部门
					 
					  ccMailSendRecordBaseDto.setEmailthe(emailMessageDto.getHeadoftempl());
					  ccMailSendRecordBaseDto.setMailid(mailid);
					  ccMailSendRecordBaseDto.setModtype(emailMessageDto.getTemplatenum());//模块类型
					  ccMailSendRecordBaseDto.setSenddate(new Date());
					  ccMailSendRecordBaseDto.setSendperson(user.getUsercode());
					  toMap=new HashMap<String, String>();
					  String stcUserMessages[]=emailMessageDto.getStcs().split(",");
					  String userName="";
					  int stcUserMessageslength=stcUserMessages.length;
					  int toUser=0;//有几个人接收邮件
					  for (int j = 0; j < stcUserMessageslength; j++) {
						  if(!"".equals(stcUserMessages[j].trim())){
							  String stcUserMessage[]=stcUserMessages[j].split("-");
							  if(!"".equals(stcUserMessage[0].trim())){//邮箱存在的话再发送
								  toMap.put(stcUserMessage[0].trim(), stcUserMessage[1].trim());
								  userName+=stcUserMessage[1].trim();
								  toUser++;
								  if(stcUserMessageslength>1&&j!=stcUserMessageslength-1){
									  userName+="、";
								  }
								  ccMailReceiverBaseDto=new CcMailReceiverBaseDto();
								  ccMailReceiverBaseDto.setMailid(mailid);
								  ccMailReceiverBaseDto.setSenderid(stcUserMessage[2].trim());
								  ccMailReceiverBaseDto.setUsertype("1");
								  ccMailReceiverBaseDtos.add(ccMailReceiverBaseDto);
							  }
						  }
					  }
					  String emailMessageDtoBody=emailMessageDto.getBodyoftempl();
					  if(toUser>1){
						  emailMessageDtoBody= emailMessageDtoBody.replaceAll("您好", userName+"您们好");
					  }else{
						  emailMessageDtoBody=emailMessageDtoBody.replaceAll("您好", userName+"您好");
					  }
					  ccMailSendRecordBaseDto.setEmaildetail(emailMessageDtoBody);
					  if(emailMessageDto.getBccs()!=null&&toMap.size()>0){//抄送人
						  ccMap=new HashMap<String, String>();
						  String bccUserMessages[]=emailMessageDto.getBccs().split(",");
						  for (int j = 0; j < bccUserMessages.length; j++) {
							  if(!"".equals(bccUserMessages[j].trim())){
								  String bccUserMessage[]=bccUserMessages[j].split("-");
								  if(!"".equals(bccUserMessage[0].trim())){//邮箱存在的话再发送
									  ccMap.put(bccUserMessage[0].trim(), bccUserMessage[1].trim());
									  ccMailReceiverBaseDto=new CcMailReceiverBaseDto();
									  ccMailReceiverBaseDto.setMailid(mailid);
									  ccMailReceiverBaseDto.setSenderid(bccUserMessage[2].trim());
									  ccMailReceiverBaseDto.setUsertype("2");
									  ccMailReceiverBaseDtos.add(ccMailReceiverBaseDto);  
								  }
							  }
						  }
					  }
					  ccMailSendRecordBaseDtos.add(ccMailSendRecordBaseDto);//添加
					  mail.sendMail(emailMessageDto.getHeadoftempl(), emailMessageDtoBody, toMap, ccMap, fileNameList);
				   }
			   }
			   if(searchDto.getTemplatenum().equals("T0203000")){
				  // ccFacinputtrackChangeDao.mergeInto(ccFacinputtrackChangeBaseDtos);
			   }
		 }
		if(ccMailSendRecordBaseDtos!=null &&ccMailSendRecordBaseDtos.size()>0){
			for (int i = 0; i < ccMailSendRecordBaseDtos.size(); i++) {
				ccMailSendRecordDao.insertMailSendRecordBase(ccMailSendRecordBaseDtos.get(i));
			}
//			ccMailSendRecordDao.insertListSendRecord(ccMailSendRecordBaseDtos);
			if(ccMailReceiverBaseDtos!=null &&ccMailReceiverBaseDtos.size()>0){
				ccMailSendRecordDao.insertListReceiver(ccMailReceiverBaseDtos);
			}
		}
		
		
		
	}
	
	
	
	

}
