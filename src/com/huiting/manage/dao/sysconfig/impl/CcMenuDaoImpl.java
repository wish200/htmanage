package com.huiting.manage.dao.sysconfig.impl;

import org.springframework.stereotype.Repository;

import com.huiting.manage.dao.common.impl.BaseDaoImpl;
import com.huiting.manage.dao.sysconfig.CcMenuDao;
import com.huiting.manage.dto.sysconfig.CcMenuDto;

/**
 *
 * @ClassName: MenuDaoImpl
 * @Description: 操作菜单表表 cc_menu
 * @author Niu_ChunPing
 * @date 2013-12-22 下午2:01:48
 */
@Repository("ccMenuDaoImpl")
public class CcMenuDaoImpl extends BaseDaoImpl<CcMenuDto, String> implements CcMenuDao {

    public CcMenuDaoImpl() {
        super.setSqlmapNamespace("ccMenuMapper");
    }
}
