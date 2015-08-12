package com.huiting.manage.dto.sysconfig;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.type.Alias;

import com.huiting.manage.dto.base.CcUserBaseDto;
import com.huiting.manage.system.util.EmailCountTextUtil;

/**
 * 邮件发送DTO
 * @author ncp
 *
 */
@Alias("emailSendDto")
public class EmailSendDto implements Serializable{
 
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 private List<CcUserBaseDto> ccUserBaseDtos;
 private String newdepcode;//部门代码
 private String depname;//部门名称
 private String bodyoftempl;//内容
 private String headoftempl;//标题
 private String statdate;//数据期次
 private List<String> indexnames;//指标名称
 	
	public List<CcUserBaseDto> getCcUserBaseDtos() {
		return ccUserBaseDtos;
	}
	public void setCcUserBaseDtos(List<CcUserBaseDto> ccUserBaseDtos) {
		this.ccUserBaseDtos = ccUserBaseDtos;
	}
	public String getNewdepcode() {
		return newdepcode;
	}
	public void setNewdepcode(String newdepcode) {
		this.newdepcode = newdepcode;
	}
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	public String getBodyoftempl() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
		Map<String, String> map=new HashMap<String, String>();
		map.put("DATE", sdf.format(new Date()));
		if(statdate!=null&&indexnames!=null){
			map.put("YYYY", statdate.substring(0, 4));
			map.put("MM",  statdate.substring(4, 6));
			String index="";
			if(indexnames!=null){
				for (int i = 0; i < indexnames.size();i++) {
					if(index.indexOf(indexnames.get(i))==-1){
						index+=indexnames.get(i)+",";
					}
				}
				index=index.substring(0, index.length()-1);
			}
			map.put("XX",index);
		}
		return bodyoftempl==null?null:EmailCountTextUtil.getCountText(bodyoftempl, map);
	}
	public void setBodyoftempl(String bodyoftempl) {
		this.bodyoftempl = bodyoftempl;
	}
	public String getHeadoftempl() {
		return headoftempl;
	}
	public void setHeadoftempl(String headoftempl) {
		this.headoftempl = headoftempl;
	}
	public String getStatdate() {
		return statdate;
	}
	public void setStatdate(String statdate) {
		this.statdate = statdate;
	}
	public List<String> getIndexnames() {
		return indexnames;
	}
	public void setIndexnames(List<String> indexnames) {
		this.indexnames = indexnames;
	}
	
}
