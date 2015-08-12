package com.huiting.manage.system.flashxmlutil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
public class GeneraterSingleGraphXML {
	
	private static void getSetLabel(StringBuilder sb,Map<String, Object> map,String[] colorList,Boolean isSetColer,int i){
		if (colorList != null) {
             sb.append("<set  isSliced='1' label='").append(map.get(Constants.LABEL)).append("' value='")
                     .append(map.get(Constants.VALUE)).append("' COLOR='").append(colorList[i]).append("'/>");
         }else if(isSetColer){
         	sb.append("<set isSliced='1'   label='").append(map.get(Constants.LABEL)).append("'  value='").append(map.get(Constants.VALUE)).append("'/>");
         }else {
         	String color="";
         	int compare=0;
         	String vale=map.get(Constants.VALUE).toString();
         	if(vale.startsWith(".")){
         		vale="0"+vale;
         		compare=vale.compareTo("0");
         	}else {
         		compare=vale.compareTo("0");
				}
         	
         	if(compare>0){
         		color="00FF99";
         	}else if(compare<0){
         		color="ffc0cb";
				}else if(compare==0){
         		color="000000";
				}
             sb.append("<set  isSliced='1' label='").append(map.get(Constants.LABEL)).append("' COLOR='").append(color).append("' value='").append(map.get(Constants.VALUE)).append("'/>");
         }
		
	}
    /**
     *
     * @param caption 标题
     * @param dataList 数据List里面是Map key:Constant.LABEL为显示的轴 Constant.VALUE为值
     * @param line 标注线
     * @param stylelist 样式
     * @param applist 应用list
     * @return
     */
    private static String getLineAndColContext(String caption, String[] colorList,Boolean isSetColer, List<Map<String, Object>> dataList, String line, List<String> stylelist, List<String> applist,Boolean dataOrder) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version='1.0' encoding='UTF-8'?>");
        sb.append("<chart ").append(caption).append(" >");
        if (dataList != null) {
            Map<String, Object> map = null;
            if(dataOrder){
            	for (int i=0;i<dataList.size(); i++) {
                    map = dataList.get(i);
                    getSetLabel(sb,map,colorList,isSetColer,i);
                }
            }else {
            	for (int i=dataList.size() - 1 ; i >= 0; i--) {
                    map = dataList.get(i);
                    getSetLabel(sb,map,colorList,isSetColer,i);
                }
			}
            
        }
        if (line != null) {
            sb.append("<trendLines>");
            sb.append("<line ").append(line).append("  />");
            sb.append("</trendLines>");
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
    /**
     * 生成单折线.单柱.图饼图.配置文件XML
     *
     * @param caption 标题
     * @param dataList 数据List里面是Map key:Constant.LABEL为显示的轴 Constant.VALUE为值
     * @param line 标注线
     * @param stylelist 样式
     * @param applist 应用list
     * @param file 生成的文件
     * @param deletsfile 删除的文件
     */
    public static String generateLineAndColXML(String caption, String[] colorList,Boolean isSetColer, List<Map<String, Object>> dataList, String line, List<String> stylelist, List<String> applist,Boolean dataOrder) {
        String context = getLineAndColContext(caption, colorList,isSetColer, dataList, line, stylelist, applist,dataOrder);
        return context;
    }
    /**
     * 生成单折线.单柱.图饼图.配置文件XML
     *
     * @param caption 标题
     * @param dataList 数据List里面是Map key:Constant.LABEL为显示的轴 Constant.VALUE为值
     * @param line 标注线
     * @param stylelist 样式
     * @param applist 应用list
     * @param file 生成的文件
     * @param deletsfile 删除的文件
     */
    public static String generateLineAndColXML(String caption, String[] colorList,Boolean isSetColer, List<Map<String, Object>> dataList, String line, List<String> stylelist, List<String> applist) {
        String context = getLineAndColContext(caption, colorList,isSetColer, dataList, line, stylelist, applist,false);
        return context;
    }
    /**
     * 生成单折线.单柱.图饼图.配置文件XML
     *
     * @param caption 标题12
     * @param dataList 数据List里面是Map key:Constant.LABEL为显示的轴 Constant.VALUE为值
     * @param line 标注线
     * @param stylelist 样式
     * @param applist 应用list
     * @param file 生成的文件
     * @param deletsfile 删除的文件
     */
    public static String generateLineAndColXML(String caption, String[] colorList, List<Map<String, Object>> dataList, String line, List<String> stylelist, List<String> applist) {
    	String context = getLineAndColContext(caption, colorList,false, dataList, line, stylelist, applist,false);
        return context;
    }

    /**
     * 生成单折线.单柱.图饼图.配置文件XMLque
     *
     * @param caption 标题
     * @param dataList 数据List里面是Map key:Constant.LABEL为显示的轴 Constant.VALUE为值
     * @param stylelist 样式
     * @param applist 应用list
     * @param file 生成的文件
     * @param deletsfile 删除的文件
     */
    public static String generateLineAndColXML(String caption, List<Map<String, Object>> dataList, List<String> stylelist, List<String> applist) {
        return generateLineAndColXML(caption, null, dataList, null, stylelist, applist);
    }
    

    /**
     * 生成单折线.单柱.图饼图.配置文件XML
     *
     * @param caption 标题
     * @param dataList 数据List里面是Map key:Constant.LABEL为显示的轴 Constant.VALUE为值
     * @param stylelist 样式
     * @param applist 应用list
     * @param colorList 颜色的list
     * @param file 生成的文件
     * @param deletsfile 删除的文件
     */
    public static String generateLineAndColXML(String caption, String[] colorList, List<Map<String, Object>> dataList, List<String> stylelist, List<String> applist) {
        return generateLineAndColXML(caption, colorList, dataList, null, stylelist, applist);
    }

    /**
     * 生成单折线.单柱.图饼图.配置文件XML
     *
     * @param caption 标题
     * @param dataList 数据List里面是Map key:Constant.LABEL为显示的轴 Constant.VALUE为值
     * @param stylelist 样式
     * @param applist 应用list
     * @param colorList 颜色的list
     * @param file 生成的文件
     * @param deletsfile 删除的文件
     */
    public static String generateLineAndColXML(String caption, List<Map<String, Object>> dataList, String line, List<String> stylelist, List<String> applist) {
        return generateLineAndColXML(caption, null, dataList, line, stylelist, applist);
    }
    public static void main(String[] args) {
		String s=".45";
		System.out.println(s.compareTo("0"));
	}
	public static String generateLineAndColXMLQ(String caption,
			List<Map<String, Object>> dataList, List<String> stylelist,
			List<String> applist) {
		return generateLineAndColXMLQ(caption, null, dataList, null, stylelist, applist);
	}
	public static String generateLineAndColXMLQ(String caption, String[] colorList, List<Map<String, Object>> dataList, String line, List<String> stylelist, List<String> applist) {
    	String context = getLineAndColContext(caption, colorList,false, dataList, line, stylelist, applist,true);
        return context;
    }
}
