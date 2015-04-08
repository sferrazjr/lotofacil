package br.com.jogatina.lotofacil.web;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.jogatina.lotofacil.domain.JogoLotoFacil;
import br.com.jogatina.lotofacil.domain.LotoFacilRepository;

@Controller
@RequestMapping("/lotofacil")
public class ManterConcursoController {
	
	@Autowired
	private LotoFacilRepository lotoFacilRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "lotofacil/index";
	}

	@RequestMapping(value = "/incluir", method = RequestMethod.GET)
	public String incluirPage() {
		return "lotofacil/incluir";
	}

	@RequestMapping(value = "/incluir", method = RequestMethod.POST)
	public String incluirSubmit(@ModelAttribute("jogoLotoFacil") JogoLotoFacil jogoLotoFacil) {
		
		lotoFacilRepository.save(jogoLotoFacil);
		
		return "lotofacil/index";
	}
	
	@RequestMapping(value = "/listar/{page}", method = RequestMethod.GET)
	public String listarPageable(@ModelAttribute("lista") ModelMap lista, @PathVariable Integer page ){
		
		Pageable pageable = new PageRequest(page, 50, new Sort(Sort.Direction.ASC, "concurso"));
		
		//lista.addAttribute( "jogos", lotoFacilRepository.findAll(new Sort(Sort.Direction.ASC, "concurso")) );
		
		lista.addAttribute( "jogos", lotoFacilRepository.findAll(pageable).getContent());
		
		return "lotofacil/listaDeJogos";
	}
	
}	
