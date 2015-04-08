package br.com.jogatina.lotofacil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication 
/*@Configuration
@ComponentScan
@EnableAutoConfiguration
*/
@EnableMongoRepositories(basePackages="br.com.jogatina.lotofacil.domain")
public class LotoFacilApp {
	public static void main(String[] args) {
		
	    SpringApplication app = new SpringApplication(LotoFacilApp.class);
	    app.setShowBanner(false);
	    app.run(args);		
	}
}

