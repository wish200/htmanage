package com.huiting.manage.dao.sysconfig.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dao.sysconfig.EmailSendDao;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.EmailSendDto;

@Repository("emailSendDaoImpl")
public class EmailSendDaoImpl extends BaseDaoImpl<EmailSendDto, String>
		implements EmailSendDao {
	public EmailSendDaoImpl() {
		super.setSqlmapNamespace("emailSendMapper");
	}

	@Override
	public List<EmailSendDto> getEmailBodyHandSumbit(SearchDto searchDto) {
		System.out.println("wo shi jinl ");
		return this.sqlSession.selectList("emailSendMapper.getEmailBodyHandSumbit", searchDto);
	}

	@Override
	public List<EmailSendDto> getEmailBodyReentry(SearchDto searchDto) {
		return this.sqlSession.selectList("emailSendMapper.getEmailBodyReentry", searchDto);
	}

	@Override
	public List<EmailSendDto> getEmailCuiBan(SearchDto searchDto) {
		return this.sqlSession.selectList("emailSendMapper.getEmailCuiBan", searchDto);
	}

	@Override
	public List<EmailSendDto> getEmailHandSumbitCuiBan(SearchDto searchDto) {
		return this.sqlSession.selectList("emailSendMapper.getEmailHandSumbitCuiBan", searchDto);
	}
}
