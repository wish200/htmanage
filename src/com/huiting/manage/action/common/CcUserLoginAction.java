package com.huiting.manage.action.common;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.google.gson.Gson;
import com.itrus.picc.ca.account.AccountHelper;
import com.itrus.picc.ca.info.AppAccountInfo;
import com.itrus.picc.ca.verify.VerifyHelper;
import com.huiting.manage.dao.sysconfig.CdCompanyDao;
import com.huiting.manage.dto.base.CcSystemPostBaseDto;
import com.huiting.manage.dto.base.CdIndexBaseDto;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CcMenuDto;
import com.huiting.manage.dto.sysconfig.CcTaskDto;
import com.huiting.manage.services.common.CcUserLoginService;
import com.huiting.manage.services.sysconfig.CcSystemPostService;
import com.huiting.manage.services.sysconfig.CcTaskService;
import com.huiting.manage.system.tag.Page;
import com.huiting.manage.system.util.Constants;
import com.huiting.manage.system.util.DateUtil;
import com.huiting.manage.system.util.PasswordEncode;
import com.huiting.manage.system.util.PropertiesUtil;

/**
 * @ClassName: CcUserLoginAction
 * @Description: 用户登录
 * @author Zou_ZhuoQi
 * @date 2013-12-3 上午9:56:00
 * 
 */
