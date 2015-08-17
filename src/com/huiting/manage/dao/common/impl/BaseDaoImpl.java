package com.huiting.manage.dao.common.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.BaseDao;
import com.huiting.manage.system.util.NumberUtil;

/**
 * @ClassName: BaseDaoImpl
 * @Description: DAO层泛型基类，实现了基本的DAO功能
 * @author Zou_ZhuoQi
 * @date 2013-12-19 上午11:10:07
 * 
 */
@SuppressWarnings("unchecked")
@Repository("baseDaoImpl")
public class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {
	@Resource(name = "sqlSession")
	protected SqlSession sqlSession;
	// 命名空间
	private String sqlmapNamespace = "";

	public static Logger logger = Logger.getLogger(BaseDaoImpl.class);

	private Class<T> entityClass = null;

	/**
	 * 创建默认构造方法，以取得真正的泛型类型
	 */
	public BaseDaoImpl() {
		Class<?> c = getClass();
		Type type = c.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] parameterizedType = ((ParameterizedType) type)
					.getActualTypeArguments();
			entityClass = (Class<T>) parameterizedType[0];
		}

	}

	// 保存实体对象
	@Override
	public T insert(T entity) {
		String sqlUrl = sqlmapNamespace + ".insert";
		logger.debug("SQL调用地址：" + sqlUrl);
		sqlSession.insert(sqlUrl, entity);
		return entity;
	}

	@Override
	public List<T> insertList(List<T> entities) {
		int sizeBatch = 1000;
		int size = entities.size();
		int fromIndex = 0;
		int toIndex = 0;
		int len = (int) Math.ceil(NumberUtil.divideD(size, sizeBatch));
		List<T> tempEnt = new ArrayList<T>();
		for (int i = 0; i < len; i++) {
			fromIndex = i * sizeBatch;
			toIndex = fromIndex + sizeBatch;
			if (toIndex > size) {
				toIndex = size;
			}
			tempEnt = entities.subList(fromIndex, toIndex);
			sqlSession.insert(sqlmapNamespace + ".insertList", tempEnt);
		}
		return entities;

	}

	// 根据id删除某个对象
	@Override
	public void deleteById(PK id) {
		String sqlUrl = sqlmapNamespace + ".deleteById";
		logger.debug("SQL调用地址：" + sqlUrl);
		sqlSession.delete(sqlUrl, id);
	}

	@Override
	public void deleteByCondition(Map<String, Object> condition) {
		String sqlUrl = sqlmapNamespace + ".deleteByCondition";
		logger.debug("SQL调用地址：" + sqlUrl + "  参数内容" + condition.toString());
		sqlSession.delete(sqlUrl, condition);
	}

	@Override
	public void deleteByCondition(String property, Object value) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put(property, value);
		deleteByCondition(condition);
	}

	// 更新
	@Override
	public int update(T entity) {
		logger.debug("更新" + entity.getClass().getName() + "对象"
				+ sqlmapNamespace + ".update");
		return sqlSession.update(sqlmapNamespace + ".update", entity);
	}

	@Override
	public void updateNull(T entity) {
		sqlSession.update(sqlmapNamespace + ".updateNull", entity);

	}

	@Override
	public T updateOrSave(T t, PK id) {
		if (null != fetch(id)) {
			update(t);
		} else {
			return insert(t);
		}
		return t;
	}

	// 根据id加载某个对象
	@Override
	public T fetch(PK id) {
		logger.debug("根据id加载对象" + sqlmapNamespace + ".fetch");
		return (T)sqlSession.selectOne(sqlmapNamespace + ".fetch", id);
	}

	@Override
	public T selectOne(Map<String, Object> condition) {
		return selectOne("selectOne", condition);
	}
	public Object selectOneUser(String property, Object value) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put(property, value);
		return selectOne("selectOneUser", condition);
	}
	public Object selectOnePicbook(String property, Object value) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put(property, value);
		return selectOne("selectOnePicbook", condition);
	}
	public Object selectOneAudio(String property, Object value) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put(property, value);
		return selectOne("selectOneAudio", condition);
	}
	public Object selectOneObject(String mapperId,String property, Object value) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put(property, value);
		return selectOne(mapperId, condition);
	}

	@Override
	public T selectOne(String property, Object value) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put(property, value);
		return selectOne("selectOne", condition);
	}

	@Override
	public T selectOne(String mapperId, Map<String, Object> condition) {
		logger.debug("查询某一个对象" + sqlmapNamespace + "." + mapperId);
		return (T)sqlSession
				.selectOne(sqlmapNamespace + "." + mapperId, condition);
	}

	@Override
	public List<T> selectList() {
		return selectList("selectList", null, null, null);
	}

	@Override
	public List<T> selectList(String property, Object value) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put(property, value);
		return selectList("selectList", condition, null, null);
	}

	@Override
	public List<T> selectList(Map<String, Object> condition) {
		return selectList("selectList", condition, null, null);
	}

	@Override
	public List<T> selectList(String mapperId, Map<String, Object> condition) {
		return selectList(mapperId, condition, null, null);

	}

	// 查找所有的对象

	@Override
	public List<T> selectList(String mapperId, Map<String, Object> condition,
			String orderBy, String sortBy) {
		logger.debug("查找对象集合" + sqlmapNamespace + "." + mapperId);
		if (condition == null) {
			condition = new HashMap<String, Object>();
		}
		condition.put("orderBy", orderBy);
		condition.put("sortBy", sortBy);
		return sqlSession.selectList(sqlmapNamespace + "." + mapperId,
				condition);
	}

	@Override
	public List<T> like(String property, Object value) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put(property, value);
		return sqlSession.selectList(sqlmapNamespace + ".like", condition);
	}

	@Override
	public String selectMaxId() {
		return sqlSession.selectOne(sqlmapNamespace + ".selectMaxId");

	}

	@Override
	public int count(Map<String, Object> condition) {
		Integer c  = sqlSession.selectOne(sqlmapNamespace + ".count", condition);
		return c.intValue();
	}

	@Override
	public Class<T> getEntityClass() {
		return entityClass;
	}

	@Override
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * sqlmapNamespace，对应sqlmap.xml中的命名空间
	 * 
	 * @return
	 */
	public String getSqlmapNamespace() {
		return sqlmapNamespace;
	}

	/**
	 * sqlmapNamespace的设置方法
	 * 
	 * @param sqlmapNamespace
	 */
	public void setSqlmapNamespace(String sqlmapNamespace) {
		this.sqlmapNamespace = sqlmapNamespace;
	}
	// 根据查询参数，当前页数，每页显示的数目得到分页列表
	// @Override
	// @Cacheable(value = "ehcache", key =
	// "'queryPage-'+#condition+'-'+#currentPage+'-'+#pageSize")
	// public Pager<T> queryPage(Map<String, Object> condition,
	// Integer currentPage, Integer pageSize) {
	//
	// Pager<T> pager = new Pager<T>(pageSize, count(condition), currentPage);
	//
	// try {
	//
	// if (condition == null) {
	//
	// condition = new HashMap<String, Object>();
	//
	// }
	//
	// condition.put("beginRow",
	// (pager.getCurrentPage() - 1) * pager.getPageSize());
	//
	// condition.put("pageSize", pager.getPageSize());
	//
	// List<T> dataList = this.sqlSession.selectList(
	// sqlmapNamespace + "Mapper.queryList", condition);
	//
	// pager.setDataList(dataList);
	//
	// return pager;
	//
	// } catch (RuntimeException re) {
	//
	// logger.error("findList " + sqlmapNamespace + "failed :{}", re);
	//
	// re.printStackTrace();
	//
	// }
	//
	// return null;
	//
	// }

	// @Override
	// public DetailsPager<T> queryDetailsPage(Map<String, Object> condition, PK
	// id) {
	//
	// T currentObj = fetch(id);
	//
	// if (currentObj != null) {
	//
	// List<PK> ids = sqlSession.selectList(
	// sqlmapNamespace + "Mapper.findIds", condition);
	//
	// int currentObjIndex = ids.indexOf(id);
	//
	// DetailsPager<T> page = new DetailsPager<T>(currentObj);
	//
	// if (currentObjIndex > 0)
	//
	// page.setPreObj(fetch(ids.get(currentObjIndex - 1)));
	//
	// if (currentObjIndex < ids.size() - 1)
	//
	// page.setNextObj(fetch(ids.get(currentObjIndex + 1)));
	//
	// return page;
	//
	// }
	//
	// return null;
	//
	// }

}