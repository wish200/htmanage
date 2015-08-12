package com.huiting.manage.action.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huiting.manage.dto.common.CcUploadFilesDto;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.services.common.AttchMentService;
import com.huiting.manage.system.util.Constants;
import com.huiting.manage.system.util.DateUtil;
import com.huiting.manage.system.util.PropertiesUtil;

public class AttchMentAction extends BaseAction {
	/**
	 * 
	 */
	private String saveRulePath = PropertiesUtil.getVlue("upload.path");
	private static final long serialVersionUID = 1L;
	/** 批量上传开始 */
	@Resource(name = "attchMentServiceImpl")
	private AttchMentService attchMentService;
	private CcUploadFilesDto attchMentFile;
	private List<CcUploadFilesDto> attchMentFiles;
	private File Filedata;
	private String FiledataFileName;
	private String filePath;
	private String moduleid;
	private String groupid;
	private String isorigin;
	private String type;

	/** 批量上传结束 */

	/**
	 * 批量上传附件
	 */
	public void uploadFile() {
		File f = new File(FiledataFileName);
		String fileName = f.getName();
		String[] str = fileName.split("\\.");
		String fileType = str[str.length - 1];
		
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyyMMdd");
		 String yearmonth =  sdf.format(new java.util.Date());
		 String newfileName = "";
		 
		String result ="";
		String duration = "";
		String path = "";
		 if(Filedata ==null || Filedata.length()<1){
			    try {
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().write("file is null");
					response.getWriter().flush();
					response.getWriter().close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 
		/*if ("JPG，GIF，PNG，JPEG".indexOf(fileType.toUpperCase())>-1) {
			if(Filedata!=null&&Filedata.length()>1024*1024){
				try {
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().write("0");
					response.getWriter().flush();
					response.getWriter().close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}*/

		File delFile = new File("/"+saveRulePath + "/" );
		if (delFile.exists())
			delFile.delete();

		HashMap<String, String> paramHashMap = new HashMap<String, String>();
		paramHashMap.put("isorigin", isorigin);
		paramHashMap.put("type", type);
		Map<String,String> rtn = null;
		 System.out.println("1----"+ Filedata.getAbsolutePath()+"-"+Filedata.getPath()+Filedata.getName()+Filedata.getAbsolutePath());
		
		
		UploadFile fileUpload = new UploadFile();
		try {
			//path = ServletActionContext.getRequest().getRealPath("/")+saveRulePath+"/"+yearmonth;
			//String newfileName = fileUpload.upLoadFile(Filedata,FiledataFileName, fileType, path );
			result = new requestclient().toUploadSingleFile(Filedata,"filepathURL",fileName, PropertiesUtil.getVlue("upload.url"), paramHashMap);
			Gson gson=new Gson();
			rtn = gson.fromJson(result, new TypeToken<Map<String,String>>(){}.getType());
			path = rtn.get("filepathURL");
			duration = rtn.get("audiolength");
			
			newfileName = path.substring(path.lastIndexOf("/")+1);
			attchMentFile = new CcUploadFilesDto();
			attchMentFile.setCreatetime(DateUtil.getSystemTime());
			attchMentFile.setCreateusercode(((CcUserDto) session.get(Constants.USERLOGIN)).getUsercode());
			attchMentFile.setFilegroupid(yearmonth);
			attchMentFile.setFileid(UUID.randomUUID().toString());
			attchMentFile.setModuleid(moduleid);
			attchMentFile.setSavepath(path);
			attchMentFile.setUploadcontenttype(fileType);
			attchMentFile.setUploadfilename(fileName);
			attchMentFile.setUploadrealname(newfileName);
			attchMentService.saveAttchMentFile(attchMentFile);
			//attchMentFiles = attchMentService.findAttchMentById(groupid);
			
			
			
			//response.getWriter().write("/"+saveRulePath+"/"+yearmonth+"/"+newfileName);
			if(type!=null&&"audio".equals(type)){
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().write(path+"duration="+duration);
				response.getWriter().flush();
				response.getWriter().close();
				System.out.println(path+"&duration="+duration);
			}else{
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().write(path);
				response.getWriter().flush();
				response.getWriter().close();
			}
			
			
			//renderJson(attchMentFile);
			//renderText("/"+saveRulePath+"/"+newfileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置下载文件时转码的名字
	 */
	public String getFileDownloadName() {
		String fileDownloadName = attchMentFile.getUploadfilename();
		try {
			fileDownloadName = new String(fileDownloadName.getBytes(),
					"ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return fileDownloadName;
	}

	/**
	 * 获取要下载的文件在服务器上的名字
	 */
	public String getFileName() {
		attchMentFiles = attchMentService.findOneAttchMent(filePath);
		attchMentFile = attchMentFiles.get(0);
		String fileName = attchMentFile.getUploadrealname();
		try {
			fileName = new String(fileName.getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return fileName;
	}

	/**
	 * 下载文件路径
	 */
	public InputStream getInputStream() {
		String name = this.getFileName();
		String path = attchMentFile.getSavepath() + "/" + name;
		// return
		// ServletActionContext.getServletContext().getResourceAsStream(path);
		File file = new File(path);
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return in;
	}

	/**
	 * 下载文件
	 * 
	 * @return
	 */
	public String download() {
		return "attchMent_download";
	}

	/**
	 * 删除附件
	 * 
	 * @return
	 */
	public String deleteFile() {
		attchMentFiles = attchMentService.findOneAttchMent(filePath);
		attchMentFile = attchMentFiles.get(0);
		attchMentService.deleteSupervisionFile(filePath);
		deleteFileServicer();

		return SUCCESS;
	}

	/**
	 * 删除服务器文件
	 */
	public String deleteFileServicer() {
		File file = new File(attchMentFile.getSavepath() + "/"
				+ attchMentFile.getUploadrealname());
		if (file.exists()) {
			file.delete();
		}
		return null;
	}

	public File getFiledata() {
		return Filedata;
	}

	public void setFiledata(File filedata) {
		Filedata = filedata;
	}

	public String getFiledataFileName() {
		return FiledataFileName;
	}

	public void setFiledataFileName(String filedataFileName) {
		FiledataFileName = filedataFileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getSaveRulePath() {
		return saveRulePath;
	}

	public void setSaveRulePath(String saveRulePath) {
		this.saveRulePath = saveRulePath;
	}

	public AttchMentService getAttchMentService() {
		return attchMentService;
	}

	public void setAttchMentService(AttchMentService attchMentService) {
		this.attchMentService = attchMentService;
	}

	public CcUploadFilesDto getAttchMentFile() {
		return attchMentFile;
	}

	public void setAttchMentFile(CcUploadFilesDto attchMentFile) {
		this.attchMentFile = attchMentFile;
	}

	public List<CcUploadFilesDto> getAttchMentFiles() {
		return attchMentFiles;
	}

	public void setAttchMentFiles(List<CcUploadFilesDto> attchMentFiles) {
		this.attchMentFiles = attchMentFiles;
	}


	public String getModuleid() {
		return moduleid;
	}

	public void setModuleid(String moduleid) {
		this.moduleid = moduleid;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getIsorigin() {
		return isorigin;
	}

	public void setIsorigin(String isorigin) {
		this.isorigin = isorigin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}





}
