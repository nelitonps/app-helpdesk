package com.npsouza.helpdesk.config;

import com.npsouza.helpdesk.services.DBServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
    //Classe de teste configurada no application.properties

    @Autowired
    private DBServices dbServices;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

    @Bean
    public boolean instanciaDB(){
        if (value.equals("create")){
            this.dbServices.instanciaDB();
        }
        return false;
    }

}
