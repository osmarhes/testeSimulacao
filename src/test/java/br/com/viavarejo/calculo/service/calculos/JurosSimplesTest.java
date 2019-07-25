package br.com.viavarejo.calculo.service.calculos;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import br.com.viavarejo.calculo.service.Calcular;

public class JurosSimplesTest {
	
	@Test
	public void testeValor() {
		Calcular jurosSimples = new Montante(new BigDecimal(1000), new BigDecimal(5), 3);
		Assert.assertTrue(jurosSimples.calcular().equals(new BigDecimal(1150)));
	}
}
