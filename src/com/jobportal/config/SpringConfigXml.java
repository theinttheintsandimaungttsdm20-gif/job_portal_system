package com.jobportal.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jobportal.service.GeneralService;

@Configuration
@PropertySource(value={"classpath:database.properties","classpath:hibernate.properties"})
@EnableTransactionManagement //spring transaction management
public class SpringConfigXml {
	@Autowired
	private Environment environment;
	@Bean//datasource bean
	public DataSource dataSource(){
		System.out.println("SpringConfigXML-->dataSource");
		DriverManagerDataSource ds=new DriverManagerDataSource();
			ds.setDriverClassName(this.environment.getProperty("db.driver"));
			ds.setUrl(this.environment.getProperty("db.url"));
			ds.setUsername(this.environment.getProperty("db.username"));
			ds.setPassword(this.environment.getProperty("db.password"));
		return ds;
	}
	@Bean//hibernate framework bean
	public LocalSessionFactoryBean sessionFactory(){
		System.out.println("SpringConfigXML-->sessionFactory");
		LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
			sf.setDataSource(dataSource());//connect datasource bean
			sf.setPackagesToScan(new String[]{//scan ORM packaing area
					"com.jobportal.entity"});
			sf.setHibernateProperties(hibernateProperties());//set the hibernate properties
		return sf;
	}
	private Properties hibernateProperties(){
		Properties p=new Properties();
			p.put("hibernate.dialect",this.environment.getProperty("hb.dialect"));
			//p.put("hibernate.show_sql",this.environment.getProperty("hb.show_sql"));
			p.put("hibernate.format_sql",this.environment.getProperty("hb.format_sql"));
		return p;
	}
	@Bean//hibernate framework transaction management bean
	public HibernateTransactionManager getTransactionManager(){
		System.out.println("SpringConfigXML-->transactionmanager");
		HibernateTransactionManager tm=new HibernateTransactionManager();
			tm.setSessionFactory(sessionFactory().getObject());
		return tm;
	}


}
