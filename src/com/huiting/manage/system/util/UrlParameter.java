package com.huiting.manage.system.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
/**
 * 
* @ClassName: UrlParameter 
* @Description: 获取访问路径中的参数
* @author Niu_ChunPing
* @date 2014-1-10 下午5:15:35
 */
public class UrlParameter {
	/**
	 * 
	* @Title: getUrlParameter 
	* @Description:  获取访问路径中的参数
	* @param @param request
	* @param @return    
	* @return String  
	* @throws
	 */
	@SuppressWarnings("rawtypes")
	public static String getUrlParameter(HttpServletRequest request,List<String> filter){
		Map map=request.getParameterMap();
	   	 StringBuilder paraList = new StringBuilder("");
	   	if(map!=null){
	   		int mapsize = map.size();
	           String key;
	           String value;
	           Object[] keyValuePairs2 = map.keySet().toArray();
	           for (int i = 0; i < mapsize; i++) {
	               key = keyValuePairs2[i].toString();
	               value = request.getParameter(key);
	               	boolean flag=true;
	               	 if(filter!=null){
	               		 for(int k=0;k<filter.size();k++){
	               			if(key.equals(filter.get(k))){
	               				flag=false;
	               			} 
	               		 } 
	               		if(flag){
	 	                   if (paraList.length() == 0) {
	 	                       paraList.append("?").append(key).append("=").append(value);
	 	                   } else {
	 	                       paraList.append("&").append(key).append("=").append(value);
	 	                   }
	 	               	 }
	               	 }else {
	               		if (paraList.length() == 0) {
	 	                       paraList.append("?").append(key).append("=").append(value);
	 	                 } else {
	 	                       paraList.append("&").append(key).append("=").append(value);
	 	                 }
					}
	               	 
	           }
	   	}
		return paraList.toString();
	}

	public static String getUrlParameter(HttpServletRequest request){
		return getUrlParameter(request,null);
	}

}
