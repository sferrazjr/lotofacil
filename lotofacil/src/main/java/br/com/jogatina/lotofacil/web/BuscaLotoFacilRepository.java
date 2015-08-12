package br.com.jogatina.lotofacil.web;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Component;

import br.com.jogatina.lotofacil.config.MongoConfiguration;
import br.com.jogatina.lotofacil.domain.EstatisticaDeJogos;
import br.com.jogatina.lotofacil.domain.JogoLotoFacil;
import br.com.jogatina.lotofacil.domain.LotoFacilRepository;

@Component
public class BuscaLotoFacilRepository {
	
	@Autowired
	private LotoFacilRepository lotoFacilRepository;
	
	@Autowired
	private MongoConfiguration mongoConfiguration;
	
	private List<Integer> numeroSelecionados;

	private Integer de;

	private Integer ate;
	
	public List<EstatisticaDeJogos> estaticas(){
		List<EstatisticaDeJogos> lista = new ArrayList<>();
		
		Aggregation agg = newAggregation(
				unwind("numeros"),
				group("numeros").count().as("vezes"),
				project("vezes").and("numero").previousOperation(),
				sort(Direction.ASC, previousOperation(), "numero")
				);

		try {
			AggregationResults<EstatisticaDeJogos> agregado = mongoConfiguration.mongoTemplate().aggregate(agg, JogoLotoFacil.class, EstatisticaDeJogos.class);
			
			lista = agregado.getMappedResults();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}
	
	public List<JogoLotoFacil> buscar(String buscaNome, Integer pagina) {
		Pageable pageable = new PageRequest(pagina, 50, new Sort(Sort.Direction.ASC, "concurso"));
		
		if(buscaNome.equals("BuscaTodos")){
			return lotoFacilRepository.findAll(pageable).getContent();
		}
		
		if(buscaNome.equals("BuscaPalpite")){
			
			try {
				
				return mongoConfiguration.mongoTemplate().find(query(where("numeros").all(numeroSelecionados)).with(pageable), JogoLotoFacil.class);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(buscaNome.endsWith("DeAte")){
			try {
				//org.springframework.data.mongodb.InvalidMongoDbApiUsageException: Due to limitations of the com.mongodb.BasicDBObject, you can't add a second 'concurso' expression specified as 'concurso : { "$lt" : 1200}'. Criteria already contains 'concurso : { "$gte" : 1100}'.
				//return mongoConfiguration.mongoTemplate().find(query(where("concurso").gte(de).and("concurso").lt(ate)).with(pageable), JogoLotoFacil.class);
				
				return mongoConfiguration.mongoTemplate().find(query(where("concurso").gte(de).lt(ate)).with(pageable), JogoLotoFacil.class);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	public void setNumeroSelecionados(List<Integer> numeroSelecionados) {
		this.numeroSelecionados = numeroSelecionados;
	}

	public void setDe(Integer de) {
		this.de = de;
	}

	public void setAte(Integer ate) {
		this.ate = ate;
	}

}
