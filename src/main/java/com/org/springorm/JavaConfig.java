package com.org.springorm;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.org.orm.dao.StudentDao;
import com.org.orm.entities.Student;

@Configuration
@ComponentScan(basePackages = {"com.org.orm.dao","com.org.orm.entities"})
public class JavaConfig {
	
	
	
	@Bean(name= {"hibernateTemplate"})
	public HibernateTemplate getHibernateTemplate() {
		HibernateTemplate hibernateTemplate=new HibernateTemplate();
		hibernateTemplate.setSessionFactory((SessionFactory) getSessionFactory());
		return hibernateTemplate;
	}
	public Properties getProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.show_sql","true");
		properties.setProperty("org.hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

//	public SessionFactory getSessionFactoryUtil() {
//		SessionFactory sessionFactory =(SessionFactory) getSessionFactory();
//		return sessionFactory;
//	}
	
	@Bean(name={"localSessionFactory","sessionFactory"})
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setHibernateProperties(getProperties());
		sessionFactory.setAnnotatedClasses(Student.class);
		return sessionFactory;
	}
	@Bean(name={"dataSource"})
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	@Bean(name={"studentDao","dao"})
	public StudentDao getStudent() {	
		StudentDao dao = new StudentDao();
		dao.setHibernateTemplate(getHibernateTemplate());
		return dao;
	}
}
