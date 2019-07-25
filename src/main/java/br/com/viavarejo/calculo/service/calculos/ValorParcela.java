package br.com.viavarejo.calculo.service.calculos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.viavarejo.calculo.service.Calcular;

public class ValorParcela implements Calcular{
	private final BigDecimal montante; 
	private final Integer parcelas;
	
	public ValorParcela(BigDecimal montante, Integer parcelas) {
		this.montante = montante;
		this.parcelas = parcelas;
	}
	
	@Override
	public BigDecimal calcular() {
		return BigDecimal.ZERO.add(montante.divide(new BigDecimal(parcelas), 2 , RoundingMode.HALF_UP));
	}
	
}
