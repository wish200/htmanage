package com.huiting.manage.services.common.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.common.CcUploadFilesDao;
import com.huiting.manage.dto.common.CcUploadFilesDto;
import com.huiting.manage.services.common.AttchMentService;
@Service("attchMentServiceImpl")
public class AttchMentServiceImpl extends BaseServiceImpl implements AttchMentService {
	 @Resource(name = "ccUploadFilesDaoImpl")
	private CcUploadFilesDao ccUploadFilesDao;
	@Override
	public void deleteSupervisionFile(String fileName) {
		Map<String, Object> testMap =new HashMap<String, Object>();
		testMap.put("fileName",fileName );
		ccUploadFilesDao.deleteByCondition(testMap);

	}

	@Override
	public void deleteSupervisionFiles(String groupID) {
		Map<String, Object> testMap =new HashMap<String, Object>();
		testMap.put("groupID",groupID);
		ccUploadFilesDao.deleteByCondition(testMap);

	}

	@Override
	public List<CcUploadFilesDto> findAttchMentById(String groupID) {
		Map<String, Object> testMap =new HashMap<String, Object>();
		testMap.put("groupID",groupID);
		return ccUploadFilesDao.selectList("selectAll",testMap,null,null);
		
	}
	@Override
	public List<CcUploadFilesDto> findOneAttchMent(String fileName){
		Map<String, Object> testMap =new HashMap<String, Object>();
		testMap.put("fileName",fileName);
		return ccUploadFilesDao.selectList("selectOne",testMap,null,null);
	}
	@Override
	public void saveAttchMentFile(CcUploadFilesDto attchMentFile) {
		ccUploadFilesDao.insert(attchMentFile);

	}
	@Override
	public void deleteSupervisionFilesAll(String groupID){
		Map<String, Object> testMap =new HashMap<String, Object>();
		testMap.put("groupID",groupID);
		List<CcUploadFilesDto> files= ccUploadFilesDao.selectList("selectAll",testMap,null,null);
		for (CcUploadFilesDto ccUploadFilesDto : files) {
			File f = new File(ccUploadFilesDto.getSavepath() + "/" + ccUploadFilesDto.getUploadrealname());
			if (f.exists())
				f.delete();
		}
		deleteSupervisionFiles(groupID);
	}
	
	

	public CcUploadFilesDao getCcUploadFilesDao() {
		return ccUploadFilesDao;
	}

	public void setCcUploadFilesDao(CcUploadFilesDao ccUploadFilesDao) {
		this.ccUploadFilesDao = ccUploadFilesDao;
	}
	
}
