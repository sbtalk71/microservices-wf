package com.demo.spring;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration

public class AppConfig {

	@Bean
	@Profile("dev")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds= new DriverManagerDataSource();
		ds.setDriverClassName("org.mariadb.jdbc.Driver");
		ds.setUrl("jdbc:mariadb://localhost:3306/springdb");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	/*
	@Bean
	@ConfigurationProperties("app.datasource")
	@Profile("prod")
	public DataSource ds() {
	    return DataSourceBuilder.create().build();
	}
	
	*/
	
	/*
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
		LocalContainerEntityManagerFactoryBean lb=new LocalContainerEntityManagerFactoryBean();
		lb.setDataSource(ds);
		lb.setPackagesToScan("com.demo.spring.entity");
	
		HibernateJpaVendorAdapter va= new HibernateJpaVendorAdapter();
		va.setDatabase(Database.MYSQL);
		va.setShowSql(true);
		
		lb.setJpaVendorAdapter(va);
		return lb;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager tx= new JpaTransactionManager();
		tx.setEntityManagerFactory(emf);
		return tx;
	}
	*/
	
}
