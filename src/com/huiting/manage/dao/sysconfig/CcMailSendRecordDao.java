package com.huiting.manage.dao.sysconfig;

import java.util.List;

import com.huiting.manage.dao.common.BaseDao;
import com.huiting.manage.dto.base.CcMailReceiverBaseDto;
import com.huiting.manage.dto.base.CcMailSendRecordBaseDto;
import com.huiting.manage.dto.sysconfig.CcMailSendRecordDto;
/**
 * 邮件发送历史记录,包括人员
 * @author ncp
 *
 */
public interface CcMailSendRecordDao extends
		BaseDao<CcMailSendRecordDto, String> {
	/**
	 * 添加邮件发送历史记录表
	 * @param ccMailSendRecordBaseDtos
	 */
	void insertListSendRecord(
			List<CcMailSendRecordBaseDto> ccMailSendRecordBaseDtos);
	/**
	 * 添加发送人表
	 * @param ccMailReceiverBaseDtos
	 */
	void insertListReceiver(List<CcMailReceiverBaseDto> ccMailReceiverBaseDtos);
	/**
	 * 添加一条记录
	 * @param ccMailSendRecordBaseDto
	 */
	void insertMailSendRecordBase(
			CcMailSendRecordBaseDto ccMailSendRecordBaseDto);

}
