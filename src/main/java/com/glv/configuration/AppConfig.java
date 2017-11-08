package com.glv.configuration;

import com.glv.Model.*;
import java.util.Properties;
import static org.hibernate.cfg.AvailableSettings.C3P0_ACQUIRE_INCREMENT;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS;
import static org.hibernate.cfg.AvailableSettings.C3P0_MIN_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_TIMEOUT;
import static org.hibernate.cfg.AvailableSettings.DRIVER;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.PASS;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.URL;
import static org.hibernate.cfg.AvailableSettings.USER;
import static org.hibernate.cfg.AvailableSettings.USE_QUERY_CACHE;
import static org.hibernate.cfg.AvailableSettings.USE_SECOND_LEVEL_CACHE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author imssbora
 */
@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = {
    @ComponentScan("com.glv.dao")
    , @ComponentScan("com.glv.Model")
    ,
      @ComponentScan("com.glv.service")})
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        Properties props = new Properties();
        // Setting JDBC properties
        props.put(DRIVER, env.getProperty("jdbc.driverClassName"));
        props.put(URL, env.getProperty("jdbc.url"));
        props.put(USER, env.getProperty("jdbc.username"));
        props.put(PASS, env.getProperty("jdbc.password"));

        // Setting Hibernate properties
        props.put(USE_QUERY_CACHE, env.getProperty("hibernate.cache.use_query_cache"));
        props.put(USE_SECOND_LEVEL_CACHE, env.getProperty("hibernate.cache.use_second_level_cache"));
        props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
        props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));

        // Setting C3P0 properties
        props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
        props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
        props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
        props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
        props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
        // props.put("jadira.usertype.autoRegisterUserTypes", "true");
        factoryBean.setHibernateProperties(props);
        factoryBean.setAnnotatedClasses(new Class[]{Contrat.class, Client.class, Vehicule.class, Telephone.class, Marque.class, Modele.class, Categorie.class});
//        factoryBean.setAnnotatedClasses(Contrat.class);
//        factoryBean.setAnnotatedClasses(Client.class);
//        factoryBean.setAnnotatedClasses(Vehicule.class);
//        factoryBean.setAnnotatedClasses(Telephone.class);
//
//        factoryBean.setAnnotatedClasses(Marque.class);
//        factoryBean.setAnnotatedClasses(Modele.class);
//        factoryBean.setAnnotatedClasses(Categorie.class);
        //  factoryBean.getJpaPropertyMap().put("jadira.usertype.autoRegisterUserTypes", "true")
        return factoryBean;
    }
    public static final int UPLOAD_SIZE = 10000000;

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(UPLOAD_SIZE);
        return new CommonsMultipartResolver();
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
