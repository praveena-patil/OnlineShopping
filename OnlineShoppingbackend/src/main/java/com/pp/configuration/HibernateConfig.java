package com.pp.configuration;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pp.model.Category;

@Configuration
@ComponentScan(basePackages={"com.pp"})
@EnableTransactionManagement
public class HibernateConfig {
	private final static String database_URL = "jdbc:h2:tcp://localhost/~/OnlineShopping";
	private final static String database_driver = "org.h2.Driver";
	private final static String database_dialect = "org.hibernate.dialect.H2Dialect";
	private final static String database_username = "sa";
	private final static String database_password = "";
	
	@Bean(name = "datasource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(database_driver);
		dataSource.setUrl(database_URL);
		dataSource.setUsername(database_username);
		dataSource.setPassword(database_password);
		return dataSource;
	}

	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		System.out.println("Session Object created..");
		builder.addProperties(getHibernateProperties());

		System.out.println("Properties added");
		builder.scanPackages("com.pp");
		builder.addAnnotatedClass(Category.class);
		
		System.out.println("All classes added");
		return builder.buildSessionFactory();
	}


	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", database_dialect);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("Hibernate properties created");
		return properties;
	}
	
	@Autowired
	@Bean(name = ("transactionManager"))
	public HibernateTransactionManager getTransactionManager(SessionFactory sf) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sf);
		return transactionManager;

	}
}
