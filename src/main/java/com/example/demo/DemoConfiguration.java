package com.example.demo;



import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages={"com.example.repository"},
        entityManagerFactoryRef = "demoEntityManagerFactory",
        transactionManagerRef= "demoTransactionManager")
@EntityScan(basePackages={"com.example.entity"})
@EnableTransactionManagement
public class DemoConfiguration {
	@Bean
    @ConfigurationProperties(prefix="spring.datasource")
	public DataSource demoDataSource() {
		DataSource source = DataSourceBuilder.create().build();
		return source;
	}

	@Bean(name = "demoEntityManagerFactory") 
	public LocalContainerEntityManagerFactoryBean pfmEntityManagerFactory(
			EntityManagerFactoryBuilder builder) {
		 Map<String, Object> properties = new HashMap<String, Object>();
		 properties.put("hibernate.hbm2ddl.auto", "none"); // or "update" / "validate" if needed
		 properties.put("hibernate.id.new_generator_mappings", "false");
		 properties.put("spring.jpa.generate-ddl", "false");
		 properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect"); // or MySQL8Dialect
		    LocalContainerEntityManagerFactoryBean bean = builder
				.dataSource(demoDataSource())
				.packages("com.example.entity", "com.example.repository")
				.properties(properties)
				.build();
		return bean;
	}

	@Bean
	public PlatformTransactionManager pfmTransactionManager(
			final @Qualifier("demoEntityManagerFactory") LocalContainerEntityManagerFactoryBean demoEntityManagerFactory) {
		return new JpaTransactionManager(demoEntityManagerFactory.getObject());
	}

}

