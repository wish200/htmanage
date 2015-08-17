package com.huiting.manage.services.common;



import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.huiting.manage.dto.common.SearchDto;

public interface HSSFFileCreateService {

	void CreateXslFile(HSSFWorkbook hssfWorkbook, List<SearchDto> searchDtos);
	/**
	 * 根据页面传来的表格创建EXCEL文档
	 * @param hssfWorkbook
	 * @param htmlData
	 * @param htmlTitle 
	 */
	void CreateXslFileToHtml(HSSFWorkbook hssfWorkbook, String htmlData, String htmlTitle)throws Exception;

}
