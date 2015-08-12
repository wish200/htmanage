package com.huiting.manage.dto.common;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.type.Alias;

import com.huiting.manage.system.tag.Page;

/**
 * @ClassName: SearchDto
 * @Description: 查找类实体
 * @author Zou_ZhuoQi
 * @date 2013-12-18 下午1:54:14
 */
@Alias("searchDto")
public class SearchDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/* activity*/
	private String activityid;
	private String activityname;
	private String activitytype;
	private Timestamp activitytime;
	/* channel*/
	private String channelid;
	private String channelname;
	/* channel*/
	private String programid;
	private String programname;
	private Timestamp loadtime;
	/* picbook*/
	private String picbookid;
	private String picbookname;
	private String userid;
	/* audio*/
	private String audioid;
	private String audioname;
	private String nickname;
	/* huiben*/
	private String huibenid;
	
	/* comment*/
	private String commentid;
	private String modular;
	private String busiid;
	private String commenttext;
	/* firstpage*/
	private String id;
	/* user*/
	private String phonenumber;
	
	
	
	/* 指标、代码相关（风险类型、险种、渠道、机构等） */
	private String indexCode;// 指标代码
	private String indexName;//指标名称
	private String lev1RiskCode;// 一级风险代码
	private String lev2RiskCode;// 二级风险代码
	private String lev3RiskCode;// 三级风险代码
	private String levelCode;//风险等级
	private String riskCode;//风险代码
	private String importvalid;//是否是KPI指标
	private String proriskflag;//省级分公司综合风险评级
	private String cenriskflag;//总公司综合风险评级
	/* 因子、代码相关（风险类型、险种、渠道、机构等） */
	private String faccode;// 因子代码
	private String useview;// 用于展示
	private String usegroup;// 用于集团报送
	private String usesupervise;// 用于分类监管
	private String datafromtype;//数据来源
	private String datafrom;
	private String idxcatgorycode;//因子大类代码
    private String facname;//因子名称
	private String veidooType;//风险维度类型
	private String countType;//计数类型--
	
	/* 用户信息相关（） */
	private String userName;// 用户名称
	private String passWord;// 用户密码
	private String userCode;// 用户代码
	private String userValidstatus;// 用户有效状态
	
	
	 public String returnUrl;//返回地址
	 public String returnTowUrl;//返回地址

	/* 数据相关（频率、时间） ** */
	private Date subtime;// 提交时间
	private List<String> lastStatDate;// 指标历史日期集合yyyyMM
	private String statDate;// 预警期次
	private String oldStatDate;//预警期次
	private String inputdate;// 录入日期
	private String moudletype;//模板类型
	 
	
	private String uptype;//文件上传类型

	/* 部门、部门岗位信息相关（主责部门、录入部门、所属部门） */
	private String newDepCode;// 新部门代码---cc_department表用
	private String depCatg;// 部门类型---cc_department表用--分为虚拟和实体部门
	private String departMentName;// 部门名称
	private String deppostype;//岗位类型
	private String depPositionName;// 部门岗位名称
	private String depPositionCode;// 部门岗位代码
	private String entityDepartMent;// cd_dep_vir2ent表中的实体部门代码
	private List<String> dempList;// 实体部门集合
	private Set<String> depcodes;
	private String inputdep;// 录入部门
	private String mainDepMent;// 主责部门
	private String importlev;//部门类型
	private String deptype;//岗位类型---岗位大类型
	/* 附表类型 */
	private String attType;//附表类型
	private String attCode;//附表代码
	private String vfacCode;//附表对应因子代码
	/* 推送任务 */
	private String taskCode;// 推送任务代码
	private String pushState;// 推送状态
	private String changeState;//整改状态
	private String submitstatus;//提交状态
	private int backnums;//整改次数
	/* 其他 */
	private List<String> validstateList;// 状态集合
	/* 重大风险事件 */
	private String startdate;//开始日期
	private String enddate;//结束日期
	private String eventname;//事件名称
	private String comname;//机构名称
	private String infosource;//信息来源
	private String validstate;//效力状态
	/*集体数据报送管理*/
	private String tabletype;//表的类型
	private String  tablename;//表的名称
	private String bksstype;//报送类型
	private String tableuse;//表的用途
	private String busiDt;//风险报送的时间
	private String reportCode;//报表代码
	/** 做什么 */
	private String doing;
	private String handle;//处理任务
	/*风险期刊管理*/
	private String periodicatitle;
	private String periodicatype;
	private Date startDate;
	private Date endDate;
	private String reporttitle;
	private String reporttype;
	//市场风险分位点
	private String quant;//
	private List<String> quants;
	/*系统公告信息*/
	private String systemcode;//系统公告号码
	private String postdesc;//系统公告摘要
	private String remark;//系统公告内容
	/*分类监管评估*/
	private String weigtVlue;//得分
	private String indexVlue;//指标值
	private String chengFaccode;//改变因子状态的字符串
	/** 含有的菜单代码用 ,隔开的 */
	private String haveMenus;
	/** 收藏夹中含有的指标id */
	private String haveDivs;
	/** 菜单id */
	private String menuId;
	/** 菜单名称 */
	private String menuname;
	/** 含有的险种代码 用逗号隔开的 */
	private String havaClassCodes;
	/** 含有的渠道代码 用逗号隔开的 */
	private String havaChannelCodes;
	/** 模板代码 */
	private String templatenum;
	/** 模板类型名称 */
	private String templatecatname;
	/** 模板名称 */
	private String templatename;
	/** 模板名称 */
	private String templatecatno;
	/** 邮件接收人类型 */
	private String rectype;
	/** 所属功能类型 */
	private String moduleid;
	
	private Page page;
	/** 指标类型 */
	private String indType;
	/** 提取频率 */
	private String fetchrate;

	/** 录入状态 */
	private String inputstate;
	/** 是否可计算 */
	private String testdl;
	
	/*** 机构代码 */
	private String comCode;
	/** 比较类型 分为环比和同比 */
	private String compareType;
	/** 险种代码 */
	private String classCode;
	/** 渠道代码 */
	private String channelCode;
	/** 险种代码集合 */
	private List<String> classCodes;
	/** 渠道代码集合 */
	private List<String> channelCodes;
	/** 菜单等级 */
	private int menuLevel;
	/** 含有的一些实体部门代码 */
	private String haveDepCodes;
	/** 部门集合 */
	private List<String> depCodes;
	private String[] arrayDepCodes;
	/** 帮助文档名称*/
	private String helpname;
	/** 指标分为总公司和分公司标志*/
	private List<String> isviewlevel;
	private String startValue;//起始值
	private String spaceValue;//间隔值

	
	

	public Set<String> getDepcodes() {
		return depcodes;
	}

	public void setDepcodes(Set<String> depcodes) {
		this.depcodes = depcodes;
	}

	public String getChengFaccode() {
		return chengFaccode;
	}

	public void setChengFaccode(String chengFaccode) {
		this.chengFaccode = chengFaccode;
	}

	public String getIndexVlue() {
		return indexVlue;
	}

	public void setIndexVlue(String indexVlue) {
		this.indexVlue = indexVlue;
	}

	public String getWeigtVlue() {
		return weigtVlue;
	}

	public void setWeigtVlue(String weigtVlue) {
		this.weigtVlue = weigtVlue;
	}

	public String getStartValue() {
		return startValue;
	}

	public void setStartValue(String startValue) {
		this.startValue = startValue;
	}

	public String getSpaceValue() {
		return spaceValue;
	}

	public void setSpaceValue(String spaceValue) {
		this.spaceValue = spaceValue;
	}

	public List<String> getIsviewlevel() {
		return isviewlevel;
	}

	public void setIsviewlevel(List<String> isviewlevel) {
		this.isviewlevel = isviewlevel;
	}

	public String getHelpname() {
		return helpname;
	}

	public void setHelpname(String helpname) {
		this.helpname = helpname;
	}

	public String[] getArrayDepCodes() {
		return arrayDepCodes;
	}

	public void setArrayDepCodes(String[] arrayDepCodes) {
		this.arrayDepCodes = arrayDepCodes;
	}

	public String getReturnTowUrl() {
		return returnTowUrl;
	}

	public void setReturnTowUrl(String returnTowUrl) {
		this.returnTowUrl = returnTowUrl;
	}

	public int getBacknums() {
		return backnums;
	}

	public void setBacknums(int backnums) {
		this.backnums = backnums;
	}

	public String getSystemcode() {
		return systemcode==null?null:systemcode.trim();
	}

	public String getDeptype() {
		return deptype;
	}

	public void setDeptype(String deptype) {
		this.deptype = deptype;
	}

	public void setSystemcode(String systemcode) {
		this.systemcode = systemcode;
	}

	public String getDatafrom() {
		return datafrom==null?null:datafrom.trim();
	}

	public void setDatafrom(String datafrom) {
		this.datafrom = datafrom;
	}

	public String getChangeState() {
		return changeState;
	}

	public void setChangeState(String changeState) {
		this.changeState = changeState;
	}

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	public String getInputdep() {
		return inputdep;
	}

	public void setInputdep(String inputdep) {
		this.inputdep = inputdep;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getModuleid() {
		return moduleid;
	}

	public String getImportvalid() {
		return importvalid;
	}

	public void setImportvalid(String importvalid) {
		this.importvalid = importvalid;
	}

	public void setModuleid(String moduleid) {
		this.moduleid = moduleid;
	}

	public String getTemplatename() {
		return templatename;
	}

	public void setTemplatename(String templatename) {
		this.templatename = templatename;
	}

	public String getTestdl() {
		return testdl;
	}

	public void setTestdl(String testdl) {
		this.testdl = testdl;
	}

	public String getFaccode() {
		return faccode;
	}

	public void setFaccode(String faccode) {
		this.faccode = faccode;
	}

	public String getInputstate() {
		return inputstate;
	}

	public void setInputstate(String inputstate) {
		this.inputstate = inputstate;
	}

	public String getIndType() {
		return indType;
	}

	public void setIndType(String indType) {
		this.indType = indType;
	}

	public String getFetchrate() {
		return fetchrate;
	}

	public void setFetchrate(String fetchrate) {
		this.fetchrate = fetchrate;
	}

	public String getOldStatDate() {
		return oldStatDate;
	}

	public void setOldStatDate(String oldStatDate) {
		this.oldStatDate = oldStatDate;
	}

	public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	public String getIndexCode() {
		return indexCode;
	}

	public String getImportlev() {
		return importlev;
	}

	public void setImportlev(String importlev) {
		this.importlev = importlev;
	}

	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}

	public Date getSubtime() {
		return subtime;
	}

	public void setSubtime(Date subtime) {
		this.subtime = subtime;
	}

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public String getPushState() {
		return pushState;
	}

	public void setPushState(String pushState) {
		this.pushState = pushState;
	}

	public String getMainDepMent() {
		return mainDepMent;
	}

	public void setMainDepMent(String mainDepMent) {
		this.mainDepMent = mainDepMent;
	}

	public String getStatDate() {
		return statDate;
	}

	public void setStatDate(String statDate) {
		this.statDate = statDate;
	}

	public List<String> getLastStatDate() {
		return lastStatDate;
	}

	public void setLastStatDate(List<String> lastStatDate) {
		this.lastStatDate = lastStatDate;
	}

	public String getDoing() {
		return doing;
	}

	public void setDoing(String doing) {
		this.doing = doing;
	}

	public String getNewDepCode() {
		return newDepCode;
	}

	public void setNewDepCode(String newDepCode) {
		this.newDepCode = newDepCode;
	}

	public String getDepCatg() {
		return depCatg;
	}

	public void setDepCatg(String depCatg) {
		this.depCatg = depCatg;
	}

	public String getDepartMentName() {
		return departMentName;
	}

	public void setDepartMentName(String departMentName) {
		this.departMentName = departMentName;
	}

	public String getDepPositionName() {
		return depPositionName;
	}

	public void setDepPositionName(String depPositionName) {
		this.depPositionName = depPositionName;
	}

	public String getDepPositionCode() {
		return depPositionCode;
	}

	public void setDepPositionCode(String depPositionCode) {
		this.depPositionCode = depPositionCode;
	}

	public String getUserName() {
		return userName==null?null:userName.trim();
	}

	public void setUserName(String userName) {
		this.userName = userName==null?null:userName.trim();
	}

	public String getUserCode() {
		return userCode==null?null:userCode.trim();
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode==null?null:userCode.trim();;
	}

	public String getUserValidstatus() {
		return userValidstatus;
	}

	public void setUserValidstatus(String userValidstatus) {
		this.userValidstatus = userValidstatus;
	}

	public String getEntityDepartMent() {
		return entityDepartMent;
	}

	public void setEntityDepartMent(String entityDepartMent) {
		this.entityDepartMent = entityDepartMent;
	}

	public List<String> getDempList() {
		return dempList;
	}

	public void setDempList(List<String> dempList) {
		this.dempList = dempList;
	}

	public String getHaveMenus() {
		return haveMenus;
	}

	public void setHaveMenus(String haveMenus) {
		this.haveMenus = haveMenus;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getHavaClassCodes() {
		return havaClassCodes;
	}

	public void setHavaClassCodes(String havaClassCodes) {
		this.havaClassCodes = havaClassCodes;
	}

	public String getHavaChannelCodes() {
		return havaChannelCodes;
	}

	public void setHavaChannelCodes(String havaChannelCodes) {
		this.havaChannelCodes = havaChannelCodes;
	}

	public List<String> getValidstateList() {
		return validstateList;
	}

	public void setValidstateList(List<String> validstateList) {
		this.validstateList = validstateList;
	}

	public String getLev1RiskCode() {
		return lev1RiskCode;
	}

	public void setLev1RiskCode(String lev1RiskCode) {
		this.lev1RiskCode = lev1RiskCode;
	}

	public String getLev2RiskCode() {
		return lev2RiskCode;
	}

	public void setLev2RiskCode(String lev2RiskCode) {
		this.lev2RiskCode = lev2RiskCode;
	}

	public String getTemplatenum() {
		return templatenum;
	}

	public void setTemplatenum(String templatenum) {
		this.templatenum = templatenum;
	}

	public String getTemplatecatname() {
		return templatecatname;
	}

	public void setTemplatecatname(String templatecatname) {
		this.templatecatname = templatecatname;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getHaveDivs() {
		return haveDivs;
	}

	public void setHaveDivs(String haveDivs) {
		this.haveDivs = haveDivs;
	}

	public String getAttType() {
		return attType;
	}

	public void setAttType(String attType) {
		this.attType = attType;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getCompareType() {
		return compareType;
	}

	public void setCompareType(String compareType) {
		this.compareType = compareType;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public List<String> getClassCodes() {
		return classCodes;
	}

	public void setClassCodes(List<String> classCodes) {
		this.classCodes = classCodes;
	}

	public List<String> getChannelCodes() {
		return channelCodes;
	}

	public void setChannelCodes(List<String> channelCodes) {
		this.channelCodes = channelCodes;
	}

	public int getMenuLevel() {
		return menuLevel;
	}

	public String getVfacCode() {
		return vfacCode;
	}

	public void setVfacCode(String vfacCode) {
		this.vfacCode = vfacCode;
	}

	public void setMenuLevel(int menuLevel) {
		this.menuLevel = menuLevel;
	}

	public String getHaveDepCodes() {
		return haveDepCodes;
	}

	public void setHaveDepCodes(String haveDepCodes) {
		this.haveDepCodes = haveDepCodes;
	}

	public List<String> getDepCodes() {
		return depCodes;
	}

	public void setDepCodes(List<String> depCodes) {
		this.depCodes = depCodes;
	}

	public String getLev3RiskCode() {
		return lev3RiskCode;
	}

	public void setLev3RiskCode(String lev3RiskCode) {
		this.lev3RiskCode = lev3RiskCode;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getTemplatecatno() {
		return templatecatno;
	}

	public void setTemplatecatno(String templatecatno) {
		this.templatecatno = templatecatno;
	}

	public String getRectype() {
		return rectype;
	}

	public void setRectype(String rectype) {
		this.rectype = rectype;
	}

	public String getUseview() {
		return useview;
	}

	public void setUseview(String useview) {
		this.useview = useview;
	}

	public String getUsegroup() {
		return usegroup;
	}

	public void setUsegroup(String usegroup) {
		this.usegroup = usegroup;
	}

	public String getUsesupervise() {
		return usesupervise;
	}

	public void setUsesupervise(String usesupervise) {
		this.usesupervise = usesupervise;
	}

	public String getDatafromtype() {
		return datafromtype;
	}

	public void setDatafromtype(String datafromtype) {
		this.datafromtype = datafromtype;
	}

	public String getSubmitstatus() {
		return submitstatus;
	}

	public void setSubmitstatus(String submitstatus) {
		this.submitstatus = submitstatus;
	}

	public String getProriskflag() {
		return proriskflag;
	}

	public void setProriskflag(String proriskflag) {
		this.proriskflag = proriskflag;
	}

	public String getCenriskflag() {
		return cenriskflag;
	}

	public void setCenriskflag(String cenriskflag) {
		this.cenriskflag = cenriskflag;
	}

	public String getVeidooType() {
		return veidooType;
	}

	public void setVeidooType(String veidooType) {
		this.veidooType = veidooType;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	public String getInfosource() {
		return infosource;
	}

	public void setInfosource(String infosource) {
		this.infosource = infosource;
	}

	public String getTabletype() {
		return tabletype;
	}

	public void setTabletype(String tabletype) {
		this.tabletype = tabletype;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getBksstype() {
		return bksstype;
	}

	public void setBksstype(String bksstype) {
		this.bksstype = bksstype;
	}

	public String getIdxcatgorycode() {
		return idxcatgorycode;
	}

	public void setIdxcatgorycode(String idxcatgorycode) {
		this.idxcatgorycode = idxcatgorycode;
	}

	public String getPostdesc() {
		return postdesc;
	}

	public void setPostdesc(String postdesc) {
		this.postdesc = postdesc;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTableuse() {
		return tableuse;
	}

	public void setTableuse(String tableuse) {
		this.tableuse = tableuse;
	}

	public String getBusiDt() {
		return busiDt;
	}

	public void setBusiDt(String busiDt) {
		this.busiDt = busiDt;
	}

	public String getDeppostype() {
		return deppostype;
	}

	public void setDeppostype(String deppostype) {
		this.deppostype = deppostype;
	}

	public String getAttCode() {
		return attCode;
	}

	public void setAttCode(String attCode) {
		this.attCode = attCode;
	}

	public String getValidstate() {
		return validstate;
	}

	public void setValidstate(String validstate) {
		this.validstate = validstate;
	}

	public String getPeriodicatitle() {
		return periodicatitle;
	}

	public void setPeriodicatitle(String periodicatitle) {
		this.periodicatitle = periodicatitle;
	}

	public String getPeriodicatype() {
		return periodicatype;
	}

	public void setPeriodicatype(String periodicatype) {
		this.periodicatype = periodicatype;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getReporttitle() {
		return reporttitle;
	}

	public void setReporttitle(String reporttitle) {
		this.reporttitle = reporttitle;
	}

	public String getReporttype() {
		return reporttype;
	}

	public void setReporttype(String reporttype) {
		this.reporttype = reporttype;
	}

	public String getReportCode() {
		return reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getMoudletype() {
		return moudletype;
	}

	public void setMoudletype(String moudletype) {
		this.moudletype = moudletype;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getQuant() {
		return quant;
	}

	public void setQuant(String quant) {
		this.quant = quant;
	}
	public List<String> getQuants() {
		return quants;
	}
	public void setQuants(List<String> quants) {
		this.quants = quants;
	}

	public String getUptype() {
		return uptype;
	}

	public void setUptype(String uptype) {
		this.uptype = uptype;
	}

	public String getCountType() {
		return countType;
	}

	public void setCountType(String countType) {
		this.countType = countType;
	}

	public String getFacname() {
		return facname;
	}

	public void setFacname(String facname) {
		this.facname = facname;
	}

	public String getActivityid() {
		return activityid;
	}

	public void setActivityid(String activityid) {
		this.activityid = activityid;
	}

	public String getActivityname() {
		return activityname;
	}

	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}

	public String getActivitytype() {
		return activitytype;
	}

	public void setActivitytype(String activitytype) {
		this.activitytype = activitytype;
	}

	public Timestamp getActivitytime() {
		return activitytime;
	}

	public void setActivitytime(Timestamp activitytime) {
		this.activitytime = activitytime;
	}

	public String getChannelid() {
		return channelid;
	}

	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}

	public String getChannelname() {
		return channelname;
	}

	public void setChannelname(String channelname) {
		this.channelname = channelname;
	}

	public String getProgramid() {
		return programid;
	}

	public void setProgramid(String programid) {
		this.programid = programid;
	}

	public String getProgramname() {
		return programname;
	}

	public void setProgramname(String programname) {
		this.programname = programname;
	}

	public Timestamp getLoadtime() {
		return loadtime;
	}

	public void setLoadtime(Timestamp loadtime) {
		this.loadtime = loadtime;
	}

	public String getPicbookid() {
		return picbookid;
	}

	public void setPicbookid(String picbookid) {
		this.picbookid = picbookid;
	}

	public String getPicbookname() {
		return picbookname;
	}

	public void setPicbookname(String picbookname) {
		this.picbookname = picbookname;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getAudioid() {
		return audioid;
	}

	public void setAudioid(String audioid) {
		this.audioid = audioid;
	}

	public String getAudioname() {
		return audioname;
	}

	public void setAudioname(String audioname) {
		this.audioname = audioname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHuibenid() {
		return huibenid;
	}

	public void setHuibenid(String huibenid) {
		this.huibenid = huibenid;
	}

	public String getCommentid() {
		return commentid;
	}

	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}

	public String getModular() {
		return modular;
	}

	public void setModular(String modular) {
		this.modular = modular;
	}

	public String getBusiid() {
		return busiid;
	}

	public void setBusiid(String busiid) {
		this.busiid = busiid;
	}

	public String getCommenttext() {
		return commenttext;
	}

	public void setCommenttext(String commenttext) {
		this.commenttext = commenttext;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	
	
	
}
