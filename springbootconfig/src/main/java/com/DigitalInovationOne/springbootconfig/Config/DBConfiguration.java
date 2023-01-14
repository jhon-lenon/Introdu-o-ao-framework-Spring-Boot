package com.DigitalInovationOne.springbootconfig.Config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String testDatabaseConnection() {
        System.out.println("DB Connection for DEV - H2");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connetion to H2_TEST - Test instance";
    }

    @Profile("producao")
    @Bean
    public String productionDatabaseConnection() {
        System.out.println("DB Connection for Production - MySQL");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connetion to MYSQL_PRODUCAO - Production instance";
    }

}
