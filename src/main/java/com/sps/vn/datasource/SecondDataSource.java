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

import com.sps.vn.common.PropertiyConfiguration.FirstProperties;

@Configuration
@EnableJpaRepositories(basePackages= GeneralConfiguration.Second.REPOSITORY_PACKAGE,
entityManagerFactoryRef= GeneralConfiguration.Second.ENTITY_MANAGER,
transactionManagerRef= GeneralConfiguration.General.TRANSACTION_MANAGER)
class SecondDataSource extends AbstractDataSourceConfiguration{
	
	@Autowired
	private FirstProperties firstProperties;

	@Override
    @Bean(name= GeneralConfiguration.Second.DATASOURCE)
    @ConfigurationProperties(prefix= GeneralConfiguration.Second.PREFIX_DATASOURCE)
    protected DataSource dataSource() {
		DataSource dataSource= DataSourceBuilder.create().build();
        return dataSource;
    }    

    @Override
    protected PlatformTransactionManager transactionManager(EntityManagerFactory sEntityManager) {
    	return null;
    }

    @Override
    @Bean(name= GeneralConfiguration.Second.ENTITY_MANAGER)
    protected EntityManagerFactory entityManagerFactory(@Qualifier(GeneralConfiguration.Second.DATASOURCE)DataSource sDataSource) {
        return this.getEntityManagerFactoryBean(sDataSource);
    }

    @Override
	protected ConnectionPool jmxDataSource(DataSource dataSource) {
		return null;
	}

	@Override
    protected String getPackagesToScan() {
        return GeneralConfiguration.Second.ENTITY_PACKAGE;
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
        return GeneralConfiguration.Second.UNIT_NAME;
    }

}
