package br.com.viavarejo.calculo.service.calculos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Assert;
import org.junit.Test;

import br.com.viavarejo.calculo.service.Calcular;
import br.com.viavarejo.calculo.service.calculos.util.CalcularUtil;

public class ValorParcelaTest {

	@Test
	public void testeValor() {
		Calcular parcela = CalcularUtil.getValorParcela(new BigDecimal(1150), 3);
		Assert.assertTrue(parcela.calcular().equals(new BigDecimal(383.33).setScale(2, RoundingMode.HALF_UP)));
	}
}
