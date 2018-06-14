package com.sps.vn.datasource;

public class GeneralConfiguration {

	public static class First {
		
		public static final String DATASOURCE= "fDataSource";
		
		public static final String PREFIX_DATASOURCE= "app.custom.datasource.first";
		
		public static final String ENTITY_PACKAGE= "com.sps.vn.entities";
		
		public static final String ENTITY_MANAGER= "fEntityManager";
		
		public static final String TRANSACTION_MANAGER= "fTransactionManager";
		
		public static final String REPOSITORY_PACKAGE= "com.sps.vn.repository.first";
		
		public static final String JMX_CONNECTION_POOL= "";
		
		public static final String UNIT_NAME= "firstUnit";
	}
		
	public static class Second {
		
		public static final String DATASOURCE= "sDataSource";
		
		public static final String PREFIX_DATASOURCE= "app.custom.datasource.second";
		
		public static final String ENTITY_PACKAGE= "com.sps.vn.entities";
		
		public static final String ENTITY_MANAGER= "sEntityManager";
		
		public static final String TRANSACTION_MANAGER= "sTransactionManager";
		
		public static final String REPOSITORY_PACKAGE= "com.sps.vn.repository.second";
		
		public static final String JMX_CONNECTION_POOL= "";
		
		public static final String UNIT_NAME= "secondUnit";
	}
	
}
