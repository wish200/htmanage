package com.huiting.manage.services.sysconfig;

import java.util.List;

import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcTaskDto;
import com.huiting.manage.services.common.BaseService;

public interface CcTaskService extends BaseService{

	List<CcTaskDto> getList(SearchDto searchDto);

	void insert(CcTaskDto ccTaskDto);
/**
 * 
* @Title: createTask 
* @Description: 定时任务创建
* @param     
* @return void  
* @throws
 */
//	void createTask();

    void creteDataInputTask();

//	void creteClassSubmitTask();

//	void creteGroupSubmitTask();
	/**
	 * 查询任务有多少条
	 * @param searchDto
	 * @return
	 */
	int getUserTaskCount(SearchDto searchDto);

	void createPushToEmail();

	void creatHandDataInputTask();


}
