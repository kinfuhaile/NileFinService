package com.springinpractice.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.nilefin.model.User;
import com.nilefin.persistent.dao.interfaces.AccountDao;
import com.springinpractice.ch04.dao.hbn.HbnUserDao;

@Profile(value="mysql-h22")
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses={User.class, HbnUserDao.class, AccountDao.class})
public class MySQLRepositoryConfig{

	   /*@Inject
	  private SessionFactory sessionFactory;*/

	  @Bean
	  public DataSource dataSource() {
		    DriverManagerDataSource dataSource = new DriverManagerDataSource();
		    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		    dataSource.setUrl("jdbc:mysql://localhost:3306/habeshalists?useSSL=false");
		    dataSource.setUsername("root");
		    dataSource.setPassword("root");
		    return dataSource;
	  }

	  @Bean
	  public HibernateTransactionManager HibernateTransactionManager() {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	    transactionManager.setSessionFactory(sessionFactory().getObject());
	    return transactionManager;
	  }

	  
	  
	  @Bean
		public LocalSessionFactoryBean sessionFactory() {
			try {
				LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
				lsfb.setDataSource(dataSource());
				 lsfb.setPackagesToScan("com.nilefin.model");
				Properties props = new Properties();
				props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
				lsfb.setHibernateProperties(props);
				lsfb.afterPropertiesSet();
			
				return lsfb;
			} catch (IOException e) {
				return null;
			}
		}


	}
