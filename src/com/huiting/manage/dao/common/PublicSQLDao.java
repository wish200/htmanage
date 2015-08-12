package com.huiting.manage.dao.common;

import java.util.List;

import com.huiting.manage.dto.base.CdDataSourceBaseDto;
import com.huiting.manage.dto.base.CdIdxCatgoryBaseDto;
import com.huiting.manage.dto.common.SearchDto;

/**
 * @ClassName: BaseSQLDao
 * @Description: 针对baseSQLMapper ，只查询不会出现修改等操作
 * @author Zou_ZhuoQi
 * @date 2013-12-22 下午1:33:59
 */
public interface PublicSQLDao extends BaseDao<Object, String> {
	/**
	 * 
	 * @Title: getCdTemplateCatnoList
	 * @Description: 查询模板类型表
	 * @param @return
	 * @return List<Object>
	 * @throws
	 */
	public List<Object> getCdTemplateCatnoList(SearchDto searchDto);

	public List<CdDataSourceBaseDto> getDataSoureList(SearchDto searchDto);

	public List<CdIdxCatgoryBaseDto> getIdxCatgoryList(SearchDto searchDto);
}
