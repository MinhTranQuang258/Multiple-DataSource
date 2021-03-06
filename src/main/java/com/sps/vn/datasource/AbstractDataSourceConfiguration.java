/*
 * Class: AbstractDataSourec
 *
 * Created on Feb 26, 2018
 *
 * (c) Copyright Swiss Post Solution, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package com.sps.vn.datasource;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.DataSourceProxy;
import org.apache.tomcat.jdbc.pool.jmx.ConnectionPool;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

abstract class AbstractDataSourceConfiguration {
    
    protected abstract DataSource dataSource();
    
    protected EntityManagerFactory getEntityManagerFactoryBean(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        
        JpaVendorAdapter jpaVendorAdapter= new HibernateJpaVendorAdapter();
        
        containerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        containerEntityManagerFactoryBean.setDataSource(dataSource);
        containerEntityManagerFactoryBean.setPackagesToScan(this.getPackagesToScan());
        containerEntityManagerFactoryBean.setJpaProperties(this.getProperties());
        containerEntityManagerFactoryBean.setPersistenceUnitName(this.getUnitName());
        containerEntityManagerFactoryBean.afterPropertiesSet();
        
        return containerEntityManagerFactoryBean.getObject();      
    }
    
    protected PlatformTransactionManager getTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
    
    protected ConnectionPool getJmxDatasource(DataSource dataSource) {
    	if(dataSource instanceof DataSourceProxy) {
    		return ((DataSourceProxy) dataSource).getPool().getJmxPool();
    	}
    	return null;
    }
    
    protected abstract PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory);
    
    protected abstract EntityManagerFactory entityManagerFactory(DataSource dataSource);
    
    protected abstract ConnectionPool jmxDataSource(DataSource dataSource);
    
    protected abstract String getPackagesToScan();
    
    protected abstract Properties getProperties();
    
    protected abstract String getUnitName();
}
