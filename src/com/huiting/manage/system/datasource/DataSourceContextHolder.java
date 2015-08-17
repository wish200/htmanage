/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huiting.manage.system.datasource;

import org.springframework.util.Assert;

/**
 *
 * @author Administrator
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDataSourceType(String dataSourceType) {
        Assert.notNull(dataSourceType, "DatabaseType cannot be null");
        contextHolder.set(dataSourceType);
    }

    public static String getDataSourceType() {
        return (String) contextHolder.get();
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }
}
