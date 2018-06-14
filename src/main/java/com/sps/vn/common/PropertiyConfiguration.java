package com.sps.vn.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiyConfiguration {

	public static class FirstProperties {
		
		private String databasePlatform;
		
		private String ddlAuto;
		
		private String showSql;

		public String getDatabasePlatform() {
			return databasePlatform;
		}

		public void setDatabasePlatform(String databasePlatform) {
			this.databasePlatform = databasePlatform;
		}

		public String getDdlAuto() {
			return ddlAuto;
		}

		public void setDdlAuto(String ddlAuto) {
			this.ddlAuto = ddlAuto;
		}

		public String getShowSql() {
			return showSql;
		}

		public void setShowSql(String showSql) {
			this.showSql = showSql;
		}
		
	}
	
	@Bean("firstProperties")
	@ConfigurationProperties(prefix= "app.custom.properties")
	public FirstProperties getFirstProperties() {
		return new FirstProperties();
	}
	
}
