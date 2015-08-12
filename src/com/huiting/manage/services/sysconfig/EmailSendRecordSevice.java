package com.huiting.manage.services.sysconfig;

import java.util.List;

import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcMailSendRecordDto;
import com.huiting.manage.services.common.BaseService;

public interface EmailSendRecordSevice extends BaseService {

	int getEmailCount(SearchDto searchDto);

	List<CcMailSendRecordDto> getEmailList(SearchDto searchDto);

}
