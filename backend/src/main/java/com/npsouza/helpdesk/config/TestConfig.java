package com.npsouza.helpdesk.config;

import com.npsouza.helpdesk.services.DBServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
    //Classe de teste configurada no application.properties

    @Autowired
    private DBServices dbServices;

    @Bean
    public void instanciaDB(){
        this.dbServices.instanciaDB();
    }

}
