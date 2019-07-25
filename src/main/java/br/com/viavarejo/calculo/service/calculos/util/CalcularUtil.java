package br.com.viavarejo.calculo.service.calculos.util;

import java.math.BigDecimal;
import java.util.List;

import br.com.viavarejo.calculo.model.TaxaJurosDiario;
import br.com.viavarejo.calculo.service.Calcular;
import br.com.viavarejo.calculo.service.calculos.Montante;
import br.com.viavarejo.calculo.service.calculos.TaxaJurosMensal;
import br.com.viavarejo.calculo.service.calculos.ValorParcela;

public class CalcularUtil {
	public static Calcular getMontante(BigDecimal valor, BigDecimal juros, Integer parcelas) {
		return new Montante(valor, juros, parcelas);
	}
	
	public static Calcular getTaxaJurosMensal(List<TaxaJurosDiario> listaJuros) {
		return new TaxaJurosMensal(listaJuros);
	}
	
	public static Calcular getValorParcela(BigDecimal montante, Integer parcelas) {
		return new ValorParcela(montante, parcelas);
	}
}
