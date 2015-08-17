package com.huiting.manage.dao.sysconfig;

import java.util.List;

import com.huiting.manage.dao.common.BaseDao;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.EmailSendDto;

public interface EmailSendDao extends BaseDao<EmailSendDto, String> {
	/**
	 * 查询手工报送的
	 * @param searchDto
	 * @return
	 */
	List<EmailSendDto> getEmailBodyHandSumbit(SearchDto searchDto);
	/**
	 * 查询重录的
	 * @param searchDto
	 * @return
	 */
	List<EmailSendDto> getEmailBodyReentry(SearchDto searchDto);
	/**
	 * 
	 * @param searchDto
	 * @return
	 */
	List<EmailSendDto> getEmailCuiBan(SearchDto searchDto);
	/**
	 * 数据报送的催办
	 * @param searchDto
	 * @return
	 */
	List<EmailSendDto> getEmailHandSumbitCuiBan(SearchDto searchDto);

}
