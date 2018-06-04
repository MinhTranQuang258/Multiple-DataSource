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

import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sps.vn.datasource.core.AbstractDataSource;

@Configuration
@EnableTransactionManagement
public class FirstDataSource extends AbstractDataSource{

    @Autowired
    private JpaProperties jpaProperties;
        
    @Override
    @Bean(name="dataSource")
    @ConfigurationProperties(prefix= "app.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }    

    @Override
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return this.getTransactionManager(entityManagerFactory);
    }

    @Override
    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
        return this.getEntityManagerFactoryBean(dataSource);
    }

    @Override
    protected String getPackagesToScan() {
        return "com.sps.vn.entities";
    }

    @Override
    protected Map<String, String> getProperties() {
        return jpaProperties.getProperties();
    }

    @Override
    protected String getUnitName() {
        return "firstUnit";
    }
}
