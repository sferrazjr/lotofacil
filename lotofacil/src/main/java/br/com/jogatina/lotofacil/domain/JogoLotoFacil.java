package br.com.jogatina.lotofacil.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "lotofacil")
public class JogoLotoFacil {
	
	@Id
	private Integer concurso;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date data;
	
	private double premio;
	private int ganhadores;
	private int[] numeros;
	
	public JogoLotoFacil(){
		
	}

	public JogoLotoFacil(int i, Date data, double d, int j, int[] bolas) {
		this.concurso = i;
		this.data = data;
		this.premio = d;
		this.ganhadores = j;
		this.setNumeros(bolas);
	}
	
	public Integer getConcurso() {
		return concurso;
	}
	public void setConcurso(Integer concurso) {
		this.concurso = concurso;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getPremio() {
		return premio;
	}
	public void setPremio(double premio) {
		this.premio = premio;
	}
	public int getGanhadores() {
		return ganhadores;
	}
	public void setGanhadores(int ganhadores) {
		this.ganhadores = ganhadores;
	}

	public int[] getNumeros() {
		return numeros;
	}

	public void setNumeros(int[] numeros) {
		this.numeros = numeros;
	}


}
