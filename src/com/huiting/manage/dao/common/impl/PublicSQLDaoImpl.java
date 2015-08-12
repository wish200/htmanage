package com.huiting.manage.dao.common.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.PublicSQLDao;
import com.huiting.manage.dto.base.CdDataSourceBaseDto;
import com.huiting.manage.dto.base.CdIdxCatgoryBaseDto;
import com.huiting.manage.dto.common.SearchDto;

/**
 * @ClassName: PublicSQLDaoImpl
 * @Description: 针对baseSQLMapper ，只查询不会出现修改等操作
 * @author Zou_ZhuoQi
 * @date 2013-12-22 下午1:35:42
 */
@Repository("publicSQLDaoImpl")
public class PublicSQLDaoImpl extends BaseDaoImpl<Object, String> implements
		PublicSQLDao {

	public PublicSQLDaoImpl() {
		super.setSqlmapNamespace("baseSQLMapper");
	}

	@Override
	public List<Object> getCdTemplateCatnoList(SearchDto searchDto) {
		return sqlSession.selectList("baseSQLMapper.getCdTemplateCatnoList", searchDto);
	}

	@Override
	public List<CdDataSourceBaseDto> getDataSoureList(SearchDto searchDto) {
		return sqlSession.selectList("baseSQLMapper.getDataSoureList", searchDto);
	}
	/**
	  * @Description: 因子大类名称 
	  * @param @param searchDto
	 */
	@Override
	public List<CdIdxCatgoryBaseDto> getIdxCatgoryList(SearchDto searchDto) {
		return sqlSession.selectList("baseSQLMapper.getIdxCatgoryList", searchDto);
	}
}
