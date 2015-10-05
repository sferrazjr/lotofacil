package br.com.jogatina.lotofacil.service;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.previousOperation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import br.com.jogatina.lotofacil.domain.EstatisticaDeJogos;
import br.com.jogatina.lotofacil.domain.JogoLotoFacil;
import br.com.jogatina.lotofacil.domain.LotoFacilRepository;

@Service
public class LotoFacilServiceImpl implements LotoFacilService {

	@Autowired
	private LotoFacilRepository lotoFacilRepository;
	
	@Autowired
	private MongoOperations mongoOperation;

	private List<Integer> numeroSelecionados;

	private Integer de;

	private Integer ate;

	/* (non-Javadoc)
	 * @see br.com.jogatina.lotofacil.service.LotoFacilService#estaticas()
	 */
	@Override
	public List<EstatisticaDeJogos> estaticas(){
		List<EstatisticaDeJogos> lista = new ArrayList<>();

		Aggregation agg = newAggregation(
				unwind("numeros"),
				group("numeros").count().as("vezes"),
				project("vezes").and("numero").previousOperation(),
				sort(Direction.ASC, previousOperation(), "numero")
				);

		try {
			AggregationResults<EstatisticaDeJogos> agregado = mongoOperation.aggregate(agg, JogoLotoFacil.class, EstatisticaDeJogos.class);

			lista = agregado.getMappedResults();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}

	/* (non-Javadoc)
	 * @see br.com.jogatina.lotofacil.service.LotoFacilService#buscar(java.lang.String, java.lang.Integer)
	 */
	@Override
	public List<JogoLotoFacil> buscar(String buscaNome, Integer pagina) {
		Pageable pageable = new PageRequest(pagina, 50, new Sort(Sort.Direction.ASC, "concurso"));

		if(buscaNome.equals("BuscaTodos")){
			return lotoFacilRepository.findAll(pageable).getContent();
		}

		if(buscaNome.equals("BuscaPalpite")){

			try {

				return mongoOperation.find(query(where("numeros").all(numeroSelecionados)).with(pageable), JogoLotoFacil.class);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if(buscaNome.endsWith("DeAte")){
			try {
				//org.springframework.data.mongodb.InvalidMongoDbApiUsageException: Due to limitations of the com.mongodb.BasicDBObject, you can't add a second 'concurso' expression specified as 'concurso : { "$lt" : 1200}'. Criteria already contains 'concurso : { "$gte" : 1100}'.
				//return mongoConfiguration.mongoTemplate().find(query(where("concurso").gte(de).and("concurso").lt(ate)).with(pageable), JogoLotoFacil.class);

				return mongoOperation.find(query(where("concurso").gte(de).lt(ate)).with(pageable), JogoLotoFacil.class);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.jogatina.lotofacil.service.LotoFacilService#setNumeroSelecionados(java.util.List)
	 */
	@Override
	public void setNumeroSelecionados(List<Integer> numeroSelecionados) {
		this.numeroSelecionados = numeroSelecionados;
	}

	/* (non-Javadoc)
	 * @see br.com.jogatina.lotofacil.service.LotoFacilService#setDe(java.lang.Integer)
	 */
	@Override
	public void setDe(Integer de) {
		this.de = de;
	}

	/* (non-Javadoc)
	 * @see br.com.jogatina.lotofacil.service.LotoFacilService#setAte(java.lang.Integer)
	 */
	@Override
	public void setAte(Integer ate) {
		this.ate = ate;
	}

	/* (non-Javadoc)
	 * @see br.com.jogatina.lotofacil.service.LotoFacilService#save(br.com.jogatina.lotofacil.domain.JogoLotoFacil)
	 */
	@Override
	public void save(JogoLotoFacil jogoLotoFacil) {
		
		mongoOperation.save(jogoLotoFacil);
		
	}



}
