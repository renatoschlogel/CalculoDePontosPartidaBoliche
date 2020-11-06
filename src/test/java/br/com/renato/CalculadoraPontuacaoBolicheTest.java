package br.com.renato;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class CalculadoraPontuacaoBolicheTest {

	@InjectMocks
	private CalculadoraPontuacaoBoliche calculadoraPontuacaoBoliche;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void deveCalcularAPontuacaoComSpareEStrick() throws Exception {
		int[] jogadas = new int[] {1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6};
		int pontuacaoTotal = calculadoraPontuacaoBoliche.pontuacaoTotal(jogadas);
		Assert.assertThat(pontuacaoTotal, is(133));
	}
	
	@Test
	public void deveCalcularAPontuacaoSemStrickESemSpare() throws Exception {
		int[] jogadas = new int[] {1, 4, 4, 5, 3, 4, 4, 5, 2, 2, 0, 1, 2, 3, 5, 4, 2, 2, 2, 2};
		int pontuacaoTotal = calculadoraPontuacaoBoliche.pontuacaoTotal(jogadas);
		Assert.assertThat(pontuacaoTotal, is(57));
	}
	
	@Test
	public void deveCalcularAPontuacaoComSpare() throws Exception {
		int[] jogadas = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 8, 2, 3, 0,0};
		int pontuacaoTotal = calculadoraPontuacaoBoliche.pontuacaoTotal(jogadas);
		Assert.assertThat(pontuacaoTotal, is(17));
	}
	
	@Test
	public void deveCalcularAPontuacaoComStrick() throws Exception {
		int[] jogadas = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 2, 3, 0, 0};
		int pontuacaoTotal = calculadoraPontuacaoBoliche.pontuacaoTotal(jogadas);
		Assert.assertThat(pontuacaoTotal, is(20));
	}
}
