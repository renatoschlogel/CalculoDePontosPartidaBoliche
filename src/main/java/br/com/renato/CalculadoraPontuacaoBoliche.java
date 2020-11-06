package br.com.renato;

import java.util.List;

import br.com.renato.models.Jogada;
import br.com.renato.models.Rodada;

public class CalculadoraPontuacaoBoliche {
	
	private int quantidadeBonusStrikeDisponiveis = 0;
	private boolean bonusSpareDisponivel = false;

	public int pontuacaoTotal(int[] jogadas) {
		
		List<Rodada> rodaras = new OrganizadorDeRodadas().organizarJogasEmRodadas(jogadas);
		int pontos = 0;
		
		for (Rodada rodada : rodaras) {
			pontos += rodada.getTotalPinosDerrubados();
			pontos += bonusSpare(rodada);
			pontos += bonusStrike(rodada);
			
			if (rodada.isSpare()) {
				registrarSpare();
			}
			
			if (rodada.isStrike()) {
				registrarStrike();
			}
		}
		
		return pontos;
	}

	private void registrarSpare() {
		this.bonusSpareDisponivel = true;
	}

	private void registrarStrike() {
		bonusSpareDisponivel = false;
		this.quantidadeBonusStrikeDisponiveis = 2;
	}

	private int bonusSpare(Rodada rodada) {
		if(this.bonusSpareDisponivel) {
			this.bonusSpareDisponivel = false;
			int quantidadePinosDerrubadosPrimeiraJogada = rodada.getJogadas().stream().findFirst().get().getQuantidadePinosDerrubados();
			return quantidadePinosDerrubadosPrimeiraJogada;
		}
		
		return 0;
	}
	
	private int bonusStrike(Rodada rodada) {
		
		if (this.quantidadeBonusStrikeDisponiveis == 0) {
			return 0;
		}

		int quantidadePinosDerrubadosDuasJogadas = 0;
		for (Jogada jogada : rodada.getJogadas()) {
			this.quantidadeBonusStrikeDisponiveis--;
			quantidadePinosDerrubadosDuasJogadas += jogada.getQuantidadePinosDerrubados();
			if (quantidadeBonusStrikeDisponiveis == 0) {
				break;
			}
		}
		return quantidadePinosDerrubadosDuasJogadas;
	}

}
