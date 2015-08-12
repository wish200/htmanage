package com.huiting.manage.system.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 邮箱内容替换
 * @author ncp
 *
 */
public class EmailCountTextUtil{
	public static Map<String,String> getMap(Map<String,String> replaceMap){
		Map<String, String> map=new HashMap<String, String>();
		map.put("\\*\\*年", "");
		map.put("\\*\\*期次", "");
		map.put("\\*\\*月", "");
		map.put("\\*\\*指标", "");
		return map;
	}
	public static String  getCountText(String countText,Map<String, String> map){
		int mapsize=map.size();
		Object[] set=map.keySet().toArray();
		String key;
		for(int i=0;i<mapsize;i++){
			key=set[i].toString();
			countText=countText.replaceAll(key, map.get(key));
		}
		return countText;
	}
	public static void main(String[] args) {
		String count= "您好：**指标按照保监会及集团公司数据上报时间要求，**年**月（**年**期次）数据报送工作已接近上报时限，请您尽快登录风险管理信息平台（http://10.133.217.28:7001/risk/），点击“数据采集报送”，选择“手工填报”，填报“指标/因子值”，如需要对因子解释说明请在“备注”中填写。同时，请确认数据已经过部门领导审核，并核对数据填报是否准确，在您保存并提交后，数据将不能修改。系统使用过程中如有任何疑问，请联系合规部风险管理处联系人：李朔（6785）";
		Map<String, String> map=new HashMap<String, String>();
		map.put("\\*\\*年", "2014年");
		map.put("\\*\\*期次", "08期次");
		map.put("\\*\\*月", "08月");
		map.put("\\*\\*指标", "--------");
		System.out.println(getCountText(count,map));
	}

}
