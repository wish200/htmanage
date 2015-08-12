package com.huiting.manage.system.util;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * <p>
 * 基于java的API工具封装类
 * </p>
 * <strong>通用工具封装类，对常用处理进行封装</strong>
 * 
 * @author wanghailong
 * @version 1.0 2012-6-12
 * @see 基于java的API工具封装类
 */
public class UtilAPI {

	// log
	private static final Logger log = Logger.getLogger(UtilAPI.class);

	/**
	 * <p>
	 * 将对象转换为String
	 * </p>
	 * <strong>将对象转换为String, NULL返回""</strong>
	 * 
	 * @author wanghailong
	 * @param obj
	 *            对象
	 * @return String
	 */
	public static String turnString(Object obj) {

		if (obj == null) {
			return "";
		}
		String str = String.valueOf(obj);
		return str;
	}

	/**
	 * <p>
	 * 将对象转换为int
	 * </p>
	 * <strong>将对象转换为int, NULL返回0</strong>
	 * 
	 * @author wanghailong
	 * @param obj
	 *            对象
	 * @return int
	 */
	public static int turnInt(Object obj) {
		int i = 0;
		if (obj == null || "".equals(obj.toString().trim())) {
			return i;
		}
		if (obj instanceof Integer) {
			i = (Integer) obj;
		} else if (obj instanceof Long) {
			i = Integer.parseInt(String.valueOf(((Long) obj)));
		} else if (obj instanceof Double) {
			i = (int) ((Double) obj).doubleValue();
		} else {
			String str = obj.toString();
			// 判断是否是浮点数格式，如果是去除小数部分
			if (str.indexOf(".") > -1) {
				str = str.substring(0, str.indexOf("."));
			}
			try {
				i = Integer.valueOf(str);
			} catch (Exception e) {
				// 类型转换异常
				e.printStackTrace();
				log.error(e);
			}
		}
		return i;
	}

	/**
	 * <p>
	 * 将对象转换为Long
	 * </p>
	 * <strong>将对象转换为Long, NULL返回0</strong>
	 * 
	 * @author wanghailong
	 * @param obj
	 *            对象
	 * @return Long
	 */
	public static long turnLong(Object obj) {
		long i = 0;
		if (obj == null || "".equals(obj.toString().trim())) {
			obj = "0";
		}
		if (obj instanceof Long) {
			i = (Long) obj;
		} else if (obj instanceof Double) {
			i = (long) ((Double) obj).doubleValue();
		} else {
			String str = obj.toString();
			// 判断是否是浮点数格式，如果是去除小数部分
			if (str.indexOf(".") > -1) {
				str = str.substring(0, str.indexOf("."));
			}

			try {
				i = Long.valueOf(str);
			} catch (Exception e) {
				// 类型转换异常
				log.error(e);
				e.printStackTrace();
			}
		}
		return i;
	}

	/**
	 * <p>
	 * 将对象转换为Double
	 * </p>
	 * <strong>将对象转换为double, NULL返回0.0</strong>
	 * 
	 * @author wanghailong
	 * @param obj
	 *            对象
	 * @return int
	 */
	public static double turnDouble(Object obj) {
		double i = 0.0;
		if (obj == null || "".equals(obj.toString().trim())) {
			return i;
		}

		String str = obj.toString();
		try {
			i = Double.parseDouble(str);
		} catch (Exception e) {
			// 类型转换异常
			log.error(e);
		}
		return i;
	}

