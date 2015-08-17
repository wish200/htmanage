package com.huiting.manage.action.common;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.google.gson.Gson;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.common.BaseService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @ClassName: BaseAction
 * @Description: 基础action类
 * @author Zou_ZhuoQi
 * @date 2013-12-13 下午3:01:23
 * 
 */
public class BaseAction extends ActionSupport implements SessionAware,
		ServletResponseAware, ServletRequestAware {
	private String systemURL;// http://12.12.12.12:8080/risk

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(BaseAction.class);

	protected Map<String, Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected BaseService baseService;
	protected SearchDto searchDto;

	// 返回值常量
	protected static final String LIST = "list";// 查询集合
	protected static final String VIEW = "view";// 单个查询
	protected static final String EDIT = "edit";// 修改
	protected static final String DELETE = "delete";// 删除
	protected static final String SAVE = "save";// 保存

	// header 常量定义//
	private static final String ENCODING_DEFAULT = "UTF-8";

	// content-type 定义 //
	private static final String TEXT = "text/plain";
	private static final String JSON = "application/json";
	private static final String XML = "text/xml";
	private static final String HTML = "text/html";

	/**
	 * logout，login等操作之前清除session中所有数据
	 */
	public void clearSession() {
		if (session != null) {
			session.clear();
		}
	}

	/**
	 * @Title: render
	 * @Description: 直接输出内容的简便函数.
	 * @param contentType
	 * @param content
	 * @return void
	 */
	public static void render(final String contentType, final String content) {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			// 设置headers参数
			String fullContentType = contentType + ";charset="
					+ ENCODING_DEFAULT;
			response.setContentType(fullContentType);
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);

			response.getWriter().write(content);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 直接输出文本.
	 * 
	 * @see #render(String, String)
	 * */
	public static void renderText(final String text) {
		render(TEXT, text);
	}

	/**
	 * 直接输出HTML.
	 * 
	 * @see #render(String, String)
	 */
	public static void renderHtml(final String html) {
		render(HTML, html);
	}

	/**
	 * * 直接输出XML.
	 * 
	 * @see #render(String, String, String...)
	 */
	public static void renderXml(final String xml) {
		render(XML, xml);
	}

	/**
	 * 
	 * @Title: renderJson
	 * @Description: 接输出JSON
	 * @param string
	 *            json字符串
	 * @see #render(String, String)
	 * @param headers
	 * @return void
	 */
	public static void renderJson(final String jsonString) {
		render(JSON, jsonString);
	}

	/**
	 * @Title: renderJson
	 * @Description: 直接输出JSON
	 * @param map
	 *            Map对象,将被转化为json字符串
	 * @see #render(String, String, String...)
	 * @param headers
	 * @return void
	 */
	public static void renderJson(@SuppressWarnings("rawtypes") final Map map) {
		Gson gson = new Gson();
		String jsonString = gson.toJson(map);
		render(JSON, jsonString);
	}

	/**
	 * @Title: renderJson
	 * @Description: 直接输出JSON.
	 * @param object
	 *            Java对象,将被转化为json字符串.
	 * @see #render(String, String, String...)
	 * @param headers
	 * @return void
	 */
	public static void renderJson(final Object object) {
		Gson gson = new Gson();
		String jsonString = gson.toJson(object);
		render(JSON, jsonString);
	}

	public static String getRootPath() {
		String classPath = null;
		try {
		// toURI() 20% to 空格
			
		classPath = BaseAction.class.getClassLoader().getResource("").toURI().getPath();
		} catch (URISyntaxException e) {
		e.printStackTrace();
		}
		String rootPath = "";
		// windows下
		if ("\\".equals(File.separator)) {
		rootPath = classPath.substring(1, classPath.indexOf("/WEB-INF/classes"));
		rootPath = rootPath.replace("/", "\\");
		}
		// linux下
		if ("/".equals(File.separator)) {
		rootPath = classPath.substring(0, classPath.indexOf("/WEB-INF/classes"));
		rootPath = rootPath.replace("\\", "/");
		}
		return rootPath + File.separator;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}

	public String getSystemURL() {
		systemURL = request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath() + "/";
		return systemURL;
	}

}