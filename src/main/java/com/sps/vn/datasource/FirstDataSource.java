/*
 * Class: FirstDataSource
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

import org.apache.tomcat.jdbc.pool.jmx.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.PlatformTransactionManager;

import com.sps.vn.common.PropertiyConfiguration.FirstProperties;

@Configuration
@EnableJpaRepositories(basePackages=GeneralConfiguration.First.REPOSITORY_PACKAGE,
entityManagerFactoryRef= GeneralConfiguration.First.ENTITY_MANAGER,
transactionManagerRef= GeneralConfiguration.General.TRANSACTION_MANAGER)
class FirstDataSource extends AbstractDataSourceConfiguration{
	
	@Autowired
	private FirstProperties firstProperties;
    
	@Primary
    @Override
    @Bean(name=GeneralConfiguration.First.DATASOURCE)
    @ConfigurationProperties(prefix= GeneralConfiguration.First.PREFIX_DATASOURCE)
    protected DataSource dataSource() {
		DataSource dataSource= DataSourceBuilder.create().build();
        return dataSource;
    }
	
	@Primary
	@Override
	@Bean(name= GeneralConfiguration.First.ENTITY_MANAGER)
	protected EntityManagerFactory entityManagerFactory(DataSource dataSource) {
		return this.getEntityManagerFactoryBean(dataSource);
	}
	
    @Override
    protected PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    	return null;
    }
	
	@Override
    protected String getPackagesToScan() {
        return GeneralConfiguration.First.ENTITY_PACKAGE;
    }

    @Override
    protected Properties getProperties() {
    	Properties properties= new Properties();
    	properties.put("hibernate.dialect", firstProperties.getDatabasePlatform());
    	properties.put("hibernate.hbm2ddl.auto", firstProperties.getDdlAuto());
    	properties.put("hibernate.show_sql", firstProperties.getShowSql());
        return properties;
    }

    @Override
    protected ConnectionPool jmxDataSource(DataSource dataSource) {
    	return null;
    }

    @Override
    protected String getUnitName() {
        return GeneralConfiguration.First.UNIT_NAME;
    }
}
