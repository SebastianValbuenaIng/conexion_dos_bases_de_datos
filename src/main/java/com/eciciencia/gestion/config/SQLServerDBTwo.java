package com.eciciencia.gestion.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "db2ManagerFactory",
        transactionManagerRef = "db2TransactionManager",
        basePackages = {
                "com.eciciencia.gestion.domain.repositories.DBTwo"
        }
)
public class SQLServerDBTwo {
    private String dialect = "org.hibernate.dialect.SQLServerDialect";

    @Bean(name = "db2DataSource")
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:sqlserver://10.1.5.40:1433;databaseName=AppMovil;SendStringParameterAsUnicode=false;TrustServerCertificate=True")
                .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                .username("desarrollo")
                .password("E65&Mx34")
                .build();
    }

    @Bean(name = "db2ManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.eciciencia.gestion.domain.entities.DBTwo");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", dialect);
        factoryBean.setJpaPropertyMap(properties);
        return factoryBean;
    }

    @Bean(name = "db2TransactionManager")
    public PlatformTransactionManager platformTransactionManager(@Qualifier(value = "db2ManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}