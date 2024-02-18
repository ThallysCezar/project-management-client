package com.metatelecom.crud.configs;


import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class FlywayConfig {

    @Bean
    @DependsOn("dataSource")
    public Flyway flyway(DataSourceProperties dataSourceProperties) {
        Flyway flyway = Flyway.configure().dataSource(dataSourceProperties.initializeDataSourceBuilder().build()).load();
        flyway.repair(); // Esta linha é importante para corrigir a coluna antes de tentar a migração
        flyway.migrate();// Configurar outras propriedades do Flyway, se necessário
        return flyway;
    }

}