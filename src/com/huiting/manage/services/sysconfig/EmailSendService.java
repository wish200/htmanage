package com.huiting.manage.services.sysconfig;

import java.util.List;

import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.EmailMessageDto;
import com.huiting.manage.dto.sysconfig.EmailSendDto;
import com.huiting.manage.services.common.BaseService;
/**
 * 邮件发送
 * @author ncp
 *
 */
public interface EmailSendService extends BaseService {
	/**&
	 * 查询问题推送模块的推送
	 * @return
	 */
	List<EmailSendDto> getEmailBody(SearchDto searchDto);
	/**
	 * 发送邮件细信息
	 * @param emailMessageDtos
	 */
	void sendEmail(List<EmailMessageDto> emailMessageDtos,CcUserDto user,SearchDto searchDto);
	/**
	 * 手工提交的部门
	 * @param searchDto
	 * @return
	 */
	List<EmailSendDto> getEmailBodyHandSumbit(SearchDto searchDto);
	/**
	 * 重录
	 * @param searchDto
	 * @return
	 */
	List<EmailSendDto> getEmailBodyReentry(SearchDto searchDto);
	/**
	 * 问题推送与整改催办提醒
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
