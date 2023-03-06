package com.example.jpabasiclivelecture230305.config;


import org.h2.tools.Server;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class H2Config {

    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    public DataSource h2ServerConfig() throws SQLException {
        Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092").start();

        return new com.zaxxer.hikari.HikariDataSource();
    }
}
