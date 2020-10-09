package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example"})
@EntityScan(basePackages= {"com.example.entity_mysql","com.example.entity_postgres"})
@EnableJpaRepositories(basePackages= {"com.example.repository_mysql","com.example.repository_postgres"})
@Configuration
@EnableAutoConfiguration(exclude = { 
        DataSourceAutoConfiguration.class, 
        DataSourceTransactionManagerAutoConfiguration.class, 
        HibernateJpaAutoConfiguration.class })
public class MultipleDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDbApplication.class, args);
	}

}
