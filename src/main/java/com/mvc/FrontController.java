package com.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan({"com.mvc"})
public class FrontController {

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory(){
         LocalEntityManagerFactoryBean factory = new LocalEntityManagerFactoryBean();
         factory.setPersistenceUnitName("myPU");
        return factory;
    }
    
    @Bean
    public JpaTransactionManager jpaTransactionManager(){
        JpaTransactionManager tx = new JpaTransactionManager();
        tx.setEntityManagerFactory(entityManagerFactory().getObject());
        return tx;
    }

}
