package com.huiting.manage.system.flashxmlutil;

import java.util.List;
import java.util.Map;

import com.huiting.manage.system.util.Constants;

/**
 * <p>生成单折线.单柱.图饼图.配置文件XML</p>
 *
 * @author 牛春平
 * @version 1.0
 * @date 2013-07-16
 */
public class GeneraterSingleGraphXMLS {
	
	private static void getSetLabel(StringBuilder sb,Map<String, Object> map,int i){
         	String color="";
         	int compare=0;
         	String vale=map.get(Constants.VALUE).toString();
         	if(vale.startsWith(".")){
         		vale="0"+vale;
         		compare=vale.compareTo("0");
         	}else {
         		compare=vale.compareTo("0");
			}
         	boolean flag=false;
         	if(compare>0){
         		color="00FF99";
         		
         	}else if(compare<0){
         		color="ffc0cb";
         		flag=true;
         	}else if(compare==0){
         		color="000000";
			}
            sb.append("<set ");
            if(flag){
            	sb.append(" displayValue='").append(map.get(Constants.VALUE).toString().replaceAll("-", "")).append("' ");
            }
            sb.append(" label='").append(map.get(Constants.LABEL)).append("' COLOR='").append(color).append("' value='").append(map.get(Constants.VALUE)).append("'/>");
	}
    /**
     *
     * @param caption 标题
     * @param dataList 数据List里面是Map key:Constant.LABEL为显示的轴 Constant.VALUE为值
     * @param line 标注线
     * @param stylelist 样式
     * @param applist 应用list
     * @param lastTop 最后一列的标题
     * @return
     */
    public static String getLineAndColContext(String caption,  List<Map<String, Object>> dataList, List<String> stylelist, List<String> applist, String lastTop) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version='1.0' encoding='UTF-8'?>");
        sb.append("<chart ").append(caption).append(" >");
        if (dataList != null) {
            Map<String, Object> map = null;
            	for (int i=dataList.size() - 1 ; i >= 0; i--) {
                    map = dataList.get(i);
                    getSetLabel(sb,map,i);
                }
            	sb.append("<set label='").append(lastTop).append("' isSum='1' COLOR='00FF99' /> ");
            
        }
        if (stylelist != null) {
            sb.append("<styles> <definition> ");
            for (int i = 0; i < stylelist.size(); i++) {
                sb.append("<style ").append(stylelist.get(i)).append(" />");
            }
            sb.append("</definition> ");
            if (applist != null) {
                sb.append("<application>");
                for (int i = 0; i < applist.size(); i++) {
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
