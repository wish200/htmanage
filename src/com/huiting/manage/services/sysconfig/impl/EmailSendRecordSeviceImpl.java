package com.huiting.manage.services.sysconfig.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.sysconfig.CcMailSendRecordDao;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcMailSendRecordDto;
import com.huiting.manage.services.common.impl.BaseServiceImpl;
import com.huiting.manage.services.sysconfig.EmailSendRecordSevice;
@Service("emailSendRecordSeviceImpl")
public class EmailSendRecordSeviceImpl extends BaseServiceImpl implements
		EmailSendRecordSevice {
	@Resource(name = "ccMailSendRecordDaoImpl")
	private CcMailSendRecordDao ccMailSendRecordDao;
	@Override
	public int getEmailCount(SearchDto searchDto) {
		Map<String, Object> condition=new HashMap<String, Object>();
		condition.put("searchDto", searchDto);
		return ccMailSendRecordDao.count(condition);
	}
	@Override
	public List<CcMailSendRecordDto> getEmailList(SearchDto searchDto) {
		return ccMailSendRecordDao.selectList("searchDto", searchDto);
	}

}
