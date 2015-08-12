package com.huiting.manage.system.task;


import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.huiting.manage.services.sysconfig.CcTaskService;


/**
  * @ClassName: TaskJob
  * @Description: TODO
  * @author: zhangyangyang
  * @date 2014-3-4 下午2:26:07
 */
public class TaskJob {
	public static Logger log = Logger.getLogger(TaskJob.class);
	@Resource(name = "ccTaskServiceImpl")
	private CcTaskService ccTaskService;
	
	
	public void SayHello() {
		/*创建任务表*/
//		ccTaskService.createTask();
		/*手工填报提醒*/
//		ccTaskService.creteDataInputTask();
		///每月一号添加一条数据
//		ccTaskService.creatHandDataInputTask();
		/**创建任务整改的email邮箱*/
//		ccTaskService.createPushToEmail();
		/*分类监管报送提醒*/
//		ccTaskService.creteClassSubmitTask();
		/*集团数据报送提醒*/
//		ccTaskService.creteGroupSubmitTask();
	}
  
}
