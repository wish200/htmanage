package com.huiting.manage.dao.sysconfig.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dao.sysconfig.CcMailSendRecordDao;
import com.huiting.manage.dto.base.CcMailReceiverBaseDto;
import com.huiting.manage.dto.base.CcMailSendRecordBaseDto;
import com.huiting.manage.dto.sysconfig.CcMailSendRecordDto;
/**
 * 邮件发送历史记录表
 * @author ncp
 *
 */
@Repository("ccMailSendRecordDaoImpl")
public class CcMailSendRecordDaoImpl extends
		BaseDaoImpl<CcMailSendRecordDto, String> implements CcMailSendRecordDao {
	 public CcMailSendRecordDaoImpl() {
	        super.setSqlmapNamespace("ccMailSendRecorMapper");
   }

	@Override
	public void insertListSendRecord(
			List<CcMailSendRecordBaseDto> ccMailSendRecordBaseDtos) {
		this.sqlSession.insert("ccMailSendRecorMapper.insertListSendRecord", ccMailSendRecordBaseDtos);
	}

	@Override
	public void insertListReceiver(
			List<CcMailReceiverBaseDto> ccMailReceiverBaseDtos) {
		this.sqlSession.insert("ccMailSendRecorMapper.insertListReceiver", ccMailReceiverBaseDtos);
	}

	@Override
	public void insertMailSendRecordBase(
			CcMailSendRecordBaseDto ccMailSendRecordBaseDto) {
		this.sqlSession.insert("ccMailSendRecorMapper.insertMailSendRecordBase", ccMailSendRecordBaseDto);
	}
}
