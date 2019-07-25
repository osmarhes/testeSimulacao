package br.com.viavarejo.calculo.service.calculos;

import java.math.BigDecimal;
import java.util.List;

import br.com.viavarejo.calculo.model.TaxaJurosDiario;
import br.com.viavarejo.calculo.service.Calcular;

public class TaxaJurosMensal implements Calcular {
	
	private final List<TaxaJurosDiario> listaJuros;
	
	public TaxaJurosMensal(List<TaxaJurosDiario> listaJuros) {
		this.listaJuros = listaJuros;
	}
	
	@Override
	public BigDecimal calcular() {
		return listaJuros.stream().map(TaxaJurosDiario::getValor).reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO);
	}
	
}
