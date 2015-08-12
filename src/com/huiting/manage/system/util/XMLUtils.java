package com.huiting.manage.system.util;

import org.apache.log4j.Logger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * @ClassName: XMLUtils
 * @Description: 验证XML是否合法
 * @author Zou_ZhuoQi
 * @date 2013-12-19 下午3:17:14
 * 
 */

public class XMLUtils {
	public static Logger logger = Logger.getLogger(XMLUtils.class);

	private XMLUtils() {
	}

	/**
	 * *验证类路径资源中的XML是否合法
	 * 
	 * @param xml
	 *            类路径资源 *
	 * @return 是否验证通过
	 * */
	public static boolean validateXML(String xml) {
		if (!xml.startsWith("/")) {
			xml = "/" + xml;
		}
		String xmlPath = FileUtils.getAbsolutePath("/WEB-INF/classes" + xml);
		try {
			InputStream in = new FileInputStream(xmlPath);
			return validateXML(in);
		} catch (FileNotFoundException ex) {
			logger.error("构造XML文件失败", ex);
		}
		return false;
	}

	/**
	 * *验证类路径资源中的XML是否合法
	 * 
	 * @param in
	 *            XML文件输入流
	 * @return 是否验证通过
	 */
	public static boolean validateXML(InputStream in) {

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setValidating(true);
			DocumentBuilder builder;
			builder = dbf.newDocumentBuilder();
			builder.parse(new InputSource(in));
			return true;
		} catch (ParserConfigurationException e) {
			logger.error("验证XML失败", e);
		} catch (SAXException e) {
			logger.error("验证XML失败", e);
		} catch (IOException e) {
			logger.error("验证XML失败", e);
		}
		return false;
	}
}