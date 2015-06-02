package br.com.jogatina.lotofacil.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.jogatina.lotofacil.domain.JogoLotoFacil;
import br.com.jogatina.lotofacil.domain.LotoFacilRepository;

@Controller
@RequestMapping("/lotofacil")
public class ManterConcursoController {
	
	@Autowired
	private LotoFacilRepository lotoFacilRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private BuscaLotoFacilRepository buscaLotoFacilRepository;

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
	
	@RequestMapping(value = "/listar/{pagina}/{buscaNome}", method = RequestMethod.GET)
	public String listar(@ModelAttribute("lista") ModelMap lista, @PathVariable Integer pagina, @PathVariable String buscaNome, Model model){
		
		lista.addAttribute( "jogos", buscaLotoFacilRepository.buscar(buscaNome, pagina));
		
		model.addAttribute("pagina", ++pagina);
		
		model.addAttribute("busca", "BuscaTodos");
		
		return "lotofacil/listaDeJogos";
	}
	
	@RequestMapping(value = "/listarInclude/{pagina}/{buscaNome}", method = RequestMethod.GET)
	public String listarPageable(@ModelAttribute("lista") ModelMap lista, @PathVariable Integer pagina, @PathVariable String buscaNome, Model model){
		
		lista.addAttribute( "jogos", buscaLotoFacilRepository.buscar(buscaNome, pagina));
		
		model.addAttribute("pagina", ++pagina);
		
		model.addAttribute("busca", buscaNome);
		
		return "lotofacil/listaDeJogosInclude";
	}
	
	@RequestMapping(value = "/palpiteNoHistorico", method = RequestMethod.GET)
	public String palpiteNoHistorico(){
		return "lotofacil/numeros";
	}
	
	@RequestMapping(value = "/verificarPalpite", method = RequestMethod.POST)
	public String verificarPalpite(@RequestParam("numerosSelecionados") List<Integer> numeroSelecionados, @ModelAttribute("lista") ModelMap lista, ModelMap model){
		
		try {
			
			buscaLotoFacilRepository.setNumeroSelecionados(numeroSelecionados);			
			
			lista.addAttribute( "jogos", buscaLotoFacilRepository.buscar("BuscaPalpite", 0));
			
			model.addAttribute("pagina", 1);
			
			model.addAttribute("busca", "BuscaPalpite");
			
			return "lotofacil/listaDeJogos";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "lotofacil/index";
		}
		
	}
	
	@RequestMapping(value = "/buscarJogos", method = RequestMethod.GET)
	public String buscarJogos(@ModelAttribute("lista") ModelMap lista, ModelMap model){
		
		lista.addAttribute("jogos", new ArrayList<>());
		
		model.addAttribute("pagina", 0);
		
		model.addAttribute("busca", "oinc");
		
		
		return "lotofacil/formBuscarJogos";
	}
	
	@RequestMapping(value = "/buscarJogos", method = RequestMethod.POST)
	public String buscarJogos(@RequestParam("de") Integer de, @RequestParam("ate") Integer ate, @ModelAttribute("lista") ModelMap lista, ModelMap model){
		
		buscaLotoFacilRepository.setDe(de);
		
		buscaLotoFacilRepository.setAte(ate);
		
		lista.addAttribute( "jogos", buscaLotoFacilRepository.buscar("DeAte", 0));
		
		model.addAttribute( "pagina", 1);
		
		model.addAttribute( "busca", "DeAte");
		
		return "lotofacil/listaDeJogos";
	}
}	
