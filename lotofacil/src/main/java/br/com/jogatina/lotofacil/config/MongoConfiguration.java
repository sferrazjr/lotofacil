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
@EnableMongoRepositories(basePackages="br.com.jogatina.lotofacil.domain")
public class MongoConfiguration {
	
//	@Bean
//	public MongoTemplate mongoTemplate() throws Exception {
//		
//		MongoClient mongoClient = new MongoClient("ds029224.mongolab.com");
//		
//		UserCredentials userCredentials = new UserCredentials("app-user","java");
//		
//		MongoTemplate mongoTemplate = new Mo
//		mongoTemplate.setWriteConcern(WriteConcern.SAFE);
//		return mongoTemplate; 
//	}
	
	
}
