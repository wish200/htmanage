package com.huiting.manage.services.sysconfig;

import java.util.List;

import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.dto.sysconfig.CdCompanyDto;
import com.huiting.manage.services.common.BaseService;

/**
 * @ClassName: CcUserService
 * @Description: cc_user 数据库逻辑处理接口
 * @author Zou_ZhuoQi
 * @date 2013-12-18 下午2:18:19
 * 
 */

public interface CcUserService extends BaseService {
	/**
	 * 
	 * @Title: queryListUser
	 * @Description: 查找用户集合
	 * @param searchDto
	 * @return List<CcUserDto>
	 * @throws
	 */
	public List<CcUserDto> queryUserList(SearchDto searchDto);

	/**
	 * 
	 * @Title: findUser
	 * @Description: 查找单个用户信息
	 * @param @param searchDto
	 * @param @return
	 * @return CcUserBaseDto
	 * @throws
	 */
	public CcUserDto findUserByCode(SearchDto searchDto);

	/**
	 * 
	 * @Title: insertUser
	 * @Description: 插入用户信息
	 * @param @param CcUserDto
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int insertUser(CcUserDto ccUserDto);

	/**
	 * 
	 * @Title: updateUser
	 * @Description: 更新用户信息
	 * @param @param CcUserDto
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int updateUser(CcUserDto ccUserDto);

	/**
	 * 
	 * @Title: deleteUser
	 * @Description: 删除用户信息
	 * @param @param CcUserDto
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int deleteUser(CcUserDto ccUserDto);

	/**
	 * 
	 * @Title: userLogin
	 * @Description:  用户登录
	 * @param @param searchDto
	 * @param @return
	 * @return CcUserDto
	 * @throws
	 */
	public CcUserDto userLogin(SearchDto searchDto);

	/**
	 * 
	 * @Title: getcdCompanyBaseDtoLists
	 * @Description:  获得机构代码
	 * @param @return
	 * @return List<CdCompanyBaseDto>
	 * @throws
	 */
	public List<CdCompanyDto> getcdCompanyBaseDtoList(SearchDto searchDto);

	/**
	  * @Description: 校验用户代码
	  * @param  searchDto
	  * @return String   
	  * @throws
	 */
	public int veriCode(SearchDto searchDto);

	public int getUserCount(SearchDto searchDto);

	public List<CcUserDto> queryUserAllList(SearchDto searchDto);

	public CcUserDto userLogin4A(SearchDto searchDto);

}
