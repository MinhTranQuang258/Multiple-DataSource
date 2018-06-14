package com.sps.vn.datasource;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.jmx.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sps.vn.common.PropertiyConfiguration.FirstProperties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.sps.vn.repository.second",
entityManagerFactoryRef="sEntityManager",
transactionManagerRef="sTransactionManager")
class SecondDataSource extends AbstractDataSourceConfiguration{
	
	@Autowired
	private FirstProperties firstProperties;

	@Override
    @Bean(name="sDataSource")
    @ConfigurationProperties(prefix= "app.custom.datasource.second")
    protected DataSource dataSource() {
		DataSource dataSource= DataSourceBuilder.create().build();
        return dataSource;
    }    

    @Override
    @Bean("sTransactionManager")
    protected PlatformTransactionManager transactionManager(EntityManagerFactory sEntityManager) {
        return this.getTransactionManager(sEntityManager);
    }

    @Override
    @Bean("sEntityManager")
    protected EntityManagerFactory entityManagerFactory(@Qualifier("sDataSource")DataSource sDataSource) {
        return this.getEntityManagerFactoryBean(sDataSource);
    }

    @Override
	protected ConnectionPool jmxDataSource(DataSource dataSource) {
		return null;
	}

	@Override
    protected String getPackagesToScan() {
        return "com.sps.vn.entities.second";
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
    protected String getUnitName() {
        return "secondUnit";
    }

}
