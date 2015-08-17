package com.huiting.manage.action.common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class UploadFile {
	private File file;
	private String fileFileName;
	private String fileContentType;
	private String realPath;
	private String fileSaveName;
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getRealPath() {
		return realPath;
	}
	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}
	public String getFileSaveName() {
		String suffix = fileFileName.substring(fileFileName.lastIndexOf("."));
		fileSaveName = file.getName() + suffix;
		return fileSaveName;
	}
	public void setFileSaveName(String fileSaveName) {
		this.fileSaveName = fileSaveName;
	}
	/**
	 * 上传文件
	 * 
	 * @param upFile
	 * @throws Exception
	 */
	public String upLoadFile(File file, String fileFileName,
			String fileContentType,String realPath) throws Exception {
		String newFileName="";
		// 设置上传文件目录
System.out.println("文件名：" + fileFileName);
System.out.println("文件类型：" + fileContentType);
		if (file != null) {
			// 文件的保存路径
			String realpath = realPath;
System.out.println("文件的保存路径：" + realpath);
			// 文件的后缀
			String suffix = fileFileName.substring(fileFileName
					.lastIndexOf("."));
			// 上传以后,会重命名文件的名称,将其命名为全部是数字的文件名,防止可能出现的乱码.
			System.out.println("文件：" + file.getName());
			newFileName = file.getName().replaceAll(".tmp", "") + suffix;
			File savefile = new File(new File(realpath), newFileName);
			// 如果保存的路径不存在,则新建
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			try {
				// 复制文件
				FileUtils.copyFile(file, savefile);
System.out.println("文件上传成功"+savefile.getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
System.out.println("文件上传失败");
			}
		}
		return newFileName;
	}

	/**
	 * 上传文件
	 * @return
	 */
	public String upLoadFile(){
		String newFileName = "";
		if (file != null) {
			String suffix = fileFileName.substring(fileFileName.lastIndexOf("."));
			newFileName = file.getName() + suffix;
			File savefile = new File(new File(realPath), newFileName);
			if (!savefile.getParentFile().exists()){
				savefile.getParentFile().mkdirs();
			}
			try {
				// 复制文件
				FileUtils.copyFile(file, savefile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return newFileName;
	}
	
	/**
	 * 删除上传文件
	 * @return
	 */
	public static void deleteUpLoadFile(String pathFile){
		File file = new File(pathFile);
		if (file.exists()){
			file.delete();
		}
	}
}
