/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huiting.manage.system.flashxmlutil;

import java.util.List;
import java.util.Map;

import com.huiting.manage.system.util.Constants;


/**
 * <p>生成线柱图.多线图.多柱图.配置文件XML</p>
 * <strong></strong>
 *
 * @author wanghailong
 * @version 1.0
 * @date 2013-05-08
 */
public class GenerateGraphXMl {
    
    
    /**
     *  生成线柱图多线图多柱图xml内容
     * @param caption 标题样式
     * @param XNamedata List<String> X轴显示的年月数据 里面是map .dataset 下面的标题值 ，set为list是各个值
     * @param dataList List<Map<String,Object>> 数据值List集合，里面是Map，key为dataset里面放的是数据类型，key为set 里面放的是值
     * @param stylelist 样式集合
     * @param applist 使用样式集合
     * @return
     */
    public static String getLineAndColContext(String caption,List<String> XNamedata,List<Map<String,Object>> dataList,List<String> stylelist,List<String> applist){
    	StringBuilder sb = new StringBuilder();
    	 sb.append("<chart ").append(caption).append(" >");
    	 if(XNamedata!=null){
    		 sb.append("<categories>");
    		 for(int i=XNamedata.size()-1;i>=0;i--){
    			 sb.append(" <category name='").append(XNamedata.get(i)).append("' />");
    		 }
    		 sb.append("</categories>");
    	 }
    	 if(dataList!=null){
    		 Map<String, Object> map=null;
    		 for(int i=0;i<dataList.size();i++){
    			 map=dataList.get(i);
    			 sb.append("<dataset ").append( map.get(Constants.DATA_SET)).append(" >");
    			 @SuppressWarnings("unchecked")
				List<String> setList=(List<String>) map.get(Constants.SET);
/*    			 if(i==0){
    				 for(int j=setList.size()-1;j>=0;j--){
        				 sb.append("<set value='").append(setList.get(j)).append("' 	showValue='1' />");
        			 } 
    			 }else {*/
    				 for(int j=setList.size()-1;j>=0;j--){
        				 sb.append("<set value='").append(setList.get(j).toString()).append("' 	 />");
        			}
    				 /* }
    			 */
    			 sb.append(" </dataset>");
    		 }
    	 }
    	 //样式
    	 if(stylelist!=null){
    		 sb.append("<styles> <definition>");
    		 for(int i=stylelist.size()-1;i>=0;i--){
    			 sb.append("<style ").append(stylelist.get(i)).append(" />");
    		 }
    		 sb.append("</definition>");
    		 if(applist!=null){
    			 sb.append("<application>");
    			 for(int i=0;i<applist.size();i++){
    				 sb.append("<apply ").append(applist.get(i)).append(" />");
    			 }
    			 sb.append("</application>");
    		 }
    		 sb.append("</styles>");
    	 }
    	 sb.append("</chart>");
    	return sb.toString();
    }
    
  
}
