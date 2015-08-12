package com.huiting.manage.dto.base;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
/**
  * @ClassName: CcTaskModuleBaseDto
  * @Description: cc_taskmodule
  * @author: zhangyangyang
  * @date 2014-2-20 上午10:20:52
 */
@Alias("ccTaskModuleBaseDto")
public class CcTaskModuleBaseDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private String modulecode;

    private String modulename;

    private String moduleurl;

    private String moduleparm1;

    private String moduleparm2;


    public String getModuleparm1() {
		return moduleparm1;
	}

	public void setModuleparm1(String moduleparm1) {
		this.moduleparm1 = moduleparm1;
	}

	public String getModuleparm2() {
		return moduleparm2;
	}

	public void setModuleparm2(String moduleparm2) {
		this.moduleparm2 = moduleparm2;
	}

	public String getModulecode() {
		return modulecode;
	}

	public void setModulecode(String modulecode) {
		this.modulecode = modulecode;
	}

	public String getModulename() {
		return modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename;
	}

	public String getModuleurl() {
		return moduleurl;
	}

	public void setModuleurl(String moduleurl) {
		this.moduleurl = moduleurl;
	}

}