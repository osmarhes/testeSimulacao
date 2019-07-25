package br.com.viavarejo.calculo.service.calculos;

import java.math.BigDecimal;

import br.com.viavarejo.calculo.service.Calcular;

public class Montante implements Calcular {
	private final BigDecimal valor;
	private final BigDecimal juros;
	private final Integer parcelas;
	
	public Montante(BigDecimal valor, BigDecimal juros, Integer parcelas) {
		this.juros = juros;
		this.valor = valor;
		this.parcelas = parcelas;
	}
	
	@Override
	public BigDecimal calcular() {
		return BigDecimal.ZERO.add(valor.multiply(juros.multiply(new BigDecimal(parcelas)))).divide(new BigDecimal(100)).add(valor);
	}
}
