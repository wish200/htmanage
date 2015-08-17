package com.huiting.manage.system.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
public class SendEmail {
	private  JavaMailSender javaMailSender;
    private  SimpleMailMessage simpleMailMessage;
    /**
     * 邮件发送
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param toList 发送人 的emailLIST 
     * @param ccList  抄送人的emailList
     * @param fileName 文件 list
     */
    /**
     * 
    * @Title: sendMail 
    * @Description: TODO
    * @param @param subject  邮件主题
    * @param @param content 邮件内容
    * @param @param toMap 发送人 Map<人名,email>;
    * @param @param ccMap 抄送人 Map<人名,email>;
    * @param @param fileNameList  发送附件的名称 --地址 
    * @return void  
    * @throws
     */
    public  void sendMail(String subject, String content,Map<String, String>  toMap,Map<String, String>  ccMap,List<String> fileNameList) {
    	try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"utf-8");
            String name= javax.mail.internet.MimeUtility.encodeText("风险管理信息平台");
            messageHelper.setFrom(new InternetAddress(name+" <"+simpleMailMessage.getFrom()+">")); //设置发件人Email
            messageHelper.setSubject(subject); //设置邮件主题
            messageHelper.setText(content,true);   //设置邮件主题内容
            setTo(messageHelper,toMap);//设定收件人Email
            setFile(messageHelper,fileNameList);
            setCC(messageHelper,ccMap);//设置抄送人
            javaMailSender.send(mimeMessage); 
    	} catch (Exception e) {
    		System.out.println("异常信息：" + e);
    	}
    	
    }

	/**
	 * 设置抄送人
	 * @param messageHelper
	 * @param ccMap
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	private  void setCC(MimeMessageHelper messageHelper,
			Map<String, String> ccMap) throws UnsupportedEncodingException,
			MessagingException {
		// TODO Auto-generated method stub
		if (ccMap != null) {
			int size = ccMap.size();
			String key;
			String value;
			Object[] object = ccMap.keySet().toArray();
			for (int i = 0; i < size; i++) {
				key = object[i].toString();
				value = ccMap.get(key);
				messageHelper.addCc(key, value);
			}

		}
	}

	/**
	 * 设置发送人
	 * @param messageHelper
	 * @param toMap
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	private  void setTo(MimeMessageHelper messageHelper,
			Map<String, String> toMap) throws UnsupportedEncodingException,
			MessagingException {
		// TODO Auto-generated method stub
		if (toMap != null) {
			int size = toMap.size();
			String key;
			String value;
			Object[] object = toMap.keySet().toArray();
			for (int i = 0; i < size; i++) {
				key = object[i].toString();
				value = toMap.get(key);
				messageHelper.addTo(key, value);
			}

		}

	}
	/**
	 * 添加附件
	 * @param messageHelper
	 * @param fileNameList
	 * @throws MessagingException
	 */
	private  void setFile(MimeMessageHelper messageHelper,
			List<String> fileNameList) throws MessagingException {
		// TODO Auto-generated method stub
		if (fileNameList != null && fileNameList.size() != 0) {
			for (int i = 0; i < fileNameList.size(); i++) {
				FileSystemResource file = new FileSystemResource(new File(fileNameList.get(i)));
				messageHelper.addAttachment(file.getFilename(), file);
			}
		}

	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	public SimpleMailMessage getSimpleMailMessage() {
		return simpleMailMessage;
	}
	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
