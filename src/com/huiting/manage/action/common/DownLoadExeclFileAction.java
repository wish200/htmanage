package com.huiting.manage.action.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;

import javax.annotation.Resource;

import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.huiting.manage.services.common.HSSFFileCreateService;

public class DownLoadExeclFileAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String htmlData;
	private String downFileName;
	private String htmlTitle;
	@Resource(name = "hssfFileCreateServiceImpl")
	private HSSFFileCreateService hssfFileCreateService;
	public String getDownloadFile(){
		return "OK";
	}
	
	public InputStream getInputStream() throws Exception{
		HSSFWorkbook hssfWorkbook=new HSSFWorkbook();
		hssfFileCreateService.CreateXslFileToHtml(hssfWorkbook,htmlData,htmlTitle);
		ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
		hssfWorkbook.write(byteArrayOutputStream);
		//System.out.println(htmlTitle);
		setDownFileName(htmlTitle.replaceAll("&nbsp;", "").replaceAll(" ", ""));
		//hssfWorkbook.setSheetName(0, downFileName);
		return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());    
	}
	public String getDownPngFlile(){
//		System.out.println("0000");
		return "PBG";
	}
	public InputStream getInputStrPng() throws Exception{
//		  System.out.println(htmlData);
//		try {
//            byte[] bytes =htmlData.getBytes("UTF-8");
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            PNGTranscoder t = new PNGTranscoder();
            TranscoderInput input = new TranscoderInput(new StringReader(htmlData));
            TranscoderOutput output = new TranscoderOutput(byteArrayOutputStream);
            t.transcode(input, output);
        	setDownFileName(htmlTitle.replaceAll("&nbsp;", "").replaceAll(" ", ""));
//            outputStream.flush();
//        } /*finally {
//            if (outputStream != null) {
//                try {
//                    outputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }*/
		
		return  new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
	}
	
	
	
	
	
	public String getHtmlData() {
		return htmlData;
	}
	public void setHtmlData(String htmlData) {
		this.htmlData = htmlData;
	}
	public String getDownFileName() {
		try{
			downFileName=new String(downFileName.getBytes("gb2312"),"ISO-8859-1");
		}catch(Exception e){
			e.printStackTrace();
		}
		return downFileName;
	}
	public void setDownFileName(String downFileName) {
		this.downFileName = downFileName;
	}
	public String getHtmlTitle() {
		return htmlTitle;
	}
	public void setHtmlTitle(String htmlTitle) {
		this.htmlTitle = htmlTitle;
	}
	
}
