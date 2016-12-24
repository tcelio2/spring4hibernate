package com.spring.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration //--> posso retirar caso eu importe esta classe para outra que usa o @Configuration
@EnableTransactionManagement

public class JPAConfiguration {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFacotry(){
	
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[]{"com.spring.model"});
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		
		return em;
	}
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("org.postgresql.Driver");
		datasource.setUrl("jdbc:postgresql://localhost:5432/unespiano");
		datasource.setUsername("postgres");
		datasource.setPassword("postgres");
		
		return datasource;
	}
	
	private Properties additionalProperties(){
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto","create");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.setProperty("hibermate.show_sql", "true");
		properties.setProperty("hibernate.form_sql", "true");
		properties.setProperty("hibernate.use_sql_comments", "true");
		return properties;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
	
}
