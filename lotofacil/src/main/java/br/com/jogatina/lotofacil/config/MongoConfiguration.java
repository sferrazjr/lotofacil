package br.com.jogatina.lotofacil.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

@Configuration
@ComponentScan
@EnableMongoRepositories
public class MongoConfiguration {

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
    	UserCredentials userCredentials = new UserCredentials("app-user","abc12345");
    	return new SimpleMongoDbFactory(new MongoClient("ds039020.mongolab.com",39020), "jogatina", userCredentials) ;
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		mongoTemplate.setWriteConcern(WriteConcern.SAFE);
		return mongoTemplate; 
	}
	
	
}
