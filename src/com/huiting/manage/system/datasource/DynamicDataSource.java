/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huiting.manage.system.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 
 * @author Administrator
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceContextHolder.getDataSourceType();
	} 
	
}
