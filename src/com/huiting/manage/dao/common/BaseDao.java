package com.huiting.manage.dao.common;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: BaseDao
 * @Description: 底层基本的dao的接口
 * @author Zou_ZhuoQi
 * @date 2013-12-19 下午2:20:56
 * 
 * @param <T>
 * @param <PK>
 */
public interface BaseDao<T, PK> {

	/**
	 * 保存单一对象，如果要保存多个对象集合，请参看{@link #insertList(List)}
	 * 
	 * @param entity
	 */
	public T insert(T entity);

	/**
	 * 保存指定类型的对象集合,如果要保存单一对象，请参看{@link #insert(Object)}
	 * 
	 * @param entities
	 *            要保存的数据集合
	 * @return
	 */
	public List<T> insertList(List<T> entities);

	/**
	 * 更新对象,如果属性为空，则不会进行对应的属性值更新,如果有属性要更新为null，请参看{@link #updateNull(Object)}
	 * 
	 * @param entity
	 *            要更新的实体对象
	 */
	public int update(T entity);

	/**
	 * 更新对象,如果属性为空，会进行对应的属性值更新,如果有属性不想更新为null，请参看{@link #update(Object)}
	 * 
	 * @param entity
	 */
	public void updateNull(T entity);

	/**
	 * 根据id删除对象
	 * 
	 * @param id
	 */
	public void deleteById(PK id);

	/**
	 * 根据条件集合删除对象
	 * 
	 * @param id
	 */
	public void deleteByCondition(Map<String, Object> condition);

	/**
	 * 根据属性和属性值删除对象
	 * 
	 * @param id
	 */
	public void deleteByCondition(String property, Object value);

	/**
	 * 根据id进行对象查询
	 * 
	 * @param id
	 * @return
	 */
	public T fetch(PK id);

	/**
	 * 根据条件集合进行分页查询
	 * 
	 * @param condition
	 *            查询条件
	 * @param currentPage
	 *            当前页数
	 * @param pageSize
	 *            页面大小
	 * @return 返回Pager对象
	 * 
	 *         public page<T> queryPage(Map<String, Object> condition, Integer
	 *         currentPage, Integer pageSize);
	 */

	/**
	 * 根据当前id进行详情分页
	 * 
	 * @param condition
	 *            分页查询的条件
	 * @param id
	 *            当前id
	 * @return 返回当前对象，上一个对象，下一对象
	 * 
	 *         public DetailsPager<T> queryDetailsPage(Map<String, Object>
	 *         condition, PK id);
	 */
	/**
	 * 根据任意属性和属性值进行对象模糊查询
	 * 
	 * @param property
	 *            进行对象匹配的属性
	 * @param value
	 *            进行对象匹配的模糊属性值
	 * @return
	 */
	public List<T> like(String property, Object value);

	/**
	 * 根据条件进行数量的查询
	 * 
	 * @param condition
	 * @return 返回符合条件的泛型参数对应表中的数量
	 */
	public int count(Map<String, Object> condition);

	/**
	 * 该方法只有在主键为int时才有用，如果主键为其他数据类型进行使用，则会抛出异常
	 * 
	 * @name selectMaxId
	 * @active 查询实体对应表最大Id
	 * @time 上午10:04:05
	 * @return 返回泛型参数对应表的主键最大值
	 */
	public String selectMaxId();

	/**
	 * 更新或保存，涉及到Mabatis使用的bean只是一个简单的值对象，不能进行id的注解，不知道哪个是主键，所以，必须同时指定t的主键值
	 * 
	 * @param t
	 *            要更新或保存的对象
	 * @param id
	 *            要更新或保存的对象的id
	 * @return 返回更新或保存的对象。
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 */
	public T updateOrSave(T t, PK id);

	/**
	 * @Description: 根据泛型类型，执行最原始的sql
	 * 
	 * @param mapperId
	 *            调用Mapper中的SQL id
	 * @param condition
	 *            Map,查询对象传输
	 * @return 返回泛型类型对象，如果返回多个结果集会抛出异常，如果要返回多个结果集，请参看
	 *         {@link #selectList(String, String)}
	 */
	public T selectOne(String mapperId, Map<String, Object> condition);

	/**
	 * 
	 * @Description: 条件为单个对象，根据条件集合进行指定类型单一对象查询
	 * @param property
	 *            Map:Key
	 * @param value
	 *            Map:value
	 * @return T
	 * @throws
	 */
	public T selectOne(String property, Object value);
	public Object selectOneUser(String property, Object value);
	public Object selectOnePicbook(String property, Object value) ;
	public Object selectOneAudio(String property, Object value) ;
	public Object selectOneObject(String mapperid,String property, Object value) ;
	/**
	 * 
	 * @Title: selectOne
	 * @Description: 条件为单个、多个传送对象，根据条件集合进行指定类型单一对象查询
	 * @param @param condition
	 * @param @return
	 * @return T
	 * @throws
	 */
	public T selectOne(Map<String, Object> condition);

	/**
	 * 
	 * @Description: 最底层查询集合方法
	 * @param @param mapperId 调用Mapper中的SQL id
	 * @param @param condition 查询集合
	 * @param @param orderBy 排序字段
	 * @param @param sortBy 排序方法
	 * @param @return
	 * @return List<T>
	 * @throws
	 */
	public List<T> selectList(String mapperId, Map<String, Object> condition,
			String orderBy, String sortBy);

	public List<T> selectList();

	/**
	 * @Description ：根据泛型类型，执行最原始的sql
	 * @param mapperId
	 *            调用Mapper中的SQL id
	 * @param condition
	 *            ：查询条件
	 * @return 返回泛型类型对象集合，如果要返回单个结果对象，请参看{@link #selectOne(String, String)}
	 */
	public List<T> selectList(String mapperId, Map<String, Object> condition);

	/**
	 * @Description: 默认调用Mapper中的SQL id: selectList
	 * @param @param condition ：查询条件
	 * @return List<T>
	 */
	public List<T> selectList(Map<String, Object> condition);

	/**
	 * 
	 * @Description: 条件只是单个的对象，默认调用Mapper中的SQL id: selectList
	 * @param @param property Map：Key
	 * @param @param value Map:Value
	 * @return List<T>
	 */
	public List<T> selectList(String property, Object value);

	/**
	 * 取得泛型类型
	 * 
	 * @return
	 */
	public Class<T> getEntityClass();

	/**
	 * 设置泛型类型
	 * 
	 * @return
	 */
	public void setEntityClass(Class<T> entityClass);

}