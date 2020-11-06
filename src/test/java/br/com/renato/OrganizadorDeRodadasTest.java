package br.com.renato;

import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import br.com.renato.models.Rodada;

public class OrganizadorDeRodadasTest {
	
	@InjectMocks
	private OrganizadorDeRodadas organizadorDeRodadas;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void deveConverterOVetorDeJogadasEmUmListaOrganizadaDeRodadas() throws Exception {
		
		int[] jogadas = new int[] {1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 8, 2, 3, 0, 0};
		
		List<Rodada> rodadas =  organizadorDeRodadas.organizarJogasEmRodadas(jogadas);
		
		Assert.assertThat(rodadas.size(), is(10));
	}
	
}
