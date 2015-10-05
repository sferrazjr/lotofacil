package br.com.jogatina.lotofacil.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LotoFacilRepository extends MongoRepository<JogoLotoFacil, Integer> {


}
