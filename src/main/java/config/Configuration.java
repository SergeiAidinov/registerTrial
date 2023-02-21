package config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootConfiguration
@PropertySource("classpath:application.properties")
public class Configuration {

    @Value("${spring.driver-class-name}")
    String driver;
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String userName;
    @Value("${spring.datasource.password}")
    String password;

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(userName);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }
}
