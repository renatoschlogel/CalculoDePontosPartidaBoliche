package br.com.renato.models;

import java.util.ArrayList;
import java.util.List;

public class Rodada {
	
	private int numero;
	
	private int quantidadeTentativas;
	
	private int totalPinosDerrubados;
	
	private List<Jogada> jogadas = new ArrayList<Jogada>();
	
	private boolean strike;
	
	private boolean spare;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getQuantidadeTentativas() {
		return quantidadeTentativas;
	}

	public void setQuantidadeTentativas(int quantidadeTentativas) {
		this.quantidadeTentativas = quantidadeTentativas;
	}

	public List<Jogada> getJogadas() {
		return jogadas;
	}

	public void setJogadas(List<Jogada> jogadas) {
		this.jogadas = jogadas;
	}

	public boolean isStrike() {
		return strike;
	}

	public void setStrike(boolean strike) {
		this.strike = strike;
	}

	public boolean isSpare() {
		return spare;
	}

	public void setSpare(boolean spare) {
		this.spare = spare;
	}

	public boolean isRodadaEncerrada() {
		
		if(isUltimaRodada()) {
			return false;
		}
		if (this.totalPinosDerrubados == 10 || this.quantidadeTentativas == 2) {
			return true;
		}
			
		return false;
	}

	public void addJogada(int pinosDerrubadosJogada) {
		Jogada jogada = new Jogada(this, pinosDerrubadosJogada);
		this.addJogada(jogada);
		this.quantidadeTentativas++;
		
		analisarRodada();
	}

	private void addJogada(Jogada jogada) {
		this.jogadas.add(jogada);
		this.totalPinosDerrubados += jogada.getQuantidadePinosDerrubados();
	}

	private void analisarRodada() {
		this.strike = ehUmStrink();
		this.spare = ehUmSpare();
	}

	private boolean ehUmSpare() {
		return this.quantidadeTentativas == 2 && this.totalPinosDerrubados == 10;
	}

	private boolean ehUmStrink() {
		return this.quantidadeTentativas == 1 && this.totalPinosDerrubados == 10;
	}

	@Override
	public String toString() {
		return "Rodada [numero=" + numero + ", quantidadeTentativas=" + quantidadeTentativas + ", totalPinosDerrubados="
				+ totalPinosDerrubados + ", strike=" + strike + ", spare=" + spare + "]";
	}

	public int getTotalPinosDerrubados() {
		return totalPinosDerrubados;
	}

	public void setTotalPinosDerrubados(int totalPinosDerrubados) {
		this.totalPinosDerrubados = totalPinosDerrubados;
	}

	public boolean isUltimaRodada() {
		return this.numero == 10;
	}

}
