package com.huiting.manage.services.sysconfig.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiting.manage.dao.sysconfig.CcUserDao;
import com.huiting.manage.dao.sysconfig.CdCompanyDao;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CdCompanyDto;
import com.huiting.manage.services.common.impl.BaseServiceImpl;
import com.huiting.manage.services.sysconfig.CcUserService;
import com.huiting.manage.system.util.PasswordEncode;

/**
 * @ClassName: CcUserServiceImpl
 * @Description:  数据库逻辑处理实现类
 * @author Zou_ZhuoQi
 * @date 2013-12-18 下午2:19:23
 * 
 */
@Service("ccUserServiceImpl")
public class CcUserServiceImpl extends BaseServiceImpl implements CcUserService {
	@Resource(name = "ccUserDaoImpl")
	CcUserDao ccUserDao;
	
	@Resource(name = "cdCompanyDaoImpl")
	CdCompanyDao cdCompanyDao;
	@Override
	public List<CcUserDto> queryUserList(SearchDto searchDto) {
		Map<String, Object> condition=new HashMap<String, Object>(); 
		condition.put("searchDto", searchDto);
		return ccUserDao.selectList("selectUserList", condition);
	}

	@Override
	public CcUserDto findUserByCode(SearchDto searchDto) {
		return ccUserDao.selectOne("searchDto", searchDto);
	}

	@Override
	public int insertUser(CcUserDto ccUserDto) {
		String tempPW = PasswordEncode.digestPassword(ccUserDto.getPassword());
		ccUserDto.setPassword(tempPW);
		ccUserDao.insert(ccUserDto);
		return 0;
	}

	@Override
	public int updateUser(CcUserDto ccUserDto) {
		ccUserDao.update(ccUserDto);
		return 0;
	}

	@Override
	public int deleteUser(CcUserDto ccUserDto) {
		ccUserDao.deleteById(ccUserDto.getUsercode());
		return 0;
	}

	@Override
	public CcUserDto userLogin(SearchDto searchDto) {
		Map<String, Object> condition=new HashMap<String, Object>(); 
//		将密码加密
		searchDto.setPassWord(PasswordEncode.digestPassword(searchDto.getPassWord().trim()));
		condition.put("searchDto", searchDto);
		return ccUserDao.selectOne("userlogin", condition);
	}

	@Override
	public List<CdCompanyDto> getcdCompanyBaseDtoList(SearchDto searchDto) {
		return cdCompanyDao.selectList("searchDto", searchDto);
	}

	/**
	  * @Description: 检验用户代码 
	  * @param  searchDto
	 */
	@Override
	public int veriCode(SearchDto searchDto) {
		int i=ccUserDao.veriCode(searchDto.getUserCode());
		return i;
	}

	/**
	  * @Description: 用户的总数 
	  * @param  searchDto
	 */
	@Override
	public int getUserCount(SearchDto searchDto) {
		Map<String, Object>condition=new HashMap<String, Object>(); 
		condition.put("searchDto", searchDto);
		return ccUserDao.count(condition);
	}

	@Override
	public List<CcUserDto> queryUserAllList(SearchDto searchDto) {
		// TODO Auto-generated method stub
		return ccUserDao.selectList("searchDto", searchDto);
	}

	@Override
	public CcUserDto userLogin4A(SearchDto searchDto) {
		Map<String, Object> condition=new HashMap<String, Object>(); 
		condition.put("searchDto", searchDto);
		return ccUserDao.selectOne("userLogin4A", condition);
	}

}
