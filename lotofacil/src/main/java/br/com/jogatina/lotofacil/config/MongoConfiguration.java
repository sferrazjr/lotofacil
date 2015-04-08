package br.com.jogatina.lotofacil.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.WriteConcern;

@Configuration
@ComponentScan
@EnableMongoRepositories
public class MongoConfiguration extends AbstractMongoConfiguration {
	
	@Override
	protected String getDatabaseName() {
		return "jogatina";
	}

	@SuppressWarnings("deprecation")
	@Override
	public Mongo mongo() throws Exception {
		return new Mongo();
	}

	@Override
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), mappingMongoConverter());
		mongoTemplate.setWriteConcern(WriteConcern.SAFE);
		return mongoTemplate; 
	}
	
	
}