public class CcUserLoginAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	private String flashData;
	private String flashData1;
	
	@Resource(name = "ccUserLoginServiceImpl")
	private CcUserLoginService ccUserLoginService;
	
	@Resource(name = "ccSystemPostServiceImpl")
	private CcSystemPostService ccSystemPostService;
	
	
	
	@Resource(name = "ccTaskServiceImpl")
	private CcTaskService ccTaskService;
	@Resource(name = "cdCompanyDaoImpl")
	private CdCompanyDao cdCompanyDao;
	private CcUserDto ccUserDto;
	/**下载名称**/
  	private String downFileName;
  	/**上传路径**/
	private String saveRulePath = PropertiesUtil.getVlue("upload.path");
	
	private List<CcSystemPostBaseDto> ccSystemPostBaseDtos;
	private SearchDto searchDto;
	private String loginMessage;// 用户登录失败反馈信息
	private List<CcMenuDto> ccMenuDtos;
	/** 任务表list  **/
	private List<CcTaskDto> ccTaskDtoList;
	
	public String login() throws Exception {
		
		try{
		if (session.get(Constants.USERLOGIN) == null) {
			if (searchDto != null&&searchDto.getPassWord()!=null) {
				ccUserDto = ccUserLoginService.userLogin(searchDto);
				session.put(Constants.USERLOGIN, ccUserDto);
			}else if (session.get(Constants.USERLOGIN) != null){
				return SUCCESS;
			}
			if (ccUserDto == null) {
				loginMessage="用户名不存在或密码错误!";
//				this.addFieldError(loginMessage, "用户名不存在或密码错误!");
				return "login";
			} else {
				if(!"1111".equals(ccUserDto.getUsercode())){
					int logintimes=ccUserDto.getLogintimes();
					CcUserDto CcUserDto1=new CcUserDto();
					CcUserDto1.setLogintimes(logintimes+1);
					CcUserDto1.setUsercode(ccUserDto.getUsercode());
					ccUserLoginService.update(CcUserDto1);
				}
				ccMenuDtos = ccUserLoginService.getUserMenus(ccUserDto);
				session.put("ccMenuDtos", ccMenuDtos);
				session.put("sysDate",DateUtil.getLastMonth(DateUtil.getYearMonth(new Date())));
				session.put("sysDateQ",DateUtil.getLastMonQ());
			}
		}
		}catch(Exception exception ){
			exception.printStackTrace();
		}
		
		return SUCCESS;

	}
	public String login4A() throws Exception {
		if (session.get(Constants.USERLOGIN) != null){
				return SUCCESS;
        }
		String appid = "016400";//系统ID
		String[] appAccount = null;
		StringBuffer cvmpath= new StringBuffer(getRootPath()+"cvm.xml"); //cvm文件路径,可用相对路径。
		String errmsg = null;
					//appid = request.getParameter("appid");
					String toSign = request.getHeader("toSign");
					if(toSign == null || "".equals(toSign)){
					  toSign = request.getParameter("toSign");
					}
					String Signature = request.getHeader("Signature");
					if(Signature == null || "".equals(Signature)){
						Signature = request.getParameter("Signature");
					}
					String issame = request.getHeader("issame");
					if(issame == null || "".equals(issame)){
						issame = request.getParameter("issame");
					}
					System.out.println("==============================1");
					System.out.println("appid"+appid);
					System.out.println(toSign);
					System.out.println(Signature);
					System.out.println("cvmpath"+cvmpath);
					System.out.println("issame:"+issame);
					System.out.println("==============================2");
					
			  VerifyHelper vHelper = new VerifyHelper();
			   AccountHelper accHelper = new AccountHelper();
			   AppAccountInfo accountInfo = new AppAccountInfo();
               accountInfo = accHelper.getLdapInfo(cvmpath.toString());		
               appAccount =vHelper.loginVerify(appid,toSign,Signature,cvmpath,issame);// new  String[]{"1111"};
               for(int i=0;i<appAccount.length;i++)
               {
                System.out.println(appAccount[i]+"----appAccount");
                }
               
               if(appAccount.length==1){
            	   searchDto=new SearchDto();
            	   searchDto.setUserName(appAccount[0]);
            	   ccUserDto = ccUserLoginService.userLogin4A(searchDto);
            	   int logintimes=ccUserDto.getLogintimes();
	   				CcUserDto CcUserDto1=new CcUserDto();
	   				CcUserDto1.setLogintimes(logintimes+1);
	   				CcUserDto1.setUsercode(ccUserDto.getUsercode());
	   				ccUserLoginService.update(CcUserDto1);
            	   session.put(Constants.USERLOGIN, ccUserDto);
            		session.put("sysDate",DateUtil.getLastMonth(DateUtil.getYearMonth(new Date())));
    				session.put("sysDateQ",DateUtil.getLastMonQ());
               }
               if (ccUserDto == null) {
				loginMessage="用户名不存在!";
				return "login";
               } else {
				ccMenuDtos = ccUserLoginService.getUserMenus(ccUserDto);
				session.put("ccMenuDtos", ccMenuDtos);
               }
		return SUCCESS;

	}
	/**
	 * 
	* @Title: getHomePage 
	* @Description: 主页显示
	* @param @return    
	* @return String  
	* @throws
	 */
	public String getHomePage(){
		CcUserDto ccUserDto = (CcUserDto) session.get(Constants.USERLOGIN);
		if(ccUserDto==null){
			return "logout";
		}
		if(searchDto==null){
			searchDto=new SearchDto();
		}
		try{
			searchDto.setUserValidstatus("1") ;
			Page page=new Page();
			page.setStartIndex(0);
			page.setPageSize(3);
			page.setEndIndex(1);
			searchDto.setPage(page);
			System.out.println(ccUserDto.getComcode()+ccUserDto.getNewdepcode()+ccUserDto.getDeppositioncode());
			ccSystemPostBaseDtos=ccSystemPostService.getSystrmPoseList(searchDto);
			searchDto.setComCode(ccUserDto.getComcode());
			searchDto.setNewDepCode(ccUserDto.getNewdepcode());
			searchDto.setDepPositionCode(ccUserDto.getDeppositioncode());
			/** 我的工作任务列表  **/
			
			ccTaskDtoList=ccTaskService.getList(searchDto);
		}catch(Exception e){
			e.printStackTrace();
			
		}
			System.out.println(ccTaskDtoList.size()+"-----size");
		return "getHomePage";
	}
	
	/**
	  * @Description: 主页KRI主指标
	  * @param @return    
	  * @return String   
	  * @throws
	 */
	public String getHomeKRI(){
		List<String> is=new ArrayList<String>();
		CcUserDto ccUserDto = (CcUserDto) session.get(Constants.USERLOGIN);
		if (searchDto == null) {
			searchDto = new SearchDto();
		}
		if("".equals(searchDto.getComCode())||searchDto.getComCode()==null){
			searchDto.setComCode(ccUserDto.getComcode());
		}
		if(ccUserDto.getComcode().equals("000000")){
			is.add("1");
		}
		if(!searchDto.getComCode().equals("000000")){
			is.add("2");
			searchDto.setIsviewlevel(is);
		}
		searchDto.setComname(cdCompanyDao.selectOne("searchDto", searchDto).getComname());
		/** 查询收藏夹中含有的指标代码 **/
		searchDto.setUserCode(ccUserDto.getUsercode());
		searchDto.setNewDepCode(ccUserDto.getNewdepcode());
		//searchDto = indexViewService.queryHaveDiv(searchDto);
		searchDto.setImportvalid("1");
		if(searchDto.getStatDate()==null||"".equals(searchDto.getStatDate())){
//			Date now=new Date();
//			searchDto.setStatDate(DateUtil.getPassDate("15",now));
			//取得数据表中最大的数据时间
			//searchDto.setStatDate(indexViewService.getMidIndexMaxDate(searchDto));
//			String date=dateFormat.format(indexViewService.getMaxDate(searchDto));
//			searchDto.setStatDate(date);	
		}
		searchDto.setFetchrate(DateUtil.getFetchrate(searchDto.getStatDate()));	
		//indexKRIDtos = indexViewService.queryListKRI(searchDto);
		//--主页KRI指标查看全部
		if("more".equals(searchDto.getDoing())){
			return "homKRIMore";
		}
		/*List<IndexKRIDto> indexKRIDtos2=new ArrayList<IndexKRIDto>();
		IndexKRIDto indexKRIDtoTemp=null;
		IndexKRIDto indexKRIDto2=null;
		CdIndexBaseDto cdIndexBaseDtoTemp=null;
		for (IndexKRIDto indexKRIDto : indexKRIDtos) {
			indexKRIDtoTemp=indexKRIDto;
			indexKRIDto2=new IndexKRIDto();
			indexKRIDto2.setIndexvalue(indexKRIDtoTemp.getIndexvalue());
			cdIndexBaseDtoTemp=new CdIndexBaseDto();
			cdIndexBaseDtoTemp.setIndexname(indexKRIDtoTemp.getCdIndexBaseDto().getIndexname());
			cdIndexBaseDtoTemp.setDataunit(indexKRIDtoTemp.getCdIndexBaseDto().getDataunit());
			indexKRIDto2.setCdIndexBaseDto(cdIndexBaseDtoTemp);
			indexKRIDto2.setColor(indexKRIDtoTemp.getColor());
			indexKRIDtos2.add(indexKRIDto2);
		}*/
		Gson gson = new Gson();
		//flashData = gson.toJson(indexKRIDtos2);
			return "getHomeKRI";
	}
	/**
	  * @Description: 主页全指标
	  * @param @return    
	  * @return String   
	  * @throws
	 */
	public String getAllIndex(){
		CcUserDto ccUserDto = (CcUserDto) session.get(Constants.USERLOGIN);
		if (searchDto == null) {
			searchDto = new SearchDto();
		}
		searchDto.setComCode(ccUserDto.getComcode());
		
		/** 查询收藏夹中含有的指标代码 **/
		searchDto.setUserCode(ccUserDto.getUsercode());
		searchDto.setNewDepCode(ccUserDto.getNewdepcode());
		//searchDto = indexViewService.queryHaveDiv(searchDto);
		
		if(searchDto.getStatDate()==null||"".equals(searchDto.getStatDate())){
			Date now=new Date();
			searchDto.setStatDate(DateUtil.getPassDate("15",now));
		}
		searchDto.setFetchrate(DateUtil.getFetchrate(searchDto.getStatDate()));	
		//indexKRIDtos =  indexViewService.queryList(searchDto);
		//--主页全集指标查看全部
		if("more".equals(searchDto.getDoing())){
			return "homALLIndexMore";
		}
		/*List<IndexKRIDto> indexKRIDtos2=new ArrayList<IndexKRIDto>();
		IndexKRIDto indexKRIDtoTemp=null;
		IndexKRIDto indexKRIDto2=null;
		CdIndexBaseDto cdIndexBaseDtoTemp=null;
		for (IndexKRIDto indexKRIDto : indexKRIDtos) {
			indexKRIDtoTemp=indexKRIDto;
			indexKRIDto2=new IndexKRIDto();
			indexKRIDto2.setIndexvalue(indexKRIDtoTemp.getIndexvalue());
			cdIndexBaseDtoTemp=new CdIndexBaseDto();
			cdIndexBaseDtoTemp.setIndexname(indexKRIDtoTemp.getCdIndexBaseDto().getIndexname());
			cdIndexBaseDtoTemp.setDataunit(indexKRIDtoTemp.getCdIndexBaseDto().getDataunit());
			indexKRIDto2.setCdIndexBaseDto(cdIndexBaseDtoTemp);
			indexKRIDto2.setColor(indexKRIDtoTemp.getColor());
			indexKRIDtos2.add(indexKRIDto2);
		}*/
		//Gson gson = new Gson();
		//flashData = gson.toJson(indexKRIDtos2);
		
		return "getAllIndex";
	}
	
	/**
	 * 
	 * @Title: logout
	 * @Description: 修改密码
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String ediPassWord(){
		loginMessage = "密码修改成功，请使用新密码重新登陆！";
		CcUserDto ccUserDto2 = (CcUserDto) session.get(Constants.USERLOGIN);
		String tempPW = PasswordEncode.digestPassword(ccUserDto.getPassword());
		ccUserDto.setUsercode(ccUserDto2.getUsercode());
		ccUserDto.setPassword(tempPW);
		ccUserLoginService.update(ccUserDto);
		session.remove(Constants.USERLOGIN);
		session.clear();
		return "logout";
	}

	/**
	 * @throws UnsupportedEncodingException 
	 * @Description: 帮助文档下载
	 * @param @return   
	 * @return String  
	 * @throws
	 */
	public String help() throws UnsupportedEncodingException{
		String filename=URLDecoder.decode(request.getParameter("searchDto.helpname"),"UTF-8");
		System.out.println("filename:"+filename);
		setDownFileName(filename);
		return "help";
	}
	
	public InputStream getInputStream() throws Exception{
		String fileName=URLDecoder.decode(request.getParameter("searchDto.helpname"),"UTF-8");
		String path=saveRulePath+"/helpword/"+fileName+".doc";
		return new FileInputStream(path);  
	}
	
	/**
	 * 
	 * @Title: logout
	 * @Description: 退出登录
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String logout() {
		loginMessage = "感谢使用本系统";
		session.remove(Constants.USERLOGIN);
		session.clear();
		return "logout";
	}
	
	public List<CcMenuDto> getCcMenuDtos() {
		return ccMenuDtos;
	}

	public void setCcMenuDtos(List<CcMenuDto> ccMenuDtos) {
		this.ccMenuDtos = ccMenuDtos;
	}

	public CcUserDto getCcUserDto() {
		return ccUserDto;
	}

	public void setCcUserDto(CcUserDto ccUserDto) {
		this.ccUserDto = ccUserDto;
	}

	public SearchDto getSearchDto() {
		return searchDto;
	}

	public void setSearchDto(SearchDto searchDto) {
		this.searchDto = searchDto;
	}
	
	public String getLoginMessage() {
		return loginMessage;
	}

	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}
	public List<CcSystemPostBaseDto> getCcSystemPostBaseDtos() {
		return ccSystemPostBaseDtos;
	}
	public void setCcSystemPostBaseDtos(
			List<CcSystemPostBaseDto> ccSystemPostBaseDtos) {
		this.ccSystemPostBaseDtos = ccSystemPostBaseDtos;
	}
	/*public List<IndexKRIDto> getIndexKRIDtos() {
		return indexKRIDtos;
	}
	public void setIndexKRIDtos(List<IndexKRIDto> indexKRIDtos) {
		this.indexKRIDtos = indexKRIDtos;
	}*/
	public List<CcTaskDto> getCcTaskDtoList() {
		return ccTaskDtoList;
	}
	public void setCcTaskDtoList(List<CcTaskDto> ccTaskDtoList) {
		this.ccTaskDtoList = ccTaskDtoList;
	}
	public String getFlashData() {
		return flashData;
	}
	public void setFlashData(String flashData) {
		this.flashData = flashData;
	}
	public String getFlashData1() {
		return flashData1;
	}
	public void setFlashData1(String flashData1) {
		this.flashData1 = flashData1;
	}
	public String getDownFileName() {
		try{
			downFileName=new String(downFileName.getBytes("gb2312"),"ISO-8859-1");
		}catch(Exception e){
			e.printStackTrace();
		}
		return downFileName;
	}
	public void setDownFileName(String downFileName) {
		this.downFileName = downFileName;
	}
	
}