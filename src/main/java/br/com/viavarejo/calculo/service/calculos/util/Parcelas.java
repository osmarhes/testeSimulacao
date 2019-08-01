package br.com.viavarejo.calculo.service.calculos.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.viavarejo.calculo.model.Parcela;

public class Parcelas {

	public static List<Parcela> gerar(BigDecimal valorParcela, BigDecimal taxaJuros, Integer numerosParcela) {
		List<Parcela> parcelas = new ArrayList<Parcela>();
		for (int i = 1; i <= numerosParcela; i++) {
			Parcela parcela = new Parcela();
			parcela.setNumeroParcela(i);
			parcela.setTaxaJurosAoMes(taxaJuros);
			parcela.setValor(valorParcela);

			parcelas.add(parcela);
		}
		return parcelas;
	}
}