	/**
	 * <p>
	 * 将对象转换为指定小数据位数字符串
	 * </p>
	 * <strong>因为Double类型会以1.1E3方式显示，NULL返回0.0</strong>
	 * 
	 * @author wanghailong
	 * @param obj
	 *            对象
	 * @param decimalPalce
	 *            小数位数
	 * @return String
	 */
	public static String formatDouble(Object obj, int decimalPalce) {
		String s = "0.0";
		if (obj == null || "".equals(obj.toString().trim())) {
			return s;
		}

		String formatType = "#.";
		if (decimalPalce > 0) {
			for (int j = 0; j < decimalPalce; j++) {
				formatType += "0";
			}
		} else {
			formatType += "0";
		}
		String str = obj.toString();
		try {
			DecimalFormat df = new DecimalFormat(formatType);
			s = df.format(Double.parseDouble(str));
			// 将.000转换为0.000
			if (s != null && s.startsWith(".")) {
				s = "0" + s;
			}
		} catch (Exception e) {
			// 类型转换异常
			log.error(e);
		}
		return s;
	}

	/**
	 * <p>
	 * 判断是不是为""或NULL
	 * </p>
	 * <strong>NULL、""返回True，其它返回False</strong>
	 * 
	 * @author wanghailong
	 * @param obj
	 *            对象
	 * @return boolean
	 */
	public static boolean isNull(Object obj) {
		if (obj == null || "".equals(obj)) {
			return true;
		}
		return false;
	}

	/**
	 * <p>
	 * 判断map集合是否为null或empty
	 * </p>
	 * <strong>null或empty返回true，其他返回false</strong>
	 * 
	 * @author wanghailong
	 * @param map
	 * @return
	 */
	public static boolean isMapNull(Map<Object, Object> map) {
		if (map == null || map.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * <p>
	 * 判断集合是否为null或empty
	 * </p>
	 * <strong>null或empty返回true，其他返回false</strong>
	 * 
	 * @author wanghailong
	 * @param list
	 * @return
	 */
	public static boolean isListNull(List<Object> list) {
		if (list == null || list.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * <p>
	 * 处理以逗号相隔的字符串
	 * </p>
	 * <strong>源字符串——以逗号相隔的字符串；目标字符串——以符号','相隔的字符串</strong>
	 * 
	 * @author wanghailong
	 * @param recordIds
	 * @return
	 */
	public static String handleStr(String strs) {
		StringBuilder builder = new StringBuilder();
		// 将源字符串转换正数组类型
		String[] strArr = strs.split(",");
		for (int i = 0; i < strArr.length; i++) {
			String str = strArr[i];
			// 当i != 0时，加上分隔符-','
			if (i != 0) {
				builder.append("','");
			}
			builder.append(str);
		}

		return builder.toString();
	}

	/**
	 * <p>
	 * 功能说明：把Map里的数据为String[]数组的数据，取出来放到对应的KEY中
	 * </p>
	 * <strong>主要用途：页面中的Name="Map.key"处理</strong>
	 * 
	 * @author wanghailong
	 * @param pageActionMap
	 *            : 页面传给ACION里的Map
	 * @return 直接可以用KEY取值的Map
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map mapValueConversion(Map entityMap) {
		Map dataMap = new HashMap();
		if (entityMap != null && entityMap.size() > 0) {

			Set setMap = entityMap.entrySet();
			Iterator itr = setMap.iterator();
			while (itr.hasNext()) {
				Entry entry = (Entry) itr.next();
				String key = turnString(entry.getKey());
				String[] value = null;
				try {
					value = (String[]) entry.getValue();
					if (value != null) {
						if (value.length > 1) {
							String keyValue = "";
							for (int i = 0; i < value.length; i++) {
								String tmp = !isNull(value[i].trim()) ? value[i]
										.trim() : "";
								if (tmp.length() > 0) {
									keyValue = keyValue + tmp + ",";
								}
							}
							// keyValue = removeStartAndEndCommaStr(keyValue);
							dataMap.put(key, keyValue);
						} else {
							dataMap.put(key,
									!isNull(value[0].trim()) ? value[0].trim()
											: "");
						}
					} else {
						dataMap.put(key, "");
					}
				} catch (Exception e) {
					dataMap.put(key, entityMap.get(key));
				}
			}
		}

		return dataMap;
	}
}