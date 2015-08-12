package com.huiting.manage.services.common;

import java.util.List;

import com.huiting.manage.dto.common.CcUploadFilesDto;

public interface AttchMentService extends BaseService {

	/**
	 * 新增附件
	 * @param knowledgeFile
	 */
	public void saveAttchMentFile(CcUploadFilesDto attchMentFile);
	/**
	 * 删除附件
	 * @param filepath 通过路径删除
	 */
	public void deleteSupervisionFile(String filepath);
	/**
	 * 删除附件
	 * @param knowledgeId 通过Id删除
	 */
	public void deleteSupervisionFiles(String supervisonId);
	/**
	 * 查找附件
	 * @param knowledgeId
	 */
	public List<CcUploadFilesDto> findAttchMentById(String supervisonId);
	/**
	 * 查找附件
	 * @param knowledgeId
	 */
	public List<CcUploadFilesDto> findOneAttchMent(String fileName);
	
	/**
	 * 删除附件硬盘文件及数据库
	 * @param knowledgeId 通过Id删除
	 */
	public void deleteSupervisionFilesAll(String groupID);
	
		
}
