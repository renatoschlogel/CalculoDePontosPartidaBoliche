package br.com.renato;

import java.util.ArrayList;
import java.util.List;

import br.com.renato.models.Rodada;

public class OrganizadorDeRodadas {

	public List<Rodada> organizarJogasEmRodadas(int[] jogadas) {
	
		List<Rodada> rodadas = new ArrayList<Rodada>();
		
		Rodada rodada = null;
		for (int i = 0; i < jogadas.length; i++) {
			
			if (rodada == null || rodada.isRodadaEncerrada()) {
				int numeroNovaRodada = rodada != null ? rodada.getNumero() + 1 : 1;
				rodada = new Rodada();
				rodada.setNumero(numeroNovaRodada);
				rodadas.add(rodada);
			}
			
			int pinosDerrubadosJogada = jogadas[i];
			rodada.addJogada(pinosDerrubadosJogada);
		}
		
		return rodadas;
	}

}
  