package com.illumina.controller;

import org.hibernate.cache.ehcache.EhCacheRegionFactory;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = { "com.illumina.db.repo" })
@Configuration
public class PersistenceConfig {
	/*
	private static final String[] ENTITY_MODEL_PACKAGES = { "com.illumina.platform.ephi.db.model" };
	// No need to specify `classpath:/`
	private static final String EHCACHE_CONFIGURATION = "META-INF/ehcache/ehcache.xml";


	@Value("${db.hibernate.debug.sql.enabled}")
	Boolean hibernateDebugSqlEnabled;

	@Value("${db.hibernate.debug.sql.formatted}")
	Boolean hibernateDebugSqlFormatted;

	@Value("${db.hibernate.debug.sql.use_comments}")
	Boolean hibernateDebugSqlUseCommments;

	@Value("${db.hibernate.cache.query}")
	Boolean hibernateQueryCacheEnabled;

	@Value("${db.hibernate.cache.second_level}")
	Boolean hibernateSecondLevelCacheEnabled;


	@Autowired
	private DataSource dataSource;

	@Bean
	JpaTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(this.dataSource);
		emf.setPackagesToScan(ENTITY_MODEL_PACKAGES);
		emf.setJpaVendorAdapter(this.jpaVendorAdapter());
		emf.setJpaProperties(this.jpaProperties());
		return emf;
	}

	private JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setGenerateDdl(false);
		adapter.setShowSql(hibernateDebugSqlEnabled);
		adapter.setDatabasePlatform(MySQL5InnoDBDialect.class.getName());
		adapter.setDatabase(Database.MYSQL);
		return adapter;
	}

	private Properties jpaProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.generate_statistics", "true");
		properties.setProperty("hibernate.cache.use_query_cache", hibernateQueryCacheEnabled.toString());
		properties.setProperty("hibernate.cache.use_second_level_cache", hibernateSecondLevelCacheEnabled.toString());
		properties.setProperty("hibernate.cache.region.factory_class", EhCacheRegionFactory.class.getName());

		properties.setProperty("hibernate.show_sql", hibernateDebugSqlEnabled.toString());
		properties.setProperty("hibernate.format_sql", hibernateDebugSqlFormatted.toString());
		properties.setProperty("hibernate.use_sql_comments", hibernateDebugSqlUseCommments.toString());

		properties.setProperty("net.sf.ehcache.configurationResourceName", EHCACHE_CONFIGURATION);
		return properties;
	}
	*/
}
