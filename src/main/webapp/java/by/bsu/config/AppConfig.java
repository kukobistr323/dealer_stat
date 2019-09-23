package by.bsu.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("by.bsu")
@PropertySource("classpath:app.properties")
@EnableJpaRepositories("by.bsu.repository")
public class AppConfig {

    private static final String DRIVER = "db.driver";
    private static final String PASSWORD = "db.password";
    private static final String URL = "db.url";
    private static final String USERNAME = "db.username";
    private static final String DIALECT = "db.hibernate.dialect";
    private static final String SHOW_SQL = "db.hibernate.show_sql";
    private static final String PACKAGES_TO_SCAN = "db.entitymanager.packages.to.scan";
    private static final String HBM2DDL_AUTO = "db.hibernate.hbm2ddl.auto";

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty(DRIVER));
        dataSource.setUrl(env.getRequiredProperty(URL));
        dataSource.setUsername(env.getRequiredProperty(USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PASSWORD));

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty(PACKAGES_TO_SCAN));
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());

        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(DIALECT, env.getRequiredProperty(DIALECT));
        properties.put(SHOW_SQL, env.getRequiredProperty(SHOW_SQL));
        properties.put(HBM2DDL_AUTO, env.getRequiredProperty(HBM2DDL_AUTO));

        return properties;
    }

}
