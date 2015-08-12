package com.huiting.manage.system.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 
 * @ClassName: PropertiesUtil
 * @Description: Properties文件读取类，用于java类上下文使用
 * @author Zou_ZhuoQi
 * @date 2014-1-2 下午4:50:37
 */
public class PropertiesUtil extends PropertyPlaceholderConfigurer {

	private static Map<String, String> ctxPropertiesMap = new HashMap<String, String>();

	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactoryToProcess,
			Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			if (value == null) {
				value = "";
			}
			try {
				value = new String(value.getBytes("ISO8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			ctxPropertiesMap.put(keyStr, value);
		}

	}

	public static String getVlue(String name) {
		return ctxPropertiesMap.get(name);
	}
}
