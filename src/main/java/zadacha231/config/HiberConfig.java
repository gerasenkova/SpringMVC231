package zadacha231.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import zadacha231.model.User;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("zadacha231")
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class HiberConfig {
    @Autowired
    private Environment env; // для того, чтобы получить свойства из property файла.

    @Bean
    //используется для создания соединения с БД. Это альтернатива DriverManager
    //с помощью Environment передаем свойства бд для установления соединения
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }

    @Bean
    // для создания сессий, с помощью которых осуществляются операции с объектами-сущностями.
    // Здесь мы устанавливаем источник данных, свойства Hibernate и в каком пакете нужно искать классы-сущности.
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());
        Properties props = new Properties();
        props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
//        props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        factoryBean.setHibernateProperties(props);
        factoryBean.setAnnotatedClasses(User.class);//устанавливаем класс-сущность
        return factoryBean;
    }

    @Bean
    //для настройки менеджера транзакций.
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }

}
