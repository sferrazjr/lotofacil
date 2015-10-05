package br.com.jogatina.lotofacil.service;

import java.util.List;

import br.com.jogatina.lotofacil.domain.EstatisticaDeJogos;
import br.com.jogatina.lotofacil.domain.JogoLotoFacil;

public interface LotoFacilService {

	public abstract List<EstatisticaDeJogos> estaticas();

	public abstract List<JogoLotoFacil> buscar(String buscaNome, Integer pagina);

	public abstract void setNumeroSelecionados(List<Integer> numeroSelecionados);

	public abstract void setDe(Integer de);

	public abstract void setAte(Integer ate);

	public abstract void save(JogoLotoFacil jogoLotoFacil);

}