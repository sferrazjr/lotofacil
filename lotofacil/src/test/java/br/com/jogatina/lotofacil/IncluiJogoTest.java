package br.com.jogatina.lotofacil;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.jogatina.lotofacil.domain.LotoFacilRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {LotoFacilApp.class} ) 
@EnableMongoRepositories(basePackages="br.com.jogatina.lotofacil.domain")
public class IncluiJogoTest {
	
	@Autowired
	LotoFacilRepository lotoFacilRepository;

	@Test
	public void incluiJogo() throws ParseException {
		//TODO: finish up insert and create delete tests methods
		
/*		int concurso = 9999;
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date data = formatter.parse("2015-02-18");
		
		int[] bolas = {2,6,8,9,10,11,12,13,14,16,19,20,23,24,25};
		
		JogoLotoFacil jogoLotoFacil = new JogoLotoFacil(
			concurso,
			data,
			1744500.41,
			1,
			bolas);
		
		JogoLotoFacil a = lotoFacilRepository.save(jogoLotoFacil);
		
		JogoLotoFacil o = lotoFacilRepository.findOne(concurso);
		
		Assert.assertEquals(o.getConcurso().intValue(), concurso);
	*/	
	}

}
