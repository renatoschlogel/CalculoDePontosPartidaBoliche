package br.com.renato.models;

public class Jogada {
	
	private int quantidadePinosDerrubados; 
	
	private Rodada rodada;
	
	public Jogada(Rodada rodada, int quantidadePinosDerrubados) {
		this.quantidadePinosDerrubados = quantidadePinosDerrubados;
		this.rodada = rodada;
	}

	public int getQuantidadePinosDerrubados() {
		return quantidadePinosDerrubados;
	}

	public void setQuantidadePinosDerrubados(int quantidadePinosDerrubados) {
		this.quantidadePinosDerrubados = quantidadePinosDerrubados;
	}

	public Rodada getRodada() {
		return rodada;
	}

	public void setRodada(Rodada rodada) {
		this.rodada = rodada;
	}

}
