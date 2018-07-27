package com.sps.vn.datasource;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.jmx.ConnectionPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class GenearalTransactionManager extends AbstractDataSourceConfiguration{

	@Override
	@Bean(name= GeneralConfiguration.General.TRANSACTION_MANAGER)
	protected PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return this.getTransactionManager(entityManagerFactory);
	}

	@Override
	protected DataSource dataSource() {
		return null;
	}

	@Override
	protected EntityManagerFactory entityManagerFactory(DataSource dataSource) {
		return null;
	}

	@Override
	protected ConnectionPool jmxDataSource(DataSource dataSource) {
		return null;
	}

	@Override
	protected String getPackagesToScan() {
		return null;
	}

	@Override
	protected Properties getProperties() {
		return null;
	}

	@Override
	protected String getUnitName() {
		return null;
	}

}
