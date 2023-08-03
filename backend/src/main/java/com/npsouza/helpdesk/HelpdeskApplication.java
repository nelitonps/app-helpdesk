package com.npsouza.helpdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//public class HelpdeskApplication implements CommandLineRunner {
	//Ao implementar CommandLineRunner sera preciso implementar o metodo Run que vai rodar sempre que inicia a aplicação
//@Override
//public void run(String... args) throws Exception {

@SpringBootApplication
public class HelpdeskApplication{

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}


}
